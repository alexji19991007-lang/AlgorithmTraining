package Class20ConcurrencyAndParallelism;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JavaFutureAndCallable {
    // Callable + Future（线程返回值）
    // Problem: Runnable 没返回值。
    // 如果想：异步计算 + 拿结果
    // 用：
    // * Callable<T>
    // * Future<T>
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 123;
        };

        Future<Integer> future = pool.submit(task);

        System.out.println("doing something else...");
        // future.get() 会：
        // * 阻塞等待结果 (i.e. blocking wait)
        Integer result = future.get();
        System.out.println(result);

        pool.shutdown();
    }
}
