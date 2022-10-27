package grabber;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import utils.HttpClientUtil;

import java.io.IOException;
import java.util.Objects;

public class Grabber {
    private final HttpClientUtil httpClientUtil = HttpClientUtil.INSTANCE;
    private final Callback callBack = new Callback(){
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            if (response.code() == 200) {
                String content = Objects.requireNonNull(response.body()).string();
                parsePage(content);
            } else {
                System.out.println("[Error] The page status code is not 200");
            }
        }
    };

    protected String[] getURLs() {
        return new String[0];
    }

    // 解析页面 然后 TODO:理论上返回可以进入数据库的对象
    protected void parsePage(String content) {
    }

    public void run() {
        String[] urls = getURLs();
        for (String url : urls) {
            httpClientUtil.requestAsync(url, callBack);
        }
    }

}
