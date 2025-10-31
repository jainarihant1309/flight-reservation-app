package com.example.flightapp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/setup-db") // Is URL se hum ise call karenge
public class DBSetupServlet extends HttpServlet {
    // -- Aapki Details Yahan Update Kar Di Gayi Hain --
    private static final String DB_ENDPOINT = "flight-app-db.cs5qmk20oxmv.us-east-1.rds.amazonaws.com";
    private static final String DB_NAME = "flightdb";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "Arihant!12_";
    // --------------------------------------------------

    private String getConnectionString() {
        return "jdbc:mysql://" + DB_ENDPOINT + ":3306/" + DB_NAME;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(out);
            return;
        }

        String createTableSQL = "CREATE TABLE IF NOT EXISTS flights (" +
                                "id INT AUTO_INCREMENT PRIMARY KEY," +
                                "flight_number VARCHAR(10) NOT NULL," +
                                "origin VARCHAR(50) NOT NULL," +
                                "destination VARCHAR(50) NOT NULL," +
                                "departure_time VARCHAR(20)," +
                                "price DECIMAL(10, 2)" +
                                ");";
        
        String insertDataSQL = "INSERT INTO flights (flight_number, origin, destination, departure_time, price) VALUES " +
                               "('AI202', 'Delhi', 'Mumbai', '08:00 AM', 7500.00)," +
                               "('6E555', 'Delhi', 'Mumbai', '09:30 AM', 7200.00)," +
                               "('UK810', 'Mumbai', 'Delhi', '11:00 AM', 7800.00)," +
                               "('AI505', 'Bengaluru', 'Delhi', '07:00 AM', 8500.00)," +
                               "('SG805', 'Delhi', 'Bengaluru', '01:00 PM', 8200.00);";

        try (Connection conn = DriverManager.getConnection(getConnectionString(), DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("DROP TABLE IF EXISTS flights;");
            out.println("Executing CREATE TABLE...");
            stmt.execute(createTableSQL);
            out.println("Table 'flights' created successfully.");

            out.println("Executing INSERT DATA...");
            stmt.execute(insertDataSQL);
            out.println("Dummy data inserted successfully.");
            
            out.println("\nDATABASE SETUP COMPLETE!");

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
