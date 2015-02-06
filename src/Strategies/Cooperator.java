
package Strategies;

import Game.Player;


public class Cooperator implements IStrategy {

    @Override
    public boolean chooseStrategy(Player p) {
        return true;
    }
    
}
