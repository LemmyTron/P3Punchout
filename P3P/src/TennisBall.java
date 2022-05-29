
public class TennisBall extends Object{
	public TennisBall (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "tennisball.java", whichWay, velocity);
		// TODO Auto-generated constructor stub
	
	}
	
	public void appear(HennyBaby b) {
		this.x= b.getX();
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
