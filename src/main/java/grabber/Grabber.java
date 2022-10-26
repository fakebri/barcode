package grabber;

import okhttp3.Callback;
import utils.HttpClientUtil;

public class Grabber {
    protected HttpClientUtil httpClientUtil = HttpClientUtil.INSTANCE;
    protected Callback constructCallBack() {
        return null;
    }

    protected String[] constructURLs() {
        return new String[0];
    }

    public void run() {
        String[] urls = constructURLs();
        Callback formatCallBack = constructCallBack();
        for (String url : urls) {
            httpClientUtil.requestAsync(url, formatCallBack);
        }
    }

}
