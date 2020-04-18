package thread.wait;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 14:24
 **/
public class Consumer implements Runnable{
    private EventStorage eventStorage;
    public Consumer(EventStorage eventStorage) {
        this.eventStorage=eventStorage;
    }
    @Override
    public void run() {
     while (true){
            eventStorage.get();
        }
    }


}
