/*

Assignment 2 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    Connection conn = null;
    String url = "jdbc:derby:PlayerDB;create=true";  //url of the DB host
    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";   //your DB password

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String userTable = "UserInfo";
            String questionTable = "QuestionTable";
            String answerTable = "AnswerTable";

            if (!checkTableExisting(userTable)) {
                statement.executeUpdate("CREATE TABLE " + userTable + " (userid VARCHAR(200), password VARCHAR(200), score INT)");
            }
            if (!checkTableExisting(questionTable)) {
                statement.executeUpdate("CREATE TABLE " + questionTable + " (questionID INT, question VARCHAR(200), answer VARCHAR(1))");
                populateQuestionTable();
            }
            if (!checkTableExisting(answerTable)) {
                statement.executeUpdate("CREATE TABLE " + answerTable + " (questionID INT, CorrectAnswer VARCHAR(100), WrongAnswer1 VARCHAR(100), WrongAnswer2 VARCHAR(100), WrongAnswer3 VARCHAR(100))");
                populateAnswerTable();
            }
            statement.close();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);

        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("> Checking existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println("> " + tableName + " was found");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex);
        }
        return flag;
    }

    public Data checkName(String username, String password) {
        Data data = new Data();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (username.isEmpty()) {
                System.out.println("> ERROR: USERNAME CANNOT BE EMPTY");
                data.loginFlag = false;
                return data;
            } else if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("> FOUND user with username: " + username + " & password: " + pass);
                if (password.compareTo(pass) == 0) {
                    System.out.println("> LOGIN SUCCESSFUL");
                    data.currentScore = rs.getInt("score");
                    data.loginFlag = true;
                    data.started = false;
                    data.username = username;
                } else {
                    System.out.println("> ERROR: Incorrect password for user '" + username + "'");
                    data.loginFlag = false;
                }
            } else {
                System.out.println("> No such user, CREATING user with name: " + username + " AND password: " + password);
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                data.currentScore = 0;
                data.loginFlag = true;
                data.username = username;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }

    public String getQuestion(int questionID) {
        Data data = new Data();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT questionID, question FROM QuestionTable "
                    + "WHERE questionID = " + questionID + "");
            if (rs.next()) {
                String question = rs.getString("question");
                data.question = question;
                System.out.println("> FOUND question: " + question);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data.question;
    }
    
     public int getQuestionId (int questionId) {
         int qID = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT questionID, question FROM QuestionTable "
                    + "WHERE questionID = " + questionId + "");
            if (rs.next()) {
                qID = rs.getInt("questionID");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qID;
    }

    public String getAnswer(int questionID) {
        Data data = new Data();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT questionID, answer FROM QuestionTable "
                    + "WHERE questionID = " + questionID + "");
            if (rs.next()) {
                String answer = rs.getString("answer");
                data.answer = answer;
                System.out.println("> FOUND questionID: " + questionID + " & answer: " + answer);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data.answer;
    }

    public String[] getWrongAnswers(int questionID) {
        Data data = new Data();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM AnswerTable "
                    + "WHERE questionID = " + questionID + "");
            if (rs.next()) {
                String answer = rs.getString("CorrectAnswer");
                String wrongAnswer1 = rs.getString("WrongAnswer1");
                String wrongAnswer2 = rs.getString("WrongAnswer2");
                String wrongAnswer3 = rs.getString("WrongAnswer3");
                data.answerArray[0] = answer;
                data.answerArray[1] = wrongAnswer1;
                data.answerArray[2] = wrongAnswer2;
                data.answerArray[3] = wrongAnswer3;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data.answerArray;
    }

    void quitGame(int score, String username) {

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + score + " WHERE userid='" + username + "'");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void populateQuestionTable() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO QuestionTable "
                    + "VALUES(1, 'Captial of New Zealand is?', 'A'),"
                    + "(2, 'The hammer and sickle is one of the most recognisable symbols of which political ideology?', 'B'),"
                    + "(3, 'Obstetrics is a branch of medicine particularly concerned with what?', 'A'),"
                    + "(4, 'Construction of which of these famous landmarks was completed first?', 'D'),"
                    + "(5, 'What was the first Star Wars Movie released?', 'A'),"
                    + "(6, 'Who won the English Football Premier League in 2019?', 'C'),"
                    + "(7, 'In 1718, which pirate died in battle off the coast of what is now North Carolina?', 'B'),"
                    + "(8, 'Which toys have been marketed with the phrase “robots in disguise?', 'C'),"
                    + "(9, 'What name is given to the revolving belt machinery in an airport that delivers checked luggage from the plane to baggage reclaim?', 'D'),"
                    + "(10, 'Which Disney character famously leaves a glass slipper behind at a royal ball?', 'C'),"
                    + "(11, 'Who coded this Assignment?', 'A'),"
                    + "(12, 'How old must you be to enter Bar101 in NZ?', 'B'),"
                    + "(13, 'What is the name of Darth Vaders Son?', 'C'),"
                    + "(14, 'In the UK, the abbreviation NHS stands for National X Service?', 'B'),"
                    + "(15, 'Who is Spiderman?', 'C'),"
                    + "(16, 'What does the word loquacious mean?', 'B')");
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateAnswerTable() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO AnswerTable "
                    + "VALUES(1, 'Wellington', 'Dunedin', 'Auckland', 'Chirstchurch'),"
                    + "(2, 'Communism', 'Republicanism', 'Liberalism', 'Conservatism'),"
                    + "(3, 'Childbirth', 'Old age', 'Broken bones', 'Heart conditions'),"
                    + "(4, 'Big Ben Clock Tower', 'Eiffel Tower', 'Royal Albert Hall', 'Empire State Building'),"
                    + "(5, 'A New Hope', 'Revenge Of The Sith', 'The Force Awakens', 'Return Of The Jedi'),"
                    + "(6, 'Liverpool', 'Man-City', 'Chelsea', 'Everton'),"
                    + "(7, 'Blackbeard', 'Captain Kidd', 'Captain Sparrow', 'Joe'),"
                    + "(8, 'Transformers', 'Hot Wheels', 'Bratz Dolls', 'Hot Wheels'),"
                    + "(9, 'Carousel', 'Concourse', 'Terminal', 'Hangar'),"
                    + "(10, 'Cinderella', 'Elsa', 'Sleeping Beauty', 'Pocahontas'),"
                    + "(11, 'Mark Alexander', 'John Doe', 'Micheal Jones', 'Fred'),"
                    + "(12, '18', '21', '12', '16'),"
                    + "(13, 'Luke Skywalker', 'Jake Skywalker', 'Anakin Skywalker', 'Leia Skywalker'),"
                    + "(14, 'Health', 'Humanity', 'Honour', 'Household'),"
                    + "(15, 'Peter Parker', 'Jack', 'Bruce Waynce', 'John Doe'),"
                    + "(16, 'Chatty', 'Angry', 'Beautiful', 'Shy')");
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
