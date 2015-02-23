
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Averager50Test {
    
    private static Averager50 instance;
    @Mock
    private static Player me;
    @Mock
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Averager50();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of toString method, of class Averager50.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Averager 50%";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Averager50.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        when(p2Cooperator.getNpercentMoves(0.5)).thenReturn(false);
        boolean expResult = false;
        boolean result = instance.chooseStrategy(me, p2Cooperator, information);
        assertEquals(expResult, result);
        verify(p2Cooperator).getNpercentMoves(0.5);
    }

    /**
     * Test of isAvg50 method, of class Averager50.
     */
    @Test
    public void testIsAvg50() {
        System.out.println("isAvg50");
        assertTrue(instance.isAvg50());
    }
    
}
