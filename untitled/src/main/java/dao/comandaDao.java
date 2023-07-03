package dao;

import connection.ConnectionFactory;
import model.comanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class comandaDao extends abstractDao<comanda>{
    public comandaDao() {
        this.identifier = 3;
    }
    @Override
    protected String createInsertStatement(comanda comanda) {
        String sb = "INSERT INTO tp.comanda "+
        " VALUES ("+
        comanda.getClientId() + ", " +
        comanda.getProdusId() + ", " +
        comanda.getPret()+ ", " +
        comanda.getCantitate() + ", " +
        comanda.getTotal() +
        ");";
        return sb;
    }

    @Override
    protected String createUpdateQuery(comanda comanda) {
        return null;
    }


    public static String[] getClientId(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT id FROM client";
        System.out.println(query);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return turnIntoList(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING , "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public static String[] getProdusId(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT id FROM produs";
        System.out.println(query);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return turnIntoList(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING , "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public static String[] turnIntoList(ResultSet rs) throws SQLException {
        int size = 0;
        ArrayList<String> out = new ArrayList<>();
        while(rs.next()){
            out.add(rs.getString(1));
            size++;
        }
        String[] arr = new String[size];
        return out.toArray(arr);
    }
}
