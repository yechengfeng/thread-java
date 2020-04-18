package thread.sync;

/**
 * @program: JustForFun
 * @description:停车厂状态
 * @author: leslie
 * @create: 2020-04-17 11:43
 **/
public class PackingStats {
    //当前的 汽车数量
    private long numberCars;
    //当前的摩托数量
    private long numberMotorcycles;
    //拥有一个停车收费信息类
    private PackingCash packingCash;

    public PackingStats(PackingCash packingCash) {
        numberCars = 0;
        numberMotorcycles = 0;
        this.packingCash = packingCash;
    }

    public synchronized void carComeIn() {
        numberCars++;
        System.out.println(String.format(" car come int |the car Num Now:"+numberCars));

    }

    public  synchronized void carGoOut() {
        numberCars--;
        System.out.println(String.format(" car come out |the car Num Now:"+numberCars));

        packingCash.vehiclePay();
    }

    public synchronized void motoCameIn() {
        System.out.println(String.format(" MotoCar come int |the MotoCar Num Now:"+numberMotorcycles));
        numberMotorcycles++;
    }

    public synchronized void motoOut() {
        System.out.println(String.format(" MotoCar come out |the MotoCar Num Now:"+numberMotorcycles));
        numberMotorcycles--;
        packingCash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }

}
