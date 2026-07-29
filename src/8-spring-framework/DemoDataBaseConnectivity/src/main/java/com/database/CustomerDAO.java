package com.database;

import java.sql.*;

public class CustomerDAO {

    private String driver;
    private String url;
    private String username;
    private String password;

    // Setter methods for dependency injection
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // fetch customer records
    public void selectAllRows() throws ClassNotFoundException, SQLException {
        System.out.println("Retrieving customer data..");

        // driver is loading
        Class.forName(driver);

        // connection establishment is done here
        Connection con = DriverManager.getConnection(url, username, password);

        // Executing our query
        Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("SELECT * FROM CustomerDb.CustomerInfo");
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.user_account");

        while (rs.next()) {
            // int customerId = rs.getInt(1);
            // String customerName = rs.getString(2);
            // double customerFees = rs.getDouble(3);
            // String custAddress = rs.getString(4);
            String userId = rs.getString("user_id");
            String userName = rs.getString("username");
            String userPassword = rs.getString("password");

            // System.out.println(customerId + " " + customerName + " " + customerFees + " " + custAddress );
            System.out.println(userId + " " + userName + " " + userPassword + " " );
        }

        // Close connection
        con.close();
    }
}

