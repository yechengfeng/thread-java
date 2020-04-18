package thread.safe;

import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description: 关于线程安全的问题。
 * @author: leslie
 * @create: 2020-04-17 13:57
 **/
public class App {

    public static void main(String[] args) {
        // safe1();
        safe2();
      //  notSafe();
    }

    /**
     * 线程安全。但是资源消耗严重。
     */
    private static void safe1() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new UnsafeTask());
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.DAYS.sleep(232);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 线程安全
     */
    private static void safe2() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SafeTask());
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.DAYS.sleep(232);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程不安全
     */
    private static void notSafe() {
        UnsafeTask unsafeTask = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.DAYS.sleep(232);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
