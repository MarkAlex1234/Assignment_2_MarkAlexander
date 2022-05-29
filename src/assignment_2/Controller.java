/*

Assignment 2 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;
    private Model model;

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

            // Login View Buttons
            case "Login":
                String username = this.view.loginPanel.unInput.getText();
                String password = this.view.loginPanel.pwInput.getText();
                this.model.checkName(username, password);
                break;
            case "EXIT":
                this.model.quitGameNOSaving();
                break;

            // Game View Buttons
            case "Save & Quit":
                this.model.quitAndSave();
                break;
            case "Restart":
                this.model.restart();
                break;
            case "Logout":
                this.model.logout();
                break;
            case "Help":
                this.model.showHelp();
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

            // Help View Buttons
            case "Close Help Menu":
                this.model.stopShowingHelp();
                break;

            // Game Over View Buttons
            case "Play again":
                this.model.restart();
                break;
            case "Main Menu":
                this.model.logout();
                break;
            case "Quit":
                this.model.quitGameNOSaving();
                break;

            //Default
            default:
                System.out.println(">CONTROLLER ERROR");
                break;
        }
    }

}
