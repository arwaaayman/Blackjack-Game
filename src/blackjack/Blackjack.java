
package blackjack;

import java.util.Scanner;


public class Blackjack {

    /**
     * @param args the command line arguments
     */
    static int choice;
    static Game game = new Game();
    static int q;
    public static void main(String[] args) {
        GUI gui = new GUI();

        game.generateDeck();
        game.playersInfo();   
      gui.runGUI( game.cards, game.players[0].cards, game.players[1].cards, game.players[2].cards, game.players[3].cards );

        Scanner scan = new Scanner(System.in);
        int count = 1;
     
        for (int m = 0; m < 3; m++) {
            while (count < 10) {
                System.out.println(game.players[m].Name);
                System.out.println("press for hit 1 for stand 0");
                choice = scan.nextInt();
                if (choice == 1) {
                    count++;
                    game.players[m].cards[game.players[m].index] = game.drawCard();
                    gui.updatePlayerHand(game.players[m].cards[game.players[m].index],m );
                    game.players[m].index++;

                } else {
                    game.players[m].calcScore();
                    break;
                }

            }
        }
////////////////////
        /////deler cards
        int highscore;
        int indexxx = game.updateScore();
        if(indexxx>=0){
        highscore=game.players[indexxx].handScore;}
        else
        {highscore=0;}
            
        count = game.players[3].index;
        if (game.players[3].handScore < highscore && game.players[3].handScore<=21 ) {
            while (count < 10) {
                game.players[3].cards[game.players[3].index] = game.drawCard();
                gui.updateDealerHand(game.players[3].cards[game.players[3].index],game.cards);
                game.players[3].index++;
                count++;
                game.players[3].calcScore();

                if (game.players[3].handScore > highscore || game.players[3].handScore>=21 ) {
                    break;
                }
       
            }
        }
        game.players[3].calcScore();

        if(game.players[3].handScore>highscore &&  game.players[3].handScore<21)
        {
            System.out.println("Deler win");
        
        }
        else if( game.players[3].handScore==21)
        {
        
            game.players[3].blackJack=true;
            System.out.println("Deler has BlackJack and win");
        } 
        else if(game.players[3].handScore > 21){
            if(indexxx>=0)
            {
            if(game.players[indexxx].handScore<=21)
            {
                if(game.players[indexxx].handScore==21)
                {
                System.out.print(game.players[indexxx].Name+" Winner and has BlaclJack and score "+game.players[indexxx].handScore);
                
                }
                else
                {

                System.out.print("Winner "+game.players[indexxx].Name+" and score "+game.players[indexxx].handScore);
                }
            
            }
            else
            {
            System.out.println("PUSH");
            System.out.println(game.players[indexxx].handScore);
            }}
            else
            System.out.println("PUSH");

        }
        
        
        

    }

}
