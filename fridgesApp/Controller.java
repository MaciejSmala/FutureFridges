/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;

/**
 *
 * @author Rushabh
 */
public class Controller implements IController {

    private Model model;
    private LoginView view;

    public Controller(Model model) {
        this.setModel(model);
    }
    @Override
    public void addView(LoginView view){
        this.view = view;
    }

    @Override
    public Model getModel() {
        return model;
    }
    @Override
    public void setModel(Model model){
        this.model = model;
    }

    @Override
    public void loginButtonClicked() {
        String text = view.userNameField.getText();
                //model.setLogin(text);
                if (view.checkdb().equals("Chef")) {
                    View2.createAndShowGUI();
                }
                view.userNameField.setText("");
                view.inputLabel.setText(text);
    }
}
