/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.atomic;

/**
 * An {@code AtomicStampedReference} maintains an object reference
 * along with an integer "stamp", that can be updated atomically.
 *
 * <p>Implementation note: This implementation maintains stamped
 * references by creating internal objects representing "boxed"
 * [reference, integer] pairs.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <V> The type of object referred to by this reference
 */
public class AtomicStampedReference<V> {

    /**
     * Pair内部类，用于维护reference和stamp
     * @param <T>
     */
    private static class Pair<T> {
        /**
         * 真正的数据
         */
        final T reference;
        /**
         * 版本号
         */
        final int stamp;
        private Pair(T reference, int stamp) {
            this.reference = reference;
            this.stamp = stamp;
        }
        /**
         * 返回Pair实例
         */
        static <T> Pair<T> of(T reference, int stamp) {
            return new Pair<T>(reference, stamp);
        }
    }

    /**
     * 由于要维护两个属性，因此干脆使用一个内部类对象来维护这两个属性
     */
    private volatile Pair<V> pair;

    /**
     * 创建具有给定初始值的新 AtomicStampedReference。
     * Creates a new {@code AtomicStampedReference} with the given
     * initial values.
     *
     * @param initialRef the initial reference 初始值
     * @param initialStamp the initial stamp 初始版本号
     */
    public AtomicStampedReference(V initialRef, int initialStamp) {
        //初始化一个Pair对象，并初始化属性值
        pair = Pair.of(initialRef, initialStamp);
    }

    /**
     *  获得当前保存的对象引用
     * Returns the current value of the reference.
     *
     * @return the current value of the reference
     */
    public V getReference() {
        return pair.reference;
    }

    /**
     * 获得当前保存的版本号
     * Returns the current value of the stamp.
     *
     * @return the current value of the stamp
     */
    public int getStamp() {
        return pair.stamp;
    }

    /**
     * Returns the current values of both the reference and the stamp.
     * Typical usage is {@code int[1] holder; ref = v.get(holder); }.
     *
     * @param stampHolder an array of size of at least one.  On return,
     * {@code stampholder[0]} will hold the value of the stamp.
     * @return the current value of the reference
     */
    public V get(int[] stampHolder) {
        Pair<V> pair = this.pair;
        stampHolder[0] = pair.stamp;
        return pair.reference;
    }

    /**
     * Atomically sets the value of both the reference and stamp
     * to the given update values if the
     * current reference is {@code ==} to the expected reference
     * and the current stamp is equal to the expected stamp.
     *
     * <p><a href="package-summary.html#weakCompareAndSet">May fail
     * spuriously and does not provide ordering guarantees</a>, so is
     * only rarely an appropriate alternative to {@code compareAndSet}.
     *
     * @param expectedReference the expected value of the reference
     * @param newReference the new value for the reference
     * @param expectedStamp the expected value of the stamp
     * @param newStamp the new value for the stamp
     * @return {@code true} if successful
     */
    public boolean weakCompareAndSet(V   expectedReference,
                                     V   newReference,
                                     int expectedStamp,
                                     int newStamp) {
        return compareAndSet(expectedReference, newReference,
                             expectedStamp, newStamp);
    }

    /**
     *  如果当前引用 == 预期引用，并且当前版本号等于预期版本号，则以原子方式将该引用和该标志的值设置为给定的更新值。
     * Atomically sets the value of both the reference and stamp
     * to the given update values if the
     * current reference is {@code ==} to the expected reference
     * and the current stamp is equal to the expected stamp.
     *
     * @param expectedReference the expected value of the reference
     * @param newReference the new value for the reference
     * @param expectedStamp the expected value of the stamp
     * @param newStamp the new value for the stamp
     * @return {@code true} if successful
     */
    public boolean compareAndSet(V   expectedReference,
                                 V   newReference,
                                 int expectedStamp,
                                 int newStamp) {
        Pair<V> current = pair;
        //一系列的判断，如果两个预期值都相等，那么尝试调用compareAndSwapObject使用新的Pair对象替代旧的Pair对象
        //这样就同时完成了reference和stamp的更新
        return
            expectedReference == current.reference &&
            expectedStamp == current.stamp &&
            ((newReference == current.reference &&
              newStamp == current.stamp) ||
             casPair(current, Pair.of(newReference, newStamp)));
    }

    /**
     * 设置新对象引用和版本号
     * Unconditionally sets the value of both the reference and stamp.
     *
     * @param newReference the new value for the reference 新对象引用
     * @param newStamp the new value for the stamp 新版本号
     */
    public void set(V newReference, int newStamp) {
        Pair<V> current = pair;
        //如果新对象引用以及新版本号和之前的都一样那就不设置
        //否则就是新建一个Pair对象并设置相应的属性，替代原来的Pair对象
        if (newReference != current.reference || newStamp != current.stamp)
            this.pair = Pair.of(newReference, newStamp);
    }

    /**
     * Atomically sets the value of the stamp to the given update value
     * if the current reference is {@code ==} to the expected
     * reference.  Any given invocation of this operation may fail
     * (return {@code false}) spuriously, but repeated invocation
     * when the current value holds the expected value and no other
     * thread is also attempting to set the value will eventually
     * succeed.
     *
     * @param expectedReference the expected value of the reference
     * @param newStamp the new value for the stamp
     * @return {@code true} if successful
     */
    public boolean attemptStamp(V expectedReference, int newStamp) {
        Pair<V> current = pair;
        return
            expectedReference == current.reference &&
            (newStamp == current.stamp ||
             casPair(current, Pair.of(expectedReference, newStamp)));
    }

    // Unsafe mechanics

    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    private static final long pairOffset =
        objectFieldOffset(UNSAFE, "pair", AtomicStampedReference.class);

    /**
     * CAS替换内部的Pair对象的方法
     *
     * @param cmp 预期pair对象
     * @param val 新pair对象
     * @return 如果成功，则返回 true
     */
    private boolean casPair(Pair<V> cmp, Pair<V> val) {
        return UNSAFE.compareAndSwapObject(this, pairOffset, cmp, val);
    }

    static long objectFieldOffset(sun.misc.Unsafe UNSAFE,
                                  String field, Class<?> klazz) {
        try {
            return UNSAFE.objectFieldOffset(klazz.getDeclaredField(field));
        } catch (NoSuchFieldException e) {
            // Convert Exception to corresponding Error
            NoSuchFieldError error = new NoSuchFieldError(field);
            error.initCause(e);
            throw error;
        }
    }
}
