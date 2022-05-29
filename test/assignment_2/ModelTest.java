/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2;

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
public class ModelTest {

    Model modelTest;

    public ModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        modelTest = new Model();
    }

    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class) //Can not restart without first creating a database and logging in
    public void testRestart() {
        System.out.println("TESTING: testRestart");
        modelTest.restart();
    }

    @Test //Successfully connect to the database
    public void testConnectingToDB() {
        System.out.println("TESTING: testConnectingToDB");
        modelTest = new Model();
    }

    @Test //Check login details are correct in DB
    public void testCheckNameAreCorrect() {
        System.out.println("TESTING: testCheckNameAreCorrect");
        String testName = "pdc";
        String testPass = "adc";
        modelTest.checkName(testName, testPass);
    }

    @Test //Check if model can logout without logging in | Expected to catch exception
    public void testLogoutWithoutLoggingIn() {
        System.out.println("TESTING: testLogoutWithoutLoggingIn");
        try {
            modelTest.logout();
        } catch (Exception e) {
            fail("TEST FAILED: testLogoutWithoutLoggingIn -> Exception not caught: " + e);
        }
    }

    @Test // Check if exception is caught when help is not showing | Expected to catch exception
    public void testStopShowingHelp() {
        System.out.println("TESTING: testStopShowingHelp");
        try {
            modelTest.stopShowingHelp();
        } catch (Exception e) {
            fail("TEST FAILED: testStopShowingHelp -> Exception not caught: " + e);
        }
    }

    @Test // Check if exception is caught when help is not showing | Expected to catch exception
    public void testStopShowingHelp2() {
        System.out.println("TESTING: testStopShowingHelp2");
        modelTest.showHelp(); // This still expected to fail as we have not logged in yet.
        try {
            modelTest.stopShowingHelp();
        } catch (Exception e) {
            fail("TEST FAILED: testStopShowingHelp2 -> Exception not caught: " + e);
        }
    }
    
    @Test // Check if successful after logging in
    public void testStopShowingHelp3() {
        System.out.println("TESTING: testStopShowingHelp3");
        String uname = "pdc";
        String pword = "adc";
        modelTest.checkName(uname, pword);
        modelTest.showHelp(); // This now passes as we have logged in.
        try {
            modelTest.stopShowingHelp();
        } catch (Exception e) {
            fail("TEST FAILED: testStopShowingHelp2 -> Exception not caught: " + e);
        }
    }

}
