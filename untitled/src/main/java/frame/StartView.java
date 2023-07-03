package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartView extends JPanel {
    private JButton clientButton;
    private JButton productsButton;
    private JButton orderButton;
    private JFrame frame = new JFrame();


    public StartView() {

        clientButton = new JButton ("Clienti");
        productsButton = new JButton ("Produse");
        orderButton = new JButton ("Creaza comanda");

        setPreferredSize (new Dimension (296, 210));
        setLayout (null);
        setBackground(Color.darkGray);

        add (clientButton);
        add (productsButton);
        add (orderButton);

        clientButton.setBounds (45, 20, 215, 45);
        clientButton.setBackground(Color.gray);
        clientButton.setForeground(Color.black);
        productsButton.setBounds (45, 80, 215, 45);
        productsButton.setBackground(Color.gray);
        productsButton.setForeground(Color.black);
        orderButton.setBounds (45, 140, 215, 45);
        orderButton.setBackground(Color.gray);
        orderButton.setForeground(Color.black);
    }


    public void display(){
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (this);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Aplicație depozit");
        frame.pack();
        frame.setVisible (true);
    }

    public void addActionListeners(ActionListener actionListener){
        clientButton.addActionListener(actionListener);
        productsButton.addActionListener(actionListener);
        orderButton.addActionListener(actionListener);
    }

    public void close(){
        frame.setVisible(false);
    }

    public JButton getClientButton() {
        return clientButton;
    }

    public JButton getProductsButton() {
        return productsButton;
    }

    public JButton getOrderButton() {
        return orderButton;
    }
}
