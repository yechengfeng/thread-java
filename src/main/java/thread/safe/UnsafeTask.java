package thread.safe;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description:并没有出现线程安全问题
 * @author: leslie
 * @create: 2020-04-16 10:18
 **/
public class UnsafeTask implements Runnable {
    private LocalDateTime localDateTime;
    private Date date;

    public UnsafeTask() {

    }

    @Override
    public void run() {
        date =new Date();
        localDateTime= LocalDateTime.now();;
        System.out.println(String.format("线程id:%s:start time:%s,", Thread.currentThread().getId(), localDateTime));
        // System.out.println(String.format("线程id:%s:start time:%s,",Thread.currentThread().getId(),date));

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("线程id:%s:End time:%s,", Thread.currentThread().getId(), localDateTime));
        //  System.out.println(String.format("线程id:%s:End time:%s,",Thread.currentThread().getId(),date));
    }
}
