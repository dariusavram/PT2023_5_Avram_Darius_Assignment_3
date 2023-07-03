package dao;

import model.*;


public class clientDao extends abstractDao<client>{

    public clientDao() {
        this.identifier = 1;
    }


    protected String createInsertStatement(client client){
        String sb = "INSERT INTO tp.client " +
                " VALUES (" +
                client.getId() + ",'" +
                client.getNume() + "', '" +
                client.getAdresa() + "', '" +
                client.getEmail() + "', " +
                client.getVarsta() +
                ");";
        return sb;
    }


    @Override
    protected String createUpdateQuery(client client) {
        String sb = "UPDATE tp.client SET nume='" + client.getNume() + "', adresa='" + client.getAdresa()
                + "', email='" + client.getEmail() + "', varsta=" + client.getVarsta() + " WHERE id=" + client.getId();
        return sb;
    }

}
