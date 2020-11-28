package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import javafx.util.Pair;
import project.MainMenu;
import project.Player;
//Test
public class Settings {
	private boolean enabled = false;
	private Font optionsFont = new Font ("Serif", Font.BOLD, 64); 
	private String option[][] = {
			new String[] {"Resume", "Options", "Deck List","Main Menu", "Quit Game"},
			new String[] {"Music", "More options", "Idk"},
	};
	private GRect hover = new GRect(2, 5);
	private Pair<GLabel, GRect> optionBox[] = new Pair[option[0].length]; 
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	private GRect blackscrn = new GRect(0, 0, MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
	private GRect menu = new GRect(0, 0, MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
	MainMenu program;
	public Settings(MainMenu program, Player player){
		this.program = program;
		blackscrn.setFillColor(new Color(0, 0, 0, 125));
		blackscrn.setFilled(true);
		menu.setSize(MainMenu.RESOLUTION_X * 0.35, MainMenu.RESOLUTION_Y * 0.75);
		menu.setLocation(MainMenu.RESOLUTION_X / 2 - menu.getWidth() / 2, MainMenu.RESOLUTION_Y / 16);
		menu.setFilled(true);
		for(int i = 0; i < option[0].length; i++) {
			GRect temp = new GRect(1, 2);
			GLabel tempL = new GLabel("If you see this, Sage sucks at coding probably", 1, 2);
			temp.setSize(menu.getWidth() * 0.5, menu.getHeight() * 0.15);
			temp.setLocation(menu.getLocation().getX() + menu.getWidth() / 2 - temp.getWidth() / 2, menu.getLocation().getY() + temp.getHeight() / 3 + i * temp.getHeight() * 1.25);
			temp.setFilled(true);
			temp.setFillColor(new Color(255, 255, 255, 255));
			tempL.setFont(optionsFont);
			tempL.setLabel(option[0][i]);
			tempL.setLocation(temp.getX() + temp.getWidth() / 2 - tempL.getWidth() / 2, temp.getY() + temp.getHeight() / 2 + tempL.getHeight() / 3);
			Pair<GLabel, GRect> tempPair = new Pair(tempL, temp);
			optionBox[i] = tempPair;
		}
		hover.setSize(optionBox[0].getValue().getWidth() * 1.1, optionBox[0].getValue().getHeight() * 1.1);
		hover.setFilled(true);
		hover.setColor(new Color(0, 250, 154));
		hover.setVisible(false);
	}
	public void openSettings(){
		program.addMouseListeners();
		program.add(blackscrn);
		program.add(menu);
		program.add(hover);
		enabled = true;
		for(Pair<GLabel, GRect> toAdd : optionBox) {
			program.add(toAdd.getValue());
			program.add(toAdd.getKey());
		}
	}
	public void closeSettings() {
		enabled = false;
		program.remove(blackscrn);	
		program.remove(menu);
		program.remove(hover);
		for(Pair<GLabel, GRect> toRemove : optionBox) {
			program.remove(toRemove.getValue());
			program.remove(toRemove.getKey());
		}

	};
	public void mouseMoved(MouseEvent e) {
		boolean found = false;
		GObject target = program.getElementAt(e.getX(), e.getY());
		System.out.println("test...");
		for(Pair<GLabel, GRect> hoverCheck : optionBox) {
			if(target == hoverCheck.getValue()) {
				hover.setVisible(true);
				hover.setLocation(target.getX()- (hover.getWidth() - target.getWidth()), target.getY() - (hover.getHeight() - target.getHeight()));
				found = true;
				System.out.println("test?");
				break;
			}
		}
		if(!found) {
			hover.setVisible(false);
			System.out.println("test!");
		}
	}
}
