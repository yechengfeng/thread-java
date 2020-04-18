package thread.group;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-16 11:44
 **/
public class MyThreadGroup extends ThreadGroup{
    public MyThreadGroup(String name) {
        super(name);
    }

    public MyThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("啊呀 ，抛异常了");
        System.out.println("info:"+e.getMessage());
        interrupt();
    }
}
