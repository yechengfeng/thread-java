package thread.daemon;

import java.util.Date;
import java.util.Deque;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-15 16:14
 **/
public class ClearTask  extends Thread{
    private Deque<Event> deque;
    private int num;
    public ClearTask(Deque<Event> deque,int num) {
        this.deque=deque;
        setDaemon(true);
        this.num=num;
    }

    @Override
    public void run() {
       while (true){
           Date date =new Date();
           clean(date);
       }
    }
    private void clean (Date date){
        long difference;
        boolean delete;
        if (deque.size()==0){
            return;
        }
        delete=false;
        do{
            Event event = deque.getLast();
            difference =date.getTime() - event.getDate().getTime();
            if (difference>10000){
                System.out.println(String.format("cleaner: %s\n",event.getEvent()));
                deque.removeLast();
                delete=true;
            }

        }while (difference>10000);
        if (delete){
            System.out.println(String.format("cleaner:size of Query %d\n ",deque.size()));
            System.out.println(num);
            System.out.println(deque.size());
            System.out.println(String.format("计算机核数: %s",Math.floor(deque.size()/num)));
        }

    }
}
