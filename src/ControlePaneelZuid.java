import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Michael on 10-09-15.
 */
public class ControlePaneelZuid extends HBox {
    @FXML
    private Button animatieBtn;
    @FXML
    private Button stopBtn;

    private Bal bal;
    private BalView balView;
    private BalController balController;

    public ControlePaneelZuid(Bal bal, BalView balview, BalController controller) {
    	//zuidpaneel constructor
        this.bal = bal;
        this.balView = balview;
        this.balController = controller;
        this.animatieBtn = new Button("Animatie");
        //koppel de button event aan pleasestart
        this.animatieBtn.setOnAction(event -> this.balController.pleaseStart());
        this.stopBtn = new Button("Stop");
        //koppel de button event aan pleasestop
        this.stopBtn.setOnAction(event -> this.balController.pleaseStop());
        setAlignment(Pos.CENTER);
        this.getChildren().addAll(animatieBtn,stopBtn);
    }
}
