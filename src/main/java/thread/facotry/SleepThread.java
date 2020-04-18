package thread.facotry;

import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 10:49
 **/
public class SleepThread implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
