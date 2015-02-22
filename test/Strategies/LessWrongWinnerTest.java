package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LessWrongWinnerTest {
    
    private static LessWrongWinner instance;
    private static Player me;
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new LessWrongWinner();
        me = new Player(instance);
        p2Cooperator = new Player(new Cooperator());
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
        p2Cooperator = null;
    }

    /**
     * Test of chooseStrategy method, of class LessWrongWinner.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        boolean expResult = p2Cooperator.getLastMove();
        boolean result = instance.chooseStrategy(me, p2Cooperator, information);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class LessWrongWinner.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "LessWrong Winner";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLess method, of class LessWrongWinner.
     */
    @Test
    public void testIsLess() {
        System.out.println("isLess");
        assertTrue(instance.isLess());

    }
    
}
