package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComparatorTest {
    
    private static Comparator instance;
    private static Player me;
    private static Player p2Random;
    
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Comparator();
        me = new Player(instance);
        p2Random = new Player(new Random());
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        me = null;
        p2Random = null;
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
    public void testChooseStrategy() {
        System.out.println("chooseStrategy");
        boolean information = true;
        boolean expResult = me.getLastMove();
        boolean result = instance.chooseStrategy(me, p2Random, information);
        assertEquals(expResult, result);
    }

    /**
     * Test of isComparator method, of class Comparator.
     */
    @Test
    public void testIsComparator() {
        System.out.println("isComparator");
        assertTrue(instance.isComparator());

    }
    
}
