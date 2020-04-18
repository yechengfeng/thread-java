package thread.lock.readWriteLock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: JustForFun
 * @description:价格信息类。用读写锁去锁住读写。
 * @author: leslie
 * @create: 2020-04-17 16:40
 **/
public class PricesInfo {
    private Double priceOne;
    private Double priceTwo;
    private ReadWriteLock locks;

    public PricesInfo() {
        priceOne = 1.0;
        priceTwo = 2.0;
        locks = new ReentrantReadWriteLock();
    }

    public double getPriceOne() {
        locks.readLock().lock();
        double value = priceOne;
        locks.readLock().unlock();
        ;
        return value;
    }

    public double getPriceTwo() {
        locks.readLock().lock();
        double value = priceTwo;
        locks.readLock().unlock();
        ;
        return value;
    }

    public void setPrices(Double priceOne, Double priceTwo) {
        locks.writeLock().lock();
        System.out.printf("%s: PriceInfo: write lock \n", new Date());
        new Date();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.priceOne=priceOne;
        this.priceTwo=priceTwo;
        System.out.printf("%s: PriceInfo: write unLock \n",new Date());
        locks.writeLock().unlock();
    }
}
