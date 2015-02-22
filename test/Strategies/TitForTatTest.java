
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TitForTatTest {
    
    private static TitForTat instance;
    private static Player me;
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new TitForTat();
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
     * Test of toString method, of class TitForTat.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Tit-for-Tat";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class TitForTat.
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
     * Test of isTitForTat method, of class TitForTat.
     */
    @Test
    public void testIsTitForTat() {
        System.out.println("isTitForTat");
        assertTrue(instance.isTitForTat());
    }
    
}
