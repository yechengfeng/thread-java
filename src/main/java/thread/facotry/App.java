package thread.facotry;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: JustForFun
 * @description: 工厂模式创建线程
 * @author: leslie
 * @create: 2020-04-17 10:50
 **/
public class App {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("GAD");
        SleepThread sleepThread = new SleepThread();
        for (int i = 0; i < 10; i++) {
          Thread thread=  myThreadFactory.newThread(sleepThread);
          thread.start();
        }
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          List<String>  listInfo = myThreadFactory.getStats();
    listInfo.forEach(System.out::println);
        }

    }
}
