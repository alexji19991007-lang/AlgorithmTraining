package Class19OOP2SingletonPattern;

// Better lazy initialization
// 对于JDK 5以前的版本，不存在volatile
public class SingletonLazyBetter {
    // Static nested class只会在第一次被需要的时候加载，也就是getInstance()被invoke的时候，
    // 而SingletonHolder被加载时才会实例化Singleton2这个类(lazy initialization)。静态
    // 变量的初始化是线程安全的（静态变量初始化只执行一次），所以这种方法既保证了线程安全，又保证了
    // lazy initialization，也不依赖于JDK版本，同时没有性能缺陷，基本上是比较完美的。

    // 但是这么写有一个非常大的restriction：
    //      - 不能传“动态参数”
    //      - new SingletonLazyBetter("xxx"); // 这个参数是写死的
    //      - getInstance("abc"); // 做不到（第一次初始化后就固定了）
    private static class SingletonHolder {
        // This is called 静态内部类单例（Initialization-on-demand holder idiom）
        // 没有锁
        // 没有 CAS
        // 没有 volatile 读写开销
        private static final SingletonLazyBetter INSTANCE = new SingletonLazyBetter("Lazy Initialization Without Volatile");
    }

    private String msg;

    private SingletonLazyBetter(String msg) {
        this.msg = msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static final SingletonLazyBetter getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
