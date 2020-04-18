package thread.expection;

/**
 * @program: JustForFun
 * @description: 设置默认的线程异常处理类
 * @author: leslie
 * @create: 2020-04-17 14:04
 **/
public class App {
    public static void main(String[] args) {
        Thread thread =new Thread(new MyThread());
        thread.setUncaughtExceptionHandler(new ThreadException());
        thread.start();
    }
}
