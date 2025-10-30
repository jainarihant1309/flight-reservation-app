<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flight Reservation</title>
</head>
<body>
    <h2>Search for Flights</h2>
    <form action="search" method="post">
        <label for="origin">Origin:</label><br>
        <input type="text" id="origin" name="origin" required><br><br>
        
        <label for="destination">Destination:</label><br>
        <input type="text" id="destination" name="destination" required><br><br>
        
        <input type="submit" value="Search Flights">
    </form>
</body>
</html>
