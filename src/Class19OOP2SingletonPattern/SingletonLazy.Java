package Class19OOP2Singleton;

// Lazy Initialization
public class SingletonLazy {
    // 可见性（visibility）
    // 多线程情况下：
    //    线程 A 创建了 INSTANCE
    //    线程 B 可能看不到最新值
    //👉 volatile 的作用：
    //    一个线程修改后，其他线程立刻能看到
    private volatile static SingletonLazy INSTANCE = null;

    private String msg;

    private SingletonLazy(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static SingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonLazy.class) { // Thread A acquires一个lock，并且在他进入后锁门
                // 31-33 Critical Section -- 我不希望多个threads同时进入到这三行代码中
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLazy("This is a Singleton (lazy)");
                }
            }
            // 结束critical section，Thread A把lock的所有权让渡出去，Thread B就可以acquire lock并且进入critical section了
        }
        return INSTANCE;
    }
}
