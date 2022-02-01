package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import project.cards.CustomCard;


public class CardPool {
	static ArrayList<Card> cardList = new ArrayList<>();

	public static ArrayList<Card> getCardList() {
		try {
		      File myObj = new File("cardpool.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String line = myReader.nextLine();
		        String[] splitLine = line.split(" ", 0);
		        String name = splitLine[0];
		        String filepath = splitLine[1];
		        int price = Integer.valueOf(splitLine[2]);
		        int cost = Integer.valueOf(splitLine[3]);
		        String effect = myReader.next();
		        String target = myReader.next();
		        int power = myReader.nextInt();
		        int secondEff = myReader.nextInt();
		        System.out.println(splitLine[0]);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		/*
		 * ArrayList<Card> cardList = new ArrayList<>(); cardList.add(new
		 * SmallHealthPotion()); cardList.add(new LargeHealthPotion()); cardList.add(new
		 * Revive()); cardList.add(new Stick()); cardList.add(new Slash());
		 * cardList.add(new Stab()); cardList.add(new SmallManaPotion());
		 * cardList.add(new LargeManaPotion()); cardList.add(new ManaRevive());
		 * cardList.add(new LifeSteal()); cardList.add(new SoulSteal());
		 * cardList.add(new Suicide()); cardList.add(new Split());
		 */
		return cardList;
	}
}
