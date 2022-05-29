/**
 *
 * @author Mark Alexander
 * ID: 20112145
 */
package assignment_2;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class View extends JFrame implements Observer {

    public LoginPanel loginPanel = new LoginPanel(); //Must be public to check login details
    private GamePanel gamePanel = new GamePanel();
    private HelpMenuPanel helpMenuPanel = new HelpMenuPanel();
    private GameOverPanel gameOverPanel = new GameOverPanel();

    private JFrame loginFrame = new JFrame("Game - Login");
    private JFrame gameFrame = new JFrame("Game - Play");
    private JFrame helpFrame = new JFrame("Game - Help");
    private JFrame gameOverFrame = new JFrame("Game - GameOver");

    public View() {
        showLoginView();
    }

    private void showLoginView() {
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 300);
        loginFrame.setResizable(false);
        loginFrame.add(loginPanel);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private void showGameView() {
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(780, 500);
        gameFrame.add(gamePanel);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    private void showHelpView() {
        helpFrame.setResizable(false);
        helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        helpFrame.setSize(350, 260);
        helpFrame.add(helpMenuPanel);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setVisible(true);
    }

    private void showGameOverView(int score) {
        gameOverFrame.setResizable(false);
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setSize(320, 300);
        if (score == 10) {
            this.gameOverPanel.loserWinnerLabel.setText("WINNER!");
        }
        this.gameOverPanel.scoreLabel.setText("" + score);
        gameOverFrame.add(gameOverPanel);
        gameOverFrame.setLocationRelativeTo(null);
        gameOverFrame.setVisible(true);
    }

    private void quitGame() {
        this.loginFrame.dispose();
        this.gameFrame.dispose();
        this.helpFrame.dispose();
    }

    private void setGamePanel(String question, String answer, String[] answerArray, int score) {
        gamePanel.questionTextField.setText(question);
        switch (answer) {
            case "A":
                //CORRECT ANSWER
                gamePanel.answer1TextField.setText("A)" + answerArray[0]); //TODO CHANGE TO ANSWER ARRAY - SEE DATA TO UNDERSTAND
                //INCORRECT ANSWERS
                gamePanel.answer2TextField.setText("B)" + answerArray[1]);
                gamePanel.answer3TextField.setText("C)" + answerArray[2]);
                gamePanel.answer4TextField.setText("D)" + answerArray[3]);
                break;
            case "B":
                //CORRECT ANSWER
                gamePanel.answer2TextField.setText("B)" + answerArray[0]);
                //INCORRECT ANSWERS
                gamePanel.answer1TextField.setText("A)" + answerArray[1]);
                gamePanel.answer3TextField.setText("C)" + answerArray[2]);
                gamePanel.answer4TextField.setText("D)" + answerArray[3]);
                break;
            case "C":
                //CORRECT ANSWER
                gamePanel.answer3TextField.setText("C)" + answerArray[0]);
                //INCORRECT ANSWERS
                gamePanel.answer1TextField.setText("A)" + answerArray[1]);
                gamePanel.answer2TextField.setText("B)" + answerArray[2]);
                gamePanel.answer4TextField.setText("D)" + answerArray[3]);
                break;
            case "D":
                //CORRECT ANSWER
                gamePanel.answer4TextField.setText("D)" + answerArray[0]);
                //INCORRECT ANSWERS
                gamePanel.answer1TextField.setText("A)" + answerArray[1]);
                gamePanel.answer2TextField.setText("B)" + answerArray[2]);
                gamePanel.answer3TextField.setText("C)" + answerArray[3]);
                break;
            default:
                //CORRECT ANSWER
                gamePanel.answer1TextField.setText("A)" + answerArray[0]); //TODO CHANGE TO ANSWER ARRAY - SEE DATA TO UNDERSTAND
                //INCORRECT ANSWERS
                gamePanel.answer2TextField.setText("B)" + answerArray[1]);
                gamePanel.answer3TextField.setText("C)" + answerArray[2]);
                gamePanel.answer4TextField.setText("D)" + answerArray[3]);
        }
        gamePanel.scoreLabel.setText("" + score);
        gamePanel.repaint();
        gameFrame.add(gamePanel);

    }

    public void addActionListener(ActionListener listener) {
        //Login Panel Buttons
        this.loginPanel.loginButton.addActionListener(listener);
        this.loginPanel.exitButton.addActionListener(listener);

        //Help Menu Buttons
        this.helpMenuPanel.closeButton.addActionListener(listener);

        //Game Buttons
        this.gamePanel.aButton.addActionListener(listener);
        this.gamePanel.bButton.addActionListener(listener);
        this.gamePanel.cButton.addActionListener(listener);
        this.gamePanel.dButton.addActionListener(listener);
        this.gamePanel.helpButton.addActionListener(listener);
        this.gamePanel.restartButton.addActionListener(listener);
        this.gamePanel.saveQuitButton.addActionListener(listener);
        this.gamePanel.logoutButton.addActionListener(listener);

        //Quit Buttons
        this.gameOverPanel.mainMenuButton.addActionListener(listener);
        this.gameOverPanel.playAgainButton.addActionListener(listener);
        this.gameOverPanel.quitButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;

        if (!data.loginFlag) {
            this.loginPanel.unInput.setText("");
            this.loginPanel.pwInput.setText("");
            this.loginPanel.messageLabel.setText("Invalid username and/or password");

        } else if (data.logoutFlag) {
            this.loginFrame.setVisible(true);
            this.gameFrame.setVisible(false);

        } else if (!data.started) {
            this.loginFrame.setVisible(false);
            data.started = true;
            this.setGamePanel(data.question, data.answer, data.answerArray, data.currentScore);
            this.showGameView();

        } else if (data.quitFlag) {
            quitGame();
            showGameOverView(data.currentScore);

        } else if (data.helpFlag) {
            showHelpView();
        } else if (!data.helpFlag) {
            this.helpFrame.dispose();
        }

        this.setGamePanel(data.question, data.answer, data.answerArray, data.currentScore);
    }
}
