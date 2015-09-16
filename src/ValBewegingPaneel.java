import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ValBewegingPaneel extends HBox {
    private int startX, startY;
    private int eindX, eindY;
    private final int PARTS = 12;
    private ValBewegingApp valBewegingApp;

    public ValBewegingPaneel(ValBewegingApp valBewegingApp, ControlePaneelNoord noordpaneel) {
        Bal bal = new Bal(-20, -20, 11);
        this.valBewegingApp = valBewegingApp;
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        BalView balview = new BalView(bal, this, noordpaneel);
        BalController controller = new BalController(bal, balview, this,
            noordpaneel); // idem maar nu aan het controller-object?
        ControlePaneelZuid zuidpaneel = new ControlePaneelZuid(bal, balview, controller);
        this.valBewegingApp.pane.setBottom(zuidpaneel);

        this.getChildren().addAll(balview, canvas);

    }

    private void drawShapes(GraphicsContext gc) {
        startX = 500 / PARTS;   // in pixels
        startY = 500 / PARTS;  //
        eindX = (PARTS - 1) * startX;  //
        eindY = (PARTS - 1) * startY;  //
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.strokeLine(startX, startY, eindX, startY);
        gc.setLineDashes(5);
        for (int te = 2; te <= (PARTS - 2); te++) {
            gc.strokeLine(startX, te * startY, eindX, te * startY);
            gc.strokeLine(te * startX, startY, te * startX, eindY);
        }
        gc.setLineDashes(30);
        gc.strokeLine(startX, startY, eindX, startY);

    }
}
