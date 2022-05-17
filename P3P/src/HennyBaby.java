
public class HennyBaby extends Character{

	public HennyBaby(int x, int y, boolean whichWay) {
		super(x, y, 100, "henrystand.png",7, whichWay);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		
		x+=hv;
		y+=vv;
		vv+=g;
		regulate();
		
		getTX().setToTranslation(x, y);
		getTX().scale(.35, .35);
	
	}
}
