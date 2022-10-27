package grabber.impl;

import grabber.Grabber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpysMeGrabber extends Grabber {
    Pattern r = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:(\\d{2,5})");


    String[] urls = new String[]{"https://raw.githubusercontent.com/clarketm/proxy-list/master/proxy-list.txt"};

    @Override
    protected String[] getURLs() {
        return this.urls;
    }

    @Override
    protected void parsePage(String content) {
        Matcher m = r.matcher(content);
        while (m.find( )) {
            System.out.println(m.group() + " 应该换下一行");
        }
    }
}
