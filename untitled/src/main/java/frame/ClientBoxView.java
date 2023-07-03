package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientBoxView extends JPanel {
    private JTextField idField;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel ageLabel;
    private JTextField ageField;
    private JLabel instrLabel;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JFrame frame = new JFrame ("Adauga/Update/Sterge client");

    public ClientBoxView() {

        idField = new JTextField (5);
        idLabel = new JLabel ("Id:");
        nameLabel = new JLabel ("Nume:");
        nameField = new JTextField (5);
        addressLabel = new JLabel ("Adresa:");
        addressField = new JTextField (5);
        emailLabel = new JLabel ("Email:");
        emailField = new JTextField (5);
        ageLabel = new JLabel ("Varsta:");
        ageField = new JTextField (5);
        instrLabel = new JLabel ("Pentru stergere, inserati doar id-ul");
        addButton = new JButton ("Adauga client");
        updateButton = new JButton("Update client");
        removeButton = new JButton("Sterge client");


        setPreferredSize (new Dimension (650, 235));
        setLayout (null);
        setBackground(Color.darkGray);


        add (idField);
        add (idLabel);
        add (nameLabel);
        add (nameField);
        add (addressLabel);
        add (addressField);
        add (emailLabel);
        add (emailField);
        add (ageLabel);
        add (ageField);
        add (instrLabel);
        add (addButton);
        add(updateButton);
        add(removeButton);

        idField.setBounds (140, 5, 125, 30);
        idLabel.setBounds (20, 5, 115, 30);
        idLabel.setForeground(Color.WHITE);
        nameLabel.setBounds (20, 40, 115, 30);
        nameLabel.setForeground(Color.WHITE);
        nameField.setBounds (140, 40, 200, 30);
        addressLabel.setBounds (20, 75, 115, 30);
        addressLabel.setForeground(Color.WHITE);
        addressField.setBounds (140, 75, 200, 30);
        emailLabel.setBounds (20, 110, 115, 30);
        emailLabel.setForeground(Color.WHITE);
        emailField.setBounds (140, 110, 200, 30);
        ageLabel.setBounds (20, 145, 115, 30);
        ageLabel.setForeground(Color.WHITE);
        ageField.setBounds (140, 145, 100, 30);
        instrLabel.setBounds (280, 5, 325, 30);
        instrLabel.setForeground(Color.WHITE);
        addButton.setBounds (250, 180, 185, 45);
        addButton.setBackground(Color.gray);
        addButton.setForeground(Color.black);
        updateButton.setBounds (60, 180, 185, 45);
        updateButton.setBackground(Color.gray);
        updateButton.setForeground(Color.black);
        removeButton.setBounds (440, 180, 185, 45);
        removeButton.setBackground(Color.gray);
        removeButton.setForeground(Color.black);
    }


    public void display(){
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add (this);
        frame.pack();
        frame.setVisible (true);
    }

    public void close(){
        frame.setVisible(false);
    }
    public ArrayList<String> getInput(){
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add(idField.getText());
        inputs.add(nameField.getText());
        inputs.add(addressField.getText());
        inputs.add(emailField.getText());
        inputs.add(ageField.getText());
        return inputs;
    }

    public void addActionListener(ActionListener al1, ActionListener al2, ActionListener al3){
        addButton.addActionListener(al1);
        updateButton.addActionListener(al2);
        removeButton.addActionListener(al3);
    }
}
