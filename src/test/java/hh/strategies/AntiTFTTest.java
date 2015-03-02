
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
public class AntiTFTTest {
    
    private static AntiTFT instance;
    @Mock
    private static Player me;
    @Mock
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new AntiTFT();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
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
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        when(me.getLastMove()).thenReturn(true);
        boolean information = true;
        boolean result = instance.chooseStrategy(me, p2Random, information);
        assertFalse(result);
        verify(me).getLastMove();
    }

    /**
     * Test of isAntiTFT method, of class AntiTFT.
     */
    @Test
    public void testWhichStrategy() {
        System.out.println("isAntiTFT");
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.ANTI_TFT);
    }
    
}
