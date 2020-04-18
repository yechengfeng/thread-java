package thread.wait;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 14:20
 **/
public class Producer implements Runnable {
    private EventStorage storage;

    @Override
    public void run() {
      while (true){
            storage.set();
        }
    }

    public Producer(EventStorage eventStorage) {
        this.storage = eventStorage;
    }
}
