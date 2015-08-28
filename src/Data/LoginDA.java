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
import Logic.Employee;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDA {

    private Connection databaseConnector = null;
    private dbconnection myConnector = new dbconnection();
    private ResultSet dataSet = null;
    String details[]=new String[2];
    String type;
    private String SQLQuery = null;

    public String[] getPassword(String username) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "SELECT * FROM users WHERE username =(?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setString(1, username);
            dataSet = preparedStatement.executeQuery();
            while (dataSet.next()) {
                details[0] = dataSet.getString("password");
                int id = dataSet.getInt("userID");
                details[1] = Integer.toString(id);
            }
            //System.out.println(str);

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "error");
        }
        return details;
    }

    public String getType(int id) throws SQLException {
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "SELECT Emptype FROM employee WHERE userID =(?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            dataSet = preparedStatement.executeQuery();
            while (dataSet.next()) {
                type = dataSet.getString("Emptype");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return type;
    }

    public int addUser(String username, String password) throws SQLException {
        int id = 0;
        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "INSERT INTO users (username,password)" + "VALUES(?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            SQLQuery = "SELECT userID FROM users WHERE username =(?)";
            PreparedStatement prestmt = databaseConnector.prepareStatement(SQLQuery);
            prestmt.setString(1, username);
            dataSet = prestmt.executeQuery();
            while (dataSet.next()) {
                id = dataSet.getInt("userID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return id;
    }

    public void addEmp(Employee emp, int id) throws SQLException {

        try {
            databaseConnector = myConnector.makeConnection();

            SQLQuery = "INSERT INTO employee (userID,Name,Age,Address,Salary,Emptype)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, emp.getName());
            preparedStatement.setInt(3, emp.getAge());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setInt(5, emp.getSalary());
            preparedStatement.setString(6, emp.getEmpType());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
