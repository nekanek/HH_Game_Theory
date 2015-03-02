
package hh.strategies;

import hh.game.Player;

public interface IStrategy {
//    public EStrategy eStrategy;
    
    public enum EStrategy {
        ANTI_TFT, AVG_50, AVG_85, COMP, COOP, DEF, LESS, LONG_MEM, RAND, TFT, TFT_FORG
    }
    
    public boolean chooseStrategy(Player me, Player opponent, boolean information);
            // returns true for cooperation
        //         false for defection
    
    public EStrategy whichStrategy();
    
    public static boolean makeRandomMove() {
        return Math.random() < 0.5;
    }
    
    
    
//    public boolean isCooperator() {
//        return false;
//    }
//    public boolean isDefector() {
//        return false;
//    }
//    public boolean isTitForTat() {
//        return false;
//    }
//    public boolean isTitForTatForgiver() {
//        return false;
//    }
//    public boolean isLess() {
//        return false;
//    }
//    public boolean isRandom() {
//        return false;
//    }
//    public boolean isAvg85() {
//        return false;
//    }
//    public boolean isLongMemory() {
//        return false;
//    }
//    public boolean isComparator() {
//        return false;
//    }
//    public boolean isAvg50() {
//        return false;
//    }
//    public boolean isAntiTFT() {
//        return false;
//    }

}
