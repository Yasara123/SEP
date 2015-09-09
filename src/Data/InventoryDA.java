/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Nandula
 */
import Logic.Drug;
import Logic.supplier;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDA {

    private Connection databaseConnector = null;
    private dbconnection myConnector = new dbconnection();
    private ResultSet dataSet = null;
    private List<Drug> drugs = new ArrayList();
    private List<supplier> supps = new ArrayList();
    private Drug adrug;
    private String SQLQuery = null;
    private supplier asup;
    public static InventoryDA inv;
    
    private InventoryDA(){
        
    }
    
    public static InventoryDA getInstance(){
        if(inv==null){
            inv=new InventoryDA();
        }
        return inv;
    }

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
                adrug.setSellingPrice(dataSet.getInt("SellingPrice"));
                drugs.add(adrug);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return drugs;

    }

    public supplier getSuppDetails(int id) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();
            int suppid = 0;
            SQLQuery = "SELECT suppId FROM drug WHERE drugId = (?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            dataSet = preparedStatement.executeQuery();
            while (dataSet.next()) {
                suppid = dataSet.getInt("suppId");
                //System.out.println(suppid);
            }
            SQLQuery = "SELECT * FROM supplier WHERE suppId = (?)";
            PreparedStatement prepstmt = databaseConnector.prepareStatement(SQLQuery);
            prepstmt.setInt(1, suppid);
            dataSet = prepstmt.executeQuery();

            while (dataSet.next()) {
                asup = new supplier();
                asup.setId(dataSet.getInt("suppId"));
                asup.setName(dataSet.getString("Name"));
                asup.setTel(dataSet.getInt("Telephone"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return asup;
    }

    public void addMessage(int id, String message, String date) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "INSERT INTO message (suppId,message,date)" + "VALUES(?,?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, message);
            preparedStatement.setString(3, date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<supplier> getallDetails() throws SQLException {
        try {
            supps.clear();
            databaseConnector = myConnector.makeConnection();
            SQLQuery = "SELECT * FROM supplier";
            PreparedStatement prepstmt = databaseConnector.prepareStatement(SQLQuery);
            dataSet = prepstmt.executeQuery();

            while (dataSet.next()) {
                asup = new supplier();
                asup.setId(dataSet.getInt("suppId"));
                asup.setName(dataSet.getString("Name"));
                asup.setAddress(dataSet.getString("Address"));
                asup.setTel(dataSet.getInt("Telephone"));
                supps.add(asup);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return supps;
    }

    public void addDrugSupp(Drug drug, supplier asup) throws SQLException {
        int id = 0;
        try {
            databaseConnector = myConnector.makeConnection();
            //add supplier
            SQLQuery = "INSERT INTO supplier (Name,Address,Telephone)" + "VALUES(?,?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setString(1, asup.getName());
            preparedStatement.setString(2, asup.getAddress());
            preparedStatement.setInt(3, asup.getTel());
            preparedStatement.executeUpdate();
            //get suppid
            SQLQuery = "SELECT suppId FROM supplier WHERE Name = (?)";
            PreparedStatement prepstmt = databaseConnector.prepareStatement(SQLQuery);
            prepstmt.setString(1, asup.getName());
            dataSet = prepstmt.executeQuery();

            while (dataSet.next()) {
                id = dataSet.getInt("suppId");
            }
            //add drug
            SQLQuery = "INSERT INTO drug (Name,QuantityAvailable,UnitPrice,SellingPrice,MOQ,suppId)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = databaseConnector.prepareStatement(SQLQuery);
            statement.setString(1, drug.getName());
            statement.setInt(2, drug.getQuantity());
            statement.setInt(3, drug.getPrice());
            statement.setInt(4, drug.getSellingPrice());
            statement.setInt(5, drug.getMOQ());
            statement.setInt(6, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void addDrug(Drug drug, int id) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();
            SQLQuery = "INSERT INTO drug (Name,QuantityAvailable,UnitPrice,SellingPrice,MOQ,suppId)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = databaseConnector.prepareStatement(SQLQuery);
            statement.setString(1, drug.getName());
            statement.setInt(2, drug.getQuantity());
            statement.setInt(3, drug.getPrice());
            statement.setInt(4, drug.getSellingPrice());
            statement.setInt(5, drug.getMOQ());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addFinanceRecord(int cost, String date,String type) throws SQLException {
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

    public void updateDrug(Drug drug) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "UPDATE drug set QuantityAvailable = (?) WHERE drugId = (?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, drug.getQuantity());
            preparedStatement.setInt(2, drug.getDrugId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeDrug(int id) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "DELETE FROM drug WHERE drugId = (?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
