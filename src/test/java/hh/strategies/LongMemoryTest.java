
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
public class LongMemoryTest {
    
    private static LongMemory instance;
    @Mock
    private static Player me;
    @Mock
    private static Player p2Cooperator;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new LongMemory();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of toString method, of class LongMemory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Long Memory";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class LongMemory.
     */
    @Test
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        when(p2Cooperator.isLastNMovesTrue(3)).thenReturn(Boolean.TRUE);
        boolean result = instance.chooseStrategy(me, p2Cooperator, true);
        assertTrue(result);
        verify(p2Cooperator).isLastNMovesTrue(3);
    }

    /**
     * Test of isLongMemory method, of class LongMemory.
     */
    @Test
    public void testWhichStrategy() {
        assertTrue(instance.whichStrategy() == IStrategy.EStrategy.LONG_MEM);
    }
    
}
