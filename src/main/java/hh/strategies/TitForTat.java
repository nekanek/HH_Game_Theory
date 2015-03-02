
package hh.strategies;

import hh.game.Player;


public class TitForTat implements IStrategy {
    
    @Override
    public String toString() {
        return "Tit-for-Tat"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (information) return opponent.getLastMove(); 
        else return IStrategy.makeRandomMove();
    }

    @Override
    public EStrategy whichStrategy() {
        return EStrategy.TFT;
    }    
}