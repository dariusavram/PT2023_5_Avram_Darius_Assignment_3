package frame;

import javax.swing.*;
import java.awt.*;

public class AllView extends JFrame {

    private JTable table;

    public AllView(JTable table){
        this.table = table;
        add(new JScrollPane(table));
        setBackground(Color.darkGray);
        setLocation(0,0);
        setSize(1650,1080);
        setVisible(true);
    }
}
