/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author smala
 */
class LoginModel {
    private String login;
    ArrayList<LoginObserver> observers;
    
    
    public void setLogin(String login) {
        this.login = login;
        for(LoginObserver o: observers){
            o.loginChanged();
        }
        
    }

    public String getLogin() {
        return login;
    }
    

    
    public LoginModel(){
        this.observers = new ArrayList<LoginObserver>();
    }
    
    
    public void addObserver(LoginObserver o){
        this.observers.add(o);
}
   

     public String checkdb(JTextField userNameField){
        String ID = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useSSL=false","root","12345");
            
            String username = userNameField.getText();
            
            Statement stm = con.createStatement();
            String sql = "select * from user where username='"+username+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()){
                //dispose();
                //LoggedInPage page = new LoggedInPage(); SHOW NEW VIEW
                //page.show();
                //View2.createAndShowGUI();
                //userNameField.setText("");
                ID= rs.getString("name");
                //System.out.println(ID);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
        return ID;
    }
}