package thread.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 20:57
 **/
public class Buffer {
    /**
     *
     */

    private final LinkedList<String> buffer;


    private final int maxSize;

    private final ReentrantLock lock;


    private final Condition lines;
    private final Condition space;


    private Boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
    }

    /**
     * 插入到缓冲区
     * @param line
     */
    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Insert Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String line = null;
        lock.lock();
        try {
            while ((buffer.size()==0)&& hasPendingLines()){
                lines.await();
            }
            if (hasPendingLines()){
                line=buffer.poll();
                System.out.printf("%s Reader Line: %d\n ",Thread.currentThread().getName(),buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public synchronized void setPendingLines(Boolean pendingLines){
        this.pendingLines=pendingLines;
    }

    public  synchronized boolean hasPendingLines(){
        return pendingLines||buffer.size()>0;
    }
}
