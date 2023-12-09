package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {

    Player[] players = new Player[4];
    Card[] cards = new Card[52];
    Card returnCard;
    int highScore;
    Random rand = new Random();
    Card c;

    void display() {
        for (int i = 0; i < 52; i++) {
            cards[i].print();
        }

    }

    public void generateDeck() {
        int counter = 0;
        for (int i = 0; i < 4; i++) { // suit
            for (int j = 0; j < 13; j++) { // rank value
                if (j < 9) {
                    c = new Card(i, j, j + 1);
                } else {
                    c = new Card(i, j, 10);
                }
                cards[counter] = c;
                counter++;
            }

        }
    }

    public Card drawCard() {
        while (true) {
            int randChoice = rand.nextInt(52);
            if (cards[randChoice] != null) {
                returnCard = cards[randChoice];
                cards[randChoice] = null;

            }

            return returnCard;
        }
    }

    public void playersInfo() {
        Scanner scan = new Scanner(System.in);
        String name;
        Card c1;
        Card c2;
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter name of "+"Player "+ (i+1) );
            
            name = scan.next();
            c1=drawCard();
            c2= drawCard();
           Player p =new Player(name, 2, c1, c2);
           players[i]=p;
           players[i].calcScore();
        }
    }

    public int updateScore() {
        int x=-1;
        highScore=0;
        for ( int i = 0; i < 4; i++) {
            if(players[i].handScore<=21){
            if (highScore < players[i].handScore) {
                highScore = players[i].handScore;
                x=i;
            }
            }
            
        }
        return x;
    }

}
