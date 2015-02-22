
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Averager85Test {
    
    private static Averager85 instance;
    private static Player me;
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Averager85();
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
     * Test of toString method, of class Averager85.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Averager 85%";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Averager85.
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
     * Test of isAvg85 method, of class Averager85.
     */
    @Test
    public void testIsAvg85() {
        System.out.println("isAvg85");
        assertTrue(instance.isAvg85());
    }
    
}
