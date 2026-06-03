package Class22ConcurrencyAndParallelism2;

// Question: What are the possible outputs of this program?
public class InterviewExample2 {
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            x = 1;
            System.out.println("T1-A: x=" + x);
            y = 1;
            System.out.println("T1-B: y=" + y);
        });

        Thread t2 = new Thread(() -> {
            y = 2;
            System.out.println("T2-A: y=" + y);
            x = 2;
            System.out.println("T2-B: x=" + x);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("MAIN: x=" + x + ", y=" + y);
    }
}



























// ✅ 核心答案（面试标准点）
// 💡关键结论
// 由于没有任何 synchronization / volatile：
// ✔ 输出顺序完全不确定
// ✔ 每个线程内部顺序是固定的（program order），但线程之间可以任意交错
// ✔ 最终 x/y 可能被“覆盖写”

// 🧠 可能的执行结果分析

// 我们先拆行为：

// Thread t1：
// x = 1
// print x
// y = 1
// print y

// Thread t2：
// y = 2
// print y
// x = 2
// print x

// 所有可能的关键 interleaving

// 🎯 情况 1：t2 完全覆盖 t1（最后写生效）
// T2-A: y=2
// T2-B: x=2
// T1-A: x=2
// T1-B: y=2
// MAIN: x=2, y=2

// 🎯 情况 2：t1 完全覆盖 t2
// T1-A: x=1
// T1-B: y=1
// T2-A: y=1
// T2-B: x=1
// MAIN: x=1, y=1

// 🎯 情况 3：交错（最常见）
// T1-A: x=1
// T2-A: y=2
// T1-B: y=2
// T2-B: x=2
// MAIN: x=2, y=2

// 🎯 情况 4：另一种交错
// T2-A: y=2
// T1-A: x=1
// T2-B: x=1
// T1-B: y=1
// MAIN: x=1, y=1

// 最终 MAIN 只有 4 种可能：
// ✔ (1,1)
// ✔ (2,2)
// ✔ (1,2)
// ✔ (2,1)