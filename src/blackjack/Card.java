
package blackjack;


public class Card {
  private final int suit,rank,value;
    
    public Card(int suit,int rank ,int value)
    {
        this.suit=suit;
        this.rank=rank;
        this.value=value;
    }
    
    public Card(Card card)
    {
        suit=card.suit;
        rank=card.rank;
        value=card.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    void print(){
               System.out.println(suit);
               System.out.println(rank);
               System.out.println(value);
             System.out.println("////////////////////////////");
    }
    public int getValue() {
        return value;
    }
    
    
    
    
}
