package thread.condition;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-18 15:01
 **/
public class App {
    public static void main(String[] args) {
        //模拟100行，每行10长度10。
        FileMock fileMock = new FileMock(100, 10);
        //模拟一个长度为20的缓冲区
        Buffer buffer = new Buffer(20);
        //生产数据
        Producer producer = new Producer(fileMock, buffer);
        Thread producerThread = new Thread(producer, "Producer");
        Consumer[] consumers = new Consumer[3];
        Thread[] consumersThread =new Thread[3];
        //三个线程消费数据
        for (int i=0;i<3;i++){
            consumers[i] =new Consumer(buffer);
            consumersThread[i]=new Thread(consumers[i],"Consumer_"+i);
        }
        producerThread.start();
        for (int i=0;i<3;i++){
            consumersThread[i].start();
        }

    }
}
