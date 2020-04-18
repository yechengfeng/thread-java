package thread.condition;

import java.util.Random;

/**
 * @program: JustForFun
 * @description:消费者
 * @author: leslie
 * @create: 2020-04-18 14:57
 **/
public class Consumer  implements Runnable{
        private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){
            String  line =buffer.get();
            processLine(line);
        }
    }
    private void  processLine(String line ){
        Random random =new Random();
        try {
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
