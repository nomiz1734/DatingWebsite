/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DP;user=sa;password=123123;encrypt=true;trustServerCertificate=true";
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        conn = DriverManager.getConnection(connectionUrl);
        return conn;
    }

    private final String serverName = "localhost";
    private final String portNumber = "1433";
    private final String user = "sa";
    private final String password = "123456";
    private final String dbName = "DP";

    public static void main(String[] args) {
        DBContext db = new DBContext();
        try {
            Connection conn = db.getConnection();
            if (conn != null) {
                System.out.println("Connect successfully!");
            } else {
                System.out.println("Connect fail!");
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
