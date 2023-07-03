package dao;

import model.produs;


public class produsDao extends abstractDao<produs> {

    public produsDao() {
        this.identifier = 2;
    }


    @Override
    protected String createInsertStatement(produs produs) {
        String sb = "INSERT INTO tp.produs  "+
                "VALUES ("+
                produs.getId() + ", '"  +
                produs.getNume() + "', "+
                produs.getPret() + ", " +
                produs.getCantitate() +
                ");";
        return sb;
    }


    @Override
    protected String createUpdateQuery(produs produs) {
        String sb = "UPDATE tp.produs SET nume='" + produs.getNume() + "', pret=" + produs.getPret()
                + ", cantitate=" + produs.getCantitate() + " WHERE id=" + produs.getId();
        return sb;
    }

}
