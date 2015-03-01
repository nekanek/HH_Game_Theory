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
public class LessWrongWinnerTest {
    
    private static LessWrongWinner instance;
    @Mock
    private static Player me;
    @Mock
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new LessWrongWinner();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of chooseStrategy method, of class LessWrongWinner.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        when(p2Cooperator.isLastNMovesFalse(7)).thenReturn(true);
        boolean result = instance.chooseStrategy(me, p2Cooperator, information);
        assertFalse(result);
        verify(p2Cooperator).isLastNMovesFalse(7);
    }

    /**
     * Test of toString method, of class LessWrongWinner.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "LessWrong Winner";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLess method, of class LessWrongWinner.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.LESS);
    }
    
}
