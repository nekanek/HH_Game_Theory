
package hh.strategies;

import hh.game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Averager85Test {
    
    private static Averager85 instance;
    @Mock
    private static Player me;
    @Mock
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Averager85();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
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
        when(p2Cooperator.getNpercentMoves(0.85)).thenReturn(true);
        boolean result = instance.chooseStrategy(me, p2Cooperator, information);
        assertTrue(result);
        verify(p2Cooperator).getNpercentMoves(0.85);
    }

    /**
     * Test of isAvg85 method, of class Averager85.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.AVG_85);
    }
    
}
