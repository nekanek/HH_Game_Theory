package Game;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    
    private ArrayList<Player> players;
    private final int gameLength;
    private final boolean information;
    private final int ccScore;
    private final int cdScore;
    private final int dcScore;
    private final int ddScore;
    private final ArrayList<Integer> scoreHistory = new ArrayList<>();
    
    private final static int CC_SCORE_DEFAULT = 10;
    private final static int CD_SCORE_DEFAULT = -10;
    private final static int DC_SCORE_DEFAULT = 20;
    private final static int DD_SCORE_DEFAULT = 0;
    private final static int GAME_LENGTH_DEFAULT = 50;
    private final static boolean INFO_DEFAULT = true;    
    
    
    protected Game(ArrayList<Player> players, int gameLength, int CC_SCORE, int CD_SCORE, int DC_SCORE, int DD_SCORE, boolean information) {
        this.players = players;
        this.gameLength = gameLength;
        this.ccScore = CC_SCORE;
        this.cdScore = CD_SCORE;
        this.dcScore = DC_SCORE;
        this.ddScore = DD_SCORE;
        this.information = information;
    }

    protected Game(ArrayList<Player> players, int gameLength) {
        this(players, gameLength, CC_SCORE_DEFAULT, CD_SCORE_DEFAULT, DC_SCORE_DEFAULT, DD_SCORE_DEFAULT, INFO_DEFAULT);
    }    

    protected Game(ArrayList<Player> players, boolean information) {
        this(players, GAME_LENGTH_DEFAULT, CC_SCORE_DEFAULT, CD_SCORE_DEFAULT, DC_SCORE_DEFAULT, DD_SCORE_DEFAULT, information);
    }    
    
    protected Game(ArrayList<Player> players) {
        this(players, INFO_DEFAULT);
    }    
    
    protected void play() {
        for (int currentRound = 0; currentRound < gameLength; currentRound++) {
            Collections.shuffle(players); 
            playRound();
        }
        printResults();
    }
    
    private void playRound() {
        scoreHistory.add(0);
        Player p1;
        Player p2;
        for (int i = 0; i < players.size(); i += 2) {
            p1 = players.get(i);
            p2 = players.get(i+1);
            playInteraction(p1, p2);
        }
    }
    
    private void playInteraction (Player p1, Player p2) {
        boolean s1, s2;
        s1 = p1.getStrategy().chooseStrategy(p1, p2, this.information);
        s2 = p2.getStrategy().chooseStrategy(p2, p1, this.information);
        p1.setLastMove(s1);
        p2.setLastMove(s2);
        if (s1 && s2) {
            p1.addPScore(ccScore);
            p2.addPScore(ccScore);
            scoreHistory.set(scoreHistory.size()-1, currScore() + ccScore * 2);
        }
        else if (s1) {
            p1.addPScore(cdScore);
            p2.addPScore(dcScore);
            scoreHistory.set(scoreHistory.size()-1, currScore() + cdScore + dcScore);
        }
        else if (s2) {
            p1.addPScore(dcScore);
            p2.addPScore(cdScore);
            scoreHistory.set(scoreHistory.size()-1, currScore() + cdScore + dcScore);            
        }
        else {
            p1.addPScore(ddScore);
            p2.addPScore(ddScore);
            scoreHistory.set(scoreHistory.size()-1, currScore() + ddScore * 2);            
        }        
    }

    private void printResults() {
        int sumScore = 0;
        for (int i : scoreHistory) {
            sumScore += i;
        }
        System.out.println("Overall Game score: " + sumScore);        
        System.out.println("Score history: ");
        System.out.println(scoreHistory.toString());
    }

    private int currScore() {
        return scoreHistory.get(scoreHistory.size()-1);
    }
    
}
