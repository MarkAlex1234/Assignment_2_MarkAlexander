/**
 *
 * @author Mark Alexander
 * @StudentID: 20112145
 *
 */
package assignment_2;

import java.util.Observable;
import java.util.Random;

public class Model extends Observable {

    public Database db;
    public Data data;
    private RandomManager rm;
    public int ans = 0;
    public String username;

    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }

    public void checkName(String uname, String pword) {
        this.username = uname;
        this.data = this.db.checkName(uname, pword);

        if (data.loginFlag) {
            this.newQuestion();
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void restart(){
        this.data.currentScore = 0;
        this.newQuestion();
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newQuestion() {
        rm = new RandomManager();
        int randomNum = rm.generateNumber();
        this.data.question = this.db.getQuestion(randomNum);;
        this.data.answer = this.db.getAnswer(randomNum);
        this.data.answerArray = this.db.getWrongAnswers(randomNum);
        data.newQuestionFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public int getNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }

    public void quitGame() {
        try {
            this.db.quitGame(this.data.currentScore, this.username);
            this.data.quitFlag = true;
            this.setChanged();
            this.notifyObservers(this.data);
        } catch (Exception e) {
            System.out.println(">ERROR: " + e);
        }
    }

    public void quitGameNOSaving() {
        System.out.println(">EXITED SUCCESSFULLY");
        System.exit(0);
    }

    public void checkAnswer(String answer) {
        try {
            if (answer.equals(data.answer)) {
                data.currentScore += 10;
                System.out.println("> CORRECT");
                if (data.currentScore == 100) {
                    System.out.println("> WINNER");
                    //TODO ADD WINNER PANEL
                }
            } else {
                data.currentScore = 0;
                System.out.println("> INCORRECT - GAMEOVER");
                quitGame();
            }
            this.newQuestion();
            this.setChanged();
            this.notifyObservers(this.data);
        } catch (Exception e) {
            System.out.println(">ERROR: " + e);
        }
    }

    public void showHelp() {
        try {
            this.data.helpFlag = true;
            this.setChanged();
            this.notifyObservers(this.data);
        } catch (Exception e) {
            System.out.println(">ERROR: " + e);
        }
    }
    
    public void stopShowingHelp(){
        this.data.helpFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void logout(View view){
        view.loginFrame.setVisible(true);
        view.gameFrame.setVisible(false);
    }
 
    public void gameOverLoser(){
        
    }
    
    public void gameOverWinner(){
        
    }
}
