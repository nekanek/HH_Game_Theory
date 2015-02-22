/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import Game.Player;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neko
 */
public class IStrategyTest {
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of makeRandomMove method, of class IStrategy.
     */
    // ?

    /**
     * Test of isCooperator method, of class IStrategy.
     */
    @Test
    public void testIsCooperator() {
        System.out.println("isCooperator");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isCooperator();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDefector method, of class IStrategy.
     */
    @Test
    public void testIsDefector() {
        System.out.println("isDefector");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isDefector();
        assertEquals(expResult, result);
    }

    /**
     * Test of isTitForTat method, of class IStrategy.
     */
    @Test
    public void testIsTitForTat() {
        System.out.println("isTitForTat");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isTitForTat();
        assertEquals(expResult, result);
    }

    /**
     * Test of isTitForTatForgiver method, of class IStrategy.
     */
    @Test
    public void testIsTitForTatForgiver() {
        System.out.println("isTitForTatForgiver");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isTitForTatForgiver();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLess method, of class IStrategy.
     */
    @Test
    public void testIsLess() {
        System.out.println("isLess");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isLess();
        assertEquals(expResult, result);
    }

    /**
     * Test of isRandom method, of class IStrategy.
     */
    @Test
    public void testIsRandom() {
        System.out.println("isRandom");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isRandom();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvg85 method, of class IStrategy.
     */
    @Test
    public void testIsAvg85() {
        System.out.println("isAvg85");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isAvg85();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLongMemory method, of class IStrategy.
     */
    @Test
    public void testIsLongMemory() {
        System.out.println("isLongMemory");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isLongMemory();
        assertEquals(expResult, result);
    }

    /**
     * Test of isComparator method, of class IStrategy.
     */
    @Test
    public void testIsComparator() {
        System.out.println("isComparator");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isComparator();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvg50 method, of class IStrategy.
     */
    @Test
    public void testIsAvg50() {
        System.out.println("isAvg50");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isAvg50();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAntiTFT method, of class IStrategy.
     */
    @Test
    public void testIsAntiTFT() {
        System.out.println("isAntiTFT");
        IStrategy instance = new IStrategyImpl();
        boolean expResult = false;
        boolean result = instance.isAntiTFT();
        assertEquals(expResult, result);
    }

    public class IStrategyImpl extends IStrategy {

        @Override
        public boolean chooseStrategy(Player me, Player opponent, boolean information) {
            return false;
        }
    }
    
}
