package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ShopGraphics extends ProjectGraphics implements ActionListener {
		GImage shopbackground;

		
		public void run() {
			initializeApplet();
			shopbackground = new GImage("media/images/shop background.jpg", 0, 0);
			shopbackground.setSize(ProjectGraphics.RESOLUTION_X, ProjectGraphics.RESOLUTION_Y);
			add(shopbackground);

			
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
}
