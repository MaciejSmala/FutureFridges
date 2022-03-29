package fridges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class DeliveryUI extends JFrame {
    JPanel sidePanel;
    JPanel centerPanel;
    JPanel endPanel;

    List<String> itemsInFridge;
    List<String> itemsToAdd;

    DefaultListModel<String> l1;
    DefaultListModel<String> l2;
    JList<String> listItems;
    JList<String> listItemsToAdd;

    DeliveryUI() {
        sidePanel = new JPanel();
        centerPanel = new JPanel();
        endPanel = new JPanel();
        itemsInFridge = new ArrayList<>();
        itemsToAdd = new ArrayList<>();
        l1 = new DefaultListModel<>();
        l2 = new DefaultListModel<>();
        listItems = new JList<>(l1);
        listItemsToAdd = new JList<>(l2);

        createUI();
    }

    void createUI() {
        setTitle("Delivery");
        JLabel sideTitle = new JLabel("items in Fridge");
        JLabel centerTitle = new JLabel("Items to add in Fridge");
        JLabel endTitle = new JLabel("Actions");

        // Side buttons
        JButton btnFront = new JButton("Open Front Door");
        JButton btnBack = new JButton("Open Back Door");

        JButton btnAdd = new JButton("Add item");
        JButton btnAddToFridge = new JButton("Add items to Fridge");

        JLabel labelToAdd = new JLabel("Item to add in Fridge");
        JTextField itemToAdd = new JTextField();
        itemToAdd.setBounds(100, 30, 100,20);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFront.setEnabled(!btnFront.isEnabled());
                btnAddToFridge.setEnabled(!btnAddToFridge.isEnabled());
                if(!btnFront.isEnabled()){
                    btnBack.setText("Close Back door");
                } else{
                    btnBack.setText("Open Back door");
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsToAdd.add(itemToAdd.getText());
                l2.addElement(itemToAdd.getText());
                listItemsToAdd.updateUI();
            }
        });

        btnAddToFridge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(String model: itemsToAdd){
                    l1.addElement(l2.getElementAt(itemsToAdd.indexOf(model)));
                }
                listItems.updateUI();
            }
        });


        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));

        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        endPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(sidePanel);
        add(centerPanel);
        add(endPanel);

        sidePanel.add(sideTitle);
        sidePanel.add(sideTitle);
        sidePanel.add(listItems);

        centerPanel.add(centerTitle);
        centerPanel.add(btnAddToFridge);
        centerPanel.add(listItemsToAdd);

        endPanel.add(endTitle);
        endPanel.add(btnFront);
        endPanel.add(btnBack);
        endPanel.add(labelToAdd);
        endPanel.add(itemToAdd);
        endPanel.add(btnAdd);

        setSize(720, 480);
        setLayout(new GridLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new DeliveryUI();
    }

}
