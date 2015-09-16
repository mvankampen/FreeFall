import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Michael on 10-09-15.
 */
public class ControlePaneelZuid extends HBox {
    private BalController balController;
    private Button animatieBtn, stopBtn, resetBtn;

    public ControlePaneelZuid(BalController balController) {
        this.balController = balController;
        setAlignment(Pos.CENTER);
        this.animatieBtn = new Button("Animatie");
        this.stopBtn = new Button("Stop");
        this.resetBtn = new Button("Reset");

        getChildren().addAll(animatieBtn,stopBtn,resetBtn);
    }
}
