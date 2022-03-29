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
public interface LoginIController {

    void addView(LoginView view);

    LoginModel getModel();

    void setModel(LoginModel model);
    
    void loginButtonClicked();
    
}
