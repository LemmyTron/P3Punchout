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

public class Character{
	
	public int x, y; //coordinates of big chungus 
	public double sh = 1.2 ; //horizontal speed variable 
	public double sv = 0 ; //vertical speed variable
	public double g = .7; // gravity acceleration variable 
	private Image img, flyingImg; 	
	public boolean wings = false;
	
	//create a polygon object for big chungus's hitbox
	Polygon chungus = new Polygon();

	
	
	private AffineTransform tx;

	//create constructor for object
	public BigChungus(int x, int y) {
		//initialize chungus with given coordinates 
		this.x = x;
		this.y = y;
		//load the big chungus images 
		img = getImage("/imgs/bigChungus.png"); 
		flyingImg = getImage("/imgs/fly.png"); 
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 			
		chungus.addPoint(x + 30, y );
		chungus.addPoint(x + 30, y+ 35);
		chungus.addPoint(x + 19, y + 50);
		chungus.addPoint(x + 19, y + 76);
		chungus.addPoint(x + 60, y + 76);
		chungus.addPoint(x + 55, y + 30);
		chungus.addPoint(x + 50, y + 20);
		chungus.addPoint(x + 50, y);
	}
	
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;		
		
		//call the update method
		update();
		
		
		
		//check to see if the space bar is being pressed
		//change sprite if so
		if(wings == false)
		{	tx.scale(1, 1);
			g2.drawImage(img, tx, null);
		}
		else {
			tx.scale(1.41,1.41);
			g2.drawImage(flyingImg, tx, null);
		}
		

	}
	
	//update chungus' position
	public void update() {
		
		tx.setToTranslation(x, y);
		tx.scale(.071, .071);
		
		//move chungus horizontally using speed
		x += sh;
		
		//move chungus vertically using speed
		y -= sv;
		
		//ensure that the velocity doesn't get too high or low
		if (!(sv < -13))
		{
			sv -= g;
		}
		if (sv > 11)
		{
			sv = 11;
		}
		//keep chungus on screen
		if(y < 0)
		{
			y = 0;
		}
		
		if(y > 295)
		{
			y = 295;
			sv = -1;
		}
		
	}
	
	//a function for creating a chungus hitbox 
	//by taking the current chungus coordinates
	public Polygon getSome()
	{
		Polygon chungus = new Polygon();
		chungus.addPoint(x + 30, y );
		chungus.addPoint(x + 30, y+ 35);
		chungus.addPoint(x + 19, y + 50);
		chungus.addPoint(x + 19, y + 76);
		chungus.addPoint(x + 60, y + 76);
		chungus.addPoint(x + 55, y + 30);
		chungus.addPoint(x + 50, y + 20);
		chungus.addPoint(x + 50, y);
		
		
		return chungus;
	}
	
	//function for jetpacking chungus around
	//by adding the speed to his vertical height
	public void jetpack()
	{
	sv += 9.5;

	
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.27, .27);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = BigChungus.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
