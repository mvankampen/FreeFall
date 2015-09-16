import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.*;

public class BalView extends Pane {
    private Bal bal;
    private Circle rondje;
    private ValBewegingPaneel valPanel;
    private ControlePaneelNoord noordPaneel;
    private DataView dataView;

    public BalView(Bal bal, ValBewegingPaneel vp, ControlePaneelNoord np)
    {
        this.bal = bal;
        createCircle(this.bal);
        //this.setVisible(false); ?? staat in voorbeeld?
        getChildren().add(this.rondje);
    }

    private void  createCircle(Bal bal)
    {
        this.rondje = new Circle(this.bal.getX(), this.bal.getY(), 12);
        this.rondje.setFill(this.bal.getKleur());
        this.rondje.setStroke(Color.BLACK);
    }

    public void adjustBal()
    {
        this.rondje.setCenterX(this.bal.getX());
        this.rondje.setCenterY(this.bal.getY());
    }
}
