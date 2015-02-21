package Game;

import Strategies.*;
import java.util.ArrayList;


public class Main {    

    public static void main(String[] args) {
        startGame("Coopers", 1, 5, 3, 
                             0, 1, 0, 
                             0, 0, 0, 0, 0);
        
        startGame("Titers", 1, 0, 6, 
                             0, 3, 0, 
                             0, 0, 0, 0, 0);
        
        startGame("Rationals", 0, 0, 3, 
                             0, 3, 2, 
                             2, 0, 0, 0, 0);  
        
        startGame("Ignorants", 0, 0, 0,  10, 0, 0,  0, 0, 0, 0, 0);
        
        startGame("Balanced", 1, 1, 2, 
                             2, 1, 1, 
                             2, 0, 0, 0, 0);  
        startGame("Pure Def", 10, 0, 0,  0, 0, 0,  0, 0, 0, 0, 0);
        startGame("Pure Coop", 0, 10, 0,  0, 0, 0,  0, 0, 0, 0, 0);
        startGame("Pure Tit", 0, 0, 10,  0, 0, 0,  0, 0, 0, 0, 0);
        startGame("Pure Rand", 0, 0, 0,  10, 0, 0,  0, 0, 0, 0, 0);
        startGame("Pure Tit forgiving", 0, 0, 0,  0, 10, 0,  0, 0, 0, 0, 0);
        startGame("Pure Less", 0, 0, 0,  0, 0, 10,  0, 0, 0, 0, 0);
        startGame("Pure avg85", 0, 0, 0,  0, 0, 0,  10, 0, 0, 0, 0);
        startGame("Pure long mem", 0, 0, 0,  0, 0, 0,  0, 10, 0, 0, 0);
        startGame("Pure comparators", 0, 0, 0,  0, 0, 0,  0, 0, 10, 0, 0);
        startGame("Pure avg50", 0, 0, 0,  0, 0, 0,  0, 0, 0, 10, 0);
        startGame("coops and long mem", 0, 8, 0,  0, 0, 0,  0, 2, 0, 0, 0);
        startGame("comps and less and long mem", 0, 0, 0,  0, 0, 3,  0, 4, 3, 0, 0);
        startGame("Anti TFT and TFT", 0, 0, 9,  0, 0, 0,  0, 0, 0, 0, 1);
    }
    
    private static void startGame(String label, int def, int coop, int tit, int ran, int titF, int less, int avg85, int lm, int cmp, int avg50, int antiTFT) {
        System.out.println(label);
        ArrayList<Player> team = createPlayers(def, coop, tit, 
                                               ran, titF, less, 
                                               avg85, lm, cmp, 
                                               avg50, antiTFT);  
        Game myGame = new Game(team, true);
        myGame.play();  
        System.out.println("");
    }
    
    private static ArrayList<Player> createPlayers (int def, int coop, int tit, int ran, int titF, int less, int avg85, int lm, int cmp, int avg50, int antiTFT) {
        ArrayList<Player> players = new ArrayList<>();
        while (def > 0 || coop > 0 || tit > 0 || ran > 0 ||titF > 0 || less > 0 || avg85 > 0 || lm > 0 || cmp > 0 || avg50 > 0 || antiTFT > 0) {
            if (def-- > 0) players.add(new Player(new Defector()));
            if (coop-- > 0) players.add(new Player(new Cooperator()));
            if (tit-- > 0) players.add(new Player(new TitForTat()));
            if (ran-- > 0) players.add(new Player(new Random()));
            if (titF-- > 0) players.add(new Player(new TitForTatForgiver()));
            if (less-- > 0) players.add(new Player(new LessWrongWinner()));
            if (avg85-- > 0) players.add(new Player(new Averager85()));
            if (lm-- > 0) players.add(new Player(new LongMemory()));
            if (cmp-- > 0) players.add(new Player(new Comparator()));
            if (avg50-- > 0) players.add(new Player(new Averager50()));
            if (antiTFT-- > 0) players.add(new Player(new AntiTFT()));
        }
        return players;
    }

}
