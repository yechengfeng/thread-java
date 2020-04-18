import cn.miludeer.jsoncode.JsonCode;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-15 11:36
 **/
public class Test {

    @org.junit.Test
    public void testRuntime() throws IOException {
        Process process = Runtime.getRuntime().exec("ls");
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        Runtime.getRuntime().gc();
    }

    @org.junit.Test
    public void testThread() {

    }

    @org.junit.Test
    public void TestJson() {
        Map map = new HashMap();
        HashMap map1 = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map3.put("map2", map2);
        map2.put("map1", map1);
        map1.put("map", map);
        map.put("test", "as.df");
        JSONObject json = new JSONObject(map3);
        System.out.println(json);
        System.out.println(JsonCode.getValue(json.toJSONString(), "$.map2.map1.map.test"));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


    private void saveHtml(String localPath, String html) {
        FileWriter fw;
        int length = localPath.split("/").length;
        String localFileStr = localPath.replace(localPath.split("/")[length - 1], "");
        File file = new File(localFileStr);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            fw = new FileWriter(localPath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(html);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void test() {

     String   var3 = Charset.defaultCharset().name();



        saveHtml("/Users/yechengfeng/deskTop/a.html","hello world");
    }
}
