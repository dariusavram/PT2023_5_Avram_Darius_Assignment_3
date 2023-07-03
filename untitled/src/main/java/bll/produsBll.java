package bll;

import dao.*;
import model.*;
import frame.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class produsBll {
    private produsDao produsDao;
    private Controller controller;

    public class AddProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = controller.getProductBox().getInput();
            produs produs = new produs(Integer.parseInt(inputs.get(0)),inputs.get(1), Double.parseDouble(inputs.get(2)), Integer.parseInt(inputs.get(3)));
            produsDao.insert(produs);
        }
    }
    public class UpdateProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = controller.getProductBox().getInput();
            produs produs = new produs(Integer.parseInt(inputs.get(0)),inputs.get(1), Double.parseDouble(inputs.get(2)), Integer.parseInt(inputs.get(3)));
            produsDao.update(produs);
        }
    }
    public class RemoveProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = controller.getProductBox().getInput();
            produsDao.remove(Integer.parseInt(inputs.get(0)));
        }
    }
    public class ViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AllView allView = new AllView(produsDao.getTable());
            } catch (IllegalAccessException | IntrospectionException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
        }
    }

    public produsBll(produsDao produsDao, Controller controller) {
        this.produsDao = produsDao;
        this.controller = controller;
        controller.addActionListener('p', new produsBll.AddProductListener(), new produsBll.UpdateProductListener(), new produsBll.RemoveProductListener());
        controller.addViewListener('p', new ViewListener());
    }
}
