package java.util;

import sun.misc.SharedSecrets;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


/**
 * 概述：
 * List接口可调整大小的数组实现。实现所有可选的List操作，并允许所有元素，包括null，元素可重复。
 * 除了列表接口外，该类提供了一种方法来操作该数组的大小来存储该列表中的数组的大小。
 * 时间复杂度：
 * 方法size、isEmpty、get、set、iterator和listIterator的调用是常数时间的。
 * 添加删除的时间复杂度为O(N)。其他所有操作也都是线性时间复杂度。
 * 容量：
 * 每个ArrayList都有容量，容量大小至少为List元素的长度，默认初始化为10。
 * 容量可以自动增长。
 * 如果提前知道数组元素较多，可以在添加元素前通过调用ensureCapacity()方法提前增加容量以减小后期容量自动增长的开销。
 * 也可以通过带初始容量的构造器初始化这个容量。
 * 线程不安全：
 * ArrayList不是线程安全的。
 * 如果需要应用到多线程中，需要在外部做同步
 * modCount：
 * 定义在AbstractList中：protected transient int modCount = 0;
 * 已从结构上修改此列表的次数。从结构上修改是指更改列表的大小，或者打乱列表，从而使正在进行的迭代产生错误的结果。
 * 此字段由iterator和listiterator方法返回的迭代器和列表迭代器实现使用。
 * 如果意外更改了此字段中的值，则迭代器（或列表迭代器）将抛出concurrentmodificationexception来响应next、remove、previous、set或add操作。
 * 在迭代期间面临并发修改时，它提供了快速失败 行为，而不是非确定性行为。
 * 子类是否使用此字段是可选的。
 * 如果子类希望提供快速失败迭代器（和列表迭代器），则它只需在其 add(int,e)和remove(int)方法（以及它所重写的、导致列表结构上修改的任何其他方法）中增加此字段。
 * 对add(int, e)或remove(int)的单个调用向此字段添加的数量不得超过 1，否则迭代器（和列表迭代器）将抛出虚假的 concurrentmodificationexceptions。
 * 如果某个实现不希望提供快速失败迭代器，则可以忽略此字段。
 * transient：
 * 默认情况下,对象的所有成员变量都将被持久化.在某些情况下,如果你想避免持久化对象的一些成员变量,你可以使用transient关键字来标记他们,transient也是java中的保留字(JDK 1.8)
 */

