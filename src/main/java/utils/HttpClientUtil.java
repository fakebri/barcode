package utils;

import okhttp3.*;

public enum HttpClientUtil {
    INSTANCE;
    private final OkHttpClient client = new OkHttpClient();


    public void requestAsync(String url, String method, RequestBody requestBody, Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.59")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("Accept-Language", "en-US,en;q=0.5")
                .addHeader("Sec-Fetch-Dest", "document")
                .addHeader("Sec-Fetch-Mode", "navigate")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-User", "?1");

        // 空数据 RequestBody.create(null, new byte[]{})
        switch (method) {
            case "post" -> builder.post(requestBody);
            case "put" -> builder.put(requestBody);
            case "delete" -> {
                if (requestBody != null) {
                    builder.delete();
                } else {
                    builder.delete(requestBody);
                }
            }
            case "patch" -> builder.patch(requestBody);
        }
        Request request = builder.build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void requestAsync(String url, Callback callback) {
        requestAsync(url, "get", null, callback);
    }


}
