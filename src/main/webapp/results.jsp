<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <h2>Available Flights</h2>
    <c:choose>
        <c:when test="${not empty flights}">
            <table border="1">
                <tr>
                    <th>Flight Number</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Departure Time</th>
                    <th>Price</th>
                </tr>
                <c:forEach var="flight" items="${flights}">
                    <tr>
                        <td>${flight.flightNumber}</td>
                        <td>${flight.origin}</td>
                        <td>${flight.destination}</td>
                        <td>${flight.departureTime}</td>
                        <td>$${flight.price}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>No flights found for your search criteria.</p>
        </c:otherwise>
    </c:choose>
    <br>
    <a href="index.jsp">Search Again</a>
</body>
</html>
