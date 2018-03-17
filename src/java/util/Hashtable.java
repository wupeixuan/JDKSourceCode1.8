package java.util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.BiFunction;

import sun.misc.SharedSecrets;

/**
 * Hashtable存储的内容是键值对(key-value)映射，其底层实现是一个Entry数组+链表；
 * Hashtable和HashMap一样也是散列表，存储元素也是键值对；
 * HashMap允许key和value都为null，而Hashtable都不能为null，Hashtable中的映射不是有序的；
 * Hashtable和HashMap扩容的方法不一样，Hashtable中数组默认大小11，扩容方式是 old*2+1。
 * HashMap中数组的默认大小是16，而且一定是2的指数，增加为原来的2倍。
 * Hashtable继承于Dictionary类（Dictionary类声明了操作键值对的接口方法），实现Map接口（定义键值对接口）；
 * Hashtable大部分类用synchronized修饰，证明Hashtable是线程安全的。
 */
public class Hashtable<K, V>
        extends Dictionary<K, V>
        implements Map<K, V>, Cloneable, java.io.Serializable {

    /**
     * 键值对/Entry数组，每个Entry本质上是一个单向链表的表头
     */
    private transient Entry<?, ?>[] table;

    /**
     * 当前表中的Entry数量，如果超过了阈值，就会扩容，即调用rehash方法
     */
    private transient int count;

    /**
     * rehash阈值
     *
     * @serial
     */
    private int threshold;

    /**
     * 负载因子
     *
     * @serial
     */
    private float loadFactor;

    /**
     * 用来实现"fail-fast"机制的（也就是快速失败）。所谓快速失败就是在并发集合中，其进行
     * 迭代操作时，若有其他线程对其进行结构性的修改，这时迭代器会立马感知到，并且立即抛出
     * ConcurrentModificationException异常，而不是等到迭代完成之后才告诉你（你已经出错了）。
     */
    private transient int modCount = 0;

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = 1421746759512286392L;

    /**
     * 指定容量大小和加载因子的构造函数
     *
     * @param initialCapacity 容量大小
     * @param loadFactor      负载因子
     * @throws IllegalArgumentException if the initial capacity is less
     *                                  than zero, or if the load factor is nonpositive.
     */
    public Hashtable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);

        if (initialCapacity == 0)
            initialCapacity = 1;
        this.loadFactor = loadFactor;
        table = new Entry<?, ?>[initialCapacity];
        threshold = (int) Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
    }

    /**
     * 指定容量大小的构造函数
     *
     * @param initialCapacity 容量大小
     * @throws IllegalArgumentException if the initial capacity is less
     *                                  than zero.
     */
    public Hashtable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    /**
     * 默认构造函数
     */
    public Hashtable() {
        // 默认构造函数，指定的容量大小是11；加载因子是0.75
        this(11, 0.75f);
    }

    /**
     * 包含子Map的构造函数
     *
     * @param t the map whose mappings are to be placed in this map.
     * @throws NullPointerException if the specified map is null.
     * @since 1.2
     */
    public Hashtable(Map<? extends K, ? extends V> t) {
        this(Math.max(2 * t.size(), 11), 0.75f);
        putAll(t);
    }

    /**
     * 返回容量大小
     *
     * @return the number of keys in this hashtable.
     */
    public synchronized int size() {
        return count;
    }

    /**
     * 判空
     *
     * @return <code>true</code> if this hashtable maps no keys to values;
     * <code>false</code> otherwise.
     */
    public synchronized boolean isEmpty() {
        return count == 0;
    }

    /**
     * 返回所有key的枚举对象
     *
     * @return an enumeration of the keys in this hashtable.
     * @see Enumeration
     * @see #elements()
     * @see #keySet()
     * @see Map
     */
    public synchronized Enumeration<K> keys() {
        return this.<K>getEnumeration(KEYS);
    }

    /**
     * 返回所有value的枚举对象
     *
     * @return an enumeration of the values in this hashtable.
     * @see java.util.Enumeration
     * @see #keys()
     * @see #values()
     * @see Map
     */
    public synchronized Enumeration<V> elements() {
        return this.<V>getEnumeration(VALUES);
    }

    /**
     * 判断是否含有该value的键值对，在Hashtable中hashCode相同的Entry用链表组织，hashCode不同的存储在Entry数组table中；
     *
     * @param value a value to search for
     * @return <code>true</code> if and only if some key maps to the
     * <code>value</code> argument in this hashtable as
     * determined by the <tt>equals</tt> method;
     * <code>false</code> otherwise.
     * @throws NullPointerException if the value is <code>null</code>
     */
    public synchronized boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }

        Entry<?, ?> tab[] = table;
        // 查找：遍历所有Entry链表
        for (int i = tab.length; i-- > 0; ) {
            for (Entry<?, ?> e = tab[i]; e != null; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否包含value值对象
     *
     * @param value value whose presence in this hashtable is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     * specified value
     * @throws NullPointerException if the value is <code>null</code>
     * @since 1.2
     */
    public boolean containsValue(Object value) {
        return contains(value);
    }

    /**
     * 判断是否包含key键值对象
     *
     * @param key possible key
     * @return <code>true</code> if and only if the specified object
     * is a key in this hashtable, as determined by the
     * <tt>equals</tt> method; <code>false</code> otherwise.
     * @throws NullPointerException if the key is <code>null</code>
     * @see #contains(Object)
     */
    public synchronized boolean containsKey(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        /**
         * 计算index, % tab.length防止数组越界
         * index表示key对应entry所在链表表头
         */
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据指定key查找对应value，查找原理与containsKey相同，查找成功返回value，否则返回null
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     * {@code null} if this map contains no mapping for the key
     * @throws NullPointerException if the specified key is null
     * @see #put(Object, Object)
     */
    @SuppressWarnings("unchecked")
    public synchronized V get(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V) e.value;
            }
        }
        return null;
    }

    /**
     * 规定的最大数组容量
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 当Hashtable中键值对总数超过阈值（容量*装载因子）后，内部自动调用rehash()增加容量，重新计算每个键值对的hashCode
     * int newCapacity = (oldCapacity << 1) + 1计算新容量 = 2 * 旧容量 + 1；并且根据新容量更新阈值
     */
    @SuppressWarnings("unchecked")
    protected void rehash() {
        int oldCapacity = table.length;
        Entry<?, ?>[] oldMap = table;

        /**
         * 新的大小为  原大小 * 2 + 1
         * 虽然不保证capacity是一个质数，但至少保证它是一个奇数
         */
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<?, ?>[] newMap = new Entry<?, ?>[newCapacity];

        modCount++;
        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap;
        // 拷贝每个Entry链表
        for (int i = oldCapacity; i-- > 0; ) {
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old;
                old = old.next;
                // 重新计算每个Entry链表的表头索引（rehash）
                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                // 开辟链表节点
                e.next = (Entry<K, V>) newMap[index];
                // 拷贝
                newMap[index] = e;
            }
        }
    }

    /**
     * 当键值对个数超过阈值，先进行rehash然后添加entry，否则直接添加entry
     */
    private void addEntry(int hash, K key, V value, int index) {
        modCount++;

        Entry<?, ?> tab[] = table;
        // 当前元素大于等于阈值，就扩容并且再计算hash值
        if (count >= threshold) {
            rehash();

            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        // 和HashMap不同，Hashtable选择把新插入的元素放到链表最前边，而且没有使用红黑树
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }

    /**
     * 设置键值对，key和value都不可为null，设置顺序:
     * 如果Hashtable含有key，设置(key, oldValue) -> (key, newValue)；
     * 如果Hashtable不含有key, 调用addEntry(...)添加新的键值对；
     *
     * @param key   the hashtable key
     * @param value the value
     * @return the previous value of the specified key in this hashtable,
     * or <code>null</code> if it did not have one
     * @throws NullPointerException if the key or value is
     *                              <code>null</code>
     * @see Object#equals(Object)
     * @see #get(Object)
     */
    public synchronized V put(K key, V value) {
        // value为空抛出空指针异常
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?, ?> tab[] = table;
        /**
         * key的hashCode是调用Object的hashCode()方法，
         * 是native的方法，如果为null，就会抛出空指针异常
         */
        int hash = key.hashCode();
        /**
         * 因为hash可能为负数，所以就先和0x7FFFFFFF相与
         * 在HashMap中，是用 (table.length - 1) & hash 计算要放置的位置
         */
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        // 如果key对应的值不存在，就调用addEntry方法加入
        addEntry(hash, key, value, index);
        return null;
    }

    /**
     * remove操作，计算key所在链表表头table[index]，然后进行单向链表的节点删除操作
     *
     * @param key the key that needs to be removed
     * @return the value to which the key had been mapped in this hashtable,
     * or <code>null</code> if the key did not have a mapping
     * @throws NullPointerException if the key is <code>null</code>
     */
    public synchronized V remove(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                modCount++;
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
        }
        return null;
    }

    /**
     * 把所有的 映射从指定的map复制到hashTable中
     * 如果给定的map中的key值已经存在于hashTable中，则将会覆盖hashTable中key所对应的value（hashTable中key值不允许重复）
     *
     * @param t mappings to be stored in this map
     * @throws NullPointerException if the specified map is null
     * @since 1.2
     */
    public synchronized void putAll(Map<? extends K, ? extends V> t) {
        //foreach 循环map数据put到hashTable中
        for (Map.Entry<? extends K, ? extends V> e : t.entrySet())
            put(e.getKey(), e.getValue());
    }

    /**
     * 清空Hashtable
     * 将Hashtable的table数组的值全部设为null
     */
    public synchronized void clear() {
        Entry<?, ?> tab[] = table;
        modCount++;
        for (int index = tab.length; --index >= 0; )
            tab[index] = null;
        count = 0;
    }

    /**
     * 对Hashtable的浅拷贝操作，浅拷贝所有bucket（单向链表组织形式）的表头
     *
     * @return a clone of the hashtable
     */
    public synchronized Object clone() {
        try {
            Hashtable<?, ?> t = (Hashtable<?, ?>) super.clone();
            t.table = new Entry<?, ?>[table.length];
            for (int i = table.length; i-- > 0; ) {
                t.table[i] = (table[i] != null)
                        ? (Entry<?, ?>) table[i].clone() : null;
            }
            t.keySet = null;
            t.entrySet = null;
            t.values = null;
            t.modCount = 0;
            return t;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    /**
     * 返回Hashtable对象的String表达方式，一系列以括号和逗号，空格分隔的Entry，如{key1=value1, key2=value2}
     *
     * @return a string representation of this hashtable
     */
    public synchronized String toString() {
        int max = size() - 1;
        if (max == -1)
            return "{}";

        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();

        sb.append('{');
        for (int i = 0; ; i++) {
            Map.Entry<K, V> e = it.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key == this ? "(this Map)" : key.toString());
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value.toString());

            if (i == max)
                return sb.append('}').toString();
            sb.append(", ");
        }
    }


    private <T> Enumeration<T> getEnumeration(int type) {
        if (count == 0) {
            return Collections.emptyEnumeration();
        } else {
            return new Enumerator<>(type, false);
        }
    }

    /**
     * 获得迭代器
     */
    private <T> Iterator<T> getIterator(int type) {
        if (count == 0) {
            return Collections.emptyIterator();
        } else {
            return new Enumerator<>(type, true);
        }
    }

    // 视图

    /**
     * 以下每个字段初始化后会包含一个首次请求后的指定视图，视图是无状态的，所以不必创建多个
     */
    private transient volatile Set<K> keySet;
    private transient volatile Set<Map.Entry<K, V>> entrySet;
    private transient volatile Collection<V> values;

    /**
     * 返回一个被synchronizedSet封装后的KeySet对象
     * synchronizedSet封装的目的是对KeySet的所有方法都添加synchronized，实现多线程同步
     */
    public Set<K> keySet() {
        if (keySet == null)
            keySet = Collections.synchronizedSet(new KeySet(), this);
        return keySet;
    }

    /**
     * Hashtable的Key的Set集合
     * KeySet继承于AbstractSet，所以，KeySet中的元素没有重复的
     */
    private class KeySet extends AbstractSet<K> {
        public Iterator<K> iterator() {
            return getIterator(KEYS);
        }

        public int size() {
            return count;
        }

        public boolean contains(Object o) {
            return containsKey(o);
        }

        public boolean remove(Object o) {
            return Hashtable.this.remove(o) != null;
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    /**
     * 返回一个被synchronizedSet封装后的EntrySet对象
     * synchronizedSet封装的目的是对EntrySet的所有方法都添加synchronized，实现多线程同步
     */
    public Set<Map.Entry<K, V>> entrySet() {
        if (entrySet == null)
            entrySet = Collections.synchronizedSet(new EntrySet(), this);
        return entrySet;
    }

    /**
     * Hashtable的Entry的Set集合
     * EntrySet继承于AbstractSet，所以，EntrySet中的元素没有重复的
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> iterator() {
            return getIterator(ENTRIES);
        }

        public boolean add(Map.Entry<K, V> o) {
            return super.add(o);
        }

        /**
         * 查找EntrySet中是否包含Object(0)
         * 首先，在table中找到o对应的Entry(Entry是一个单向链表)
         * 然后，查找Entry链表中是否存在Object
         */
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) o;
            Object key = entry.getKey();
            Entry<?, ?>[] tab = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;

            for (Entry<?, ?> e = tab[index]; e != null; e = e.next)
                if (e.hash == hash && e.equals(entry))
                    return true;
            return false;
        }

        /**
         * 删除元素Object(0)
         * 首先，在table中找到o对应的Entry(Entry是一个单向链表)
         * 然后，删除链表中的元素Object
         */
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) o;
            Object key = entry.getKey();
            Entry<?, ?>[] tab = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;

            @SuppressWarnings("unchecked")
            Entry<K, V> e = (Entry<K, V>) tab[index];
            for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
                if (e.hash == hash && e.equals(entry)) {
                    modCount++;
                    if (prev != null)
                        prev.next = e.next;
                    else
                        tab[index] = e.next;

                    count--;
                    e.value = null;
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return count;
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    /**
     * 返回一个被synchronizedCollection封装后的ValueCollection对象
     * synchronizedCollection封装的目的是对ValueCollection的所有方法都添加synchronized，实现多线程同步
     */
    public Collection<V> values() {
        if (values == null)
            values = Collections.synchronizedCollection(new ValueCollection(),
                    this);
        return values;
    }

    /**
     * Hashtable的value的Collection集合。
     * ValueCollection继承于AbstractCollection，所以，ValueCollection中的元素可以重复的。
     */
    private class ValueCollection extends AbstractCollection<V> {
        public Iterator<V> iterator() {
            return getIterator(VALUES);
        }

        public int size() {
            return count;
        }

        public boolean contains(Object o) {
            return containsValue(o);
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    // Comparison and hashing

    /**
     * 重新equals()函数
     * 若两个Hashtable的所有key-value键值对都相等，则判断它们两个相等
     *
     * @param o object to be compared for equality with this hashtable
     * @return true if the specified Object is equal to this Map
     * @see Map#equals(Object)
     * @since 1.2
     */
    public synchronized boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Map))
            return false;
        Map<?, ?> t = (Map<?, ?>) o;
        if (t.size() != size())
            return false;

        try {
            /**
             * 通过迭代器依次取出当前Hashtable的key-value键值对
             * 并判断该键值对，存在于Hashtable(o)中。
             * 若不存在，则立即返回false；否则，遍历完“当前Hashtable”并返回true。
             */
            Iterator<Map.Entry<K, V>> i = entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<K, V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (!(t.get(key) == null && t.containsKey(key)))
                        return false;
                } else {
                    if (!value.equals(t.get(key)))
                        return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }

    /**
     * 计算Hashtable的哈希值
     *
     * @see Map#hashCode()
     * @since 1.2
     */
    public synchronized int hashCode() {
        int h = 0;
        //若 Hashtable的实际大小为0 或者 加载因子<0，则返回0
        if (count == 0 || loadFactor < 0)
            return h;  // Returns zero

        loadFactor = -loadFactor;  // Mark hashCode computation in progress
        Entry<?, ?>[] tab = table;
        //返回Hashtable中的每个Entry的key和value的异或值的总和
        for (Entry<?, ?> entry : tab) {
            while (entry != null) {
                h += entry.hashCode();
                entry = entry.next;
            }
        }

        loadFactor = -loadFactor;  // Mark hashCode computation complete

        return h;
    }

    @Override
    public synchronized V getOrDefault(Object key, V defaultValue) {
        V result = get(key);
        return (null == result) ? defaultValue : result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);     // explicit check required in case
        // table is empty.
        final int expectedModCount = modCount;

        Entry<?, ?>[] tab = table;
        for (Entry<?, ?> entry : tab) {
            while (entry != null) {
                action.accept((K) entry.key, (V) entry.value);
                entry = entry.next;

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);     // explicit check required in case
        // table is empty.
        final int expectedModCount = modCount;

        Entry<K, V>[] tab = (Entry<K, V>[]) table;
        for (Entry<K, V> entry : tab) {
            while (entry != null) {
                entry.value = Objects.requireNonNull(
                        function.apply(entry.key, entry.value));
                entry = entry.next;

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    @Override
    public synchronized V putIfAbsent(K key, V value) {
        Objects.requireNonNull(value);

        // Makes sure the key is not already in the hashtable.
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                if (old == null) {
                    entry.value = value;
                }
                return old;
            }
        }

        addEntry(hash, key, value, index);
        return null;
    }

    @Override
    public synchronized boolean remove(Object key, Object value) {
        Objects.requireNonNull(value);

        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if ((e.hash == hash) && e.key.equals(key) && e.value.equals(value)) {
                modCount++;
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                count--;
                e.value = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized boolean replace(K key, V oldValue, V newValue) {
        Objects.requireNonNull(oldValue);
        Objects.requireNonNull(newValue);
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                if (e.value.equals(oldValue)) {
                    e.value = newValue;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 替换
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public synchronized V replace(K key, V value) {
        Objects.requireNonNull(value);
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public synchronized V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);

        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (; e != null; e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                // Hashtable not accept null value
                return e.value;
            }
        }

        V newValue = mappingFunction.apply(key);
        if (newValue != null) {
            addEntry(hash, key, newValue, index);
        }

        return newValue;
    }

    @Override
    public synchronized V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);

        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                V newValue = remappingFunction.apply(key, e.value);
                if (newValue == null) {
                    modCount++;
                    if (prev != null) {
                        prev.next = e.next;
                    } else {
                        tab[index] = e.next;
                    }
                    count--;
                } else {
                    e.value = newValue;
                }
                return newValue;
            }
        }
        return null;
    }

    @Override
    public synchronized V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);

        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if (e.hash == hash && Objects.equals(e.key, key)) {
                V newValue = remappingFunction.apply(key, e.value);
                if (newValue == null) {
                    modCount++;
                    if (prev != null) {
                        prev.next = e.next;
                    } else {
                        tab[index] = e.next;
                    }
                    count--;
                } else {
                    e.value = newValue;
                }
                return newValue;
            }
        }

        V newValue = remappingFunction.apply(key, null);
        if (newValue != null) {
            addEntry(hash, key, newValue, index);
        }

        return newValue;
    }

    @Override
    public synchronized V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);

        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                V newValue = remappingFunction.apply(e.value, value);
                if (newValue == null) {
                    modCount++;
                    if (prev != null) {
                        prev.next = e.next;
                    } else {
                        tab[index] = e.next;
                    }
                    count--;
                } else {
                    e.value = newValue;
                }
                return newValue;
            }
        }

        if (value != null) {
            addEntry(hash, key, value, index);
        }

        return value;
    }

    /**
     * 将Hashtable的总的容量，实际容量，所有的Entry都写入到输出流中
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws IOException {
        Entry<Object, Object> entryStack = null;

        synchronized (this) {
            // Write out the threshold and loadFactor
            s.defaultWriteObject();

            // Write out the length and count of elements
            s.writeInt(table.length);
            s.writeInt(count);

            // Stack copies of the entries in the table
            for (int index = 0; index < table.length; index++) {
                Entry<?, ?> entry = table[index];

                while (entry != null) {
                    entryStack =
                            new Entry<>(0, entry.key, entry.value, entryStack);
                    entry = entry.next;
                }
            }
        }

        // Write out the key/value objects from the stacked entries
        while (entryStack != null) {
            s.writeObject(entryStack.key);
            s.writeObject(entryStack.value);
            entryStack = entryStack.next;
        }
    }

    /**
     * 将Hashtable的总的容量，实际容量，所有的Entry依次读出
     */
    private void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        // Read in the threshold and loadFactor
        s.defaultReadObject();

        // Validate loadFactor (ignore threshold - it will be re-computed)
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new StreamCorruptedException("Illegal Load: " + loadFactor);

        // Read the original length of the array and number of elements
        int origlength = s.readInt();
        int elements = s.readInt();

        // Validate # of elements
        if (elements < 0)
            throw new StreamCorruptedException("Illegal # of Elements: " + elements);

        // Clamp original length to be more than elements / loadFactor
        // (this is the invariant enforced with auto-growth)
        origlength = Math.max(origlength, (int) (elements / loadFactor) + 1);

        // Compute new length with a bit of room 5% + 3 to grow but
        // no larger than the clamped original length.  Make the length
        // odd if it's large enough, this helps distribute the entries.
        // Guard against the length ending up zero, that's not valid.
        int length = (int) ((elements + elements / 20) / loadFactor) + 3;
        if (length > elements && (length & 1) == 0)
            length--;
        length = Math.min(length, origlength);

        // Check Map.Entry[].class since it's the nearest public type to
        // what we're actually creating.
        SharedSecrets.getJavaOISAccess().checkArray(s, Map.Entry[].class, length);
        table = new Entry<?, ?>[length];
        threshold = (int) Math.min(length * loadFactor, MAX_ARRAY_SIZE + 1);
        count = 0;

        // Read the number of elements and then all the key/value objects
        for (; elements > 0; elements--) {
            @SuppressWarnings("unchecked")
            K key = (K) s.readObject();
            @SuppressWarnings("unchecked")
            V value = (V) s.readObject();
            // sync is eliminated for performance
            reconstitutionPut(table, key, value);
        }
    }

    /**
     * readObject使用的put方法（重建put），因为put方法支持重写，并且子类尚未初始化的时候不能调用put方法，所以就提供了reconstitutionPut
     * 它和常规put方法有几点不同，不检测rehash,因为初始元素数目已知。modCount不会自增，因为我们是在创建一个新的实例。
     */
    private void reconstitutionPut(Entry<?, ?>[] tab, K key, V value)
            throws StreamCorruptedException {
        if (value == null) {
            throw new java.io.StreamCorruptedException();
        }
        // 确保Key不在Hashtable中
        // 反序列化过程中不应该 会发生的情况
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            //反序列化过程中如果出现Key值重复，抛出异常StreamCorruptedException
            if ((e.hash == hash) && e.key.equals(key)) {
                throw new java.io.StreamCorruptedException();
            }
        }
        // 创建新的Entry.
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }

    /**
     * Hashtable的Entry节点，它本质上是一个单向链表。
     * 因此，我们能推断出Hashtable是由拉链法实现的散列表
     */
    private static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        protected Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        protected Object clone() {
            return new Entry<>(hash, key, value,
                    (next == null ? null : (Entry<K, V>) next.clone()));
        }

        // Map.Entry Ops

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        // 进行判断value是否为空，即不允许value为空，其实key也不能为空
        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        // 覆盖equals()方法，判断两个Entry是否相等。
        // 若两个Entry的key和value都相等，则认为它们相等。
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        public int hashCode() {
            // 直接用hash进行异或，与HashMap不同
            return hash ^ Objects.hashCode(value);
        }

        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }

    // Types of Enumerations/Iterations
    private static final int KEYS = 0;
    private static final int VALUES = 1;
    private static final int ENTRIES = 2;

    /**
     * Enumerator的作用是提供了通过elements()遍历Hashtable的接口和通过entrySet()遍历Hashtable的接口。
     * 因为，它同时实现了 Enumerator接口和Iterator接口。
     */
    private class Enumerator<T> implements Enumeration<T>, Iterator<T> {
        // 指向Hashtable的table
        Entry<?, ?>[] table = Hashtable.this.table;
        // Hashtable的总的大小
        int index = table.length;
        Entry<?, ?> entry;
        Entry<?, ?> lastReturned;
        int type;

        /**
         * Enumerator是 迭代器(Iterator) 还是 枚举类(Enumeration)的标志
         * iterator为true，表示它是迭代器；否则，是枚举类。
         */
        boolean iterator;

        /**
         * 在将Enumerator当作迭代器使用时会用到，用来实现fail-fast机制。
         */
        protected int expectedModCount = modCount;

        Enumerator(int type, boolean iterator) {
            this.type = type;
            this.iterator = iterator;
        }

        /**
         * 从遍历table的数组的末尾向前查找，直到找到不为null的Entry。
         */
        public boolean hasMoreElements() {
            Entry<?, ?> e = entry;
            int i = index;
            Entry<?, ?>[] t = table;
            /* Use locals for faster loop iteration */
            while (e == null && i > 0) {
                e = t[--i];
            }
            entry = e;
            index = i;
            return e != null;
        }

        /**
         * 获取下一个元素
         * 注意：从hasMoreElements() 和nextElement() 可以看出Hashtable的elements()遍历方式
         * 首先，从后向前的遍历table数组。table数组的每个节点都是一个单向链表(Entry)。
         * 然后，依次向后遍历单向链表Entry。
         */
        @SuppressWarnings("unchecked")
        public T nextElement() {
            Entry<?, ?> et = entry;
            int i = index;
            Entry<?, ?>[] t = table;
            /* Use locals for faster loop iteration */
            while (et == null && i > 0) {
                et = t[--i];
            }
            entry = et;
            index = i;
            if (et != null) {
                Entry<?, ?> e = lastReturned = entry;
                entry = e.next;
                return type == KEYS ? (T) e.key : (type == VALUES ? (T) e.value : (T) e);
            }
            throw new NoSuchElementException("Hashtable Enumerator");
        }

        // 迭代器Iterator的判断是否存在下一个元素
        // 实际上，它是调用的hasMoreElements()
        public boolean hasNext() {
            return hasMoreElements();
        }

        // 迭代器获取下一个元素
        // 实际上，它是调用的nextElement()
        public T next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            return nextElement();
        }

        // 迭代器的remove()接口。
        // 首先，它在table数组中找出要删除元素所在的Entry，
        // 然后，删除单向链表Entry中的元素。
        public void remove() {
            if (!iterator)
                throw new UnsupportedOperationException();
            if (lastReturned == null)
                throw new IllegalStateException("Hashtable Enumerator");
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            synchronized (Hashtable.this) {
                Entry<?, ?>[] tab = Hashtable.this.table;
                int index = (lastReturned.hash & 0x7FFFFFFF) % tab.length;

                //获取该槽位第一个元素
                @SuppressWarnings("unchecked")
                Entry<K, V> e = (Entry<K, V>) tab[index];
                //从单链表的一端向后遍历
                for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
                    //当前元素即为上一个返回元素
                    if (e == lastReturned) {
                        modCount++;
                        expectedModCount++;
                        //删除上一个元素
                        if (prev == null)
                            tab[index] = e.next;
                        else
                            prev.next = e.next;
                        count--;
                        lastReturned = null;
                        return;
                    }
                }
                throw new ConcurrentModificationException();
            }
        }
    }
}
