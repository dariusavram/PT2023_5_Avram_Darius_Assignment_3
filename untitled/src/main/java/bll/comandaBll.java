package bll;

import java.io.PrintStream;
import dao.*;
import model.*;
import frame.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class comandaBll {
    private comandaDao comandaDao;
    private clientDao clientDao;
    private produsDao produsDao;
    private Controller control;


    public class CreateComandaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> inputs = control.getOrderView().getInput();
            produs produs = produsDao.findById(Integer.parseInt(inputs.get(0)));
            client client = clientDao.findById(Integer.parseInt(inputs.get(1)));

            if(produs.getCantitate() < Integer.parseInt(inputs.get(2))){
                control.printMessage("Cantitate insuficientă");
                return;
            }

            produs.setCantitate(produs.getCantitate() - Integer.parseInt(inputs.get(2)));
            produsDao.update(produs);
            DecimalFormat df = new DecimalFormat("0.00");

            comanda comanda = new comanda();
            comanda.setCantitate(Integer.parseInt(inputs.get(2)));
            comanda.setClientId(client.getId());
            comanda.setProdusId(produs.getId());
            comanda.setPret(produs.getPret());
            double total = produs.getPret() * comanda.getCantitate();
            String totalStr = df.format(total);
            comanda.setTotal(Double.parseDouble(totalStr));
            comandaDao.insert(comanda);

            try {
                createBill(comanda, client, produs);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public comandaBll(comandaDao comandaDAO, clientDao clientDAO, produsDao ProdusDAO, Controller control) {
        this.comandaDao = comandaDAO;
        this.clientDao = clientDAO;
        this.produsDao = ProdusDAO;
        this.control = control;
        control.addOrderListener(new CreateComandaListener());

    }


    public void createBill(comanda comanda,client client, produs produs) throws IOException {
        Random rand = new Random();
        int billId = rand.nextInt();
        String name = "bill" + billId + ".txt";
        File file = new File(name);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        writer.write(df.format(now) + "\n");
        writer.write("Nume client: "+ client.getNume() + "\n");
        writer.write("Produs: " + produs.getNume() + "\n");
        writer.write("Cantitate: " + comanda.getCantitate() + "\n");
        writer.write("Pret per bucată: " + produs.getPret() + "\n");
        writer.write("Total: " + comanda.getTotal());
        writer.flush();
        writer.close();
    }

}
