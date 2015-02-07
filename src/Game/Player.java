package Game;

import Strategies.IStrategy;

public class Player {
    
    private int PScore = 0;
    private boolean LastMove = false;
    private final IStrategy Strategy;

    protected Player(IStrategy Strategy) {
        this.Strategy = Strategy;
    }

    public int getPScore() {
        return PScore;
    }

    protected void addPScore(int PScore) {
        this.PScore += PScore;
    }
    
    protected void setLastMove(boolean LastMove) {
        this.LastMove = LastMove;
    }
    
    public boolean getLastMove() {
        return LastMove;
    }

    protected IStrategy getStrategy() {
        return Strategy;
    }

    
}
