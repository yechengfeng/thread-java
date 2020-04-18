package thread.lock.reentrantLock;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 15:38
 **/
public class PrintQueue {
    private Lock queueLock;

    public PrintQueue(Boolean failMode) {
        queueLock = new ReentrantLock(failMode);
    }
    public void printJob(Object document){
        queueLock.lock();
        long duration = (long)( Math.random()*10000);
        System.out.println(String.format("%s |printing a job during %d seconds!",Thread.currentThread().getName(),duration/1000));
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }
}
