package grabber.callbacks;

import okhttp3.Call;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainCallBack extends CallBackBase {
    Pattern r = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:(\\d{2,5})");

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        String content = response.body().string();
        Matcher m = r.matcher(content);
        while (m.find( )) {
            System.out.println(m.group() + " 应该换下一行");
        }
    }
}
