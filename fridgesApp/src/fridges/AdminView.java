package fridges;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

public class AdminView extends JPanel implements PropertyChangeListener {


    private JButton createButton;
    private JButton deleteButton;
    //private JButton reset;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JComboBox<String> roles;
    private String[] jobroles = {"Admin", "Chef", "DeliveryPerson", "Waiter"};
    private JTextField txtuser;

    private AdminModel model;

    public AdminView(AdminModel model) {
        super(new GridBagLayout());
        initView();

        this.model = model;
        model.addListener(this);
    }

    private void initView() {

        txtuser = new JTextField(40);
        jLabel1 = new JLabel("User ID", SwingConstants.CENTER);
        jLabel3 = new JLabel("User Type ", SwingConstants.CENTER);
        createButton = new JButton("Create User");
        deleteButton = new JButton("Delete User");
        roles = new JComboBox<String>(jobroles);
        txtuser.setFont(new Font("Courier", Font.BOLD, 40));
        jLabel1.setFont(new Font("Courier", Font.BOLD, 40));
        jLabel3.setFont(new Font("Courier", Font.BOLD, 40));
        roles.setFont(new Font("Courier", Font.BOLD, 40));
        createButton.setFont(new Font("Courier", Font.BOLD, 40));
        deleteButton.setFont(new Font("Courier", Font.BOLD, 40));
        
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setuser(txtuser, roles);
            }
        });

        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.removeuser(txtuser);
            }
        });

       // reset = new JButton("Reset");
       // reset.addActionListener(new ActionListener() {
         //   public void actionPerformed(ActionEvent e) {
         //       txtuser.setText("");

          //  }
       //});

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(jLabel1, c);
        add(txtuser, c);
        add(createButton, c);
        add(deleteButton, c);
        //add(reset, c);

        add(jLabel3, c);
        add(roles, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
    }

    private static void createAndShowGUI(AdminModel model) {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;

        // set the jframe height and width
        frame.setSize(new Dimension(width, height));
        //Display the window.
        frame.add(new AdminView(model));
        frame.pack();
        frame.setVisible(true);
    }

    public static void go(){
        AdminModel model = new AdminModel();
        createAndShowGUI(model);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
