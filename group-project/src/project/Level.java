package project;
import acm.graphics.GImage;

public class Level {

	private GImage levelImage;
	private int levelNumber;
	private Enemy enemy;
	private boolean complete;
	
	public Level(GImage levelImage, int levelNumber, Enemy enemy, boolean complete) {
		this.levelImage = levelImage;
		this.levelNumber = levelNumber;
		this.enemy = enemy;
		this.complete = complete;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
	public void setComplete() {
		this.complete = true;
	}
	
}