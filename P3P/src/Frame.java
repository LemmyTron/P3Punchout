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
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	
	Background 	bg 	= new Background(0, 0);
	Vyane character1 	= new Vyane(80, 200, true);
	Character  character2 	= new Character(650, 200, 100, "testMan.png", 7.03, false, .12);
	Font fnt = new Font (Font.MONOSPACED, Font.BOLD, 50);
	
	boolean selected = false;
	boolean gameBegin = false;
	boolean gameOver = false;
	double start = 0;
	double soFar = 0;
	
	boolean[] picked = new boolean[6];
	boolean henry = false;
	boolean bella = false;
	boolean david = false;
	boolean aak = false;
	boolean vianne = false;
	boolean cryp = false; {

	picked[0] = henry;
	picked[1] = bella;
	picked[2] = david;
	picked[3] = aak;
	picked[4] = vianne;
	picked[5] = cryp;
	
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//paint the background
		bg.paint(g);
		
		
		if (gameBegin && !gameOver)
		{
		bg.compLab();
		character1.paint(g);
		character2.paint(g);
		
		//if __ is true, paint this
		
        soFar = (int)((System.currentTimeMillis() - start)/1000);
		g.setFont(fnt);
		g.setColor(new Color(0,5,0));
		g.drawString(" " + (int)(95 - soFar) , 340, 50);
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
         
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		gameBegin = true;
		bg.compLab();
		bg.setX(bg.getX() - 100);
	
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
			
			int code = arg0.getKeyCode();
			
			switch (code) { 
			
			case 68:
				   character1.moveRight();
				   break;
			case 65:
				   character1.moveLeft();
				   break;
			
			 
			case 76:
				   character2.moveRight();
				   break;
			  
			case 74:
				   character2.moveLeft();
				   break;
			   }
			   
			   if(arg0.getKeyCode() == 73 && character2.y == 325) {
				   character2.jump();
			   }
			   
			   if(arg0.getKeyCode() == 87 && character1.y == 325) {
				   character1.jump();
			   }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		   if(arg0.getKeyCode() == 90) { 
			   character1.punch(character2,character1.faceRight, 10);
			   if(character2.hp == 0)
				{
				bg.endGame1();
				}
		   } 
		   if(arg0.getKeyCode() == 77) {
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
