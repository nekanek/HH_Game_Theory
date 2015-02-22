
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TitForTatForgiverTest {
    
    private static TitForTatForgiver instance;
    private static Player me;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new TitForTatForgiver();
        me = new Player(instance);
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
    }

    /**
     * Test of toString method, of class TitForTatForgiver.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Tit-for-Tat Forgiver 0.5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class TitForTatForgiver.
     */
//    @Test
//    public void testChooseStrategy() {
//        System.out.println("chooseStrategy");
//        boolean information = true;
//        boolean expResult = false;
//        boolean result = instance.chooseStrategy(me, opponent, information);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of isTitForTatForgiver method, of class TitForTatForgiver.
     */
    @Test
    public void testIsTitForTatForgiver() {
        System.out.println("isTitForTatForgiver");
        assertTrue(instance.isTitForTatForgiver());
    }
    
}
