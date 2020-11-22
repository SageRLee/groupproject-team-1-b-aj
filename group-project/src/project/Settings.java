package project;

import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GRect;
import project.MainMenu;
import project.Player;

public class Settings {
	private boolean enabled = true;
	//private String option[4][4];
	
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
		menu.setLocation(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y / 6);
		menu.setSize(MainMenu.RESOLUTION_X * 0.4, MainMenu.RESOLUTION_Y * 0.8);
		menu.setFilled(true);
	}
	public void openSettings(){
		program.add(blackscrn);
		program.add(menu);
		enabled = true;
	

	}
	public void closeSettings() {
		enabled = false;
		program.remove(blackscrn);	
		program.remove(menu);

	};
}
