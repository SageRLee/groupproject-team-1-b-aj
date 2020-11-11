package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.program.GraphicsProgram;
import starter.GraphicsPane;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Timer;
import acm.graphics.*;



public class ShopGraphics extends GraphicsPane {
	
	private MainMenu program;
	
	private GImage shopbackground;
	private GImage sell;
	private GImage buy;
	private GImage back;
	private GObject target;
	private GRect hover = new GRect(0, 0, 3, 3 );
	private int lastX = 0;
	private int lastY = 0;
	
	public ShopGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	public void initializeObjects() {
		shopbackground = new GImage("media/images/shop background.jpg", 0, 0);
		shopbackground.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		
		sell= new GImage("media/images/sell-hi.png", 188, 388);
		sell.setSize(MainMenu.RESOLUTION_X/5, MainMenu.RESOLUTION_Y/5);
		
		buy= new GImage("media/images/buy-20clipart-buy-md.png", 666, 388);
		buy.setSize(MainMenu.RESOLUTION_X/5, MainMenu.RESOLUTION_Y/5);
		
		back= new GImage("media/images/back_button.png", 1377, 388);
		back.setSize(MainMenu.RESOLUTION_X/5, MainMenu.RESOLUTION_Y/5);
	}
	
	public void mouseMoved(MouseEvent e) {
		
		if (program.getElementAt(e.getX(), e.getY()) == sell || program.getElementAt(e.getX(), e.getY()) == buy || program.getElementAt(e.getX(), e.getY()) == back ) {
			hover.setLocation(program.getElementAt(e.getX(), e.getY()).getX() - 8,  program.getElementAt(e.getX(), e.getY()).getY() - 8);
			hover.setVisible(true);
			target = program.getElementAt(e.getX(), e.getY());
			if (program.getElementAt(e.getX(), e.getY()) != program.getElementAt(lastX, lastY)) {
				program.getAudioPlayer().playSound("media/sounds/", "cardHover.mp3");
			}
		} else {
			hover.setVisible(false);
			target = null;
		}
		
		lastX = e.getX();
		lastY = e.getY();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(target == null) {
			
		} else {
			program.getAudioPlayer().playSound("media/sounds", "select.mp3");
		}
		
		if(target == sell) {
		System.out.println("shop background.jpg");	
		
		} else if(target == buy){
			System.out.println("sell-hi.png");
			
		} else if(target == back) {
			System.out.println("back_button.png");
			
		}
	
	}
	@Override
	public void showContents() {
		program.add(shopbackground);
		program.add(sell);
		program.add(buy);
		program.add(back);
	}
	
	@Override
	public void hideContents() {
		program.remove(shopbackground);
		program.remove(sell);
		program.remove(buy);
		program.remove(back);
	}
}

