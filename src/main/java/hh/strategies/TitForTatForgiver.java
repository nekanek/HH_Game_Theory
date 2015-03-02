
package hh.strategies;

import hh.game.Player;


public class TitForTatForgiver implements IStrategy {
    
    private final double forgivenessChance = 0.5;

    @Override
    public String toString() {
        return "Tit-for-Tat Forgiver " + forgivenessChance; 
    }

    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        if (!opponent.getLastMove()) return (forgivenessChance > Math.random());
        else return true;
    }
    
    @Override
    public EStrategy whichStrategy() {
        return EStrategy.TFT_FORG;
    }    
}