package java.lang;


public class Object {

    /**
     * 一个本地方法,具体是用C(C++)在DLL中实现的,然后通过JNI调用
     */
    private static native void registerNatives();

    /**
     * 对象初始化时自动调用此方法
     */
    static {
        registerNatives();
    }

    /**
     * 返回此Object的运行时类
     */
    public final native Class<?> getClass();

    /**
     * hashCode的常规协定是：
     * 1.在java应用程序执行期间,在对同一对象多次调用hashCode()方法时,必须一致地返回相同的整数,前提是将对象进行equals比较时所用的信息没有被修改。
     * 从某一应用程序的一次执行到同一应用程序的另一次执行,该整数无需保持一致。
     * 2.如果根据equals(object)方法,两个对象是相等的,那么对这两个对象中的每个对象调用hashCode方法都必须生成相同的整数结果。
     * 3.如果根据equals(java.lang.Object)方法,两个对象不相等,那么对这两个对象中的任一对象上调用hashCode()方法不要求一定生成不同的整数结果。
     * 但是,程序员应该意识到,为不相等的对象生成不同整数结果可以提高哈希表的性能。
     */
    public native int hashCode();

    /**
     * 这里比较的是对象的内存地址
     */
    public boolean equals(Object obj) {
        return (this == obj);
    }

    /**
     * 本地clone方法,用于对象的复制
     */
    protected native Object clone() throws CloneNotSupportedException;

    /**
     * 返回该对象的字符串表示,非常重要的方法
     * getClass().getName();获取字节码文件的对应全路径名例如java.lang.Object
     * Integer.toHexString(hashCode());将哈希值转成16进制数格式的字符串。
     */
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    /**
     * 不能被重写，用于唤醒一个在因等待该对象（调用了wait方法）被处于等待状态（waiting 或 time_wait）的线程，该方法只能同步方法或同步块中调用
     */
    public final native void notify();

    /**
     * 不能被重写，用于唤醒所有在因等待该对象（调用wait方法）被处于等待状态（waiting或time_waiting）的线程，该方法只能同步方法或同步块中调用
     */
    public final native void notifyAll();

    /**
     * 不能被重写，用于在线程调用中，导致当前线程进入等待状态（time_waiting)，timeout单位为毫秒,该方法只能同步方法或同步块中调用,超过设置时间后线程重新进入可运行状态
     */
    public final native void wait(long timeout) throws InterruptedException;


    public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                    "nanosecond timeout value out of range");
        }

        if (nanos > 0) {
            timeout++;
        }

        wait(timeout);
    }

    /**
     * 在其他线程调用此对象的notify()方法或notifyAll()方法前,导致当前线程等待。换句话说,此方法的行为就好像它仅执行wait(0)调用一样。
     * 当前线程必须拥有此对象监视器。
     * 该线程发布对此监视器的所有权并等待,直到其他线程通过调用notify方法或notifyAll方法通知在此对象的监视器上等待的线程醒来,
     * 然后该线程将等到重新获得对监视器的所有权后才能继续执行。
     */
    public final void wait() throws InterruptedException {
        wait(0);
    }

    /**
     * 这个方法用于当对象被回收时调用，这个由JVM支持，Object的finalize方法默认是什么都没有做，如果子类需要在对象被回收时执行一些逻辑处理，则可以重写finalize方法。
     */
    protected void finalize() throws Throwable {
    }
}
