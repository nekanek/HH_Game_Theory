
package Strategies;

import Game.Player;


public class Cooperator extends IStrategy {

    @Override
    public String toString() {
        return "Cooperator";
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        return true;
    }

    @Override
    public boolean isCooperator() {
        return true;
    }
    
}
