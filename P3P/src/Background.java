
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Background{
	
	private int x, y;
	ArrayList<String> winners = new ArrayList<String>(); 
	private Image img; 	
	private AffineTransform tx;
	
	//test stuff
	private double scale = 8;
	public boolean selectTime = false;
	public boolean gameBegin = false;
	public boolean gameOver = false;
	public boolean giveWinner = true;


	public Background(int x, int y) {
		img = getImage("title.png"); 
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				
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
		if (giveWinner) {
			g.drawString("wheiwgeygyuqwegfygqwyeufguyqwgef", 100, 100);
		}
		
	}
	public void setX(int val) {
		x = val;
	}
	
	public int getX() {
		return x;
	}
	
	public void setScale(double val) {
		scale = val;
	}
	
	public void compLab() {
		img = getImage("compLab.png");
		setScale(9.5);	
	}
	
	public void end(Character uno, Character dos) {
		gameOver = true;
		if (uno.hp > dos.hp || uno.hp == dos.hp) {
			endGame1();
		}
		else {
			endGame2();
		}
	}
	
	public void select() {
		img = getImage("chooseyourcharacter.png");
		setScale(1.142);	
	}
	
	public void endGame1() {
		img = getImage("player1wins.png");
	}
	public void endGame2() {
		img = getImage("player2wins.png");
	}
	
	public void congratulations(String winner) {
		try {
		      FileWriter myWriter = new FileWriter("filename.txt");
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		try {
		      File myObj = new File("filename.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		       String data = myReader.nextLine();
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	    
	  }
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(scale, scale);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	public static Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
     

}
