package thread.safe;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description:threadLocal指定线程独有的内部变量。
 * @author: leslie
 * @create: 2020-04-16 11:11
 **/
public class SafeTask implements Runnable{

    private static ThreadLocal<Date> startTime = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };
    @Override
    public void run() {
        System.out.println(String.format("线程id:%s:start time:%s,", Thread.currentThread().getId(), startTime.get()));
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("线程id:%s:End time:%s,", Thread.currentThread().getId(), startTime.get()));
    }


}
