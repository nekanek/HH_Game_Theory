
package strategies;

import game.Player;


public class Averager50 implements IStrategy {

    @Override
    public String toString() {
        return "Averager 50%"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        return opponent.getNpercentMoves(0.5);
    }

    @Override
    public EStrategy whichStrategy() {
        return EStrategy.AVG_50;
    }
    
    

}