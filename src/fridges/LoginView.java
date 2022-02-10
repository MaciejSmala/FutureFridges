/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author smala
 */
public class LoginView extends JPanel implements Observer {

    private Model model;
    JTextField userNameField;
    //private JTextField passwordField;
    JLabel inputLabel;
    private JButton loginButton;
    private JLabel welcomeLabel;
    private IController c;

    public LoginView(IController c) {
        super(new GridBagLayout());
        initView();
        this.c=c;
        this.c.addView(this);
        this.model = c.getModel();
        this.model.addObserver(this);
    }

    private void initView() {

        userNameField = new JTextField(40);
        welcomeLabel = new JLabel("Welcome, please type in your ID:",SwingConstants.CENTER);
        inputLabel = new JLabel("ID",SwingConstants.CENTER);
        loginButton = new JButton("Log in");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(textField.getText());
                //label.setText("logged in");
                c.loginButtonClicked();
            }
        });

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(welcomeLabel, c);
        add(inputLabel, c);
        add(userNameField, c);
        add(loginButton, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
    }

    private static void createAndShowGUI(IController c) {
        //Create and set up the window.
        JFrame frame = new JFrame("View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        //Add contents to the window.
        frame.add(new LoginView(c));
        frame.setTitle("Fridge login");
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                IController c = new Controller(model);
                createAndShowGUI(c);
            }
        });
    }

    private void setLogin(String login) {
        inputLabel.setText(login);
    }

    @Override
    public void loginChanged() {
        setLogin(model.getLogin());
    }

    @Override
    public String checkdb() {
        return model.checkdb(userNameField);
    }

}
