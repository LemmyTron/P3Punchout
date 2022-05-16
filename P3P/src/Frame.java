import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	 
	//create a score variable
	
	//create a variable for the high score
	
	Background 	bg 	= new Background(0, 0);

	Character  character1 	= new Character(80, 300, 100, "testMan.png", 7.03, true);
	Character  character2 	= new Character(650, 300, 100, "testMan.png", 7.03, false);

	//create a font object for drawing the score
	
	{
		
	
	}
	
	 
	public void paint(Graphics g) {
		super.paintComponent(g);
		//paint the background
		bg.paint(g);
		character1.paint(g);
		character2.paint(g);
		//paint all objects in the orange array
		
		
		
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("CHUNGUS");
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
			System.out.println(arg0.getKeyCode());
			  
			   if(arg0.getKeyCode() == 68) {
				   character1.moveRight();
			   }
			   if(arg0.getKeyCode() == 87 && character1.y == 350) {
				   character1.jump();
			   }
			   if(arg0.getKeyCode() == 65) {
				   character1.moveLeft();
			   }
			
			    
			   if(arg0.getKeyCode() == 76) {
				   character2.moveRight();
			   }
			   if(arg0.getKeyCode() == 73 && character2.y == 350) {
				   character2.jump();
			   }
			   if(arg0.getKeyCode() == 74) {
				   character2.moveLeft();
			   }
			
			   
			   

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		   if(arg0.getKeyCode() == 77) { 
			   character1.punch(character2,character1.faceRight, 10);
			   if(character2.hp == 0)
				{
				bg.endGame1();
				}
		   } 
		   if(arg0.getKeyCode() == 17) {
			   character2.punch(character1,character2.faceRight, 10);
			   if(character1.hp == 0)
				{
				   bg.endGame2();
				}
		   }
		// TODO Auto-generated method stub
		//change boolean for right sprite
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
