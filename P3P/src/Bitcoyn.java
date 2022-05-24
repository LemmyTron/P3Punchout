
public class Bitcoyn extends Object{

	public Bitcoyn (int x, int y, String pers, boolean whichWay){
		super(x, y, "bitcoin.java", whichWay);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		
		x+=vx;
		y+=vy;
		vy+=g;
		
	
	}
	
	//if crypto faces right && throw key clicked, call bitcoin projectile
	//if jump, projectile goes where
	
}