package thread.wait;

/**
 * @program: JustForFun
 * @description: 通过 wait()，notify()演示一个生产者消费者问题。
 * @author: leslie
 * @create: 2020-04-17 14:22
 **/
public class App {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        Thread threadProducer = new Thread(producer);
        Thread ThreadConsumer = new Thread(consumer);
        threadProducer.start();
        ThreadConsumer.start();
        try {
            threadProducer.join();
            ThreadConsumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
