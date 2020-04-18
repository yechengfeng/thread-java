package thread.lock.reentrantLock;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 15:49
 **/
public class Job implements Runnable{
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s:going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s:is done to print a document\n",Thread.currentThread().getName());

    }
}
