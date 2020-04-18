package thread.daemon;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description: 守护进程
 * @author: leslie
 * @create: 2020-04-17 14:05
 **/
public class App {
    public static void main(String[] args) {
        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        WriteTask writeTask = new WriteTask(deque);
        int num =2;
        for (int i = 0; i < num; i++) {
            Thread thread =new Thread(writeTask);
            thread.start();
        }
        ClearTask clearTask =new ClearTask(deque,num);
        clearTask.start();
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
