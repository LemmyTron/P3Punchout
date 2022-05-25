
public class FGrade extends Object{
	public FGrade (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "FGrade.png", whichWay, velocity);
		// TODO Auto-generated constructor stub
	}
	public void appear(MD b) {
		this.x= b.getX();
		
	}
}
