package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import starter.GraphicsPane;

public class ShopTest extends GraphicsPane {
	
	private MainMenu program;
	
	private ArrayList<Card> shopCardList;
	
	private Font shopFont = new Font("TimesRoman", Font.PLAIN, 50);
	
	private Card selectCard;
	private GPoint selectCardPrevPoint;
	private GImage buyButton = new GImage("media/images/BuyButton.png");
	private GImage sellButton = new GImage("media/images/SellButton.png");
	private GLabel goldAmount = new GLabel("");
	
	
	public ShopTest(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	
	public void initializeObjects() {
		
		shopCardList = CardPool.getCardList();
		
		int x = 0;
		int y = 0;
		for (Card card : shopCardList) {
			if (x == 5) {
				x = 0;
				y++;
			}
			
			card.getPicture().setLocation(25 + (210 * x), 25 + (310 * y));
			x++;
		}

		buyButton.setLocation(1300, 600);
		sellButton.setLocation(1600, 600);
		
		updateGoldAmount();
		goldAmount.setLocation(1500, 50);
		goldAmount.setFont(shopFont);
		goldAmount.setColor(Color.YELLOW);

		updateOwnedCards();
	}
	
	public void updateOwnedCards() {
		for (Card card : shopCardList) {
			if (program.getPlayer().hasCard(card)) {
				card.getPicture().setSize(100, 150);
			} else {
				card.getPicture().setSize(200, 300);
			}
		}
	}
	
	public void updateGoldAmount() {
		goldAmount.setLabel("GOLD: " + ConfigManager.getPath("gold"));
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (program.getElementAt(e.getX(), e.getY()) instanceof GImage) {
			GImage currElem = (GImage) program.getElementAt(e.getX(), e.getY());
			
			if (currElem == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
			
			if (currElem == buyButton || currElem == sellButton) {
				
				String shopNote = "";
				Color shopNoteColor = Color.BLACK;
				
				if (selectCard == null) {
					shopNote = "CARD NOT SELECTED";
					shopNoteColor = Color.RED;
				}
				else {
					if (currElem == buyButton) {
						if (program.getPlayer().hasCard(selectCard)) {
							shopNote = "ALREADY OWN CARD";
							shopNoteColor = Color.RED;
						} 
						else {
							
							if (program.getPlayer().getGold() >= selectCard.getCost()) {
								shopNote = "PURCHASED CARD";
								shopNoteColor = Color.GREEN;
								program.getPlayer().addCard(selectCard);
								program.getPlayer().setGold(program.getPlayer().getGold() - (selectCard.getCost()));
							} 
							else {
								shopNote = "NOT ENOUGH GOLD";
								shopNoteColor = Color.RED;
							}
						}
					} 
					else if (currElem == sellButton) {
						
						if (program.getPlayer().hasCard(selectCard)) {
							shopNote = "SOLD CARD";
							shopNoteColor = Color.GREEN;
							program.getPlayer().removeCard(selectCard);
							program.getPlayer().setGold(program.getPlayer().getGold() + (selectCard.getCost()/2));
							selectCard.getPicture().setSize(200, 300);
						} 
						
						else {
							shopNote = "DON'T OWN CARD";
							shopNoteColor = Color.RED;
						}
					}
				}
				updateGoldAmount();
				updateOwnedCards();

				final String finalShopNote = shopNote;
				final Color finalShopNoteColor = shopNoteColor;
				
				new Thread() {
					public void run() {
						currElem.setSize(150, 150);
						program.pause(300);
						currElem.setSize(200, 200);
						
						GLabel shopLabel = new GLabel("");
						shopLabel.setLabel(finalShopNote);
						shopLabel.setColor(finalShopNoteColor);
						shopLabel.setFont(shopFont);
						shopLabel.setLocation(1300, 120);	
						program.add(shopLabel);
						
						for (int x = 0; x < 10; x++) {
							shopLabel.move(0, 10);
							program.pause(100);
						}
						
						program.remove(shopLabel);
					}
				}.start();
				
				return;
			}
			
			for (Card card : shopCardList) {
				if (card.getPicture() == currElem) {
					if (selectCard != null) {
						selectCard.getPicture().setLocation(selectCardPrevPoint);
					}
					
					selectCard = card;
					selectCardPrevPoint = currElem.getLocation();
					selectCard.getPicture().setLocation(1450, 250);
				}
			}
		}
	}
	
	@Override
	public void showContents() {
		program.add(MainMenuGraphics.menuButton);
		program.add(buyButton);
		program.add(sellButton);
		program.add(goldAmount);
		for (Card card : shopCardList) {
			program.add(card.getPicture());
		}
	}
	
	@Override
	public void hideContents() {
		program.remove(MainMenuGraphics.menuButton);
		program.remove(buyButton);
		program.remove(sellButton);
		program.remove(goldAmount);
		for (Card card : shopCardList) {
			program.remove(card.getPicture());
		}
		if (selectCard != null)
			program.remove(selectCard.getPicture());
	}
	

}
