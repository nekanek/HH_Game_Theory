
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AntiTFTTest {
    
    private static AntiTFT instance;
    private static Player me;
    private static Player p2Cooperator;
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new AntiTFT();
        me = new Player(instance);
        p2Cooperator = new Player(new Cooperator());
        p2Random = new Player(new Random());
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
        p2Cooperator = null;
        p2Random = null;
    }

    /**
     * Test of toString method, of class AntiTFT.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Anti Tit-for-Tat";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class AntiTFT.
     */
//    @Test
//    public void testChooseStrategy() {
//        System.out.println("chooseStrategy");
//        boolean information = true;
//        boolean expResult = false;
//        boolean result = instance.chooseStrategy(p2Cooperator, p2Random, information);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of isAntiTFT method, of class AntiTFT.
     */
    @Test
    public void testIsAntiTFT() {
        System.out.println("isAntiTFT");
        assertTrue(instance.isAntiTFT());
    }
    
}
