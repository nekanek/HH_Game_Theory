
package strategies;

import game.Player;


public class LongMemory implements IStrategy {
    
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
    public EStrategy whichStrategy() {
        return EStrategy.LONG_MEM;
    }    
    
}