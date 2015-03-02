
package game;

import strategies.Cooperator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    /**
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        List<Player> team = new ArrayList<>();
        team.add(new Player(new Cooperator()));
        team.add(new Player(new Cooperator()));
        Game myGame = new Game(team, true);
        myGame.play(); 
        assertTrue(myGame.gameScore() == 1000);
    }
    
}
