
package hh.strategies;

import hh.game.Player;
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
public class ComparatorTest {
    
    private static Comparator instance;
    @Mock
    private static Player me;
    @Mock
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Comparator();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of toString method, of class Comparator.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Comparator";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Comparator.
     */
    @Test
    public void testChooseStrategyOpponentIsBetter() {
        System.out.println("chooseStrategyOpponentIsBetter");
        when(me.getTotalPScore()).thenReturn(100);
        when(p2Random.getTotalPScore()).thenReturn(200);
        when(p2Random.getLastMove()).thenReturn(Boolean.TRUE);
        boolean information = true;
        boolean expResult = true;
        boolean result = instance.chooseStrategy(me, p2Random, information);
        assertEquals(expResult, result);
        verify(me).getTotalPScore();
        verify(p2Random).getLastMove();
        verify(p2Random).getTotalPScore();        
    }
    
    @Test
    public void testChooseStrategyMeIsBetter() {
        System.out.println("chooseStrategyMeIsBetter");
        when(me.getTotalPScore()).thenReturn(200);
        when(p2Random.getTotalPScore()).thenReturn(100);
        when(me.getLastMove()).thenReturn(Boolean.FALSE);
        boolean information = true;
        boolean expResult = false;
        boolean result = instance.chooseStrategy(me, p2Random, information);
        assertEquals(expResult, result);
        verify(me).getTotalPScore();
        verify(me).getLastMove();
        verify(p2Random).getTotalPScore();
    }
    /**
     * Test of isComparator method, of class Comparator.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.COMP);
    }
    
}
