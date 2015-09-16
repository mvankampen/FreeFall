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
    @FXML
    private Button resetBtn;

    private Bal bal;
    private BalView balView;
    private BalController balController;

    public ControlePaneelZuid(Bal bal, BalView balview, BalController controller) {
        this.bal = bal;
        this.balView = balview;
        this.balController = controller;
        this.animatieBtn = new Button("Animatie");
        this.animatieBtn.setOnAction(event -> this.balController.pleaseStart());
        this.stopBtn = new Button("Stop");
        this.stopBtn.setOnAction(event -> this.balController.pleaseStop());
        this.resetBtn = new Button("Reset");
    }
}
