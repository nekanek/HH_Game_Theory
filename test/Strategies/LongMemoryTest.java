
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LongMemoryTest {
    
    private static LongMemory instance;
    private static Player me;
    private static Player p2Cooperator;
    private static Player p2Defector;
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new LongMemory();
        me = new Player(instance);
        p2Cooperator = new Player(new Cooperator());
        p2Defector = new Player(new Defector());
        p2Random = new Player(new Random());
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
        p2Cooperator = null;
        p2Defector = null;
        p2Random = null;
    }

    /**
     * Test of toString method, of class LongMemory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Long Memory";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class LongMemory.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean expResult = p2Cooperator.isLastNMovesTrue(3);
        boolean result = instance.chooseStrategy(me, p2Cooperator, true);
        assertEquals(expResult, result);
    }

    /**
     * Test of isLongMemory method, of class LongMemory.
     */
    @Test
    public void testIsLongMemory() {
        System.out.println("isLongMemory");
        assertTrue(instance.isLongMemory());

    }
    
}
