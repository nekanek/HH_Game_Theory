
package hh.strategies;

import hh.game.Player;


public class Averager85 implements IStrategy {
    
    @Override
    public String toString() {
        return "Averager 85%"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        return opponent.getNpercentMoves(0.85);
    }
    
    @Override
    public EStrategy whichStrategy() {
        return EStrategy.AVG_85;
    }  
}