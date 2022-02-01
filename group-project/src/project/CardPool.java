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
		        int price = Integer.parseInt(splitLine[2]);
		        int cost = Integer.parseInt(splitLine[3]);
		        String effect = splitLine[4];
		        String target = splitLine[5];
		        int power = Integer.parseInt(splitLine[6]);
		        int secEff = Integer.parseInt(splitLine[7]);
		        cardList.add(new CustomCard(name, filepath, price, cost, effect, target, power, secEff));
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		return cardList;
	}
}
