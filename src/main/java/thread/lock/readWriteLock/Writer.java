package thread.lock.readWriteLock;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 16:57
 **/
public class Writer implements Runnable {
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s Writer :Attempt to Modify the Price.\n",new Date());
            pricesInfo.setPrices(Math.random()*10,Math.random()*8);
            System.out.printf("%s Writer :Price has been Modify.\r\n",new Date());
            System.out.println("-----------");
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
