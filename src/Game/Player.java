package Game;

import Strategies.IStrategy;
import java.util.ArrayList;

public class Player {
    
    private ArrayList<Integer> pScore;
    private ArrayList<Boolean> movesHistory;
    private int histCoop = 0;
    private int totalPScore = 0;
    
    private final IStrategy strategy;

    protected Player(IStrategy strategy) {
        this(strategy, (Math.random() < 0.5));
    }

    protected Player(IStrategy strategy, boolean lastMove) {
        this.movesHistory = new ArrayList<>();
        this.pScore = new ArrayList<>();
        this.strategy = strategy;
        this.movesHistory.add(lastMove);
    }
    
    public int getPScore() {
        return pScore.get(pScore.size()-1);
    }

    public ArrayList<Integer> getPScoreHistory() {
        return pScore;
    }
    
    protected void addPScore(int pScore) {
        this.pScore.add(pScore);
        this.totalPScore += pScore;
    }

    public int getTotalPScore() {
        return totalPScore;
    }
    
    protected void setLastMove(boolean lastMove) {
        this.movesHistory.add(lastMove);
        if (lastMove) histCoop++;
    }
    
    public boolean getLastMove() {
        return movesHistory.get(movesHistory.size()-1);
    }
    
    public boolean getLast7Moves() {
        return isLastNMovesFalse(7);
    }
    
    public boolean isLastNMovesFalse(int n) {
        boolean result = false;
        for (int i = movesHistory.size() - 1; i >= 0; i--) 
            if (result || movesHistory.get(i)) return false;
        return true;
    }    
    
    public boolean isLastNMovesTrue(int n) {
        boolean result = true;
        for (int i = movesHistory.size() - 1; i >= 0; i--) 
            if (!(result && movesHistory.get(i))) return false;
        return true;
    }        
    public boolean get85percentMoves() {
        return getNpercentMoves(0.85);
    }    
    
    public boolean getNpercentMoves(double n) {
        if (movesHistory.size() == 1) return movesHistory.get(0);
        else return (histCoop/(movesHistory.size()-1) > n);
    }
    
    protected IStrategy getStrategy() {
        return strategy;
    }

    @Override
    public String toString() {
        return "Player{" + "strategy=" + strategy + '}';
    }

    
}
