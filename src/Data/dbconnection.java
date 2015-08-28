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
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class dbconnection {

    private Connection connect;

    public Connection makeConnection() throws SQLException {
        if (connect == null) {
            try {
                new Driver();
                connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
