import javafx.scene.paint.Color;

public class Bal {
	private double x;
	private double y;
	private double vy;
	private int t;
	private Color kleur;
	private final double valversnelling = 9.81;


public Bal()
{
	this.kleur = Color.RED;
	reset();
}

public void adjust (int dt)
{
	t = t + dt;
}
public void reset()
{
	t = 0;
	x = 10;
	y = 0;
}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getVy()
	{
		return vy;
	}
	public int getT()
	{
	    return t;
	}
	   
	public Color getKleur()
	{
	    return kleur;
	}
	public void setY (double y)
	{
		this.y = y;
	} 

	public void setX (double x)
	{
		this.x = x;
	}

}