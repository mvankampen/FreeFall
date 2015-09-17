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
    private boolean doorgaan_thread = true;
    private boolean doorgaan_wheel;
    private double dt;
    private double valhoogte;
    private Thread draad;
    private int ms;

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

        while (doorgaan_thread) {
            if(this.bal.getY() < valhoogte) {
            	System.out.println("waiting");
                try {
					draad.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            else{
            	System.out.println("READDDDDDYYYYYYY");
            	this.animation.stop();
            	draad.stop();
            }
        }
    } 

    public void pleaseStart() {
        this.bal.reset();
        this.dt = this.noordpaneel.getDt();
        this.valhoogte = this.noordpaneel.getYbereik();
    	animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        final KeyFrame kf = new KeyFrame(Duration.millis(this.dt), e -> this.bal.adjust(this.dt));
        final KeyFrame kf2 = new KeyFrame(Duration.millis(this.dt), e -> this.balView.adjustBal());
        animation.getKeyFrames().addAll(kf,kf2);
        animation.play();
       System.out.println("Soap");
        this.noordpaneel.setDisable(true);
        draad = new Thread(this);
        draad.setDaemon(true);
        draad.start(); 

    }

    @SuppressWarnings("deprecation")
	public void pleaseStop() {
    	this.noordpaneel.setDisable(false);
        this.animation.stop();
        draad.stop();
    }
}
