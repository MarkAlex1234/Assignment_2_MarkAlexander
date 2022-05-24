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
        gameFrame.setSize(400, 350);
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

    public void setQuestion(String q, String a) {
        gamePanel.questionTextField.setText(q);
        gamePanel.answer1TextField.setText(a);
        calcPanel.repaint();
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
            this.setQuestion(data.question, data.answer);
        } else if (data.quitFlag) {
            this.loginFrame.dispose();
            this.gameFrame.dispose();
            this.helpFrame.dispose();
            this.quitGame(data.currentScore);
            System.out.println("> EXITED SUCCESSFULLY");
        } else if (data.helpFlag) {
            showHelpView();
        } else if (!data.helpFlag) {
            this.helpFrame.dispose();
        } else {
            this.setQuestion(data.question, data.answer);
        }
    }
}
