package Class22ConcurrencyAndParallelism2;

// Question: What are the possible outputs of this program
public class InterviewExample3 {
    static boolean ready = false;
    static int number = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            number = 42;
            ready = true;
        });

        Thread t2 = new Thread(() -> {
            while (!ready) {
                // busy wait
            }
            System.out.println(number);
        });

        t2.start();
        t1.start();
    }
}






















// ✅ 标准答案
// 可能出现：
// ✔ 1. 正常情况
// 42
// ❌ 2. 也可能：
// 0
// 甚至：
// ❌ 3. t2 一直卡住（极端情况）

// 💡核心考点

// 1. visibility problem（可见性问题）
// t2 可能看不到：
// ready = true;
// number = 42;
// 的更新。

// 2. reordering（指令重排序）
// JVM / CPU 可能优化成：
// ready = true;
// number = 42;
// 或者甚至在另一线程视角：
// ready = true 可见了
// number 还没刷新

// 3. busy loop 不保证刷新缓存
// t2 可能一直在：
// CPU cache 里读旧值 ready=false