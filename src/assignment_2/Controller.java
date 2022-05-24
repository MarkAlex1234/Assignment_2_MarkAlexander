package assignment_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mark Alexander
 * @StudentID: 20112145
 *
 */
public class Controller implements ActionListener {

    public View view;
    public Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("> BUTTONCLICKED: " + command);
        switch (command) {
            case "Login":
                String username = this.view.loginPanel.unInput.getText();
                String password = this.view.loginPanel.pwInput.getText();
                this.model.checkName(username, password);
                break;
            case "EXIT":
                this.model.quitGameNOSaving();
                break;
            case "Save & Quit":
                this.model.quitGame();
                break;
            case "Logout":
                this.view.loginFrame.setVisible(true);
                this.view.gameFrame.setVisible(false);
                break;
            case "Help":
                this.model.showHelp();
                break;
            case "Close Help Menu":
                this.model.stopShowingHelp();
                break;
            case "A":
                this.model.checkAnswer("A");
                break;
            case "B":
                this.model.checkAnswer("B");
                break;
            case "C":
                this.model.checkAnswer("C");
                break;
            case "D":
                this.model.checkAnswer("D");
                break;
            default:
                break;
        }
    }

}
