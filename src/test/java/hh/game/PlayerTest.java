
package hh.game;

import hh.strategies.Cooperator;
import hh.strategies.IStrategy;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class PlayerTest {
    
    private Player instance;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Player(new Cooperator());
        
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of addPScore method, of class Player.
     */
    @Test
    public void testAddPScore() {
        System.out.println("addPScore");
        int pScore = 5;
        instance.addPScore(pScore);
        assertEquals(5, instance.getTotalPScore());
    }

    /**
     * Test of getTotalPScore method, of class Player.
     */


    /**
     * Test of setLastMove method, of class Player.
     */
    @Test
    public void testSetLastMove() {
        System.out.println("setLastMove");
        boolean lastMove = false;
        instance.setLastMove(lastMove);
        assertFalse(instance.getLastMove());
    }

    /**
     * Test of getLastMove method, of class Player.
     */

    /**
     * Test of isLastNMovesFalse method, of class Player.
     */
    @Test
    public void testIsLastNMovesFalse() {
        System.out.println("isLastNMovesFalse");
        int n = 3;
        instance.setLastMove(false);
        instance.setLastMove(false);
        instance.setLastMove(false);
        boolean result = instance.isLastNMovesFalse(n);
        assertTrue(result);
    }

    /**
     * Test of isLastNMovesTrue method, of class Player.
     */
    @Test
    public void testIsLastNMovesTrue() {
        System.out.println("isLastNMovesTrue");
        int n = 3;
        instance.setLastMove(true);
        instance.setLastMove(true);
        instance.setLastMove(true);
        boolean result = instance.isLastNMovesTrue(n);
        assertTrue(result);
    }

    /**
     * Test of getNpercentMoves method, of class Player.
     */
    @Test
    public void testGetNpercentMoves() {
        System.out.println("getNpercentMoves");
        double n = 0.8;
        instance.setLastMove(!instance.getLastMove());
        // after previous line in history are 1 false and 1 true moves
        instance.setLastMove(true);
        instance.setLastMove(true);
        instance.setLastMove(true);
        boolean result = instance.getNpercentMoves(n);
        assertTrue(result);
    }

    /**
     * Test of getStrategy method, of class Player.
     */
    @Test
    public void testGetStrategy() {
        System.out.println("getStrategy");
        IStrategy expResult = (new Player(new Cooperator())).getStrategy();
        IStrategy result = instance.getStrategy();
        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Player{strategy=Cooperator}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
