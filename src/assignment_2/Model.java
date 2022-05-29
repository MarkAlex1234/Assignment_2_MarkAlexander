/**
 *
 * @author Mark Alexander
 * @StudentID: 20112145
 *
 */
package assignment_2;

import java.util.Observable;

public class Model extends Observable {

    public Database db;
    public Data data;
    private RandomManager rm;
    public int ans = 0;
    public String username;

    public Model() {
        try {
            this.db = new Database();
            this.db.dbsetup();
        } catch (Exception e) {
            System.out.println(">ERROR SETTING UP DATABASE IN THE MODEL CLASS: " + e);
        }
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

    public void restart() {
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
            if (this.data.currentScore >= 10) {
                System.out.println("> WINNER");
                this.data.quitFlag = true;
                this.setChanged();
                this.notifyObservers(this.data);
            } else if (answer.equals(data.answer)) {
                this.data.currentScore += 1;
                System.out.println("> CORRECT");
                this.setChanged();
                this.notifyObservers(this.data);
                this.newQuestion();
            } else {
                data.currentScore = 0;
                System.out.println("> INCORRECT - GAMEOVER");
                this.setChanged();
                this.notifyObservers(this.data);
                quitGame();
            }

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

    public void stopShowingHelp() {
        this.data.helpFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void logout(View view) {
        view.loginFrame.setVisible(true);
        view.gameFrame.setVisible(false);
    }

    public void gameOverLoser() {

    }

    public void gameOverWinner() {

    }
}
