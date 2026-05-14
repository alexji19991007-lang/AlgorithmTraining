package Class20ConcurrencyAndParallelism;

public class JavaMultiThreading {
    public static void main(String[] args) {
        // 方法1: 继承Thread
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // t1.run() 和 t1.start() 的区别？
        // run() = 普通方法调用
        // start() = 真正开启新线程
        myThread1.start();
        myThread2.start();

        // 方法2: Implement Runnable Interface
        Runnable task = new MyTask();
        Thread myTask1 = new Thread(task);
        Thread myTask2 = new Thread(task);
        myTask1.start();
        myTask2.start();

        // 方法3: 使用Lambda (after Java 8)
        Runnable lambdaRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " : " + i
                );
            }
        };

        Thread lambdaTask1 = new Thread(lambdaRunnable);
        Thread lambdaTask2 = new Thread(lambdaRunnable);
        lambdaTask1.start();
        lambdaTask2.start();
    }

}

// 最原始的方法：继承Thread
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(
                Thread.currentThread().getName()
                + " : " + i
            );
        }
    }
}

// 更推荐的方法：Implement Runnable
class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(
                Thread.currentThread().getName()
                + " running " + i
            );
        }
    }
}
