package thread.lock.readWriteLock;

import java.util.Date;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 16:51
 **/
public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.printf("%s: %s PriceOne: %f\n", new Date()
                    , Thread.currentThread().getName(), pricesInfo.getPriceOne());
            System.out.printf("%s: %s PriceTwo: %f\n", new Date()
                    , Thread.currentThread().getName(), pricesInfo.getPriceTwo());
        }

    }
}
