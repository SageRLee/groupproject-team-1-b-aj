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
	MainMenu program;
	public Settings(MainMenu program, Player player){
		this.program = program;
		blackscrn.setFillColor(new Color(0, 0, 0, 125));
		blackscrn.setFilled(true);
		program.add(blackscrn);
	}
	public void openSettings(){
		System.out.println("happens");
		blackscrn.setVisible(true);
		enabled = true;
		blackscrn.sendToFront();

	}
	public void closeSettings() {
		enabled = false;
		blackscrn.setVisible(false);
		blackscrn.sendToBack();
		
	};
}
