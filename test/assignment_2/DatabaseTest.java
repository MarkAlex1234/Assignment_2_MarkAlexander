/*

Assignment 2 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {

    Database dbTest;

    public DatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbTest = new Database();
        dbTest.dbsetup();
    }

    @After
    public void tearDown() {
    }

    @Test //Check Database set up correctly
    public void testDbsetup() {
        System.out.println(">TESTING: testDbsetup");
        Database instance = new Database();
        instance.dbsetup();
    }

    @Test // Check if username is set/found correctly
    public void testCheckName() {
        System.out.println(">TESTING: testCheckName");
        Data result = new Data();

        String username = "pdc";
        String password = "adc";
        String expUsername = "pdc";

        result = dbTest.checkName(username, password);
        assertSame(expUsername, result.username);
    }

    @Test(expected = NullPointerException.class) // Test without setting up the DB
    public void testCheckName2() {
        System.out.println(">TESTING: testCheckName2");
        Data result = new Data();
        Database instance = new Database();
        
        String username = "pdc";
        String password = "adc";
        String expUsername = "pdc";

        result = instance.checkName(username, password);
        assertSame(expUsername, result.username);
    }

    @Test // Returns a pass as 1 has that question matching
    public void testGetQuestion() {
        System.out.println(">TESTING: testGetQuestion");
        int questionID = 1;
        
        String result;
        result = dbTest.getQuestion(questionID);
        
        String expResult = "Captial of New Zealand is?";
        assertEquals(expResult, result);
    }
    
     @Test // Returns a pass as 0 has no question related with it
    public void testGetQuestion2() {
        System.out.println(">TESTING: testGetQuestion2");
        int questionID = 0;
        
        String result;
        result = dbTest.getQuestion(questionID);
        
        String expResult = "";
        assertEquals(expResult, result);
    }

    @Test // Check if with the same ID
    public void testGetQuestionId() {
        System.out.println(">TESTING: testGetQuestionId");
        int questionId = 1;
        
        int expResult = 1;
        int result = dbTest.getQuestionId(questionId);
        assertEquals(expResult, result);
    }
    
    @Test // Check if fails with different IDs
    public void testGetQuestionId2() {
        System.out.println(">TESTING: testGetQuestionId2");
        int questionId = 2;
        
        int expResult = 1;
        int result = dbTest.getQuestionId(questionId);
        assertNotSame(expResult, result);
    }

    @Test // Checks with a correct answer
    public void testGetAnswer() {
        System.out.println(">TESTING: testGetAnswer");
        int questionID = 3;
        
        String expResult = "A";
        String result = dbTest.getAnswer(questionID);
        
        assertEquals(expResult, result);
    }

    @Test // Check if with an invalid QuestionID that both return empty arrays
    public void testAnswersArray() {
        System.out.println(">TESTING: testAnswersArray");
        int questionID = 0;      
        String[] expResult = {"","","",""};
        String[] result = dbTest.getAnswersArray(questionID);
        assertArrayEquals(expResult, result);
    }
    
    @Test // Check if with an valid QuestionID that both return the same arrays
    public void testAnswersArray2() {
        System.out.println(">TESTING: testAnswersArray2");
        int questionID = 5;      
        String[] expResult = {"A New Hope", "Revenge Of The Sith", "The Force Awakens", "Return Of The Jedi"};
        String[] result = dbTest.getAnswersArray(questionID);
        assertArrayEquals(expResult, result);
    }
}
