
package Strategies;

import Game.Player;


public class Defector extends IStrategy {

    @Override
    public String toString() {
        return "Defector"; 
    }

    @Override
    public boolean chooseStrategy(Player p2, boolean information) {
        return false;
    }
    
    @Override
    public boolean isDefector() {
        return true;
    }
}
