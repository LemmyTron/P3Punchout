import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Object {
	//add location attributes
		public int x, y; //position
		private Image img; 	
		protected int vx;
		protected int vy;
		private AffineTransform tx;
		public Object resetObject;
		public boolean throwRight = false; 
		public double g = .001; 
		
		
		public Object(int x, int y, String pers, boolean whichWay) {
			this.x = x;
			this.y = y;
			img = getImage(pers); //load the image for Tree
			
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); //initialize the location of the image //use your variables
			throwRight = whichWay; 
		}   
		
		public void changePicture(String newFileName) {
			img = getImage(newFileName);
			init(x, y);
		}
		
		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;

			//call update to update the actually picture location
			update();
			g2.drawImage(img, tx, null);
			//g.drawRect(x, y, w, h); 
			

		}
		/* update the picture variable location */
		private void update() {
			x+= vx; //velocity in y affects y location
			y+= vy;
			vy+= g;
			

			//prevent bird from leaving at the top of the frame - similar to the limit you added to pong paddles
			//if(y  <0) {
				//y=50;
				//vy=0;  
			//}
			//if(y>510) {
				//y=510;
				//vy=0;
			//}
			tx.setToTranslation(x, y);
			tx.scale(scale	, scale);
			
		}
		
		public void reset() {
			x = 380;
			vx = -2;
		}
		//public void flap() {
			//what's the intent if we command the bird to fly?
			//vy -= 15;
		//}
		//public void reset() {
			//y=200;
		//	vy=0;
		//}
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(.5, .5);
		}

		private Image getImage(String path) {
			Image tempImage = null;
			try {
				URL imageURL = Object.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tempImage;
		}
		public void setImg(Image image) {
			img = image; 
		}

}


