package Game;

import Strategies.IStrategy;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Player {
    
    private final ArrayList<Integer> pScore;
    private final ArrayList<Boolean> movesHistory;
    private int histCoop = 0;
    private int totalPScore = 0;
    
    private final IStrategy strategy;

    public Player(IStrategy strategy) {
        this(strategy, (Math.random() < 0.5));
    }

    private Player(IStrategy strategy, boolean lastMove) {
        this.movesHistory = new ArrayList<>();
        this.pScore = new ArrayList<>();
        this.strategy = strategy;
        this.movesHistory.add(lastMove);
        if (lastMove) histCoop++;
    }
    
//    private int getPScore() {
//        return pScore.get(pScore.size()-1);
//    }

    private ArrayList<Integer> getPScoreHistory() {
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
    
    public boolean isLastNMovesFalse(int n) {
        boolean result = false;
        for (int i = movesHistory.size() - 1; i >= 0 && i >= movesHistory.size() - n; i--) 
            if (result || movesHistory.get(i)) return false;
        return true;
    }    
    
    public boolean isLastNMovesTrue(int n) {
        boolean result = true;
        for (int i = movesHistory.size() - 1; i >= 0 && i >= movesHistory.size() - n; i--) 
            if (!(result && movesHistory.get(i))) return false;
        return true;
    }       
    
    public boolean getNpercentMoves(double n) {
        double percent = ((double)histCoop/(movesHistory.size()));
        return Double.compare(percent, n) >= 0;
       
    }
    
    protected IStrategy getStrategy() {
        return strategy;
    }

    @Override
    public String toString() {
        return "Player{" + "strategy=" + strategy + '}';
    }

    
}
