/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;
/**
 *
 * @author princenhodges
 */
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class AdminModel implements AdminObserver {

    private PropertyChangeSupport listenerManager = new PropertyChangeSupport(this);

    public AdminModel() {
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        listenerManager.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        listenerManager.removePropertyChangeListener(listener);
    }

    public String setuser(JTextField codeuser, JComboBox role) {
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String pass = "12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection conn = DriverManager.getConnection(url, user, pass)) {
                String sql = "INSERT INTO `user` (`username`, `name`) VALUES ( ?, ?);";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, codeuser.getText());
                pst.setString(2, role.getSelectedItem().toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Created");
                conn.close();
            }

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public String removeuser(JTextField codeuser) {
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String pass = "12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection conn = DriverManager.getConnection(url, user, pass)) {
                String sql = "DELETE FROM `user` WHERE username= ? ;";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, codeuser.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delted Created");
                conn.close();
            }

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
