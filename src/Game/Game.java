package Game;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    
    ArrayList<Player> Players;
    final int GameLength;
    final int CCscore = 3;
    final int CDscore = 5;
    final int DCscore = 0;
    final int DDscore = 1;
    ArrayList<Integer> ScoreHistory = new ArrayList<>();
    
    // boolean information ?

    public Game(ArrayList<Player> players, int GameLength) {
        if (players.size() % 2 != 0) 
            throw new IllegalArgumentException("Number of players should be even");
        this.Players = players;
        this.GameLength = GameLength;
    }
    
    protected void play() {
        for (int currentRound = 0; currentRound < GameLength; currentRound++) {
            Collections.shuffle(Players); 
            playRound();
        }
        printResults();
    }
    
    private void playRound() {
        ScoreHistory.add(0);
        
        Player p1;
        Player p2;
        for (int i = 0; i < Players.size(); i += 2) {
            p1 = Players.get(i);
            p2 = Players.get(i+1);
            playInteraction(p1, p2);
        }
    }
    
    private void playInteraction (Player p1, Player p2) {
        boolean s1 = p1.getStrategy().chooseStrategy(p2);
        boolean s2 = p2.getStrategy().chooseStrategy(p1);
        p1.setLastMove(s1);
        p2.setLastMove(s2);
        if (s1 && s2) {
            p1.addPScore(CCscore);
            p2.addPScore(CCscore);
            ScoreHistory.set(ScoreHistory.size()-1, currScore() + CCscore * 2);
        }
        else if (s1) {
            p1.addPScore(CDscore);
            p2.addPScore(DCscore);
            ScoreHistory.set(ScoreHistory.size()-1, currScore() + CDscore + DCscore);
        }
        else {
            p1.addPScore(DDscore);
            p2.addPScore(DDscore);
            ScoreHistory.set(ScoreHistory.size()-1, currScore() + DDscore * 2);            
        }
    }

    private void printResults() {
        for (Player p : Players) {
            System.out.println("Strategy: " + p.getStrategy() + "; Score: " + p.getPScore());
        }
        System.out.println("Overall Game score: " + ScoreHistory.get(GameLength-1));
        System.out.println("Score history: ");
        System.out.println(ScoreHistory.toString());
    }

    private int currScore() {
        return ScoreHistory.get(ScoreHistory.size()-1);
    }
    
}
