package Game;

import Strategies.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
//        ArrayList<Player> players = demoPlayers();
//        Game myGame = new Game(players, 100, 10, -10, 20, 0, true);
//        myGame.play();
        startGame("Coopers", 1, 5, 3, 
                             0, 1, 0, 
                             0);
        
        startGame("Titers", 1, 0, 6, 
                             0, 3, 0, 
                             0);
        
        startGame("Rationals", 0, 0, 3, 
                             0, 3, 2, 
                             2);  
        
        startGame("Ignorants", 0, 0, 0,  10, 0, 0,  0);
        
        startGame("Balanced", 1, 1, 2, 
                             2, 1, 1, 
                             2);         
    }
    
    private static void startGame(String label, int def, int coop, int tit,
                                                    int ran, int titF, int less,
                                                    int avg85) {
        System.out.println(label);
        ArrayList<Player> team = createPlayers(def, coop, tit, 
                             ran, titF, less, 
                             avg85);  
        Game myGame = new Game(team, 100, 10, -10, 20, 0, true);
        myGame.play();  
    }
    
    private static ArrayList<Player> createPlayers (int def, int coop, int tit,
                                                    int ran, int titF, int less,
                                                    int avg85
                                                   ) {
        ArrayList<Player> players = new ArrayList<>();
        while (def > 0 || coop > 0 || tit > 0 || ran > 0 ||titF > 0 || less > 0 || avg85 > 0) {
            if (def-- > 0) players.add(new Player(new Defector()));
            if (coop-- > 0) players.add(new Player(new Cooperator()));
            if (tit-- > 0) players.add(new Player(new TitForTat()));
            if (ran-- > 0) players.add(new Player(new Random()));
            if (titF-- > 0) players.add(new Player(new TitForTatForgiver()));
            if (less-- > 0) players.add(new Player(new LessWrongWinner()));
            if (avg85-- > 0) players.add(new Player(new Averager85()));
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

    private static ArrayList<Player> demoPlayers () {
        int def = 15;
        int coop = 15; 
        int tit = 30;
        int ran = 0;
        int titF = 10;
        int less =10;
        int avg85 = 10;
        return createPlayers(def, coop, tit, 
                             ran, titF, less, 
                             avg85);        
//        int same = 30;
//        return createPlayers(same, same, same, 
//                             same, same, same, 
//                             same);

    }
}
