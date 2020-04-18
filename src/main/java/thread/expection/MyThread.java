package thread.expection;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-16 11:35
 **/
public class MyThread  implements Runnable{
    @Override
    public void run() {
            throw   new NullPointerException("啊呀，空指针异常哦!");
    }
}
