/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2;

import junit.framework.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author WindForce
 */
public class RandomManagerTest {
    
    RandomManagerTest rmTest;
    
    public RandomManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rmTest = new RandomManagerTest();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test //Test if the generated number is less than 16
    public void testGenerateNumberLessThan15() {
        System.out.println(">TESTING: testGenerateNumberLessThan15");
        RandomManager instance = new RandomManager();
        int result = instance.generateNumber();
        assertTrue(result < 16);
    }
    
    @Test //Test if the generated number is over 15, it fails
    public void testGenerateNumberGreaterThan15() {
        System.out.println(">TESTING: testGenerateNumberGreaterThan15");
        RandomManager instance = new RandomManager();
        int result = instance.generateNumber();
        if(result > 15){
            fail(">TEST FAIL: The generated number is over 15");
        }
    }
    
    @Test //Test if the generated number is larger than 0
    public void testGenerateNumberLargerThan0() {
        System.out.println(">TESTING: testGenerateNumberLargerThan0");
        RandomManager instance = new RandomManager();
        int result = instance.generateNumber();
        assertTrue(result > 0);
    }
    
    @Test //Test if the generated number is not null
    public void testGenerateNumberIsNotNull() {
        System.out.println(">TESTING: testGenerateNumberIsNotNull");
        RandomManager instance = new RandomManager();
        int result = instance.generateNumber();
        assertNotNull(result);
    }
    
    @Test(expected = AssertionError.class) //Test if generated number does not return 0
    public void testGenerateNumberIsNotZero() {
        System.out.println(">TESTING: testGenerateNumberIsNotZero");
        RandomManager instance = new RandomManager();
        int expected = 0;
        int result = instance.generateNumber();
        assertEquals(result, expected);
    }
    
}
