package com.example.flightapp.dao;

import com.example.flightapp.model.Flight;
import javaika.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightDAO {
    // Simulating a database table with a static list
    private static final List<Flight> flights = new ArrayList<>();

    static {
        // Adding some dummy data
        flights.add(new Flight("AI202", "Delhi", "Mumbai", "08:00 AM", 7500.00));
        flights.add(new Flight("6E555", "Delhi", "Mumbai", "09:30 AM", 7200.00));
        flights.add(new Flight("UK810", "Mumbai", "Delhi", "11:00 AM", 7800.00));
        flights.add(new Flight("AI505", "Bengaluru", "Delhi", "07:00 AM", 8500.00));
        flights.add(new Flight("SG805", "Delhi", "Bengaluru", "01:00 PM", 8200.00));
    }

    public List<Flight> findFlights(String origin, String destination) {
        // Java Stream API to filter flights
        return flights.stream()
                .filter(flight -> flight.getOrigin().equalsIgnoreCase(origin) && 
                                 flight.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }
}
