/* winning strategy from http://lesswrong.com/lw/7f2/prisoners_dilemma_tournament_results/
 * Make opponents last move, unless opponent defected 7 times (or if half the game is over - not implemented)
 */
package Strategies;

import Game.Player;
import java.util.ArrayList;

public class LessWrongWinner extends IStrategy {
    
    private final ArrayList<Player> blackList = new ArrayList<>();
    
    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        if (blackList.contains(opponent)) return false;
        else if (opponent.getLast7Moves()) {
            blackList.add(opponent);
            return false;
        }
        else return opponent.getLastMove();
    }

    @Override
    public String toString() {
        return "LessWrong Winner";
    }

    @Override
    public boolean isLess() {
        return true;
    }
    
}
