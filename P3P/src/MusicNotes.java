
public class MusicNotes extends Object{
	public MusicNotes (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "musicnotes(1).png", whichWay, velocity);
		// TODO Auto-generated constructor stub
	}
	public void appear(Vyane b) {
		this.x= b.getX();
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
 