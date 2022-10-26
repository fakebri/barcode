import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrabberTest {
    String url = "https://raw.githubusercontent.com/TheSpeedX/SOCKS-List/master/http.txt";

    @Test
    public void request() throws IOException, InterruptedException {
        //第一步 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 一个grabber可能有多个URL，所以考虑还需要在grabber类加一个getURLs，然后循环访问
        //第二步 创建Request对象
        // Request对象可以做一个设置好UA等HTTP头的util
        Request request = new Request.Builder().url(url).build();
        //第三步 创建Call对象（Call其实是一个接口，具体实现还是RealCall类中）
        Call call = client.newCall(request);
        //第四步 call对象调用enqueue()方法，通过Callback()回调拿到响应体Response
        // 回调函数可以放到grabber类里面,
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //异步请求失败之后的回调
                //TODO:用Logger
                e.printStackTrace();
                System.out.println("Fail!");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //异步请求成功之后的回调
                // 执行页面解析代码
                String content = response.body().string();
                // 按指定模式在字符串查找
                String pattern = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:(\\d{2,5})";
                // 创建 Pattern 对象
                Pattern r = Pattern.compile(pattern);
                // 现在创建 matcher 对象
                Matcher m = r.matcher(content);
                while (m.find( )) {
                    System.out.println(m.group() + " 应该换下一行");
                }
                // 入库
                // 呃 没有数据库，预计使用ORM封装成类然后通过DAO进入数据库，数据库层兼容多个数据库。

            }
        });

        // Sleep主现成防止协程返回之前结束作业。
        Thread.sleep(5000);
    }

}
