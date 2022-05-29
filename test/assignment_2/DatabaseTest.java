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
public class DatabaseTest {
    
    public DatabaseTest() {
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
    public void testDbsetup() {
        System.out.println("dbsetup");
        Database instance = new Database();
        instance.dbsetup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckName() {
        System.out.println("checkName");
        String username = "";
        String password = "";
        Database instance = new Database();
        Data expResult = null;
        Data result = instance.checkName(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        int questionID = 0;
        Database instance = new Database();
        String expResult = "";
        String result = instance.getQuestion(questionID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetQuestionId() {
        System.out.println("getQuestionId");
        int questionId = 0;
        Database instance = new Database();
        int expResult = 0;
        int result = instance.getQuestionId(questionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        int questionID = 0;
        Database instance = new Database();
        String expResult = "";
        String result = instance.getAnswer(questionID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetWrongAnswers() {
        System.out.println("getWrongAnswers");
        int questionID = 0;
        Database instance = new Database();
        String[] expResult = null;
        String[] result = instance.getWrongAnswers(questionID);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testQuitGame() {
        System.out.println("quitGame");
        int score = 0;
        String username = "";
        Database instance = new Database();
        instance.quitGame(score, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPopulateQuestionTable() {
        System.out.println("populateQuestionTable");
        Database instance = new Database();
        instance.populateQuestionTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPopulateAnswerTable() {
        System.out.println("populateAnswerTable");
        Database instance = new Database();
        instance.populateAnswerTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
