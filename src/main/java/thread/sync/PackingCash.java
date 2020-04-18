package thread.sync;

/**
 * @program: JustForFun
 * @description:模拟停车场,收费类
 * @author: leslie
 * @create: 2020-04-17 11:36
 **/
public class PackingCash {
    /**
     * 每次停车花费
     */
    private static final int cost =2;
    private long  cash;
    public PackingCash(){
        cash=0;
    }

    /**
     * 车子给我付钱，总金额增加
     */
    public  synchronized void vehiclePay(){

        cash+=cost;
        System.out.println(String.format("the cash Now:"+cash));
    }

    //打烊下班，计算收入
    public  synchronized  void close(){
        System.out.println("close accounting...");
        long totalAccount;
        totalAccount=cash;
        cash=0;
        System.out.println(String.format("the total  is :%s",totalAccount));
    }
}
