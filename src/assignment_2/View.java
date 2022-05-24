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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements Observer {

    public LoginPanel loginPanel = new LoginPanel();
    public GamePanel gamePanel = new GamePanel();
    public HelpMenuPanel helpMenuPanel = new HelpMenuPanel();
    private JPanel calcPanel = new JPanel();

    public JTextField calcSolution = new JTextField(10);

    public JFrame loginFrame = new JFrame("Game - Login");
    public JFrame gameFrame = new JFrame("Game - Play");
    public JFrame helpFrame = new JFrame("Game - Help");

    private RandomManager rm = new RandomManager();

    private boolean gameOver = false;

    public View() {
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 300);
        loginFrame.setResizable(false);
        loginFrame.add(loginPanel);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    public void startQuiz() {
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(750, 500);
        gameFrame.add(gamePanel);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    public void showHelpView() {
        helpFrame.setResizable(false);
        helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        helpFrame.setSize(350, 260);
        helpFrame.add(helpMenuPanel);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setVisible(true);
    }

    public void setQuestion(String question, String answer, String[] answerArray) {
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
        this.gamePanel.saveQuitButton.addActionListener(listener);
        this.gamePanel.logoutButton.addActionListener(listener);

        //Quit Buttons
    }

    private void quitGame(int score) {
        JPanel quitPanel = new JPanel();
        JLabel scoreLabel = new JLabel("Your score: " + score);
        quitPanel.add(scoreLabel);
        this.getContentPane().removeAll();
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if (!data.loginFlag) {
            this.loginPanel.unInput.setText("");
            this.loginPanel.pwInput.setText("");
            this.loginPanel.messageLabel.setText("Invalid username and/or password");
        } else if (!data.started) {
            this.loginFrame.setVisible(false);
            this.startQuiz();
            data.started = true;
            this.setQuestion(data.question, data.answer, data.answerArray);
        } else if (data.quitFlag) {
            this.loginFrame.dispose();
            this.gameFrame.dispose();
            this.helpFrame.dispose();
            this.quitGame(data.currentScore);
            System.out.println("> EXITED SUCCESSFULLY");
        } else if (data.helpFlag) {
            showHelpView();
        } else if (data.newQuestionFlag) {
            this.setQuestion(data.question, data.answer, data.answerArray);
        } else if (!data.helpFlag) {
            this.helpFrame.dispose();
        } else {
           // this.setQuestion(data.question, data.answer, data.answerArray); -- CAUSING ERROR? INVESTIGATE
        }
    }
}
