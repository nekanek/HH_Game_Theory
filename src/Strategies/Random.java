
package Strategies;

import Game.Player;


public class Random extends IStrategy {

    @Override
    public String toString() {
        return "Pure random"; 
    }

    @Override
    public boolean chooseStrategy(Player opponent, boolean information) {
        return IStrategy.makeRandomMove();
    }
    
    @Override
    public boolean isRandom() {
        return true;
    }    
}