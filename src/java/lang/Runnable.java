package java.lang;

/**
 * 任何 class 只要实现了 Runnable，就能被线程执行。
 * 定义了一个通用的标准，只要想被运行，就实现它。
 * 可以在不开子线程的情况下运行
 * Runnable 表示一类无返回值，且不抛出异常的任务
 * Runnable 类任务通常由 Thread 直接执行，也可以交给【任务执行器】Executor去执行
 * 此外，Runnable 还可以经过适配器的装配，与 Callable 类型、Future 类型等配合使用
 * 该接口已函数化：
 * Runnable runnable = new Runnable() {
 *     @Override
 *     public void run() {
 *         System.out.println("Runnable");
 *     }
 * };
 * 可以简写为：
 * Runnable runnable = () -> { System.out.println("Runnable"); };
 *
 * @see java.lang.Thread
 * @see java.util.concurrent.Callable
 */
@FunctionalInterface
public interface Runnable {
    /**
     * 任务执行入口
     *
     * @see java.lang.Thread#run()
     */
    void run();
}
