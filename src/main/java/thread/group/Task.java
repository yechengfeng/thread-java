package thread.group;

import java.util.Random;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 10:00
 **/
public class Task implements Runnable{
    @Override
    public void run() {
        while (true){
            int i= 100/((int)(new Random().nextDouble() *100));
        if (Thread.currentThread().isInterrupted()){
            System.out.println(String.format("thread interrupted: %s :",Thread.currentThread().getId()));
        return;
        }
        }
    }
}
