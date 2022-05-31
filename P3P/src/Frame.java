/*
 * LEAVE GAME COMMENTS HERE
 * reminders:
 * ... see readme for instructions 
 * 		during char select, be patient
 *				-might need to click a few times
 *				-check console to see if selection goes thru
 *				-feel free to replay if it needs to reload
 *
 *comment below:
 *
 *
 *
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//declare and instantiate background
	Background 	bg 	= new Background(0, 0);
	//declare and initialize characters with null vals
	//to fill later during selection
	Character character1 	= null;
	Character  character2 	= null;
	//declare character for selection display
	Character  preview 	= new Character(320, 150, 100, "henrystand.png", "henryrev.png", "henrypunch.png",  "henrypunchrev.png", 7.03, true, 1.5);
	//declare and init objects with null vals
	//to fill later during selection
	//declare character for selection display
	//initialize variables for keeping track of time
	double start;
	double soFar;
	
	public void paint(Graphics g) {
		//paint
		super.paintComponent(g);
		
		//paint background
		bg.paint(g);
		
		//paint screens and its instructions using
		//booleans to check progression
		//starting w/ title
		if (!bg.selectTime)
		{
			//create instructions on title screen
			g.setColor(new Color(0,0,0));
			g.drawString("Press Space To Join the Punchout" , 310, 280);
		}
		//paint selection screen
		if(bg.selectTime && !bg.gameBegin)
		{
			bg.select();
			//create aesthetic rectangle behind preview
			g.setColor(new Color(255,255,255));
			g.fillRect(320, 150, 150, 160);
			//paint the preview character
			preview.paint(g);
			//call method allowing for "cycling"
			//between characters using a switch statement
			preview.preview();
			//draw character names on screen using
			//a switch statement
			Font fnt = new Font (Font.MONOSPACED, Font.BOLD, 20);
			g.setFont(fnt);
			switch(preview.getDex()) {	
			
			case 0:
				g.drawString("HennyBaby" , 340, 335);
				break;
			case 1:
				g.drawString("Bella" , 340, 335);
				break;
			case 2:
				g.drawString("Mr. David" , 340, 335);
				break;
			case 3:
				g.drawString("Aak" , 340, 335);
				break;
			case 4:
				g.drawString("Vianne" , 340, 335);
				break;
			case 5:
				g.drawString("CrypClub", 340, 335);
				break;
			}
		}

		//paint the main fighting screen when triggered
		if (bg.gameBegin && !bg.gameOver)
		{
		//call method to change background
		bg.compLab();
		//paint character
		character1.paint(g);
		character2.paint(g);
		//show hp score
		g.drawString("HP: " + character1.getHpStr(), 100, 50);
		g.drawString("HP: " + character2.getHpStr(), 650, 50);
		//call time managment method
		//and draw the timer using the vars
		manageTime();
		Font fnt = new Font (Font.MONOSPACED, Font.BOLD, 50);
		g.setFont(fnt);
		g.setColor(new Color(0,5,0));
		g.drawString(" " + (int)(95 - soFar) , 340, 50);
		}
		
		//paint the appropriate Game Over screen
		if(bg.gameOver) {
			bg.paint(g);
			Font fnt = new Font (Font.MONOSPACED, Font.BOLD, 20);
			g.setFont(fnt);
			g.drawString("Congratulations " + bg.getReadW(), 230, 330);
			g.drawString("Press Space to Play Again " , 235, 60);
		}
	}
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("P3 Punchout");
		f.setSize(new Dimension(800, 450));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//decrease selection index when left arrow is pressed
		//using method
		if(bg.selectTime&& arg0.getX() >=20 && arg0.getX()<= 180) {
			if(arg0.getY()>=180 && arg0.getY() <= 280) {
				preview.dec();
			}
		}
		
		//increase selection index when left arrow is pressed 
		//using method
		if(bg.selectTime &&arg0.getX() >=630 && arg0.getX()<= 790) {
			if(arg0.getY()>=180 && arg0.getY() <= 280) {
				preview.inc();				
			}
		}
		
		//select characters when button is pressed
		if(bg.selectTime &&arg0.getX() >=310 && arg0.getX()<= 530) {
			if(arg0.getY()>=350 && arg0.getY() <= 410) {
			
				//make sure no character has been selected yet
				//char 1
				if(preview.picked() == -1)
				{
				character1 = preview.whoIsYou(preview.getDex(),80,200,true);
			    preview.picked[preview.getDex()] = true;
			    System.out.println("yassssss");
				}
			}
			
				//ensure there aren't repeats for char 2
				//start the game
				else if (preview.picked()!= preview.getDex()) {
				    character2 = preview.whoIsYou(preview.getDex(),650,200,false);
					System.out.println("oink");
					bg.gameBegin = true;
					//fix scaling
					bg.setX(getX() - 100);
					//start the timer using the startTimer method
					startTimer();
				}
				
			}
			
		
		}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub			
			
			//use switch statement and int
			//to collect the keycode being used
			//and move accordingly
			int code = arg0.getKeyCode();

			switch (code) { 

			case 68: //letter d
				   character1.moveRight();
				   //preview.inc();
				   //System.out.println(preview.getDex());
				   character1.setFaceRight(true); 
				   break;

			case 65: //letter a
				   character1.moveLeft();
				   character1.setFaceRight(false); 
				   break;


			case 76: //letter l
				   character2.moveRight();
				   character2.setFaceRight(true); 			
				   break;

			case 74: //letter j
				   character2.moveLeft();
				   character2.setFaceRight(false); 				   
				   break;

			case 90: //letter n
				character1.punching = true; 
				break; 

			case 77:
				character2.punching = true;
				break;


			   }  
			   //start selection sequence when
			   // when the spacebar is first pressed
			   //using booleans and an if-statement
			   if(arg0.getKeyCode() == 32) { //letter w
				   	//call screen change method, change bool accordingly
				   if(!bg.selectTime) {
				    bg.select();
					bg.selectTime = true;
					//turn established physics off for preview
					preview.setNoPhysics(true);
				   }
					if(bg.gameOver) {
					 bg.reset(character1, character2, preview);
					}

			   }

			   if(arg0.getKeyCode() == 73 && character2.getY() == 325) { //letter m
				   character2.jump();

			   }

			   if(arg0.getKeyCode() == 87 && character1.getY() == 325) { //letter w
				   character1.jump();
			   }

	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		//use an int w/ key code detection and such
		//to call punch methods accordingly
		//and end game when necessary
		int p = arg0.getKeyCode();
		switch(p) {
		case 90:
			   character1.punch(character2,character1.isFaceRight(), 10);
			   if(character2.getHp() <= 0)
				{
		        bg.end(character1, character2);	 
				}
			   character1.punching = false; 
			   break;
		case 77:
			   character2.punch(character1,character2.isFaceRight(), 10);
			   if(character1.getHp() <= 0)
				{
		        bg.end(character1, character2);
				}
			   character2.punching = false; 
		   }


		// TODO Auto-generated method stub
		//change boolean for right sprite
	
	}
	//declare timer start method
	public void startTimer() {
		start = System.currentTimeMillis();
	}
	//declare timer managment method
	public void manageTime() {
		//calculate the time elapsed in seconds
        soFar = (int)((System.currentTimeMillis() - start)/1000);
        //use if-statement to end game if
        //timer reaches 0
        if(90 - soFar == 0)
        {
        	bg.end(character1, character2);
        }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

