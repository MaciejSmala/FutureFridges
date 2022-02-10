/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;

/**
 *
 * @author smala
 */
public interface IController {

    void addView(LoginView view);

    Model getModel();

    void setModel(Model model);
    
    void loginButtonClicked();
    
}
