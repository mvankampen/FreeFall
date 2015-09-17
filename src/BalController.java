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
    	//constructor van balcontroller
        this.bal = bal;
        this.balView = balview;
        this.valBewegingPaneel = valBewegingPaneel;
        this.noordpaneel = noordpaneel;
    }

    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param e
     * @see MouseWheelEvent
     */
    @Override public void mouseWheelMoved(MouseWheelEvent e) {

    }

   
    @Override public void run() {
    	//runnable voor de thread draad. Wordt gebruikt om de y as 
    	//positie te monitoren en zet de animatie stop zodra de y as over de gezete y waarde in noordpane is (default 100)
        while (doorgaan_thread) {
            if(this.bal.getY() < valhoogte) {
            	//doe niets, hou de thread actief 
                try {
					draad.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            else{
            	//Y is groter dan valhoogte, dus stop de animatie
            	this.animation.stop();
            	draad.stop();
            }
        }
    } 

    public void pleaseStart() {
    	//start functie gelinkt aan de animatie button
    	//reset de bal zodat de animatie altijd op y = 0 begint
        this.bal.reset();
        //delta tijd is de invoer van noordpaneel delta tijd (default 20)
        this.dt = this.noordpaneel.getDt();
        //valhoogte is de invoer van noordpaneel ybereik (default 100)
        this.valhoogte = this.noordpaneel.getYbereik();
        //maak de animatie aan & laat deze bal.adjust() uitvoeren met een update voor de view voor oneidige periode
    	animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        final KeyFrame kf = new KeyFrame(Duration.millis(this.dt), e -> this.bal.adjust(this.dt));
        final KeyFrame kf2 = new KeyFrame(Duration.millis(this.dt), e -> this.balView.adjustBal());
        animation.getKeyFrames().addAll(kf,kf2);
        //start de animatie
        animation.play();
        //zet de buttons op disable zodat de waardes niet meer kunnen worden gewijzigd
        this.noordpaneel.setDisable(true);
        //maak de controle thread aan
        draad = new Thread(this);
        //daemon op true zodat de thread stopt bij het sluiten van de applicatie
        draad.setDaemon(true);
        draad.start(); 

    }

    @SuppressWarnings("deprecation")
	public void pleaseStop() {
    	//stop functie gelinkt aan de stop button
    	this.noordpaneel.setDisable(false);
    	//me stop de animatie en kill de thread
        this.animation.stop();
        draad.stop();
    }
}
