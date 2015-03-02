
package strategies;

import game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DefectorTest {
    
    private static Defector instance;
    private static Player me;
    private static Player p2Cooperator;
    private static Player p2Defector;
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Defector();
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
     * Test of toString method, of class Defector.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Defector";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Defector.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        assertFalse (("Should always Defect"),
                instance.chooseStrategy(me, p2Random, information));
    }

    /**
     * Test of isDefector method, of class Defector.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.DEF);
    }
    
}
