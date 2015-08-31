/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.*;
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
public class FinanceDA {

    private Connection databaseConnector = null;
    private dbconnection myConnector = new dbconnection();
    private ResultSet dataSet = null;
    private List<Employee> emp = new ArrayList();
    private List<TransactionFinance> trans = new ArrayList();
    private TransactionFinance atrans;
    private Employee anemp;
    private String SQLQuery = null;

    public List<Employee> getDetails() throws SQLException {
        try {
            emp.clear();
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "SELECT * FROM employee";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            dataSet = preparedStatement.executeQuery();

            while (dataSet.next()) {
                anemp = new Employee();
                anemp.setEmpID(dataSet.getInt("empID"));
                anemp.setName(dataSet.getString("Name"));
                anemp.setSalary(dataSet.getInt("Salary"));
                anemp.setEmpType(dataSet.getString("Emptype"));
                emp.add(anemp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return emp;
    }

    public void removeEmployee(int id) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "DELETE FROM employee WHERE empID = (?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            SQLQuery = "DELETE FROM users WHERE userID = (?)";
            PreparedStatement statement = databaseConnector.prepareStatement(SQLQuery);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (Exception e) {
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
    
    public List<TransactionFinance> getRecords(String date) throws SQLException {
        try {
            trans.clear();
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "SELECT * FROM finance";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            dataSet = preparedStatement.executeQuery();
            String dte;
            String year;
            String[] list;
            while (dataSet.next()) {
                dte = dataSet.getString("date");
                list = dte.split("-");
                year = list[0];
                if(date.equals(year)){
                    atrans = new TransactionFinance();
                    atrans.setType(dataSet.getString("Type"));
                    atrans.setValue(dataSet.getInt("Value"));
                    atrans.setDate(dte);
                    trans.add(atrans);
                }
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return trans;
    }

}
