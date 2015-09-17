import javafx.scene.layout.HBox;

public class DataView extends HBox {
	 private Bal bal;  
	 private final int MINHOOGTE = 17; // minmale hoogte van dit view
	 private int hoogte;    
	 private ValBewegingApp valBewegingApp;// actuele hoogte van dit view
	   
	 private int x, y;
	 private boolean dragged = false;
	 private int dragX, dragY;
	 
	 public DataView(Bal bal){
		 this.bal = bal;
		 
		 
	 }
	   
}
