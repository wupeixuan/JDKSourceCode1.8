package java.lang.ref;

/**
 * 弱引用(Weak Reference)
 * 当一个对象为弱引用时，运行 GC 后会回收其引用指向的对象
 * 它可以用于解决非静态内部类的内存泄露问题（定义一个静态内部类，并让它持有外部类的弱引用）
 * 还可以用于实现缓存，比如 WeakHashMap
 *
 * @param <T>
 */
public class WeakReference<T> extends Reference<T> {

    /**
     * 对 referent 对象进行弱引用
     *
     * @param referent 被弱引用的对象
     */
    public WeakReference(T referent) {
        super(referent);
    }

    /**
     * 对 referent 对象进行弱引用，在对象被回收后，会把弱引用对象，也就是 WeakReference 对象或者其子类的对象，放入队列 ReferenceQueue 中
     *
     * @param referent 被弱引用的对象
     * @param q        引用队列
     */
    public WeakReference(T referent, ReferenceQueue<? super T> q) {
        super(referent, q);
    }

}
