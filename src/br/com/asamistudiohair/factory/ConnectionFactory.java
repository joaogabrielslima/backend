package br.com.asamistudiohair.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "DB1*fhjnr";
    private static final String DB_PATH = "jdbc:mysql://localhost:3306/AsamiStudioHair";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_PATH, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = createConnection();

        if (conn != null){
            System.out.println("Connected Succesfully!");
            conn.close();
        }
    }
}
