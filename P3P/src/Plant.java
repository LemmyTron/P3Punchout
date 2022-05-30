
public class Plant extends Object{
	public Plant (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "plant.png", whichWay, velocity);
		// TODO Auto-generated constructor stub
	}

	public void appear(Belluh b) {
		this.x= b.getX();
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
