package Strategies;

import Game.Player;

public abstract class IStrategy {
    public abstract boolean chooseStrategy(Player me, Player opponent, boolean information);
            // returns true for cooperation
        //         false for defection
    
    public static boolean makeRandomMove() {
        return Math.random() < 0.5;
    }
    
    public boolean isCooperator() {
        return false;
    }
    public boolean isDefector() {
        return false;
    }
    public boolean isTitForTat() {
        return false;
    }
    public boolean isTitForTatForgiver() {
        return false;
    }
    public boolean isLess() {
        return false;
    }
    public boolean isRandom() {
        return false;
    }
    public boolean isAvg85() {
        return false;
    }
    public boolean isLongMemory() {
        return false;
    }
    public boolean isComparator() {
        return false;
    }
    public boolean isAvg50() {
        return false;
    }
    public boolean isAntiTFT() {
        return false;
    }

}
