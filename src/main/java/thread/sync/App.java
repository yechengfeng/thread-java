package thread.sync;

/**
 * @program: JustForFun
 * @description: 模拟车子进入 车库离开的过程，利用 加锁保证线程安全。
 *
 * @author: leslie
 * @create: 2020-04-17 11:22
 **/
public class App {
    public static void main(String[] args) {
        PackingCash packingCash = new PackingCash();
        PackingStats packingStats = new PackingStats(packingCash);
        Thread[] threads = new Thread[6];
        //6条线程的收入 360 快
        for (int i = 0; i < 6; i++) {
            Sensor  sensor= new Sensor(packingStats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < 6; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("Num for car: %d\n",packingStats.getNumberCars()));
        System.out.println(String.format("Num for MotoCar: %d\n",packingStats.getNumberMotorcycles()));
        packingCash.close();
    }
}
