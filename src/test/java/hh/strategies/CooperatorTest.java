
package strategies;

import game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CooperatorTest {
    
    private static Cooperator instance;
    private static Player me;
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Cooperator();
        me = new Player(instance);
        p2Random = new Player(new Random());
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
        p2Random = null;
    }

    /**
     * Test of toString method, of class Cooperator.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Cooperator";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Cooperator.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        boolean expResult = true;
        boolean result = instance.chooseStrategy(me, p2Random, information);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCooperator method, of class Cooperator.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.COOP);
    }
    
}
