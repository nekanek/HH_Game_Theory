package hh.game;

import hh.strategies.IStrategy;
import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private final List<Integer> pScore;
    private final List<Boolean> movesHistory;
    private int histCoop = 0;
    private int totalPScore = 0;
    
    private final IStrategy strategy;

    public Player(IStrategy strategy) {
        this(strategy, (Math.random() < 0.5));
    }

    public Player(IStrategy strategy, boolean lastMove) {
        this.movesHistory = new ArrayList<>();
        this.pScore = new ArrayList<>();
        this.strategy = strategy;
        this.movesHistory.add(lastMove);
        if (lastMove) histCoop++;
    }
    
//    private int getPScore() {
//        return pScore.get(pScore.size()-1);
//    }

    private List<Integer> getPScoreHistory() {
        return pScore;
    }
    
    void addPScore(int pScore) {
        this.pScore.add(pScore);
        totalPScore += pScore;
    }

    public int getTotalPScore() {
        return totalPScore;
    }
    
    void setLastMove(boolean lastMove) {
        this.movesHistory.add(lastMove);
        if (lastMove) histCoop++;
    }
    
    public boolean getLastMove() {
        return movesHistory.get(movesHistory.size()-1);
    }
    
    public boolean isLastNMovesFalse(int n) {
        for (int i = movesHistory.size() - 1; i >= 0 && i >= movesHistory.size() - n; i--) 
            if (movesHistory.get(i)) return false;
        return true;
    }    
    
    public boolean isLastNMovesTrue(int n) {
        for (int i = movesHistory.size() - 1; i >= 0 && i >= movesHistory.size() - n; i--) 
            if (!movesHistory.get(i)) return false;
        return true;
    }       
    
    public boolean getNpercentMoves(double n) {
        double percent = ((double)histCoop/(movesHistory.size()));
        return Double.compare(percent, n) >= 0;
       
    }
    
    IStrategy getStrategy() {
        return strategy;
    }

    @Override
    public String toString() {
        return "Player{" + "strategy=" + strategy + '}';
    }

    
}
