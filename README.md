# Dynamic Shop implementation

Objective: Increase flexibility of shop class by refactoring the current cardlist. Instead of having a pre-set list hardcoded into the object, cards will be read from 
an outside file. This way, additional cards can be more easily added or removed. Currently, the shop reads from an object named CardPool, which contains all cards
in the game, hard-coded into an array. This will have to be rewritten to accommodate the change.

Pseudocode:

CardPool Object:
	Initialize Card List Function:
	This function will read a text file for card data and then store all the data
		Read in txt file with card pool data
			Each line of the file has card name, image filepath, shop cost, mana cost, effect, target, power, secondaryEff
			Create custom card with this data
			log new card into cardpool
			Repeat until EOF
			
	GetCardList (updated)
		returna array from initialize card list function
		
Player Object
	hasCard function (updated to account for change)
		check if input card name exists in deck
		if so, return true, otherwise return false
Custom Card Object (new!)
		As input, get card name, image filepath, shop cost, mana cost, effect, target, power, secondaryEff
    
		switch depending on effect
			increase or decrease
				change the target stats by the power
      Both
        change one target by the first power, and then other target by secondaryEff
     switch depending on target
      can target self, other (enemy), or split

#Demonstration
Upon pullng the program, navigate to git\groupproject-team-1-b-aj\bin
Note cardpool.txt, with 12 unique cards. 
Launch the program from MainMenu.java and navigate to the shop, noting the 12 unique cards visable in the shop. 
Close the game, and open cardpool.txt.
To add a new card, write it in the following line in this format:
Cardname, Filepath, Shop Price, Mana Cost, Effect (increase, decrease, both), target (self, other, split), power, secondary effect (currently used for both effect)
For simplicity, I've given an example card to add below. 
Stab media/images/cards/StabCard.png 200 7 decrease other 5 0
After adding the card and saving the file, reopen the game and note how the card has been added to the shop. 
			
