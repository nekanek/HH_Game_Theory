
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomTest {
    
    private static Random instance;
    private static Player me;
    private static Player p2Cooperator;
    private static Player p2Defector;
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Random();
        me = new Player(instance);
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
    }

    /**
     * Test of toString method, of class Random.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Pure random";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Random.
     */
//    @Test
//    public void testChooseStrategy() {
//        System.out.println("chooseStrategy");
//        boolean information = false;
//        boolean expResult = false;
//        boolean result = instance.chooseStrategy(me, opponent, information);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of isRandom method, of class Random.
     */
    @Test
    public void testIsRandom() {
        System.out.println("isRandom");
        assertTrue(instance.isRandom());
    }
    
}
