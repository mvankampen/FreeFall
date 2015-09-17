import javafx.scene.paint.Color;

public class Bal {
    private double x;
    private double y;

    private double vy;
    private double t;

    private Color kleur;
    
    private final double VALVERSNELLING = 9.81;


    public Bal(double x, double y, double radius) {
        this.kleur = Color.RED;
        this.x = x;
        this.y = y;
        reset();
    }

    public void adjust(double dt) {
    	dt = 0.020;
        t = t + dt;
        System.out.println("De t waarde in adjust is " + t);
        System.out.println("De y waarde in adjust voor modificatie is " + y);
        float a = 1;
        float b = 2;
        float n = a/b;
        System.out.println("dit is de waarde van n" + n);
        y = n * VALVERSNELLING * t * t;
        vy = VALVERSNELLING * t;
        System.out.println("De y waarde in 'adjust' is " + y );
    }

    public void reset() {
        t = 0;
        x = 110;
        y = 0;
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

    public double getT() {
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