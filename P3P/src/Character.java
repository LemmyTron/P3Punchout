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
	public int x, y, hp; 
	public int hv, vv;
	public double speed;
	public boolean faceRight = false;
	
	private double scale;
	
	
	public double g = .001; 
	private Image img; 	

	private AffineTransform tx;

	//create constructor for object
	public Character(int x, int y, int health, String pers, double fastness, boolean whichWay, double height) {
		this.x = x;
		this.y = y;
		hp = health;
		//load the character images 
		img = getImage(pers); 
	
		scale = height;
		
		speed = fastness; 
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 			
		
		faceRight = whichWay;
	
	}
	
	public AffineTransform getTX() {
		return tx;
	}
	
	public void update() {
		
		x+=hv;
		y+=vv;
		vv+=g;
		regulate();
		
		tx.setToTranslation(x, y);
		tx.scale(scale, scale);
	
	}
	
	public void jump()
	{
		vv -= 25; 
	}
	
	public void moveLeft()
	{
	hv -= speed;
	faceRight = false;
	
	}
	
	public void punch(Character opp, boolean rightDir, int hurtedness)
	{
	 	if (rightDir && opp.x > this.x && opp.x< this.x + 70)
	 	{
	 		opp.hp -= hurtedness;
	 		System.out.println(1);
	 	}
	 		
		if (!rightDir && opp.x < this.x && opp.x> this.x - 70)
	 	{
	 		opp.hp -= hurtedness;
	 		System.out.println(2);

	 	}
		
		
		System.out.println(opp.hp);
	 		
	}
	
	public void moveRight()
	{
	hv += speed;
	faceRight = true;
	
	}
	
	public void regulate()
	{
		if(hv > 0){
			hv-=.0001;
		}
		if(hv < 0){
			hv+=.0001;
		}
		if(hv > 12){
			hv = 12;
		}
		if(hv < -12)	{
			hv = -12;
		}
		
		if(y < 325){
			vv++;
		}
		if(y > 325){
			vv=0;
			y = 325;
		}
		if(x < 90){
			x = 90;
		}
		if(x > 680){
			x = 680;
		}
		
	} 
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.4, .4);
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
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		
		
		
	}
}
