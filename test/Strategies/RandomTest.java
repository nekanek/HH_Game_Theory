
package Strategies;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomTest {
    
    private static Random instance;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Random();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of toString method, of class Random.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Pure random";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseStrategy method, of class Random.
     */
//    @Test
//    public void testChooseStrategy() {
//        System.out.println("chooseStrategy");
//        boolean information = false;
//        boolean expResult = true;
//        when(makeRandomMove()).thenReturn(true);
//        boolean result = instance.chooseStrategy(me, p2Cooperator, information);
//        assertEquals(expResult, result);
//        verify(makeRandomMove());
//    }

    /**
     * Test of isRandom method, of class Random.
     */
    @Test
    public void testIsRandom() {
        System.out.println("isRandom");
        assertTrue(instance.isRandom());
    }
    
}
