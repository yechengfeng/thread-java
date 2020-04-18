package thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 11:50
 **/
public class Sensor implements Runnable {
    private PackingStats packingStats;

    //每个线程模拟 30条车进入，带来 60 元收入
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            packingStats.carComeIn();
            packingStats.carComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            packingStats.motoCameIn();
            try {
                TimeUnit.MILLISECONDS.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            packingStats.motoOut();
            packingStats.carGoOut();
            packingStats.carGoOut();

        }

    }

    public Sensor(PackingStats packingStats) {
        this.packingStats = packingStats;
    }


}
