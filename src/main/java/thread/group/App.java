package thread.group;

import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description:    线程组的概念
 * @author: leslie
 * @create: 2020-04-17 09:55
 **/
public class App {
    public static void main(String[] args) {
        MyThreadGroup myThreadGroup =new MyThreadGroup("GDA_DETAIL");
        Task task =new Task();
        for (int i=0;i<10;i++){
            Thread thread =new Thread(myThreadGroup,task);
            thread.start();

        }

        System.out.println("active Thread:" +myThreadGroup.activeCount());
        myThreadGroup.list();

        Thread[] threads =new Thread[myThreadGroup.activeCount()];
        myThreadGroup.enumerate(threads);
        for (int i=0;i<threads.length;i++)
        {
            System.out.println(String.format("theadName %s:%s",threads[i].getName(),threads[i].getState()));
        }
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
