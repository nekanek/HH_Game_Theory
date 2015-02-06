
package Strategies;

import Game.Player;


public class TitForTat implements IStrategy {

    @Override
    public boolean chooseStrategy(Player opponent) {
        return opponent.getLastMove(); 
    }
    
}