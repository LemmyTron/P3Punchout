import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.net.URL;
public class Character {
	public int x, y; 
	private Image img; 	

	private AffineTransform tx;

	//create constructor for object
	public Character(int x, int y) {
		//initialize chungus with given coordinates 
		this.x = x;
		this.y = y;
		//load the big chungus images 
		img = getImage("/imgs/bigChungus.png"); 
	
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 			
	
	}
	
	public void update() {
		
		tx.setToTranslation(x, y);
		tx.scale(.071, .071);
	
	}
	
	
	
	public void moveLeft()
	{
	x -= 9.5;
	}
	
	
	public void moveRight()
	{
	x += 9.5;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.27, .27);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Character.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
}
