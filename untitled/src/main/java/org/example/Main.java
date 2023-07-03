package org.example;

import bll.clientBll;
import bll.comandaBll;
import bll.produsBll;
import dao.clientDao;
import dao.comandaDao;
import dao.produsDao;
import frame.*;

public class Main {
    public static void main(String[] args){
        StartView start = new StartView();
        ClientView client = new ClientView();
        OrderView order = new OrderView();
        ProductView produs = new ProductView();
        ClientBoxView cBox = new ClientBoxView();
        ProductBoxView pBox = new ProductBoxView();
        Controller control = new Controller(start, produs, order, client, cBox, pBox);
        clientDao clientDao = new clientDao();
        produsDao produsDao = new produsDao();
        comandaDao comandaDao = new comandaDao();
        clientBll clbll = new clientBll(clientDao, control);
        produsBll prbll = new produsBll(produsDao, control);
        comandaBll cobll = new comandaBll(comandaDao, clientDao, produsDao, control);
    }
}
