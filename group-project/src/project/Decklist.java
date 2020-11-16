package project;

import acm.graphics.GRect;

public class Decklist {
	private GRect blackscrn = new GRect(0, 0, MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y );
	MainMenu program;
	Decklist(MainMenu program){
		this.program = program;
	}
	public void openDeckList(){
		program.add(blackscrn);
	}
	public void closeDeckList() {
		
	};
}
