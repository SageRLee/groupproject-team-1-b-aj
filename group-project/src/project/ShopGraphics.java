package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.program.GraphicsProgram;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Timer;
import acm.graphics.*;



public class ShopGraphics extends ProjectGraphics implements ActionListener {
		GImage shopbackground;
		GImage sell;
		GImage buy;
		GImage back;
		private static GObject target;
		private GRect hover = new GRect(0, 0, 3, 3 );
		private int lastX = 0;
		private int lastY = 0;
		
		public void run() {
			initializeApplet();
			shopbackground = new GImage("media/images/shop background.jpg", 0, 0);
			shopbackground.setSize(ProjectGraphics.RESOLUTION_X, ProjectGraphics.RESOLUTION_Y);
			add(shopbackground);
			
			sell= new GImage("media/images/sell-hi.png", 188, 388);
			sell.setSize(ProjectGraphics.RESOLUTION_X/5, ProjectGraphics.RESOLUTION_Y/5);
			add(sell);
			
			buy= new GImage("media/images/buy-20clipart-buy-md.png", 666, 388);
			buy.setSize(ProjectGraphics.RESOLUTION_X/5, ProjectGraphics.RESOLUTION_Y/5);
			add(buy);
			
			back= new GImage("media/images/back_button.png", 1377, 388);
			back.setSize(ProjectGraphics.RESOLUTION_X/5, ProjectGraphics.RESOLUTION_Y/5);
			add(back);
			
			addMouseListeners();
			
		}
			public void mouseMoved(MouseEvent e) {
				
				if(getElementAt(e.getX(), e.getY()) == sell || getElementAt(e.getX(), e.getY()) == buy || getElementAt(e.getX(), e.getY()) == back ) {
					hover.setLocation( getElementAt(e.getX(), e.getY()).getX() - 8,  getElementAt(e.getX(), e.getY()).getY() - 8);
					hover.setVisible(true);
					target = getElementAt(e.getX(), e.getY());
					if(getElementAt(e.getX(), e.getY()) != getElementAt(lastX, lastY)) {
						playSound("media/sounds/", "cardHover.mp3");
					}
				}
				else {
					hover.setVisible(false);
					target = null;
				}
				
				lastX = e.getX();
				lastY = e.getY();
			}
			
		
		private void playSound(String string, String string2) {
				// TODO Auto-generated method stub
			
			}
		
		@Override
		public void mousePressed(MouseEvent e) {
             if(target == null) {}
				
			else {
				playSound("media/sounds/", "select.wav");
			}
				if(target == sell) {
				System.out.println("shop background.jpg");	
				
				} else if(target == buy){
					System.out.println("sell-hi.png");
					
				} else if(target == back) {
					System.out.println("back_button.png");
					
				}
		
		}
}

