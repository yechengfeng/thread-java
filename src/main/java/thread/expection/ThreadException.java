package thread.expection;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-15 17:49
 **/
public class ThreadException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(String.format("%s 程序报错了:%s",t.getName(),e.getMessage()));
    }
}
