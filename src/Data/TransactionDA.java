/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Drug;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nandula
 */
public class TransactionDA {

    private Connection databaseConnector = null;
    private dbconnection myConnector = new dbconnection();
    private ResultSet dataSet = null;
    private List<Drug> drugs = new ArrayList();
    private Drug adrug;
    private String SQLQuery = null;

    public List<Drug> getDrugs() throws SQLException {

        try {
            drugs.clear();
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "SELECT * FROM drug";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            dataSet = preparedStatement.executeQuery();

            while (dataSet.next()) {
                adrug = new Drug();
                adrug.setDrugId(dataSet.getInt("drugId"));
                adrug.setName(dataSet.getString("Name"));
                adrug.setPrice(dataSet.getInt("UnitPrice"));
                adrug.setQuantity(dataSet.getInt("QuantityAvailable"));
                adrug.setMOQ(dataSet.getInt("MOQ"));
                drugs.add(adrug);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return drugs;

    }

    public void addTransaction(int empid, String record, String Date, int total) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();
            SQLQuery = "INSERT INTO orders (empID,OrderItems,TotalCost,Date)" + "VALUES(?,?,?,?)";
            PreparedStatement statement = databaseConnector.prepareStatement(SQLQuery);
            statement.setInt(1, empid);
            statement.setString(2, record);
            statement.setInt(3, total);
            statement.setString(4, Date);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addFinanceRecord(int cost, String date, String type) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();
            SQLQuery = "INSERT INTO finance (Type,Value,date)" + "VALUES(?,?,?)";
            PreparedStatement statement = databaseConnector.prepareStatement(SQLQuery);
            statement.setString(1, type);
            statement.setInt(2, cost);
            statement.setString(3, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateInventory(List<Drug> update) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();
            for (int i = 0; i < update.size(); i++) {
                SQLQuery = "UPDATE drug set QuantityAvailable = (?) WHERE drugId = (?)";
                PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
                preparedStatement.setInt(1, update.get(i).getQuantity());
                preparedStatement.setInt(2, update.get(i).getDrugId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
