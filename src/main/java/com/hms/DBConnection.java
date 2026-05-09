package com.hms;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "radh@0701";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to database.");

        }
        catch (Exception e){
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
        return conn;
    }
}
