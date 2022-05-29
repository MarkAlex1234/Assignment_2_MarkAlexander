/*

Assignment 2 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.awt.event.ActionListener;
import java.util.Observable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewTest {
    
    public ViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test // Check if we can add a listener to the view
    public void testAddActionListener() {
        System.out.println("addActionListener");
        ActionListener listener = null;
        View instance = new View();
        instance.addActionListener(listener);
    }

    @Test(expected = NullPointerException.class) // Can not pass with null
    public void testUpdate() {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        View instance = new View();
        instance.update(o, arg);
    }
    
}
