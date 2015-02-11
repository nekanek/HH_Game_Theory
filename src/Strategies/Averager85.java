
package Strategies;

import Game.Player;


public class Averager85 extends IStrategy {

    @Override
    public String toString() {
        return "Averager 85%"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        return opponent.get85percentMoves();
    }
    
    @Override
    public boolean isAvg85() {
        return true;
    }   
}