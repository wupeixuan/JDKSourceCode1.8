package java.lang;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

/**
 * Runtime类，里面可以获得应用运行时的一些状态（主要包括使用的内存和cpu个数）和在应用运行时执行一些操作（程序退出、执行gc、设置退出时的钩子函数）。
 * 用到了单例模式：确保一个类最多只有一个实例，并提供一个全局访问点。
 */
public class Runtime {
    private static Runtime currentRuntime = new Runtime();

    /**
     * 应用了设计模式中的单例模式饿汉式(线程安全)
     * 返回与当前应用程序相关的java运行时对象。
     */
    public static Runtime getRuntime() {
        return currentRuntime;
    }

    /**
     * 私有构造函数，单例模式的条件，返回与当前应用程序相关的java运行时对象,不支持new的Runtime
     */
    private Runtime() {
    }

    /**
     * 通过启动虚拟机的关闭序列，终止当前正在运行的 Java 虚拟机。此方法从不正常返回。可以将变量作为一个状态码；根据惯例，非零的状态码表示非正常终止。
     * 虚拟机的关闭序列包含两个阶段。在第一个阶段中，会以某种未指定的顺序启动所有已注册的关闭钩子(hook)（如果有的话），并且允许它们同时运行直至结束。
     * 在第二个阶段中，如果已启用退出终结，则运行所有未调用的终结方法。一旦完成这个阶段，虚拟机就会暂停。
     * 如果在虚拟机已开始其关闭序列后才调用此方法，那么若正在运行关闭钩子，则将无限期地阻断此方法。
     * 如果已经运行完关闭钩子，并且已启用退出终结 (on-exitfinalization)，那么此方法将利用给定的状态码（如果状态码是非零值）暂停虚拟机；否则将无限期地阻断虚拟机。
     */
    public void exit(int status) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkExit(status);
        }
        Shutdown.exit(status);
    }

    /**
     * 注册新的虚拟机来关闭钩子。
     */
    public void addShutdownHook(Thread hook) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("shutdownHooks"));
        }
        ApplicationShutdownHooks.add(hook);
    }

    /**
     * 取消注册某个先前已注册的虚拟机关闭钩子。
     * 如果指定的钩子先前已注册并且成功地取消注册，则返回 true，其他情况返回 false。
     */
    public boolean removeShutdownHook(Thread hook) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("shutdownHooks"));
        }
        return ApplicationShutdownHooks.remove(hook);
    }

    /**
     * 强行终止目前正在运行的 Java 虚拟机。此方法从不正常返回。
     * 应小心使用此方法。与 exit方法不同，此方法不会启动关闭钩子，并且如果已启用退出终结，此方法也不会运行未调用的终结方法。
     * 如果已经发起关闭序列，那么此方法不会等待所有正在运行的关闭钩子或终结方法完成其工作。
     */
    public void halt(int status) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkExit(status);
        }
        Shutdown.halt(status);
    }

    /**
     * 在退出时启用或禁用终结；这样做可指定拥有未被自动调用终结方法的所有对象的终结方法，并将在退出 Java 运行时前运行此终结方法。默认情况下，禁用退出终结。
     * 如果有安全管理器，则首先使用 0 作为变量来调用其 checkExit 方法，以确保允许退出。这可能会导致 SecurityException。
     */
    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            try {
                security.checkExit(0);
            } catch (SecurityException e) {
                throw new SecurityException("runFinalizersOnExit");
            }
        }
        Shutdown.setRunFinalizersOnExit(value);
    }

    /**
     * 在单独的进程中执行指定的字符串命令。
     * 对于 exec(command) 形式的调用而言，其行为与调用 exec(command, null, null) 完全相同。
     */
    public Process exec(String command) throws IOException {
        return exec(command, null, null);
    }

    /**
     * 在指定环境的单独进程中执行指定的字符串命令。
     * 对于 exec(command, envp) 形式的调用而言，其行为与调用 exec(command, envp, null) 完全相同。
     */
    public Process exec(String command, String[] envp) throws IOException {
        return exec(command, envp, null);
    }

    /**
     * 在有指定环境和工作目录的独立进程中执行指定的字符串命令。
     * 对于 exec(command, envp, dir) 形式的调用而言，其行为与调用 exec(cmdarray, envp, dir) 完全相同，其中 cmdarray 是 command 中所有标记的数组。
     * 更准确地说，可以使用通过调用 new StringTokenizer(command) 创建的 StringTokenizer 将 command 字符串拆解成标记，调用时不对字符类别做进一步的修改。
     * 然后将标记生成器所生成的标记以相同的顺序放入新的字符串数组 cmdarray 中。
     */
    public Process exec(String command, String[] envp, File dir)
            throws IOException {
        if (command.length() == 0)
            throw new IllegalArgumentException("Empty command");

        StringTokenizer st = new StringTokenizer(command);
        String[] cmdarray = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++)
            cmdarray[i] = st.nextToken();
        return exec(cmdarray, envp, dir);
    }

    /**
     * 在单独的进程中执行指定命令和变量。
     * 对于 exec(cmdarray) 形式的调用而言，其行为与调用 exec(cmdarray, null, null) 完全相同。
     */
    public Process exec(String cmdarray[]) throws IOException {
        return exec(cmdarray, null, null);
    }

    /**
     * 在指定环境的独立进程中执行指定命令和变量。
     * 对于 exec(cmdarray, envp) 形式的调用而言，其行为与调用 exec(cmdarray, envp, null) 完全相同。
     */
    public Process exec(String[] cmdarray, String[] envp) throws IOException {
        return exec(cmdarray, envp, null);
    }


    /**
     * 在指定环境和工作目录的独立进程中执行指定的命令和变量。
     * 给定的字符串数组 cmdarray 表示一个命令行标记，字符串数组 envp 则表示“环境”变量设置，此方法会创建一个新进程，而指定的命令就在这个进程中执行。
     * 此方法检查 cmdarray 是否是一条有效的操作系统命令。哪些命令有效取决于系统，但是该命令至少必须有一个非 null 字符串的非空列表。
     */
    public Process exec(String[] cmdarray, String[] envp, File dir)
            throws IOException {
        return new ProcessBuilder(cmdarray)
                .environment(envp)
                .directory(dir)
                .start();
    }

    /**
     * 向 Java 虚拟机返回可用处理器的数目。
     * 该值在特定的虚拟机调用期间可能发生更改。因此，对可用处理器数目很敏感的应用程序应该不定期地轮询该属性，并相应地调整其资源用法。
     * 虚拟机可用的最大处理器数目；从不小于 1
     */
    public native int availableProcessors();

    /**
     * 返回 Java 虚拟机中的空闲内存量。调用 gc 方法可能导致 freeMemory 返回值的增加。
     */
    public native long freeMemory();

    /**
     * 返回 Java 虚拟机中的内存总量。此方法返回的值可能随时间的推移而变化，这取决于主机环境。
     */
    public native long totalMemory();

    /**
     * 返回 Java 虚拟机试图使用的最大内存量。如果内存本身没有限制，则返回值 Long.MAX_VALUE。
     */
    public native long maxMemory();

    /**
     * 运行垃圾回收器。调用此方法意味着 Java 虚拟机做了一些努力来回收未用对象，以便能够快速地重用这些对象当前占用的内存。
     * 当控制从方法调用中返回时，虚拟机已经尽最大努力回收了所有丢弃的对象。
     * 垃圾回收机制主要有两类：引用计数收集器  跟踪收集器
     */
    public native void gc();

    /* Wormhole for calling java.lang.ref.Finalizer.runFinalization */
    private static native void runFinalization0();

    /**
     * 运行挂起 finalization 的所有对象的终止方法。
     * 调用此方法意味着 Java 虚拟机做了一些努力运行已被丢弃对象的 finalize 方法，
     * 但是这些对象的 finalize 方法还没有运行。当控制从方法调用中返回时，Java 虚拟机已经尽最大努力去完成所有未执行的终止方法。
     * 如果不显式调用 runFinalization 方法，则 Java 虚拟机会根据需要在单独的线程中自动执行此终止过程。
     */
    public void runFinalization() {
        runFinalization0();
    }

    /**
     * 启用／禁用指令跟踪。
     */
    public native void traceInstructions(boolean on);

    /**
     * 启用／禁用方法调用跟踪。
     */
    public native void traceMethodCalls(boolean on);

    /**
     * 加载具有指定动态库。
     */
    @CallerSensitive
    public void load(String filename) {
        load0(Reflection.getCallerClass(), filename);
    }

    synchronized void load0(Class<?> fromClass, String filename) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkLink(filename);
        }
        if (!(new File(filename).isAbsolute())) {
            throw new UnsatisfiedLinkError(
                    "Expecting an absolute path of the library: " + filename);
        }
        ClassLoader.loadLibrary(fromClass, filename, true);
    }

    /**
     * 加载具有指定动态库。
     */
    @CallerSensitive
    public void loadLibrary(String libname) {
        loadLibrary0(Reflection.getCallerClass(), libname);
    }

    synchronized void loadLibrary0(Class<?> fromClass, String libname) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkLink(libname);
        }
        if (libname.indexOf((int) File.separatorChar) != -1) {
            throw new UnsatisfiedLinkError(
                    "Directory separator should not appear in library name: " + libname);
        }
        ClassLoader.loadLibrary(fromClass, libname, false);
    }

    /**
     * 创建输入流的本地化版本。此方法获取 InputStream，并返回除本地化外其他所有方面都和变量等效的 InputStream，这些方面包括：作为本地字符集中的字符从流中被读取，并将它们从本地字符集自动转换为 Unicode。
     */
    @Deprecated
    public InputStream getLocalizedInputStream(InputStream in) {
        return in;
    }

    /**
     * 创建输出流的本地化版本。此方法获取 OutputStream，并返回除本地化外其他所有方面都和变量等效的 OutputStream，这些方面包括：作为 Unicode 字符被写入流中，并被自动转换为本地字符集。
     * 如果参数已经是本地流，则可作为结果返回。
     */
    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream out) {
        return out;
    }

}
