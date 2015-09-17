import javafx.scene.paint.Color;

public class Bal {
    private double x;
    private double y;
    private double vy;
    private double t;
    private Color kleur;
    private final double VALVERSNELLING = 9.81;


    public Bal(double x, double y, double radius) {
    	//Constructor voor de bal, reset om de bal standaard waardes te geven
        this.kleur = Color.RED;
        this.x = x;
        this.y = y;
        reset();
    }

    public void adjust(double dt) {
    	//omzetting van delta tijd naar miliseconden
    	dt = dt * 0.001;
        t = t + dt;
        //a + b worden afgemaakt om ervoor te zorgen dat 1/2 niet gezien wordt als 0. Nodig voor de formule
        float a = 1;
        float b = 2;
        float n = a/b;
        y = n * VALVERSNELLING * t * t;
        vy = VALVERSNELLING * t;
    }
    
    public void reset() {
    	//set de bal terug op zijn standaard waardes
        t = 0;
        x = 110;
        y = 0;
        vy = 0;
    }
    //getters
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
    //setters
    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

}