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
	Character  preview 	= new Character(320, 150, 100, "henrystand.png", 7.03, true, 1.5);
	Font fnt = new Font (Font.MONOSPACED, Font.BOLD, 50);
	
	public boolean selectTime = false;
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
	boolean cryp = false; 
		
	{
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
		g.setColor(new Color(255,255,255));
		if(selectTime && !gameBegin)
		{
			bg.paint(g);
			g.fillRect(320, 150, 150, 160);
			g.drawRect(310, 350, 220, 60);
			preview.paint(g);
			preview.preview();
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

		
		
		if (gameBegin && !gameOver)
		{
		bg.compLab();
		character1.paint(g);
		character2.paint(g);
		
		//if __ is true, paint this
		
        soFar = (int)((System.currentTimeMillis() - start)/1000);
		
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
		if(!selectTime)
		{bg.select();
		selectTime = true;
		preview.noPhysics = true;
		}
		
		if(selectTime&& arg0.getX() >=20 && arg0.getX()<= 180) {
			if(arg0.getY()>=180 && arg0.getY() <= 280) {
				preview.dec();
			}
		}
		if(selectTime &&arg0.getX() >=630 && arg0.getX()<= 790) {
			if(arg0.getY()>=180 && arg0.getY() <= 280) {
				preview.inc();
				System.out.println("yuh");
				
			}
		}
		if(selectTime &&arg0.getX() >=310 && arg0.getX()<= 530) {
			if(arg0.getY()>=350 && arg0.getY() <= 410) {
				picked[preview.getDex()] = true;
				
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
			System.out.println(arg0.getKeyCode());
			
			int code = arg0.getKeyCode();
			
			switch (code) { 
			
			case 68: //character d
				   character1.moveRight();
				   preview.inc();
				   System.out.println(preview.getDex());
				   break;
			case 65: //letter a
				   character1.moveLeft();
				   break;
			
			 
			case 76: //letter l
				   character2.moveRight();
				   break;
			  
			case 74: //letter j
				   character2.moveLeft();
				   break;
				   
			case 78: //letter n
				Object.paint(); 
				break;
				
			case 88:
				//break; 
			 
			   }
			   
			   if(arg0.getKeyCode() == 73 && character2.y == 325) { //letter m
				   character2.jump();
			   }
			   
			   if(arg0.getKeyCode() == 87 && character1.y == 325) { //letter w
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

	public boolean getSelectTime() {
		return selectTime;
	}
	public Vyane getCharacter1() {
		return character1;
	}
	public Character getCharacter2() {
		return character2; 
	}
	
	
}
