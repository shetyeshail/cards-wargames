package cards;

import java.util.ArrayList;

public class WarGames {//start class

    public static void main(String[] args) {//start main method
        //variables
        Deck deck = new Deck();
        ArrayList<Card> war1 = new ArrayList<>();
        ArrayList<Card> war2 = new ArrayList<>();
        ArrayList<Card> uPile1 = new ArrayList<>();
        ArrayList<Card> uPile2 = new ArrayList<>();
        ArrayList<Card> wPile1 = new ArrayList<>();
        ArrayList<Card> wPile2 = new ArrayList<>();
        deck.shuffle();
        //added this
        boolean again = true;
        //while deck isn't empty add cards to unplayed 1 and 2
        while (!deck.isEmpty()) {
            uPile1.add(deck.deal());
            uPile2.add(deck.deal());
        }
        //while neither unplayed is empty
        while (!uPile1.isEmpty() || !uPile2.isEmpty()) {
            //added this, while you want to go again is true
            while (again == true) {
                //for each index in the pile, do each time
                for (int i = 0; i < 26; i++) {
                    //turn each card
                    uPile1.get(i).turn();
                    uPile2.get(i).turn();
                    //add each card to each warpile
                    war1.add(uPile1.get(i));
                    war2.add(uPile2.get(i));
                    //print each card from each warpile
                    System.out.println("War Card 1: " + war1.get(i).toString());
                    System.out.println("War Card 2: " + war2.get(i).toString());
                    //added this, if cards are equal go again
                    if (war1.get(i).equals(war2.get(i))) {
                        again = true;
                    //else if they aren't equal don't go again
                    } else {
                        again = false;
                    }
                }//end for loop
            }//end again while
        }//end neither unplayed while
        for (int j = 0; j < 26; j++){
            if (war1.get(j).compareTo(war2.get(j)) >= 1){
                //move the cards from war1 and war2 to wpile1
                wPile1.add(war1.get(j));
                wPile1.add(war2.get(j));
            }
            else{
                //move the cards from war1 and war2 to wpile2
                wPile2.add(war1.get(j));
                wPile2.add(war2.get(j));
            }
        System.out.println("The number of cards in winning pile 1: " + wPile1.size());
        System.out.println("The number of cards in winning pile 2: " + wPile2.size());
        }
        
        //report results of game
        //how many cards each player has and size of piles
//        System.out.println("The number of cards in winning pile 1: " + wPile1.size());
//        System.out.println("The number of cards in winning pile 2: " + wPile2.size());
    }//end main method
}//end class



/*NOTES: I have been having issues figuring out why when I run the program, it
 * prints all the cards but IDK what it does after that. I have to figure that 
 * out.
 */