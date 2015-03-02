package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import strategies.Cooperator;
import strategies.IStrategy.EStrategy;

public class Game {

    private List<Player> players;
    private final int gameLength;
    private final boolean hasInformation;
    private final int ccScore;
    private final int cdScore;
    private final int dcScore;
    private final int ddScore;
    private final List<Integer> scoreHistory;
    private final static int CC_SCORE_DEFAULT = 10;
    private final static int CD_SCORE_DEFAULT = -10;
    private final static int DC_SCORE_DEFAULT = 20;
    private final static int DD_SCORE_DEFAULT = 0;
    private final static int GAME_LENGTH_DEFAULT = 50;
    private final static boolean INFO_DEFAULT = true;

    Game(List<Player> players, int gameLength, int ccScore, int cdScore, int dcScore, int ddScore, boolean hasInformation) {
        if (players.size()%2 != 0) {
            throw new IllegalArgumentException("Number of players in a team should be even.");
        }
        this.players = players;
        this.gameLength = gameLength;
        this.scoreHistory = new ArrayList<>(gameLength);
        this.ccScore = ccScore;
        this.cdScore = cdScore;
        this.dcScore = dcScore;
        this.ddScore = ddScore;
        this.hasInformation = hasInformation;
    }

    Game(List<Player> players, int gameLength) {
        this(players, gameLength, CC_SCORE_DEFAULT, CD_SCORE_DEFAULT, DC_SCORE_DEFAULT, DD_SCORE_DEFAULT, INFO_DEFAULT);
    }

    Game(List<Player> players, boolean information) {
        this(players, GAME_LENGTH_DEFAULT, CC_SCORE_DEFAULT, CD_SCORE_DEFAULT, DC_SCORE_DEFAULT, DD_SCORE_DEFAULT, information);
    }

    Game(List<Player> players) {
        this(players, INFO_DEFAULT);
    }

    void play() {
        for (int currentRound = 0; currentRound < gameLength; currentRound++) {
            Collections.shuffle(players);
            playRound();
        }
        printResults();
    }

    private void playRound() {
        int roundScore = 0;
        Player p1;
        Player p2;
        for (int i = 0; i < players.size() - 1; i += 2) {
            p1 = players.get(i);
            p2 = players.get(i + 1);
            roundScore += playInteraction(p1, p2);
        }
        scoreHistory.add(roundScore);
    }

    private int playInteraction(Player p1, Player p2) {
        boolean s1, s2;
        s1 = p1.getStrategy().chooseStrategy(p1, p2, hasInformation);
        s2 = p2.getStrategy().chooseStrategy(p2, p1, hasInformation);
        p1.setLastMove(s1);
        p2.setLastMove(s2);
        if (s1 && s2) {
            p1.addPScore(ccScore);
            p2.addPScore(ccScore);
            return ccScore * 2;
        } else if (s1) {
            p1.addPScore(cdScore);
            p2.addPScore(dcScore);
            return cdScore + dcScore;
        } else if (s2) {
            p1.addPScore(dcScore);
            p2.addPScore(cdScore);
            return cdScore + dcScore;
        } else {
            p1.addPScore(ddScore);
            p2.addPScore(ddScore);
            return ddScore * 2;
        }
    }

    private void printResults() {
        System.out.println("Overall Game score: " + gameScore());
        System.out.println("Score history: ");
        System.out.println(scoreHistory.toString());
        System.out.println("\nOverall game result per type of player:");
        Map<String, Integer> scores = playersScore();
        for (String name : scores.keySet()) {
            System.out.println(name + " : " + scores.get(name));
        }
    }

    private int currScore() {
        return scoreHistory.get(scoreHistory.size() - 1);
    }

    int gameScore() {
        int sumScore = 0;
        for (int i : scoreHistory) {
            sumScore += i;
        }
        return sumScore;
    }
    
    Map<String, Integer> playersScore() {
        Map<String, Integer> scores = new HashMap<>(20);
        scores.put("Anti TFTs", 0);
        scores.put("Averagers 50", 0);
        scores.put("Averagers 85", 0);
        scores.put("Comparators", 0);
        scores.put("Cooperators", 0);
        scores.put("Defectors", 0);
        scores.put("LessWorngers", 0);
        scores.put("Guys with Long Memory", 0);
        scores.put("Ignorant chaotic guys", 0);
        scores.put("TFTs", 0);
        scores.put("TFTs with 50% forgivness chance", 0);
        
        for (Player p : players) {
            EStrategy strategy = p.getStrategy().whichStrategy();
            switch (strategy) {
                case ANTI_TFT: {scores.replace("Anti TFTs", scores.get("Anti TFTs") + 
                                    p.getTotalPScore()); break;}
                case AVG_50: {scores.replace("Averagers 50", scores.get("Averagers 50") + 
                                    p.getTotalPScore()); break;}
                case AVG_85: {scores.replace("Averagers 85", scores.get("Averagers 85") + 
                                    p.getTotalPScore()); break;}
                case COMP: {scores.replace("Comparators", scores.get("Comparators") + 
                                    p.getTotalPScore()); break;}
                case COOP: {scores.replace("Cooperators", scores.get("Cooperators") + 
                                    p.getTotalPScore()); break;}
                case DEF: {scores.replace("Defectors", scores.get("Defectors") + 
                                    p.getTotalPScore()); break;}
                case LESS: {scores.replace("LessWorngers", scores.get("LessWorngers") + 
                                    p.getTotalPScore()); break;}
                case LONG_MEM: {scores.replace("Guys with Long Memory", scores.get("Guys with Long Memory") + p.getTotalPScore()); break;}
                case RAND: {scores.replace("Ignorant chaotic guys", scores.get("Ignorant chaotic guys") +                                    p.getTotalPScore()); break;}
                case TFT: {scores.replace("TFTs", scores.get("TFTs") + p.getTotalPScore()); break;}
                case TFT_FORG: {scores.replace("TFTs with 50% forgivness chance", scores.get("TFTs with 50% forgivness chance") + 
                                    p.getTotalPScore()); break;}
                default: throw new IllegalArgumentException("Unknown strategy");
            }
        }
        return scores;
    }
    
}
