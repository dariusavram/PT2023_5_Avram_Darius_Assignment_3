package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * <p>ProductBoxView is used to get the information for the products that are to be added, removed or updated.</p>
 */
public class ProductBoxView extends JPanel {
    private JButton button;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JLabel instrLabel;
    private JButton updateButton;
    private JButton removeButton;

    public ProductBoxView() {

        idField = new JTextField (5);
        idLabel = new JLabel ("Id produs:");
        nameLabel = new JLabel ("Nume produs:");
        nameField = new JTextField (5);
        quantityLabel = new JLabel ("Cantitate:");
        quantityField = new JTextField (5);
        priceLabel = new JLabel ("Pret:");
        priceField = new JTextField (5);
        instrLabel = new JLabel ("Pune doar id-ul pentru stergere");
        button = new JButton ("Adauga produs");
        updateButton = new JButton("Actualizeaza produs");
        removeButton = new JButton("Sterge produs");


        setPreferredSize (new Dimension (650, 215));
        setLayout (null);
        setBackground(Color.darkGray);


        add (idField);
        add (idLabel);
        add (nameLabel);
        add (nameField);
        add (quantityField);
        add (quantityLabel);
        add (priceField);
        add (priceLabel);
        add (instrLabel);
        add (button);
        add(updateButton);
        add(removeButton);

       idField.setBounds (140, 5, 125, 30);
        idLabel.setBounds (20, 5, 115, 30);
        idLabel.setForeground(Color.WHITE);
        nameLabel.setBounds (20, 40, 115, 30);
        nameLabel.setForeground(Color.WHITE);
        nameField.setBounds (140, 40, 200, 30);
        quantityLabel.setBounds (20, 75, 115, 30);
        quantityLabel.setForeground(Color.WHITE);
        quantityField.setBounds (140, 75, 200, 30);
        priceLabel.setBounds (20, 110, 115, 30);
        priceLabel.setForeground(Color.WHITE);
        priceField.setBounds (140, 110, 100, 30);
        instrLabel.setBounds (280, 5, 340, 30);
        instrLabel.setForeground(Color.WHITE);
        button.setBounds (250, 160, 185, 45);
        button.setBackground(Color.gray);
        button.setForeground(Color.black);
        updateButton.setBounds (60, 160, 185, 45);
        updateButton.setBackground(Color.gray);
        updateButton.setForeground(Color.black);
        removeButton.setBounds (440, 160, 185, 45);
        removeButton.setBackground(Color.gray);
        removeButton.setForeground(Color.black);
    }

    public void display(){
        JFrame frame = new JFrame ("Adauga/Update/Sterge produs");
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add (this);
        frame.pack();
        frame.setVisible (true);
    }
    public ArrayList<String> getInput(){
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add(idField.getText());
        inputs.add(nameField.getText());
        inputs.add(priceField.getText());
        inputs.add(quantityField.getText());
        return inputs;
    }
    public void addActionListener(ActionListener al1, ActionListener al2, ActionListener al3){
        button.addActionListener(al1);
        updateButton.addActionListener(al2);
        removeButton.addActionListener(al3);
    }
}
