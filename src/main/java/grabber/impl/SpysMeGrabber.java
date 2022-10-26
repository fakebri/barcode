package grabber.impl;

import grabber.Grabber;
import grabber.callbacks.PlainCallBack;
import okhttp3.Callback;

public class SpysMeGrabber extends Grabber {

    String[] urls = new String[]{"https://raw.githubusercontent.com/clarketm/proxy-list/master/proxy-list.txt"};
    Callback formatCallBack = new PlainCallBack();

    @Override
    protected Callback constructCallBack() {
        return this.formatCallBack;
    }

    @Override
    protected String[] constructURLs() {
        return this.urls;
    }

}
