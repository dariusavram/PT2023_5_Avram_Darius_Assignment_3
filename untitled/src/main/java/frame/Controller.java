package frame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private final StartView startView;
    private final ClientView clientView;
    private final ProductView productView;
    private final OrderView orderView;
    private final ClientBoxView clientBox;
    private final ProductBoxView productBox;

    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(startView.getClientButton())){
                startView.close();
                clientView.display();
            }else if(e.getSource().equals(startView.getProductsButton())){
                startView.close();
                productView.display();
            }else if(e.getSource().equals(startView.getOrderButton())){
                startView.close();
                orderView.display();
            }
        }
    }

    class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(clientView.getBackButton())) {
                clientView.close();
                startView.display();
            }else if(e.getSource().equals(productView.getBackButton())){
                productView.close();
                startView.display();

            }
        }
    }

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (clientView.getAddButton().equals(source)) {
                clientBox.display();
            } else if (clientView.getViewButton().equals(source)) {
                System.out.println("view A");
            } else if (productView.getAddButton().equals(source)) {
                productBox.display();
            }
        }
    }

    public Controller(StartView start, ProductView produs, OrderView order, ClientView client, ClientBoxView cBox, ProductBoxView pBox){
        startView = start;
        productView = produs;
        orderView = order;
        clientView = client;
        clientBox = cBox;
        productBox = pBox;
        startView.addActionListeners(new Listener());
        clientView.addActionListeners(new ButtonListener(), new BackListener());
        productView.addActionListeners(new ButtonListener(), new BackListener());
        orderView.addActionListeners(new ButtonListener());
        startView.display();
    }

    public ClientView getClientView() {
        return clientView;
    }

    public ProductView getProductView() {
        return productView;
    }

    public OrderView getOrderView() {
        return orderView;
    }

    public ClientBoxView getClientBox() {
        return clientBox;
    }

    public ProductBoxView getProductBox() {
        return productBox;
    }

    public void addActionListener(char c, ActionListener al1, ActionListener al2, ActionListener al3){
        if(c == 'c'){
            clientBox.addActionListener(al1, al2, al3);
        }else{
            productBox.addActionListener(al1, al2, al3);
        }
    }

    public void addViewListener(char c, ActionListener a){
        if(c == 'c'){
            clientView.addViewListener(a);
        }else{
            productView.addViewListener(a);
        }
    }

    public void addOrderListener(ActionListener al){
        orderView.addActionListeners(al);
    }

    public void printMessage(String message){
        JOptionPane.showMessageDialog(orderView,message);
    }
}
