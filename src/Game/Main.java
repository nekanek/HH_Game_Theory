package Game;

import Strategies.Cooperator;
import java.util.ArrayList;


public class Main {

   
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Player p = new Player(new Cooperator());
            players.add(p);
        }
        Game myGame = new Game(players, 10);
        myGame.play();
    }
    
}
