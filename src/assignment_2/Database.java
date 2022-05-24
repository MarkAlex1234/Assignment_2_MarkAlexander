/**
 *
 * @author Mark Alexander
 * @StudentID: 20112145
 *
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
            String questionTable = "QnA";

            if (!checkTableExisting(userTable)) {
                statement.executeUpdate("CREATE TABLE " + userTable + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            if (!checkTableExisting(questionTable)) {
                statement.executeUpdate("CREATE TABLE " + questionTable + " (questionID INT, question VARCHAR(50), answer VARCHAR(1))");
                populateQuestionTable();
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
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;

    }

    public Data getQuestion(int questionID) {
        Data data = new Data();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT questionID, question, answer FROM QNA "
                    + "WHERE questionID = '" + questionID + "'");
            if (rs.next()) {
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                data.question = question;
                data.answer = answer;
                System.out.println("> FOUND question: " + question + " & answer: " + answer);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
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
            statement.executeUpdate("INSERT INTO QNA "
                    + "VALUES('1', 'Captial of New Zealand is?', A),"
                    + "('1', 'The hammer and sickle is one of the most recognisable symbols of which political ideology?', B),"
                    + "('2', 'Obstetrics is a branch of medicine particularly concerned with what?', A),"
                    + "('3', 'Construction of which of these famous landmarks was completed first?', D),"
                    + "('4', 'What was the first Star Wars Movie released?', A),"
                    + "('5', 'Who won the English Football Premier League in 2019?', C),"
                    + "('6', 'In 1718, which pirate died in battle off the coast of what is now North Carolina?', B),"
                    + "('7', 'Which toys have been marketed with the phrase “robots in disguise?', C),"
                    + "('8', 'What name is given to the revolving belt machinery in an airport that delivers checked luggage from the plane to baggage reclaim?', D),"
                    + "('9', 'Which Disney character famously leaves a glass slipper behind at a royal ball?', C),"
                    + "('10', 'Who coded this Assignment?', A),"
                    + "('11', 'How old must you be to enter Bar101 in NZ?', B),"
                    + "('12', 'What is the name of Darth Vaders' Son?', C),"
                    + "('13', 'In the UK, the abbreviation NHS stands for National X Service?', B),"
                    + "('14', 'Who is Spiderman?', C),"
                    + "('15', 'What does the word loquacious mean?', B)");

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

//Git
