package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ShopGraphics extends ProjectGraphics implements ActionListener {
		GImage shopbackground;
		GImage sell;
		GImage buy;
		GImage back;

		
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
		}	
		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
}

