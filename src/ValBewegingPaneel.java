import javafx.scene.layout.HBox;

public class ValBewegingPaneel extends HBox {
    private int startX, startY;
    private int eindX, eindY;
    private final int PARTS = 12;

    public ValBewegingPaneel(ValBewegingApp valBewegingApp, ControlePaneelNoord noordpaneel) {
    	Bal bal = new Bal ();
		BalView balview = new BalView (bal, this, noordpaneel);
		BalController controller = new BalController (bal, balview, this, noordpaneel); // idem maar nu aan het controller-object? 
		this.getChildren().add(balview);
		ControlePaneelZuid zuidpaneel = new ControlePaneelZuid (bal, balview, controller);
		this.getChildren().addAll(zuidpaneel);
    }
}
