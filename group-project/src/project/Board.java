package project;

//ANDREW

public class Board {

	private int turnNumber;
	private boolean enemyTurn;
	private Enemy enemy;
	private Player player;
	
	public Board(int turnNumber, boolean enemyTurn, Enemy enemy, Player player) {
		this.turnNumber = turnNumber;
		this.enemyTurn = enemyTurn;
		this.enemy = enemy;
		this.player = player;
	}
	
	public int getTurnNumber() {
		return turnNumber;
	}
	
	public void increaseTurnNumber() {
		turnNumber++;
	}
	
	public boolean isEnemyTurn() {
		return enemyTurn;
	}
	
	public void setEnemyTurn() {
		enemyTurn = true;
	}
	
	public void setPlayerTurn() {
		enemyTurn = false;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}

	public Player getPlayer() {
		return player;
	}
}
