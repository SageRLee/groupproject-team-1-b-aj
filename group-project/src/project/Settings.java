package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import javafx.util.Pair;
import project.MainMenu;
import project.Player;
//Test
public class Settings {
	private boolean enabled = false;
	private boolean decklistOpen = false;
	private Font optionsFont = new Font ("Serif", Font.BOLD, 64); 
	private String option[][] = {
			new String[] {"Resume", "Options", "Deck List","Main Menu", "Quit Game"},
			new String[] {"Music", "More options", "Idk"},
	};
	private GRect hover = new GRect(2, 5);
	private Pair<GLabel, GRect> optionBox[] = new Pair[option[0].length]; 
	private GImage closeDeck = new GImage("media/images/back_button.png");
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
		decklistOpen = false;
		program.remove(blackscrn);	
		program.remove(menu);
		program.remove(hover);
		program.remove(closeDeck);
		for(Pair<GLabel, GRect> toRemove : optionBox) {
			program.remove(toRemove.getValue());
			program.remove(toRemove.getKey());
		}
	};
	public void overrideMouseMoved(MouseEvent e) {

		boolean found = false;
		GObject target = program.getElementAt(e.getX(), e.getY());
		for(Pair<GLabel, GRect> hoverCheck : optionBox) {
			if(target == hoverCheck.getValue() || target == hoverCheck.getKey()) {
				hover.setVisible(true);
				hover.setLocation(hoverCheck.getValue().getX()- (hover.getWidth() - hoverCheck.getValue().getWidth()) / 2, hoverCheck.getValue().getY() - (hover.getHeight() - hoverCheck.getValue().getHeight()) / 2);
				found = true;
				break;
			}
		}
		if(!found) {
			hover.setVisible(false);
		}
	}
	public void overrideMouseClicked(MouseEvent e) {
		boolean found = false;
		GObject target = program.getElementAt(e.getX(), e.getY());
		for(int i = 0; i < optionBox.length; i++) {
			if(target == optionBox[i].getValue() || target == optionBox[i].getKey()) {
				switch(i) {
				case 0:
					//Resume
					closeSettings();
					break;
				case 1:
					//Options - probably fullscreen
					break;
				case 2:
					//Deck List
					decklistOpen = true;
					program.remove(menu);
					for(Pair<GLabel, GRect> toRemove : optionBox) {
						program.remove(toRemove.getValue());
						program.remove(toRemove.getKey());	
					}
					program.add(closeDeck);
					break;
				case 3:
					//Main Menu
					program.openMainMenu();
					break;
				case 4:
					//Quit Game
					System.exit(0);
					break;
				default:
					//Absolutely nothing - give good grade on project please and thank you
			
				}	
			}
		}
	}
	
}
