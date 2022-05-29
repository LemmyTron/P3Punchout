
import java.awt.Color;
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
//declare background class
public class Background{
	
	//variables for background placement
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	
	//declare variable for scaling background
	private double scale = 8;
	
	//initialize booleans for screen transitions
	public boolean selectTime = false;
	public boolean gameBegin = false;
	public boolean gameOver = false;

	//initialize string for storing winner
	//for the read/write method
	//using null as filler
	private String readW = null;

	//background constructor
	public Background(int x, int y) {
		img = getImage("title.png"); 
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				
	}
	
	//paint for the background
	public void paint(Graphics g) {
	
		//update and draw the background
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
	
	
	}
	
	//method for the game ending
	//with character parameters to monitor who wins
	//and who loses
	public void end(Character uno, Character dos) {
		gameOver = true;
		//use if-statements to 
		if (uno.hp > dos.hp || uno.hp == dos.hp) {
			endGame1();
			congratulate("Player 1");
		}
		else {
			endGame2();
			congratulate("Player 2");
		}

	}
	
	//set methods for backgrounds:
	//computer lab
	public void compLab() {
			img = getImage("compLab.png");
			setScale(9.5);	
		}
	//selection screen
	public void select() {
		img = getImage("chooseyourcharacter.png");
		setScale(1.142);	
	}
	//game over screen
	public void endGame1() {
		img = getImage("player1wins.png");
	}
	public void endGame2() {
		img = getImage("player2wins.png");
		
	}
	//method to write the winner of the game to a file
	//and read and print it
	//using a string variable
	public void congratulate(String winner) {
		//write
		try {
		      FileWriter myWriter = new FileWriter("whoWon.txt");
		      myWriter.write(winner);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		//read
		try {
		      File myObj = new File("whoWon.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		       readW = myReader.nextLine();
		       System.out.println("got it");
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		}
	    
	  
	
	//set/get methods for background x value
		
	public void setX(int val) {
			x = val;
		}
	public int getX() {
			return x;
		}
	
	//get method for read winner
	public String getReadW(){
		return readW;
	}
	
	//setMethod for the scale
	public void setScale(double val) {
			scale = val;
		}
	
	
	//update and image methods
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
