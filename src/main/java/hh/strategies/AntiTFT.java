
package hh.strategies;

import hh.game.Player;


public class AntiTFT implements IStrategy {
    
    @Override
    public String toString() {
        return "Anti Tit-for-Tat"; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (information) 
            if (me.getLastMove()) return false;
        return IStrategy.makeRandomMove();
    }

    @Override
    public EStrategy whichStrategy() {
        return EStrategy.ANTI_TFT;
    }
    
    
}