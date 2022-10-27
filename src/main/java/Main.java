import grabber.GrabberManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GrabberManager grabberManager = new GrabberManager();
        grabberManager.initGrabbers();
        grabberManager.runTasks();

        Thread.sleep(10000);
    }

}
