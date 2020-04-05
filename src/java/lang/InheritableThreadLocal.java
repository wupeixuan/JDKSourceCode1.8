package java.lang;

/**
 * 创建允许子线程继承的 ThreadLocal
 *
 * @see ThreadLocal
 */
public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    /**
     * 拿到父线程的值后，可以在这里处理后再返回给子线程
     *
     * @param parentValue the parent thread's value
     * @return the child thread's initial value
     */
    protected T childValue(T parentValue) {
        return parentValue;
    }

    /**
     * 获取当前线程内的 inheritableThreadLocals 属性
     *
     * @param t 当前线程
     */
    ThreadLocalMap getMap(Thread t) {
        return t.inheritableThreadLocals;
    }

    /**
     * 初始化线程中的 inheritableThreadLocals 属性
     *
     * @param t          当前线程
     * @param firstValue value for the initial entry of the table.
     */
    void createMap(Thread t, T firstValue) {
        t.inheritableThreadLocals = new ThreadLocalMap(this, firstValue);
    }
}
