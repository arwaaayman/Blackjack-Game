
package blackjack;


public class Player {
    Card[] cards=new Card[11];
    String Name;
    boolean blackJack;
    int handScore;
    int index=0;

    public Player(String Name,int index,Card c1 ,Card c2) {
        this.Name = Name;
        this.index=index;
        this.cards[0]=c1;
        this.cards[1]=c2;
        
    }

    public int calcScore()
    {handScore=0;
    for(int i=0;i<index;i++)
    {
    handScore+=cards[i].getValue();
    
    }
   
    return handScore;
    }
    
}
