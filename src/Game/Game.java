package Game;

public class Game {
    
    
    
    private void playRound (Player p1, Player p2) {
        boolean s1 = p1.getStrategy().chooseStrategy(p2);
        boolean s2 = p2.getStrategy().chooseStrategy(p1);
        if (s1 && s2) {
            
        }
                
    }
}
