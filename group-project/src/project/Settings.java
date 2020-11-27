package project;

import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GRect;
import project.MainMenu;
import project.Player;
//Test
public class Settings {
	private boolean enabled = false;
	private String option[][] = {
			new String[] {"Resume", "Options", "Deck List", "Quit Game"},
			new String[] {"Music", "More options", "Idk"},
	};
	private GRect optionBox[] = new GRect[4];
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
		menu.setSize(MainMenu.RESOLUTION_X * 0.4, MainMenu.RESOLUTION_Y * 0.8);
		menu.setLocation(MainMenu.RESOLUTION_X / 2 - menu.getWidth() / 2, MainMenu.RESOLUTION_Y / 6);
		menu.setFilled(true);
		for(int i = 0; i < 4; i++) {
			GRect temp = new GRect(1, 2);
			temp.setSize(menu.getWidth() * 0.7, menu.getHeight() * 0.15);
			temp.setLocation(menu.getLocation().getX() + menu.getWidth() / 2, menu.getLocation().getY() + temp.getHeight() / 4 + i * menu.getHeight() * 0.15);
			temp.setFilled(true);
			temp.setFillColor(new Color(255, 255, 255, 255));
			optionBox[i] = temp;
		}
	}
	public void openSettings(){
		program.add(blackscrn);
		program.add(menu);
		enabled = true;
		for(GRect toAdd : optionBox) {
			program.add(toAdd);
		}
	

	}
	public void closeSettings() {
		enabled = false;
		program.remove(blackscrn);	
		program.remove(menu);
		for(GRect toRemove : optionBox) {
			program.remove(toRemove);
		}

	};
}
