package Class20ConcurrencyAndParallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaExecutorService {
    public static void main(String[] args) {
        // 方法4: 真正工作里最常用 -- ExecutorService
        // * 现实里几乎不会疯狂 new Thread。因为：
        //      创建线程很贵
        // * 所以 Java 有：
        //      Thread Pool（线程池）
        // 这才是真实生产环境最接近的写法, 因为：
        // * 限制线程数量
        // * 避免 OOM
        // * 避免线程创建开销
        // * 统一管理线程
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskId = i;

            Runnable myTask = () -> {
                System.out.println(Thread.currentThread().getName() + " executing task " + taskId);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            pool.submit(myTask);
        }

        pool.shutdown();
    }
}
