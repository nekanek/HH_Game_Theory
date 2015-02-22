
package Strategies;

import Game.Player;


public class Comparator extends IStrategy {
    @Override
    public String toString() {
        return "Comparator"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        else
            if (me.getTotalPScore() < opponent.getTotalPScore())
                return opponent.getLastMove(); 
            else
                return me.getLastMove();
    }
    @Override
    public boolean isComparator() {
        return true;
    }
    
}