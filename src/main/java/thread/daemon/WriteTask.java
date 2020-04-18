package thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description: 利用守护进程大致判断计算机核数
 * @author: leslie
 * @create: 2020-04-15 13:36
 **/
public class WriteTask implements Runnable {
    private Deque<Event> deque;

    public WriteTask(Deque<Event> deque){
        this.deque=deque;
    }

    /**
     * 在前十秒，8 个线程 写入了 80 个事件
     *
     */
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            Event event =new Event();
            event.setDate(new Date());
            event.setEvent("generate a event:" +Thread.currentThread().getId()+"\n");
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
