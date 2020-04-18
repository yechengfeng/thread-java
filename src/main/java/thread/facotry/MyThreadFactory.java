package thread.facotry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 10:35
 **/
public class MyThreadFactory implements ThreadFactory {

    /**
     *
     */
    private int counter;

    /**
     *
     */
    private String name;

    private List<String> stats;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread" + (counter++));
        stats.add(String.format("create thread: %s,%s,%s", thread.getName(), thread.getId(), new Date()));

        return thread;
    }

    public MyThreadFactory(String name) {
        counter = 0;
        stats = new ArrayList<String>();
        this.counter = counter;
        this.name=name;
    }

    public List<String> getStats() {
        return stats;
    }
}

