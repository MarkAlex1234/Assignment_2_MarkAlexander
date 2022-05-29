/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author WindForce
 */
public class ModelTest {
    
    public ModelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCheckName() {
        System.out.println("checkName");
        String uname = "";
        String pword = "";
        Model instance = new Model();
        instance.checkName(uname, pword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRestart() {
        System.out.println("restart");
        Model instance = new Model();
        instance.restart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testNewQuestion() {
        System.out.println("newQuestion");
        Model instance = new Model();
        instance.newQuestion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testQuitAndSave() {
        System.out.println("quitAndSave");
        Model instance = new Model();
        instance.quitAndSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testQuitGame() {
        System.out.println("quitGame");
        Model instance = new Model();
        instance.quitGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testQuitGameNOSaving() {
        System.out.println("quitGameNOSaving");
        Model instance = new Model();
        instance.quitGameNOSaving();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckAnswer() {
        System.out.println("checkAnswer");
        String answer = "";
        Model instance = new Model();
        instance.checkAnswer(answer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testShowHelp() {
        System.out.println("showHelp");
        Model instance = new Model();
        instance.showHelp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testStopShowingHelp() {
        System.out.println("stopShowingHelp");
        Model instance = new Model();
        instance.stopShowingHelp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testLogout() {
        System.out.println("logout");
        Model instance = new Model();
        instance.logout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
