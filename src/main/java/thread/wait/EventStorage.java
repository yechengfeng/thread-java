package thread.wait;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JustForFun
 * @description:一个消费中间件
 * @author: leslie
 * @create: 2020-04-17 14:08
 **/
public class EventStorage {
    private  int maxSize;
    private Queue<LocalDateTime> storage;

    public EventStorage(){
        maxSize=10;
        storage =new LinkedList<>();
    }
    public synchronized void set(){
        while (storage.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //插入，大于容量大小不会insert 到头部。
        storage.offer(LocalDateTime.now());
        System.out.println(String.format("Set:storage size: %d",storage.size()));
        notify();
    }

    public synchronized void get(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费并且remove
        String element=storage.poll().toString();
        System.out.println(String.format("Get:storage size: %d,|%s",storage.size(),element));
        notify();
    }
}
