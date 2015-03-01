
package strategies;

import game.Player;
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
public class TitForTatForgiverTest {
    
    private static TitForTatForgiver instance;
    @Mock
    private static Player me;
    @Mock
    private static Player opponent;
    
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
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        when(opponent.getLastMove()).thenReturn(true);
        boolean result = instance.chooseStrategy(me, opponent, information);
        assertTrue(result);
        verify(opponent).getLastMove();
    }

    /**
     * Test of isTitForTatForgiver method, of class TitForTatForgiver.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.TFT_FORG);
    }
    
}
