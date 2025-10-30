package com.example.flightapp.model;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private double price;

    public Flight(String flightNumber, String origin, String destination, String departureTime, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
    }

    // Getters
    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public double getPrice() { return price; }
}
