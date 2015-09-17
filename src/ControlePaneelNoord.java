import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by Michael on 16-09-15.
 */
public class ControlePaneelNoord extends HBox {
    private Label labelBereikX;
    private Label labelBereikY;
    private Label labelDeltaTijd;
    private TextField bereikXveld;
    private TextField bereikYveld;
    private TextField deltaTijdveld;
    
    

    public ControlePaneelNoord() {
    	//constructor van het noordpaneel
        this.labelBereikX = new Label("Bereik x:");
        this.labelBereikY = new Label("Bereik y:");
        this.labelDeltaTijd = new Label("Delta Tijd");
        this.bereikXveld = new TextField("100");
        this.bereikYveld = new TextField("100");
        this.deltaTijdveld = new TextField("20");
        setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.getChildren().addAll(labelBereikX,bereikXveld, labelBereikY, bereikYveld, labelDeltaTijd, deltaTijdveld);
    }
    //getters
    public double getYbereik()
    {
        return Double.parseDouble(this.bereikYveld.getText());
    }

    public double getXbereik()
    {
        return Double.parseDouble(this.bereikXveld.getText());
    }


    public double getDt()
    {
        return Double.parseDouble(this.deltaTijdveld.getText());
    }
}
