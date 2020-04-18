package thread.lock.readWriteLock;


import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description: 通过 ReadWriteLock 锁保证数据一致性。演示了 读写锁
 * @author: leslie
 * @create: 2020-04-17 17:04
 **/
public class App {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader[] readers = new Reader[5];
        Thread[] threadReader = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadReader[i] = new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread writeThread = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threadReader[i].start();
        }
        writeThread.start();
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
