package Game;

import Strategies.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    
    ArrayList<Player> players;
    final int gameLength;
    final boolean information;
    final int CC_SCORE;
    final int CD_SCORE;
    final int DC_SCORE;
    final int DD_SCORE;
    ArrayList<Integer> scoreHistory = new ArrayList<>();
    
    ArrayList<Integer> scoreHistoryCoop = new ArrayList<>();
    ArrayList<Integer> scoreHistoryDef = new ArrayList<>();
    ArrayList<Integer> scoreHistoryTit = new ArrayList<>();
    ArrayList<Integer> scoreHistoryTitF = new ArrayList<>();
    ArrayList<Integer> scoreHistoryLess = new ArrayList<>();
    ArrayList<Integer> scoreHistoryRan = new ArrayList<>();
    ArrayList<Integer> scoreHistoryAvg85 = new ArrayList<>();
    
    public Game(ArrayList<Player> players, int gameLength, int CC_SCORE, int CD_SCORE, int DC_SCORE, int DD_SCORE, boolean information) {
        this.players = players;
        this.gameLength = gameLength;
        this.CC_SCORE = CC_SCORE;
        this.CD_SCORE = CD_SCORE;
        this.DC_SCORE = DC_SCORE;
        this.DD_SCORE = DD_SCORE;
        this.information = information;
        System.out.println("players" + players.toString());
    }


    public Game(ArrayList<Player> players, int gameLength) {
        this(players, gameLength, 3, 0, 5, 1, true);
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
        scoreHistoryCoop.add(0);
        scoreHistoryDef.add(0);
        scoreHistoryTit.add(0);
        scoreHistoryTitF.add(0);
        scoreHistoryLess.add(0);
        scoreHistoryRan.add(0);
        scoreHistoryAvg85.add(0);  
        Player p1;
        Player p2;
        for (int i = 0; i < players.size(); i += 2) {
            p1 = players.get(i);
            p2 = players.get(i+1);
            playInteraction(p1, p2);
        }
    }
    
    private void playInteraction (Player p1, Player p2) {
        boolean s1 = p1.getStrategy().chooseStrategy(p2, this.information);
        boolean s2 = p2.getStrategy().chooseStrategy(p1, this.information);
        p1.setLastMove(s1);
        p2.setLastMove(s2);
        if (s1 && s2) {
            p1.addPScore(CC_SCORE);
            addScore(p1, CC_SCORE);
            p2.addPScore(CC_SCORE);
            addScore(p2, CC_SCORE);
            scoreHistory.set(scoreHistory.size()-1, currScore() + CC_SCORE * 2);
        }
        else if (s1) {
            p1.addPScore(CD_SCORE);
            addScore(p1, CD_SCORE);
            p2.addPScore(DC_SCORE);
            addScore(p2, DC_SCORE);
            scoreHistory.set(scoreHistory.size()-1, currScore() + CD_SCORE + DC_SCORE);
        }
        else if (s2) {
            p1.addPScore(DC_SCORE);
            addScore(p1, DC_SCORE);
            p2.addPScore(CD_SCORE);
            addScore(p2, CD_SCORE);
            scoreHistory.set(scoreHistory.size()-1, currScore() + CD_SCORE + DC_SCORE);            
        }
        else {
            p1.addPScore(DD_SCORE);
            addScore(p1, DD_SCORE);
            p2.addPScore(DD_SCORE);
            addScore(p2, DD_SCORE);
            scoreHistory.set(scoreHistory.size()-1, currScore() + DD_SCORE * 2);            
        }        
    }

    private void printResults() {
//        System.out.println("Cooperators: " + scoreHistoryCoop.toString());
//        System.out.println("Defectors: " + scoreHistoryDef.toString());
//        System.out.println("Tit For Tat: " + scoreHistoryTit.toString());
//        System.out.println("Forgiving 0.5 Tit For Tat: " + scoreHistoryTitF.toString());
//        System.out.println("Less Wrongers: " + scoreHistoryLess.toString());
//        System.out.println("Randoms: " + scoreHistoryRan.toString());
//        System.out.println("Average 85%: " + scoreHistoryAvg85.toString());
//        
//        System.out.println("Cooperators: " + scoreHistoryCoop.get(gameLength-1));
//        System.out.println("Defectors: " + scoreHistoryDef.get(gameLength-1));
//        System.out.println("Tit For Tat: " + scoreHistoryTit.get(gameLength-1));
//        System.out.println("Forgiving 0.5 Tit For Tat: " + scoreHistoryTitF.get(gameLength-1));
//        System.out.println("Less Wrongers: " + scoreHistoryLess.get(gameLength-1));
//        System.out.println("Randoms: " + scoreHistoryRan.get(gameLength-1));
//        System.out.println("Average 85%: " + scoreHistoryAvg85.get(gameLength-1));
        int sumScore = 0;
        for (int i : scoreHistory) {
            sumScore += i;
        }
//        System.out.println("Overall Game score: " + scoreHistory.get(gameLength-1));
        System.out.println("Overall Game score: " + sumScore);        
        System.out.println("Score history: ");
        System.out.println(scoreHistory.toString());
    }

    private int currScore() {
        return scoreHistory.get(scoreHistory.size()-1);
    }
    
    private void addScore(Player p, int score) {
//        if (p.getStrategy().isAvg85()) {
//            scoreHistoryAvg85.set(scoreHistoryAvg85.size()-1, 
//                                  scoreHistoryAvg85.get(scoreHistory.size()-1)                           
//                                  + score); return; }
//        if (p.getStrategy().isCooperator()) {
//            scoreHistoryCoop.set(scoreHistoryCoop.size()-1, 
//                                  scoreHistoryCoop.get(scoreHistoryCoop.size()-1)                           
//                                  + score); return; }
//        if (p.getStrategy().isDefector()) {
//            scoreHistoryDef.set(scoreHistoryDef.size()-1, 
//                                  scoreHistoryDef.get(scoreHistoryDef.size()-1)                           
//                                  + score); return; }
//        if (p.getStrategy().isTitForTat()) {
//            scoreHistoryTit.set(scoreHistoryTit.size()-1, 
//                                  scoreHistoryTit.get(scoreHistoryTit.size()-1)                           
//                                  + score); return; }
//        if (p.getStrategy().isTitForTatForgiver()) {
//            scoreHistoryTitF.set(scoreHistoryTitF.size()-1, 
//                                  scoreHistoryTitF.get(scoreHistoryTitF.size()-1)                           
//                                  + score); return; }
//        if (p.getStrategy().isLess()) {
//            scoreHistoryLess.set(scoreHistoryLess.size()-1, 
//                                  scoreHistoryLess.get(scoreHistoryLess.size()-1)                           
//                                  + score); return; }
//        if (p.getStrategy().isRandom()) {
//            scoreHistoryRan.set(scoreHistoryRan.size()-1, 
//                                  scoreHistoryRan.get(scoreHistoryRan.size()-1)                           
//                                  + score); return; }        
    }
}
