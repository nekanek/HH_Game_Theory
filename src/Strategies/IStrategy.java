package Strategies;

import Game.Player;

public interface IStrategy {
    public boolean chooseStrategy (Player p) ;
        // returns true for cooperation
        //         false for defection
}
