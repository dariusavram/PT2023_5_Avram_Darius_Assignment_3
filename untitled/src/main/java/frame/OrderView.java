package frame;

import dao.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class OrderView extends JPanel {
    private JComboBox<String> prodField;
    private JLabel instrLabel;
    private JComboBox<String> clientField;
    private JTextField quantField;
    private JLabel clientLabel;
    private JLabel quantLabel;
    private JLabel prodLabel;
    private JButton orderButton;

    private JFrame frame = new JFrame ("Comanda");

    public OrderView() {

        prodField = new JComboBox<>(comandaDao.getProdusId());
        instrLabel = new JLabel ("Creaza comanda");
        clientField = new JComboBox<>(comandaDao.getClientId());
        quantField = new JTextField (5);
        clientLabel = new JLabel ("Id client:");
        quantLabel = new JLabel ("Cantitate:");
        prodLabel = new JLabel ("Id produs:");
        orderButton = new JButton ("Plaseaza comanda");


        setPreferredSize (new Dimension (410, 245));
        setLayout (null);
        setBackground(Color.darkGray);

        add (prodField);
        add (instrLabel);
        add (clientField);
        add (quantField);
        add (clientLabel);
        add (quantLabel);
        add (prodLabel);
        add (orderButton);


        prodField.setBounds (195, 60, 185, 25);
        instrLabel.setBounds (5, 20, 295, 25);
        instrLabel.setForeground(Color.white);
        clientField.setBounds (195, 100, 185, 25);
        quantField.setBounds (195, 140, 185, 25);
        clientLabel.setBounds (5, 100, 170, 25);
        clientLabel.setForeground(Color.white);
        quantLabel.setBounds (5, 140, 170, 25);
        quantLabel.setForeground(Color.white);
        prodLabel.setBounds (5, 60, 175, 25);
        prodLabel.setForeground(Color.white);
        orderButton.setBounds (30, 185, 150, 45);
        orderButton.setBackground(Color.gray);
        orderButton.setForeground(Color.black);

    }
    public void display(){
        frame.setBackground(Color.darkGray);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (this);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible (true);
    }
    public ArrayList<String> getInput(){
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add(prodField.getSelectedItem().toString());
        inputs.add(clientField.getSelectedItem().toString());
        inputs.add(quantField.getText());
        return inputs;
    }
        public void addActionListeners(ActionListener actionlistener){
        orderButton.addActionListener(actionlistener);

    }


    public void close(){
        frame.setVisible(false);
    }
}

