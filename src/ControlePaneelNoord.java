import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by Michael on 16-09-15.
 */
public class ControlePaneelNoord extends HBox {
    private BalController balController;
    private Label labelBereikX;
    private Label labelBereikY;
    private TextField bereikXveld;
    private TextField bereikYveld;

    public NorthPane(BalController balController) {
        this.balController = balController;
        this.labelBereikX = new Label("Bereik x:");
        this.labelBereikY = new Label("Bereik y:");
        this.bereikXveld = new TextField();
        this.bereikYveld = new TextField();
        setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.getChildren().addAll(labelBereikX,bereikXveld, labelBereikY, bereikYveld);

    }
}
