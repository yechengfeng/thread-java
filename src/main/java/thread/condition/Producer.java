package thread.condition;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-18 14:52
 **/
public class Producer implements Runnable {
    private FileMock mock;
    private Buffer buffer;

    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()) {
            /**
             * 生产者mock数据，insert数据
             */
            String line = mock.getLines();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
