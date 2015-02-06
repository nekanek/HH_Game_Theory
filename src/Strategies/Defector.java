
package Strategies;

import Game.Player;


public class Defector implements IStrategy {

    @Override
    public boolean chooseStrategy(Player p) {
        return false;
    }
    
}
