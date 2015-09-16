import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class BalController implements Runnable, MouseWheelListener {

    private Bal bal;
    private BalView balView;
    private ValBewegingPaneel valBewegingPaneel;
    private ControlePaneelNoord noordpaneel;

    private Timeline animation;
    private boolean doorgaan_thread;
    private boolean doorgaan_wheel;
    private int dt;
    private double valhoogte;
    private Thread draad;

    public BalController(Bal bal, BalView balview, ValBewegingPaneel valBewegingPaneel,
        ControlePaneelNoord noordpaneel) {
        this.bal = bal;
        this.balView = balview;
        this.valBewegingPaneel = valBewegingPaneel;
        this.noordpaneel = noordpaneel;
        this.animation = new Timeline(new KeyFrame(Duration.millis(100)));

    }

    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param e
     * @see MouseWheelEvent
     */
    @Override public void mouseWheelMoved(MouseWheelEvent e) {

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override public void run() {

    }

    public void pleaseStart() {

    }

    public void pleaseStop() {

    }

    private void slaap(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
