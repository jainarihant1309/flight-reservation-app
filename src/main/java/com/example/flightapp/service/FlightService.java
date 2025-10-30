package com.example.flightapp.service;

import com.example.flightapp.dao.FlightDAO;
import com.example.flightapp.model.Flight;
import java.util.List;

public class FlightService {
    private FlightDAO flightDAO = new FlightDAO();

    public List<Flight> searchFlights(String origin, String destination) {
        // In a real app, you might have more business logic here.
        // For now, we just call the DAO.
        return flightDAO.findFlights(origin, destination);
    }
}
