package com.example.flightapp.dao;

import com.example.flightapp.model.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    // --- Aapki Details Yahan Update Kar Di Gayi Hain ---
    private static final String DB_ENDPOINT = "flight-app-db.cs5qmk20oxmv.us-east-1.rds.amazonaws.com";
    private static final String DB_NAME = "flightdb";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "Arihant!123";
    // ----------------------------------------------------

    private String getConnectionString() {
        return "jdbc:mysql://" + DB_ENDPOINT + ":3306/" + DB_NAME;
    }

    public FlightDAO() {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Flight> findFlights(String origin, String destination) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights WHERE origin = ? AND destination = ?";

        try (Connection conn = DriverManager.getConnection(getConnectionString(), DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, origin);
            pstmt.setString(2, destination);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String flightNumber = rs.getString("flight_number");
                    String flightOrigin = rs.getString("origin");
                    String flightDestination = rs.getString("destination");
                    String departureTime = rs.getString("departure_time");
                    double price = rs.getDouble("price");
                    flights.add(new Flight(flightNumber, flightOrigin, flightDestination, departureTime, price));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
