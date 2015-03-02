
package strategies;

import game.Player;


public class Defector implements IStrategy {
    
    @Override
    public String toString() {
        return "Defector"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player p2, boolean information) {
        return false;
    }

    @Override
    public EStrategy whichStrategy() {
        return EStrategy.DEF;
    }    
}
