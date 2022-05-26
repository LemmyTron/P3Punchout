
public class Bitcoin extends Object{

	public Bitcoin (int x, int y, String image, boolean whichWay, double velocity){
		super(x, y, "bitcoin.png", whichWay, velocity);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		
		x +=vx;
		y +=vy;
		vy +=g;
		
	}
	
	//boom shakalaka
	
	public void appear(CrypClub b) {
		this.x= b.getX();
		
	}
	//if crypto faces right && throw key clicked, call bitcoin projectile
	//if jump, projectile goes where
	
}