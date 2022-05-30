import java.awt.Image;

public class Belluh extends Character{
	public Belluh(int x, int y,boolean whichWay) {
		super(x, y, 60, "bella.png", 8, whichWay, 0.31);
		// TODO Auto-generated constructor stub
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setPunch(String punchedImg) {
		punchedImg = getImage ("bellapunch.png");
	}
	
}
