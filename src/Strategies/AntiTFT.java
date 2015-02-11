
package Strategies;

import Game.Player;


public class AntiTFT extends IStrategy {
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
    public boolean isAntiTFT() {
        return true;
    }
    
}