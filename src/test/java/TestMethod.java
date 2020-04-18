import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @program: JustForFun
 * @description: 测试关于java 1.8的新特性
 * 1.	Lambda 表达式
 * 2.   方法引用
 * 3.  	函数式接口
 * 4.  接口的默认方法
 * 5.  Stream 流
 * 6.  Optional 类
 * 7.  	Nashorn, JavaScript 引擎
 * 8. 	新的日期时间 API
 * 9.  	Base64
 * @author: leslie
 * @create: 2020-04-16 14:22
 **/
public class TestMethod {

    //新特性函数处理
    @Test
    public void testStream() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(Integer.toString(i));
        }
        strings.forEach((item) -> System.out.println(item));
        Set<String> strings1 = strings.stream().collect(Collectors.toSet());
    }


    //1.8新特性 Optional
    @Test
    public void optional() {

        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(a.orElse(0) + b.orElse(2));
    }


    //java 新特性 函数接口。
    @Test
    public void testFunction() {
//Function 函数接口
        Function<Integer, Integer> func = p -> p * 10;
        System.out.println(func.apply(2).intValue());
        //
        Consumer<String> consumer = p -> System.out.println(p);    // 因为没有出参，常用于打印、发送短信等消费动作
        consumer.accept("这是一个没有出参的函数接口哦");

        //
        Supplier<Integer> supplier = () -> 100;    // 常用于业务“有条件运行”时，符合条件再调用获取结果的应用场景；运行结果须提前定义，但不运行。
        System.out.println(supplier.get());

        //出参是一个 布尔类型。
        Predicate<Integer> predicate = p -> p % 2 == 0;
        System.out.println(predicate.test(2));
    }

    @Test
    public void testStream1() throws IOException {
        Supplier<String> streamDesc = () -> "| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|";
        System.out.println(streamDesc.get());
        String dataInfo = FileUtils.readFileToString(new File("/Users/yechengfeng/Downloads/市北机房.json"), "utf-8");
        JSONArray json = JSON.parseArray(dataInfo);
        List<Map<String, Object>> list = new ArrayList(JSONArray.toJavaObject(json, List.class));
        Set<String> s1 = list.stream().filter(item -> item.containsKey("原IP")).map(item -> item.get("原IP").toString()).collect(Collectors.toSet());
        s1.stream().forEach(item -> System.out.println(item));
        System.out.println(s1.stream().count());
        Set<Integer> a = s1.stream().map((String::hashCode)).collect(Collectors.toSet());
        a.forEach(System.out::println);
        a.forEach(item -> System.out.println(item));
        a.forEach(System.out::println);
        //一般只做遍历。
        a.forEach(item -> System.out.println());
        System.out.println(a.stream().findFirst().get());
    }

    @Test
    public void testStream2() throws IOException {
        Function<Integer, Integer> func = p -> p * 10;
        Consumer<String> consumer = p -> System.out.println(p);    // 因为没有出参，常用于打印、发送短信等消费动作
        Supplier<Integer> supplier = () -> 100;    // 常用于业务“有条件运行”时，符合条件再调用获取结果的应用场景；运行结果须提前定义，但不运行。
        Predicate<Integer> predicate = p -> p % 2 == 0; //出参是个boolean类型
        String dataInfo = FileUtils.readFileToString(new File("/Users/yechengfeng/Downloads/市北机房.json"), "utf-8");
        JSONArray json = JSON.parseArray(dataInfo);
        List<Map<String, Object>> list = new ArrayList(JSONArray.toJavaObject(json, List.class));
        list.stream().filter(
                item -> Integer.parseInt(StringUtils.substringAfterLast(item.get("原IP").toString(), ".")) > 145)
                .forEach(System.out::println);

        Map<String, Object> firstMap = list.stream().filter(
                item -> Integer.parseInt(StringUtils.substringAfterLast(item.get("原IP").toString(), ".")) > 145)
                .findFirst().get();

        String newIp = list.stream().filter(
                item -> Integer.parseInt(StringUtils.substringAfterLast(item.get("原IP").toString(), ".")) > 145)
                .map(item -> item.get("新IP").toString()).collect(Collectors.joining("***新ip"));


        Set set = list.stream().filter(
                item -> Integer.parseInt(StringUtils.substringAfterLast(item.get("原IP").toString(), ".")) > 145)
                .map(item -> item.get("新IP").toString()).collect(Collectors.toSet());


        System.out.println(newIp);
        list.stream().allMatch(item -> item.get("对应内网地址").toString().startsWith("192.168"));
        System.out.println(list.stream().filter(item -> !item.get("对应内网地址").toString().startsWith("192.168")).collect(Collectors.toSet()));
        System.out.println(list.stream().map(Map::keySet).collect(Collectors.toSet()));
        System.out.println(list.stream().map(Map::keySet).flatMap(Collection::stream).collect(Collectors.toSet()));

        Spliterator spliterator = list.spliterator().trySplit();
        System.out.println(spliterator.toString());
        list.stream().peek(item -> System.out.println("sysytem:" + item)).collect(Collectors.toSet());
    }

    @Test
    public void testSplit() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 2000; i++) {
            list.add("" + i);
        }
        list.spliterator().forEachRemaining(e -> System.out.println(e));
        System.out.println("end");
    }
}
