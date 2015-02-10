
package Strategies;

import Game.Player;


public class TitForTatForgiver extends IStrategy {

    private final double forgivenessChance = 0.5;

    @Override
    public String toString() {
        return "Tit-for-Tat Forgiver " + forgivenessChance; 
    }

    @Override
    public boolean chooseStrategy(Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        if (!opponent.getLastMove()) return (forgivenessChance > Math.random());
        else return true;
    }
    
    @Override
    public boolean isTitForTatForgiver() {
        return true;
    }
    
}