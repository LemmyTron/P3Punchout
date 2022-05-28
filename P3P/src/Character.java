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
	private static int index = 0;
	public int x, y, hp; 
	public int hv, vv;
	public double speed;
	public boolean noPhysics = false;
	public boolean faceRight = false;
	public boolean p1 = false;
	
	private Object bitcoin;
	private Object fgrade;
	private Object musicnotes;
	public Object getObject; 
	private double scale;
	public boolean punchSprite = false; 
	//new
	private Image punchedImg; 
	
	
	public double g = .001; 
	private Image img; 	

	private AffineTransform tx;
	private Object plant;

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
		
		if(!noPhysics){
		regulate();
		}
		
		tx.setToTranslation(x, y);
		tx.scale(scale, scale);
	
	}
	public void inc() {
		index++;
		if(getDex() == 6){
			setDex(0);
		}
			
	}
	public void dec() {
		index--;
		if(getDex() == -1){
			setDex(5);
		}
			
	}
	
	public Character whoIsYou(int num, int x, int y, boolean whichWay ){
		switch(num) {
			case 0:
			{
				return new HennyBaby(x, y, whichWay);
			}
			case 1:
			{
				return new Belluh(x, y, whichWay);
			}
			case 2:
			{
				return new MD(x, y, whichWay);
			}
			case 3:
			{
				return new Aak(x, y, whichWay);
			}
			case 4:
			{
				return new Vyane(x, y, whichWay);
			}
			case 5:
			{
				return new CrypClub(x, y, whichWay);
			}
		}
		return null;
		
	}
	
	public void setDex(int give) {
		index = give ;
	}
	
	public static int getDex() {
		return index;
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
	
	public void preview(){
	
		switch(index) {	
		case 0:
			img = getImage("henrystand.png");
			scale = 1.5;
			break;
		case 1:
			img = getImage("bella.png");
			break;
		case 2:
			img = getImage("mrdavid.png");			
			break;
		case 3:
			img = getImage("aakarsh.png");
			break;
		case 4:
			img = getImage("vianneguitar.png");
			scale = 1.5;
			break;
		case 5:
			img = getImage("crypto.png");
			scale = .5;
			break;
		
		
		}
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.85, .85);
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
		
		//der her
		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		
		
		if(punchSprite == false) {
			//tx.scale(1,  1);
			g2.drawImage(img,  tx, null);
		}
		else if(punchSprite == true){
			//tx.scale(1, 1)
			g2.drawImage(punchedImg, tx, null); //need to change img to the punch image
		}
		
		
		
		
	}

	public Object getFgrade() {
		return fgrade;
	}

	public void setFgrade(Object fgrade) {
		this.fgrade = fgrade;
	}

	public Object getBitcoin() {
		return bitcoin;
	}

	public void setBitcoin(Object bitcoin) {
		this.bitcoin = bitcoin;
	}

	public Object getMusicnotes() {
		return musicnotes;
	}

	public void setMusicnotes(Object musicnotes) {
		this.musicnotes = musicnotes;
	}

	public Object getPlant() {
		return getPlant();
	}

	public void setPlant(Object plant) {
		this.plant = plant;
	}
}