public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    private static final long serialVersionUID = 8683452581122892189L;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空的对象数组
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 默认的空数组
     * 无参构造函数创建的数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 存放数据的数组的缓存变量，不可序列化
     */
    transient Object[] elementData;

    /**
     * 元素数量
     *
     * @serial
     */
    private int size;

    /**
     * 带有容量initialCapacity的构造方法
     *
     * @param initialCapacity 初始容量列表的初始容量
     * @throws IllegalArgumentException 如果指定容量为负
     */
    public ArrayList(int initialCapacity) {
        // 如果初始化时ArrayList大小大于0
        if (initialCapacity > 0) {
            // new一个该大小的object数组赋给elementData
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {// 如果大小为0
            // 将空数组赋给elementData
            this.elementData = EMPTY_ELEMENTDATA;
        } else {// 小于0
            // 则抛出IllegalArgumentException异常
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 不带参数的构造方法
     */
    public ArrayList() {
        // 直接将空数组赋给elementData
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 带参数Collection的构造方法
     *
     * @param c 其元素将被放入此列表中的集合
     * @throws NullPointerException 如果指定的集合是空的
     */
    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toarray可能（错误地）不返回对象[]（见JAVA BUG编号6260652）
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            // 使用空数组
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 因为容量常常会大于实际元素的数量。内存紧张时，可以调用该方法删除预留的位置，调整容量为元素实际数量。
     * 如果确定不会再有元素添加进来时也可以调用该方法来节约空间
     */
    public void trimToSize() {
        modCount++;
        // 如果size小于length
        if (size < elementData.length) {
            // 重新将elementData设置大小为size
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 使用指定参数设置数组容量
     *
     * @param minCapacity 所需的最小容量
     */
    public void ensureCapacity(int minCapacity) {
        //如果数组为空，容量预取0，否则去默认值(10)
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                // any size if not default element table
                ? 0
                // larger than default for default empty table. It's already
                // supposed to be at default size.
                : DEFAULT_CAPACITY;
        //若参数大于预设的容量，在使用该参数进一步设置数组容量
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    /**
     * 得到最小扩容量
     *
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 判断是否需要扩容
     *
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // 如果最小需要空间比elementData的内存空间要大，则需要扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 数组的最大容量，可能会导致内存溢出(VM内存限制)
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 扩容，以确保它可以至少持有由参数指定的元素的数目
     *
     * @param minCapacity 所需的最小容量
     */
    private void grow(int minCapacity) {
        // 获取到ArrayList中elementData数组的内存空间长度
        int oldCapacity = elementData.length;
        // 扩容至原来的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 再判断一下新数组的容量够不够，够了就直接使用这个长度创建新数组，
        // 不够就将数组长度设置为需要的长度
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //若预设值大于默认的最大值检查是否溢出
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 调用Arrays.copyOf方法将elementData数组指向新的内存空间时newCapacity的连续空间
        // 并将elementData的数据复制到新的内存空间
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 检查是否溢出，若没有溢出，返回最大整数值(java中的int为4字节，所以最大为0x7fffffff)或默认最大值
     *
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)   //溢出
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    /**
     * 返回ArrayList的大小
     *
     * @return ArrayList中的元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 返回是否为空
     *
     * @return true 如果ArrayList中无元素
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含一个数 返回bool
     *
     * @param o 检测o是否为ArrayList中元素
     * @return true 如果ArrayList中包含o元素
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    /**
     * 返回一个值在数组首次出现的位置，会根据是否为null使用不同方式判断。不存在就返回-1。时间复杂度为O(N)
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 返回一个值在数组最后一次出现的位置，会根据是否为null使用不同方式判断。不存在就返回-1。时间复杂度为O(N)
     *
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 返回副本，元素本身没有被复制，复制过程数组发生改变会抛出异常
     *
     * @return v ArrayList副本
     */
    public Object clone() {
        try {
            // 调用父类(翻看源码可见是Object类)的clone方法得到一个ArrayList副本
            ArrayList<?> v = (ArrayList<?>) super.clone();
            // 调用Arrays类的copyOf，将ArrayList的elementData数组赋值给副本的elementData数组
            v.elementData = Arrays.copyOf(elementData, size);
            v.modCount = 0;
            // 返回副本v
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    /**
     * 转换为Object数组，使用Arrays.copyOf()方法
     *
     * @return 一个数组包含所有列表中的元素, 且顺序正确
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 将ArrayList里面的元素赋值到一个数组中去
     * 如果a的长度小于ArrayList的长度，直接调用Arrays类的copyOf，返回一个比a数组长度要大的新数组，里面元素就是ArrayList里面的元素；
     * 如果a的长度比ArrayList的长度大，那么就调用System.arraycopy，将ArrayList的elementData数组赋值到a数组，然后把a数组的size位置赋值为空。
     *
     * @param a 如果它的长度大的话，列表元素将存储在这个数组中; 否则，将为此分配一个相同运行时类型的新数组。
     * @return 一个包含ArrayList元素的数组
     * @throws ArrayStoreException  将与数组类型不兼容的值赋值给数组元素时抛出的异常
     * @throws NullPointerException 数组为空
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // 创建一个新的a的运行时类型数组，内容不变
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }


    /**
     * 返回指定位置的值，因为是数组，所以速度特别快
     *
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 返回指定位置的值，但是会先检查这个位置数否超出数组长度
     *
     * @param index 要返回的元素的索引
     * @return ArrayList中指定位置的元素
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        // 检查是否越界
        rangeCheck(index);
        // 返回ArrayList的elementData数组index位置的元素
        return elementData(index);
    }

    /**
     * 设置指定位置为一个新值，并返回之前的值，会检查这个位置是否超出数组长度
     *
     * @param index   要替换的元素的索引
     * @param element 要存储在指定位置的元素
     * @return 之前在指定位置的元素
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E set(int index, E element) {
        // 检查是否越界
        rangeCheck(index);
        // 调用elementData(index)获取到当前位置的值
        E oldValue = elementData(index);
        // 将element赋值到ArrayList的elementData数组的第index位置
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 添加一个值，首先会确保容量
     *
     * @param e 要添加到此列表中的元素
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     */
    public boolean add(E e) {
        // 扩容
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        // 将e赋值给elementData的size+1的位置
        elementData[size++] = e;
        return true;
    }

    /**
     * 在ArrayList的index位置，添加元素element，会检查添加的位置和容量
     *
     * @param index   指定元素将被插入的索引
     * @param element 要插入的元素
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, E element) {
        // 判断index是否越界
        rangeCheckForAdd(index);
        // 扩容
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        //src:源数组； srcPos:源数组要复制的起始位置； dest:目的数组； destPos:目的数组放置的起始位置； length:复制的长度
        // 将elementData从index位置开始，复制到elementData的index+1开始的连续空间
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        // 在elementData的index位置赋值element
        elementData[index] = element;
        // ArrayList的大小加一
        size++;
    }

    /**
     * 在ArrayList的移除index位置的元素,会检查添加的位置，返回之前的值
     *
     * @param index 要删除的元素的索引
     * @return 从ArrayList中删除的元素
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E remove(int index) {
        // 判断是否越界
        rangeCheck(index);

        modCount++;
        // 读取旧值
        E oldValue = elementData(index);
        // 获取index位置开始到最后一个位置的个数
        int numMoved = size - index - 1;
        if (numMoved > 0)
            // 将elementData数组index+1位置开始拷贝到elementData从index开始的空间
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        // 使size-1 ，设置elementData的size位置为空，让GC来清理内存空间
        elementData[--size] = null; //便于垃圾回收器回收

        return oldValue;
    }

    /**
     * 在ArrayList的移除对象为O的元素，跟indexOf方法思想基本一致
     *
     * @param o 要从该列表中删除的元素（如果存在）
     * @return true 如果这个列表包含指定的元素
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }


    /**
     * 快速删除指定位置的值，之所以叫快速，应该是不需要检查和返回值，因为只内部使用
     *
     * @param index
     */
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        // 使size-1 ，设置elementData的size位置为空，让GC来清理内存空间
        elementData[--size] = null; //便于垃圾回收器回收
    }

    /**
     * 清空数组，把每一个值设为null,方便垃圾回收(不同于reset，数组默认大小有改变的话不会重置)
     */
    public void clear() {
        modCount++;

        //便于垃圾回收器回收
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        //把size设置为0，以便我们不会浏览到null值的内存空间
        size = 0;
    }

    /**
     * 添加一个集合的元素到末端，若要添加的集合为空返回false
     *
     * @param c 包含要添加到此列表中的元素的集合
     * @return true 如果该列表因添加而改变
     * @throws NullPointerException 如果指定的集合是空的
     */
    public boolean addAll(Collection<? extends E> c) {
        // 将c转换为数组a
        Object[] a = c.toArray();
        // 获取a占的内存空间长度赋值给numNew
        int numNew = a.length;
        // 扩容至size + numNew
        ensureCapacityInternal(size + numNew);  // Increments modCount
        // 将a的第0位开始拷贝至elementData的size位开始，拷贝长度为numNew
        System.arraycopy(a, 0, elementData, size, numNew);
        // 将size增加numNew
        size += numNew;
        // 如果c为空，返回false，c不为空，返回true
        return numNew != 0;
    }

    /**
     * 从第index位开始，将c全部拷贝到ArrayList,若要添加的集合为空返回false
     *
     * @param index 在哪个索引处插入指定集合中的第一个元素
     * @param c     包含要添加到此列表中的元素的集合
     * @return true 如果该列表因添加而改变
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException      如果指定的集合是空的
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        // 判断index大于size或者是小于0,如果是，则抛出IndexOutOfBoundsException异常
        rangeCheckForAdd(index);
        // 将c转换为数组a
        Object[] a = c.toArray();
        int numNew = a.length;
        // 扩容至size + numNew
        ensureCapacityInternal(size + numNew);  // Increments modCount
        // 获取需要添加的个数
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                    numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    /**
     * 删除指定范围元素。参数为开始删的位置和结束位置
     *
     * @throws IndexOutOfBoundsException if {@code fromIndex} or
     *                                   {@code toIndex} is out of range
     *                                   ({@code fromIndex < 0 ||
     *                                   fromIndex >= size() ||
     *                                   toIndex > size() ||
     *                                   toIndex < fromIndex})
     */
    protected void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = size - toIndex;//后段保留的长度
        System.arraycopy(elementData, toIndex, elementData, fromIndex,
                numMoved);

        //便于垃圾回收期回收
        int newSize = size - (toIndex - fromIndex);
        for (int i = newSize; i < size; i++) {
            elementData[i] = null;
        }
        size = newSize;
    }

    /**
     * 检查index是否超出数组长度 用于添加元素时
     */
    private void rangeCheck(int index) {
        // 如果下标超过ArrayList的数组长度
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 检查是否溢出
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 抛出的异常的详情
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * ArrayList移除集合c中的所有元素
     *
     * @param c 包含要从此列表中移除的元素的集合
     * @return {@code true} 如果该列表因移除而改变
     * @throws ClassCastException   if the class of an element of this list
     *                              is incompatible with the specified collection
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     *                              specified collection does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>),
     *                              or if the specified collection is null
     * @see Collection#contains(Object)
     */
    public boolean removeAll(Collection<?> c) {
        // 如果c为空，则抛出空指针异常
        Objects.requireNonNull(c);
        // 调用batchRemove移除c中的元素
        return batchRemove(c, false);
    }

    /**
     * 仅保留指定集合c中的元素
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws ClassCastException   if the class of an element of this list
     *                              is incompatible with the specified collection
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     *                              specified collection does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>),
     *                              or if the specified collection is null
     * @see Collection#contains(Object)
     */
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        // 调用batchRemove保留c中的元素
        return batchRemove(c, true);
    }

    /**
     * 根据complement值，将ArrayList中包含c中元素的元素删除或者保留
     *
     * @param c
     * @param complement true时从数组保留指定集合中元素的值，为false时从数组删除指定集合中元素的值。
     * @return 数组中重复的元素都会被删除(而不是仅删除一次或几次)，有任何删除操作都会返回true
     */
    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] elementData = this.elementData;
        // 定义一个w，一个r，两个同时右移
        int r = 0, w = 0;
        boolean modified = false;
        try {
            // r先右移
            for (; r < size; r++)
                // 如果c中不包含elementData[r]这个元素
                if (c.contains(elementData[r]) == complement)
                    // 则直接将r位置的元素赋值给w位置的元素，w自增
                    elementData[w++] = elementData[r];
        } finally {
            // 防止抛出异常导致上面r的右移过程没完成
            if (r != size) {
                // 将r未右移完成的位置的元素赋值给w右边位置的元素
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                // 修改w值增加size-r
                w += size - r;
            }
            // 如果有被覆盖掉的元素，则将w后面的元素都赋值为null
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;//改变的次数
                //新的大小为保留的元素的个数
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * 保存数组实例的状态到一个流（即序列化）。写入过程数组被更改会抛出异常
     *
     * @serialData The length of the array backing the <tt>ArrayList</tt>
     * instance is emitted (int), followed by all of its elements
     * (each an <tt>Object</tt>) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        //执行默认的反序列化/序列化过程。将当前类的非静态和非瞬态字段写入此流
        s.defaultWriteObject();

        // 写入大小
        s.writeInt(size);

        // 按顺序写入所有元素
        for (int i = 0; i < size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * 从流中重构ArrayList实例（即反序列化）。
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        // 执行默认的序列化/反序列化过程
        s.defaultReadObject();

        // 读入数组长度
        s.readInt(); // ignored

        if (size > 0) {
            // 像clone()方法 ，但根据大小而不是容量分配数组
            int capacity = calculateCapacity(elementData, size);
            SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, capacity);
            ensureCapacityInternal(size);

            Object[] a = elementData;
            //读入所有元素
            for (int i = 0; i < size; i++) {
                a[i] = s.readObject();
            }
        }
    }

    /**
     * 返回一个从index开始的ListIterator对象
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        return new ListItr(index);
    }

    /**
     * 返回一个ListIterator对象，ListItr为ArrayList的一个内部类，其实现了ListIterator<E> 接口
     *
     * @see #listIterator(int)
     */
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    /**
     * 返回一个Iterator对象，Itr为ArrayList的一个内部类，其实现了Iterator<E>接口
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * 通用的迭代器实现
     */
    private class Itr implements Iterator<E> {
        int cursor;       //游标，下一个元素的索引，默认初始化为0
        int lastRet = -1; //上次访问的元素的位置
        int expectedModCount = modCount;//迭代过程不运行修改数组，否则就抛出异常

        //是否还有下一个
        public boolean hasNext() {
            return cursor != size;
        }

        //下一个元素
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();//检查数组是否被修改
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;//向后移动游标
            return (E) elementData[lastRet = i];//设置访问的位置并返回这个值
        }

        //删除元素
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();//检查数组是否被修改

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayList.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        //检查数组是否被修改
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    /**
     * ListIterator迭代器实现
     */
    private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            checkForComodification();

            try {
                int i = cursor;
                ArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * Returns a view of the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations.
     * <p>
     * <p>This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>
     *      list.subList(from, to).clear();
     * </pre>
     * Similar idioms may be constructed for {@link #indexOf(Object)} and
     * {@link #lastIndexOf(Object)}, and all of the algorithms in the
     * {@link Collections} class can be applied to a subList.
     * <p>
     * <p>The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws IllegalArgumentException  {@inheritDoc}
     */
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        return new SubList(this, 0, fromIndex, toIndex);
    }

    /**
     * 安全检查
     *
     * @param fromIndex
     * @param toIndex
     * @param size
     */
    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }

    /**
     * 子数组
     */
    private class SubList extends AbstractList<E> implements RandomAccess {
        private final AbstractList<E> parent;
        private final int parentOffset;
        private final int offset;
        int size;

        SubList(AbstractList<E> parent,
                int offset, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.offset = offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = ArrayList.this.modCount;
        }

        public E set(int index, E e) {
            rangeCheck(index);
            checkForComodification();
            E oldValue = ArrayList.this.elementData(offset + index);
            ArrayList.this.elementData[offset + index] = e;
            return oldValue;
        }

        public E get(int index) {
            rangeCheck(index);
            checkForComodification();
            return ArrayList.this.elementData(offset + index);
        }

        public int size() {
            checkForComodification();
            return this.size;
        }

        public void add(int index, E e) {
            rangeCheckForAdd(index);
            checkForComodification();
            parent.add(parentOffset + index, e);
            this.modCount = parent.modCount;
            this.size++;
        }

        public E remove(int index) {
            rangeCheck(index);
            checkForComodification();
            E result = parent.remove(parentOffset + index);
            this.modCount = parent.modCount;
            this.size--;
            return result;
        }

        protected void removeRange(int fromIndex, int toIndex) {
            checkForComodification();
            parent.removeRange(parentOffset + fromIndex,
                    parentOffset + toIndex);
            this.modCount = parent.modCount;
            this.size -= toIndex - fromIndex;
        }

        public boolean addAll(Collection<? extends E> c) {
            return addAll(this.size, c);
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            rangeCheckForAdd(index);
            int cSize = c.size();
            if (cSize == 0)
                return false;

            checkForComodification();
            parent.addAll(parentOffset + index, c);
            this.modCount = parent.modCount;
            this.size += cSize;
            return true;
        }

        public Iterator<E> iterator() {
            return listIterator();
        }

        public ListIterator<E> listIterator(final int index) {
            checkForComodification();
            rangeCheckForAdd(index);
            final int offset = this.offset;

            return new ListIterator<E>() {
                int cursor = index;
                int lastRet = -1;
                int expectedModCount = ArrayList.this.modCount;

                public boolean hasNext() {
                    return cursor != SubList.this.size;
                }

                @SuppressWarnings("unchecked")
                public E next() {
                    checkForComodification();
                    int i = cursor;
                    if (i >= SubList.this.size)
                        throw new NoSuchElementException();
                    Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length)
                        throw new ConcurrentModificationException();
                    cursor = i + 1;
                    return (E) elementData[offset + (lastRet = i)];
                }

                public boolean hasPrevious() {
                    return cursor != 0;
                }

                @SuppressWarnings("unchecked")
                public E previous() {
                    checkForComodification();
                    int i = cursor - 1;
                    if (i < 0)
                        throw new NoSuchElementException();
                    Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length)
                        throw new ConcurrentModificationException();
                    cursor = i;
                    return (E) elementData[offset + (lastRet = i)];
                }

                @SuppressWarnings("unchecked")
                public void forEachRemaining(Consumer<? super E> consumer) {
                    Objects.requireNonNull(consumer);
                    final int size = SubList.this.size;
                    int i = cursor;
                    if (i >= size) {
                        return;
                    }
                    final Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    while (i != size && modCount == expectedModCount) {
                        consumer.accept((E) elementData[offset + (i++)]);
                    }
                    // update once at end of iteration to reduce heap write traffic
                    lastRet = cursor = i;
                    checkForComodification();
                }

                public int nextIndex() {
                    return cursor;
                }

                public int previousIndex() {
                    return cursor - 1;
                }

                public void remove() {
                    if (lastRet < 0)
                        throw new IllegalStateException();
                    checkForComodification();

                    try {
                        SubList.this.remove(lastRet);
                        cursor = lastRet;
                        lastRet = -1;
                        expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                public void set(E e) {
                    if (lastRet < 0)
                        throw new IllegalStateException();
                    checkForComodification();

                    try {
                        ArrayList.this.set(offset + lastRet, e);
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                public void add(E e) {
                    checkForComodification();

                    try {
                        int i = cursor;
                        SubList.this.add(i, e);
                        cursor = i + 1;
                        lastRet = -1;
                        expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                final void checkForComodification() {
                    if (expectedModCount != ArrayList.this.modCount)
                        throw new ConcurrentModificationException();
                }
            };
        }

        /**
         * 返回指定范围的子数组
         *
         * @param fromIndex
         * @param toIndex
         * @return
         */
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new SubList(this, offset, fromIndex, toIndex);
        }

        private void rangeCheck(int index) {
            if (index < 0 || index >= this.size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + this.size;
        }

        private void checkForComodification() {
            if (ArrayList.this.modCount != this.modCount)
                throw new ConcurrentModificationException();
        }

        public Spliterator<E> spliterator() {
            checkForComodification();
            return new ArrayListSpliterator<E>(ArrayList.this, offset,
                    offset + this.size, this.modCount);
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        @SuppressWarnings("unchecked") final E[] elementData = (E[]) this.elementData;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++) {
            action.accept(elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
     * list.
     * <p>
     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, and {@link Spliterator#ORDERED}.
     * Overriding implementations should document the reporting of additional
     * characteristic values.
     *
     * @return a {@code Spliterator} over the elements in this list
     * @since 1.8
     */
    @Override
    public Spliterator<E> spliterator() {
        return new ArrayListSpliterator<>(this, 0, -1, 0);
    }

    /**
     * Index-based split-by-two, lazily initialized Spliterator
     */
    static final class ArrayListSpliterator<E> implements Spliterator<E> {

        /**
         * 如果ArrayLists是不可变的，或者在结构上不可变（不添加，删除等），我们可以用Arrays.spliterator实现它们的分割器。
         * 相反，我们在遍历期间检测到尽可能多的干扰而不会影响性能。
         * 我们主要依靠modCounts。这些不能保证检测到并发冲突，有时对线程内干扰过于保守，但在实践中检测到足够的问题是值得的。
         * 为了实现这一点，我们
         * （1）懒惰地初始化fence和expectedModCount，直到我们需要提交到我们正在检查的状态的最后一点;从而提高精度。
         * （这不适用于SubLists，它会使用当前非惰性值的分割符）。
         * （2）我们在forEach（对性能最敏感的方法）结束时只执行一次ConcurrentModificationException检查。
         * 当使用forEach（而不是迭代器）时，我们通常只能在行为之后检测干扰，而不是之前。
         * 进一步的CME触发检查适用于所有其他可能的违反假设的情况，例如null或过小的elementData数组，因为它的大小（）只能由于干扰而发生。
         * 这允许forEach的内循环在没有任何进一步检查的情况下运行，并且简化了lambda分辨率。虽然这需要进行多次检查，但请注意，在list.stream（）。
         * forEach（a）的常见情况中，除forEach本身之外，不会执行任何检查或其他计算。其他较少使用的方法无法利用这些优化的大部分优势。
         */

        private final ArrayList<E> list;
        private int index; // current index, modified on advance/split
        private int fence; // -1 until used; then one past last index
        private int expectedModCount; // initialized when fence set

        /**
         * Create new spliterator covering the given  range
         */
        ArrayListSpliterator(ArrayList<E> list, int origin, int fence,
                             int expectedModCount) {
            this.list = list; // OK if null unless traversed
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() { // initialize fence to size on first use
            int hi; // (a specialized variant appears in method forEach)
            ArrayList<E> lst;
            if ((hi = fence) < 0) {
                if ((lst = list) == null)
                    hi = fence = 0;
                else {
                    expectedModCount = lst.modCount;
                    hi = fence = lst.size;
                }
            }
            return hi;
        }

        public ArrayListSpliterator<E> trySplit() {
            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
            return (lo >= mid) ? null : // divide range in half unless too small
                    new ArrayListSpliterator<E>(list, lo, index = mid,
                            expectedModCount);
        }

        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null)
                throw new NullPointerException();
            int hi = getFence(), i = index;
            if (i < hi) {
                index = i + 1;
                @SuppressWarnings("unchecked") E e = (E) list.elementData[i];
                action.accept(e);
                if (list.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return true;
            }
            return false;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            int i, hi, mc; // hoist accesses and checks from loop
            ArrayList<E> lst;
            Object[] a;
            if (action == null)
                throw new NullPointerException();
            if ((lst = list) != null && (a = lst.elementData) != null) {
                if ((hi = fence) < 0) {
                    mc = lst.modCount;
                    hi = lst.size;
                } else
                    mc = expectedModCount;
                if ((i = index) >= 0 && (index = hi) <= a.length) {
                    for (; i < hi; ++i) {
                        @SuppressWarnings("unchecked") E e = (E) a[i];
                        action.accept(e);
                    }
                    if (lst.modCount == mc)
                        return;
                }
            }
            throw new ConcurrentModificationException();
        }

        public long estimateSize() {
            return (long) (getFence() - index);
        }

        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        }
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        // figure out which elements are to be removed
        // any exception thrown from the filter predicate at this stage
        // will leave the collection unmodified
        int removeCount = 0;
        final BitSet removeSet = new BitSet(size);
        final int expectedModCount = modCount;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++) {
            @SuppressWarnings("unchecked") final E element = (E) elementData[i];
            if (filter.test(element)) {
                removeSet.set(i);
                removeCount++;
            }
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }

        // shift surviving elements left over the spaces left by removed elements
        final boolean anyToRemove = removeCount > 0;
        if (anyToRemove) {
            final int newSize = size - removeCount;
            for (int i = 0, j = 0; (i < size) && (j < newSize); i++, j++) {
                i = removeSet.nextClearBit(i);
                elementData[j] = elementData[i];
            }
            for (int k = newSize; k < size; k++) {
                elementData[k] = null;  // Let gc do its work
            }
            this.size = newSize;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            modCount++;
        }

        return anyToRemove;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final int expectedModCount = modCount;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++) {
            elementData[i] = operator.apply((E) elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c) {
        final int expectedModCount = modCount;
        Arrays.sort((E[]) elementData, 0, size, c);
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }
}
