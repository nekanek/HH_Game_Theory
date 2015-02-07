package Game;

import Strategies.Cooperator;
import Strategies.Defector;
import Strategies.TitForTat;
import java.util.ArrayList;


public class Main {

   
    public static void main(String[] args) {
       
        ArrayList<Player> players = createPlayers(100, 100, 100);
        Game myGame = new Game(players, 10000);
        myGame.play();
    }
    
    private static ArrayList<Player> createPlayers (int def, int coop, int tit) {
        ArrayList<Player> players = new ArrayList<>();
        while (def > 0 || coop > 0 || tit > 0) {
            if (def-- > 0) players.add(new Player(new Defector()));
            if (coop-- > 0) players.add(new Player(new Cooperator()));
            if (tit-- > 0) players.add(new Player(new TitForTat()));
        }


//        for (int i = 0; i < 100; i++) {
//            Player p = new Player(new Cooperator());
//            players.add(p);
//        }
//        for (int i = 0; i < 100; i++) {
//            Player p = new Player(new Defector());
//            players.add(p);
//        }
//        for (int i = 0; i < 100; i++) {
//            Player p = new Player(new TitForTat());
//            players.add(p);
        
        return players;
    }
    
}
