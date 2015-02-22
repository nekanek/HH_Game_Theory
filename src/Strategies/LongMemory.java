
package Strategies;

import Game.Player;


public class LongMemory extends IStrategy {
    @Override
    public String toString() {
        return "Long Memory"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (information) 
            return opponent.isLastNMovesTrue(3); 
        else
            return IStrategy.makeRandomMove();
    }

    @Override
    public boolean isLongMemory() {
        return true;
    }
    
}