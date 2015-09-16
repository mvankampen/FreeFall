import javafx.scene.paint.Color;

public class Bal {
    private double x;
    private double y;

    private double vy;
    private int t;

    private Color kleur;
    
    private final double VALVERSNELLING = 9.81;


    public Bal(double x, double y, double radius) {
        this.kleur = Color.RED;
        this.x = x;
        this.y = y;
        reset();
    }

    public void adjust(int dt) {
        t = t + dt;
        y = 1/2 * this.VALVERSNELLING * t * t;
        vy = this.VALVERSNELLING * t;
    }

    public void reset() {
        t = 0;
        x = 110;
        y = 40;
        vy = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVy() {
        return vy;
    }

    public int getT() {
        return t;
    }

    public Color getKleur() {
        return kleur;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

}