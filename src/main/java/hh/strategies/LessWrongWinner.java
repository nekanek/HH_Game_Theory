
package hh.strategies;

import hh.game.Player;
import java.util.HashSet;
import java.util.Set;

/* winning strategy from http://lesswrong.com/lw/7f2/prisoners_dilemma_tournament_results/
 * Make opponents last move, unless opponent defected 7 times (or if half the game is over - not implemented)
 */
public class LessWrongWinner implements IStrategy {
    
    private final Set<Player> blackList = new HashSet<>();
    
    @Override
    public boolean chooseStrategy(Player me, Player opponent, boolean information) {
        if (!information) return IStrategy.makeRandomMove();
        if (blackList.contains(opponent)) return false;
        else if (opponent.isLastNMovesFalse(7)) {
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
    public EStrategy whichStrategy() {
        return EStrategy.LESS;
    }    
}
