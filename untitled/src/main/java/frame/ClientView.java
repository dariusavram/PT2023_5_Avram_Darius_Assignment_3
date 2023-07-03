package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientView extends JPanel {
    private JButton addButton;
    private JButton viewButton;
    private JButton backButton;
    private JFrame frame = new JFrame ("Clienti");

    public ClientView() {

        addButton = new JButton ("Adauga/Update/Sterge client");
        viewButton = new JButton ("Vezi clientii");
        backButton = new JButton("Back");

        setPreferredSize (new Dimension (327, 360));
        setLayout (null);
        setBackground(Color.darkGray);

        add (addButton);
        add (viewButton);
        add (backButton);

        addButton.setBounds (60, 20, 215, 90);
        addButton.setBackground(Color.gray);
        addButton.setForeground(Color.black);
        viewButton.setBounds (60, 130, 215, 90);
        viewButton.setBackground(Color.gray);
        viewButton.setForeground(Color.black);
        backButton.setBounds(60, 270, 215, 45);
        backButton.setBackground(Color.gray);
        backButton.setForeground(Color.black);
    }


    public void display(){
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (this);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible (true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void addActionListeners(ActionListener actionListener, ActionListener backListener){
        addButton.addActionListener(actionListener);
        backButton.addActionListener(backListener);
    }

    public void close(){
        frame.setVisible(false);
    }

    public void addViewListener(ActionListener a){

        viewButton.addActionListener(a);
    }
}
