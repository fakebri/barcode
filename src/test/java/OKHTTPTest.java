import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import utils.HttpClientUtil;

import java.io.IOException;

public class OKHTTPTest {
    Callback testCallback = new Callback() {
        @Override
        public void onFailure(@NotNull Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(@NotNull Call call, Response response) throws IOException {
            System.out.println(response.body().string());
        }
    };

    @Test
    public void httpClientUtilTest() throws InterruptedException {
        HttpClientUtil httpClientUtil = HttpClientUtil.INSTANCE;
        httpClientUtil.requestAsync("https://httpbin.org/patch","patch",RequestBody.create(null, new byte[]{}),testCallback);
        Thread.sleep(5000);
    }
}
