package grabber;

import grabber.impl.SpysMeGrabber;

import java.util.ArrayList;
import java.util.List;

public class GrabberManager {
    private static final List<Grabber> grabbers = new ArrayList<>();

    public void initGrabbers() {
        grabbers.add(new SpysMeGrabber());
    }

    public void runTasks() {
        for(Grabber grabber: grabbers) {
            grabber.run();
        }
    }



}
