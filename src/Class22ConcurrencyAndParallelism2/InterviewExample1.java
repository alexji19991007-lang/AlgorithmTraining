package Class22ConcurrencyAndParallelism2;

// Question: What is the possible output of this program?
public class InterviewExample1 {
    static int counter = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                counter++;
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                counter++;
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}

























// ✅ 标准答案
// 不是 200000，而是：
// 任何小于等于 200000 的值（通常远小于 200000，比如 120000~180000）
// 💡考点
// 1. counter++ 不是原子操作
// 其实是 3 步：
// load counter
// add 1
// store counter

// 两个线程会发生：
// lost update（覆盖写）

// 2. race condition
// 两个线程可能同时读到同一个值：
// counter = 10
// T1: read 10
// T2: read 10
// T1: write 11
// T2: write 11   ❌ lost one increment

