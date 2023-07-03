package bll;

import dao.clientDao;
import model.client;
import frame.AllView;
import frame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class clientBll {

    private dao.clientDao cl_dao;
    private Controller controller;

    public class AddClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = controller.getClientBox().getInput();
            client client = new client(Integer.parseInt(inputs.get(0)),inputs.get(1),inputs.get(2),inputs.get(3),Integer.parseInt(inputs.get(4)));
            cl_dao.insert(client);
        }
    }
    public class UpdateClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = controller.getClientBox().getInput();
            client client = new client(Integer.parseInt(inputs.get(0)),inputs.get(1),inputs.get(2),inputs.get(3),Integer.parseInt(inputs.get(4)));
            cl_dao.update(client);
        }
    }
    public class RemoveClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = controller.getClientBox().getInput();
            cl_dao.remove(Integer.parseInt(inputs.get(0)));
        }
    }

    public class ViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AllView allView = new AllView(cl_dao.getTable());
            } catch (IllegalAccessException | IntrospectionException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
        }
    }

    public clientBll(clientDao clDao, Controller controller) {
        this.cl_dao = clDao;
        this.controller = controller;
        controller.addActionListener('c', new AddClientListener(), new UpdateClientListener(), new RemoveClientListener());
        controller.addViewListener('c', new ViewListener());
    }

}
