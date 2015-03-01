
package strategies;

import game.Player;


public class Random implements IStrategy {
    
    @Override
    public String toString() {
        return "Pure random"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        return IStrategy.makeRandomMove();
    }

    @Override
    public EStrategy whichStrategy() {
        return EStrategy.RAND;
    }    
}