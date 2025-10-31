package com.example.flightapp.controller;

import com.example.flightapp.model.Flight;
import com.example.flightapp.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FlightSearchServlet extends HttpServlet {
    private FlightService flightService = new FlightService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");

        List<Flight> foundFlights = flightService.searchFlights(origin, destination);

        request.setAttribute("flights", foundFlights);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
