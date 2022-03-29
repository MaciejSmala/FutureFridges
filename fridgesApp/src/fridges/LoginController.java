/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;

import javax.swing.JOptionPane;

/**
 *
 * @author smala
 */
public class LoginController implements LoginIController {

    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model) {
        this.setModel(model);
    }

    @Override
    public void addView(LoginView view) {
        this.view = view;
    }

    @Override
    public LoginModel getModel() {
        return model;
    }

    @Override
    public void setModel(LoginModel model) {
        this.model = model;
    }

    @Override
    public void loginButtonClicked() {
        String text = view.userNameField.getText();
        //model.setLogin(text);
        if (view.checkdb().equals("Chef")) {
            //View2.createAndShowGUI();
        } else if (view.checkdb().equals("Admin")) {
            AdminView.go();
        } else if (view.checkdb().equals("DeliveryPerson")) {
            //ViewDelivery.start();
        } else if (view.checkdb().equals("Waiter")) {
            JOptionPane.showMessageDialog(null, "Waiters do not have access to the fridge");
        } else {
            JOptionPane.showMessageDialog(null, "incoorrect ID");
        }
        view.userNameField.setText("");
        view.setLogin(text);
        //view.inputLabel.setText(text);
    }

}
