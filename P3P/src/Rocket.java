
public class Rocket extends Object{
	public Rocket (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "rocket.png", whichWay, velocity);
		// TODO Auto-generated constructor stub
	}
	public void appear(Aak b) {
		this.x= b.getX();
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
