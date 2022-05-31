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
import java.util.Arrays;
public class Character {
	//declare/initialize variable for character selection index
	private static int index = 0;
	//declare x/y location values, health values variables
	private int x, y, hp; 
	//declare velocity variables
	private int hv, vv;
	//declare speed variable
	private double speed;
	//declare boolean for selection screen physics
	private boolean noPhysics = false;
	//declare boolean to check which way the character faces
	private boolean faceRight = false;	
	//declare scale variable for character sizes
	private double scale;
	//declare boolean variable for if punch is called
	public boolean punching = false;
	//declare Strings that can hold character img variations of
		//regular stand, stand reverse, punch, and punch reverse 
	private String reg;
	private String rev;
	private String punch;
	private String revpunch;
	
	
	//initialize and fill array with values to organize character selections
	boolean[] picked = new boolean[6];
	boolean henry = false;
	boolean bella = false;
	boolean david = false;
	boolean aak = false;
	boolean vianne = false;
	boolean cryp = false; 
	{
	picked[0] = henry;
	picked[1] = bella;
	picked[2] = david;
	picked[3] = aak;
	picked[4] = vianne;
	picked[5] = cryp;
	}
	
	
	//add gravity variable
	public double g = .001; 
	private Image img; 	

	private AffineTransform tx;

	//create character constructor for parent-class
	public Character(int x, int y, int health, String pers, String reverse, String punchng, String revPunching, double fastness, boolean whichWay, double height) {
		this.x = x;
		this.y = y;
		hp = health;
		//load the character images 
		img = getImage(pers); 
	
		scale = height;
	
		speed = fastness; 
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 			
		
		setFaceRight(whichWay);
		//add constructors above to for different img strings
			//to be assigned to values in each character subclass
		reg = pers;
		rev = reverse;
		punch = punchng;
		revpunch = revPunching;
	
	
	}
	
	public AffineTransform getTX() {
		return tx;
	}
	
	//update the character
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
	
	//method for sprite transitions
		//takes in String of image and sets it to img using getImage
		//assigned in indv character subclasses
	public void sprite(String yuh) {
		img = getImage(yuh);
	}
	
	//increase the index variable and rotate when necessary
	public void inc() {
		setDex(getDex()+1);
		if(getDex() == 6){
			setDex(0);
		}
			
	}
	//decrease the index variable and rotate when necessary
	public void dec() {
		setDex(getDex()-1);		
		if(getDex() == -1){
			setDex(5);
		}
			
	}
	//method to actually set character1 and character2
	//variables to right characters
	public Character whoIsYou(int num, int x, int y, boolean whichWay ){
		//switch statement to actually set the character as necessary
		//by returning it correctly, using the
		//index of the character select screen
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
	
	//method with a for-loop
	//to see if different characters are picked
	public int picked() {
		for(int i = 0; i < 6; i++) {
			if(picked[i]) {
				return i;
			}
		}
		return -1;
	}
	
	
	//movement methods using velocity
	//(both horizontal and vertical)
	public void jump()
	{
		vv -= 25; 
	}
	
	public void moveLeft()
	{
	hv -= speed;
	setFaceRight(false);
	
	}
	
	public void moveRight()
	{
	hv += speed;
	setFaceRight(true);
	
	}
	
	//declare punch method 
	//parameters for opponent, damage, right direction
	public void punch(Character opp, boolean rightDir, int hurtedness)
	{	
		//check if opponent is in range
		//using x and y and if right way is faced
		
	 	if (rightDir && opp.x > this.x && opp.x< this.x + 70 && this.y< opp.y + 40 && this.y> opp.y - 40)
	 	{
	 		
	 		opp.hp -= hurtedness;
	 		//subtract damage
	 	}
	 		
		if (!rightDir && opp.x < this.x && opp.x> this.x - 70 && this.y< opp.y + 40 && this.y> opp.y - 40)
	 	{
	 		opp.hp -= hurtedness;
	 		
	 	}	 		
	}
	
	
	

	//method for physics
	//and character location
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
		
		//use booleans to figure out sprite transitions
			//based on direction facind and if punching
		if(isFaceRight() && !punching) {
			sprite(reg);
		}
		if(!isFaceRight() && !punching) {
			sprite(rev);
		}
		if(isFaceRight() && punching) {
			sprite(punch);
		}
		if(!isFaceRight() && punching) {
			sprite(revpunch);
		}
	} 
	
	//method for getting right image
	//for character select screen
	public void preview(){
		//switch statement using the index of 
		//the character selct screen, getting the right
		//image and scaling as necessary
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
	
	//in character class create a method called setPunch method with punch image parameter, each character has their own assignment of that parameter 
	public void setPunch(String punchedImg) {
		img = getImage(punchedImg);
	}
	

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		update();
		g2.drawImage(img, tx, null);
		
		
	
		}

//getters	
	public int getX() {
		return x; 
	}
	public int getY() {
		return y;
	}
	public int getHp() {
		return hp; 
	}
	public int getVv() {
		return vv; 
	}
	public int getHv() {
		return hv; 
	}
	public double getSpeed() {
		return speed; 
	}
	public boolean getNoPhysics() {
		return noPhysics; 
	}
	public boolean getFaceRight() {
		return isFaceRight();
	}
	public double getScale() {
		return scale; 
	}
	public boolean getPunching() {
		return punching; 
	}
	public String getReg() {
		return reg;
	}
	public String getRev() {
		return rev;
	}
	public String getPunch() {
		return punch;
	}
	public String getRevPunch() {
		return revpunch;
	}
	public int getIndex() {
		return index; 
	}

	
	
	public String getHpStr() {
		return Integer.toString(hp); 
	}	
	public void setDex(int give) {
		index = give ;
	}
	public static int getDex() {
		return index;
	}
//setters
	public void setX(int setX) {
		this.x = setX;
	}
	public void setY(int setY) {
		this.y = setY;
	}

	public void setHp(int setHp) {
		this.hp = setHp;
	}
	public void setHv(int setHv) {
		this.hv = setHv;
	}
	public void setVv(int setVv) {
		this.vv = setVv;
	}
	
	public void setSpeed(double setSpeed) {
		this.speed = setSpeed;
	}

	void setNoPhysics(boolean setNoPhysics) {
		this.noPhysics = setNoPhysics;
	}
	

	public void setFaceRight(boolean setFaceRight) {
		this.faceRight = setFaceRight;
	}
	

	public void setScale(double setScale) {
		this.scale = setScale;
	}
	

	public void setPunching(boolean setPunching) {
		this.punching = setPunching;
	}
	

	public void setReg(String setReg) {
		this.reg = setReg;
	}
	

	public void setRev(String setRev) {
		this.rev = setRev;
	}
	

	public void setRevPunch(String setRevPunch) {
		this.revpunch = setRevPunch;
	}
	

	public void setIndex(int setIndex) {
		this.index = setIndex;
	}

	public boolean isFaceRight() {
		return faceRight;
	}
	

	
}
