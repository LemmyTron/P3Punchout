import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;
//test
public class Object {
	//add location attributes
		public int x, y; //position
		private Image img; 	
		private double vx; //can i change this to double
		private double vy;
		private AffineTransform tx;
		public Object resetObject;
		public boolean faceRight = false; 
		public double g = .001; 
		//boolean for paint
		//set boolean true, if true paint 
		private boolean paintObj;

		
		public Object(int x, int y, String image, boolean whichWay, double velocity) {
			this.x = x;
			this.y = y;
			img = getImage(image); //load the image for Tree
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); //initialize the location of the image //use your variables
			faceRight = whichWay; 
			
			//do i have to init velocity?
			vx = velocity; 
		}   
		
		public Object() {
			// TODO Auto-generated constructor stub
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
			double scale = 0; //new
			tx.scale(scale	, scale);
			
		}
		
	
		
		public void reset() {
			x = 380;
			vx = -2;
		}
		
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
		
		public Object whatObj(int num, int x, int y, boolean whichWay){
			switch(num) {
				case 0:
				{
					return new TennisBall(x, y, whichWay);
				}
				case 1:
				{
					return new Plant(x, y, whichWay);
				}
				case 2:
				{
					return new FGrade(x, y, whichWay);
				}
				case 3:
				{
					return new Rocket(x, y, whichWay);
				}
				case 4:
				{
					return new MusicNotes(x, y, whichWay);
				}
				case 5:
				{
					return new Bitcoin(x, y, whichWay);
				}
			}
			return null;
			
		}
		
		public void setImg(Image image) {
			img = image; 
		}
		//new

		public void paint1(Graphics g2) {
			// TODO Auto-generated method stub
			
		}

		public boolean isPaintObj() {
			return paintObj;
		}

		public void setPaintObj(boolean paintObj) {
			this.paintObj = paintObj;
		}

} 


