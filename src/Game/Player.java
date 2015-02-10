package Game;

import Strategies.IStrategy;
import java.util.ArrayList;

public class Player {
    
    private ArrayList<Integer> pScore;
    private ArrayList<Boolean> movesHistory;
    private int histCoop = 0;
    
    private final IStrategy strategy;

    protected Player(IStrategy strategy) {
        this(strategy, true);
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
    }
    
    protected void setLastMove(boolean lastMove) {
        this.movesHistory.add(lastMove);
        if (lastMove) histCoop++;
    }
    
    public boolean getLastMove() {
        return movesHistory.get(movesHistory.size()-1);
    }
    
    public boolean getLast7Moves() {
        if (movesHistory.size() < 7) return true;
        boolean result = false;
        for (int i = movesHistory.size() - 1; i >= 0; i--) 
            if (result || movesHistory.get(i)) return true;
        return result;
    }
 
    public boolean get85percentMoves() {
        if (movesHistory.size() == 1) return movesHistory.get(0);
        else return (histCoop/(movesHistory.size()-1) > 0.85);
    }    
    
    protected IStrategy getStrategy() {
        return strategy;
    }

    @Override
    public String toString() {
        return "Player{" + "strategy=" + strategy + '}';
    }

    
}
