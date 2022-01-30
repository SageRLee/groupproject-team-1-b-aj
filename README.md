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
      

			
