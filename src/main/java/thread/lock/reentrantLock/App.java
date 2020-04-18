package thread.lock.reentrantLock;

/**
 * @program: JustForFun
 * @description:
 * 通过print的打印工作介绍重入锁的公平锁策略和非公平锁策略
 *
 * 1. 默认 Flase 为非公平锁，随机分配给一个等待的线程, 底层代码不保证执行顺序。
 * 2. true 为公平锁，分配给等待时间最长的一个线程。底层代码严格保证执行顺序。
 * @author: leslie
 * @create: 2020-04-17 15:54
 **/
public class App {
    public static void main(String[] args) {
        System.out.println("Running example with fair-mode=false");

        testLock(true);
       System.out.println("Running example with fair-mode=true");
        testLock(false);

    }

    public static void testLock(Boolean failMode) {
        PrintQueue printQueue = new PrintQueue(failMode);
        Thread[] thread = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "thread-" +i);
            thread[i].start();

        }

        for (int i=0;i<10;i++){
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
