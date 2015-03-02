
package strategies;

import game.Player;


public class Cooperator implements IStrategy {
    
    @Override
    public String toString() {
        return "Cooperator";
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        return true;
    }
    
    @Override
    public EStrategy whichStrategy() {
        return EStrategy.COOP;
    }    
}
