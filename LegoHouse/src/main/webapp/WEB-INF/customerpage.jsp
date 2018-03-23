<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.House"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Customer home page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <%if (request.getAttribute("personalOrders") == null) {%>
                <div class="col-md-6">
                    <% User user = (User) request.getSession().getAttribute("user");%>
                    <h1>Hello <%= (String) user.getEmail()%> </h1>
                    <div class="form-group">
                        <form name="calculate" action="FrontController" method="Post">
                            <input type="hidden" name="command" value="calculate">
                            Height:<br>
                            <input class="form-control" type="number" name="height" placeholder=">= 4">
                            <br>
                            Width:<br>
                            <input class="form-control" type="number" name="width" placeholder=">= 8">
                            <br>
                            Length:<br>
                            <input class="form-control" type="number" name="length" placeholder=">= 10">
                            <br>
                            <input class="btn btn-primary" type="submit" name="order" value="Calculate">
                        </form>
                    </div>
                    <% String error = (String) request.getAttribute("error");
                        if (error != null) {%>
                    <p><%= error%></p>
                    <% } %>
                    <div class="form-group">
                        <form name="orderlist" action="FrontController" method="Post">
                            <input type="hidden" name="command" value="orderlist">
                            <input class="btn btn-primary" type="submit" name="order" value="Show orders">
                        </form>
                    </div>
                    <%@include file="Include/logout.jsp" %>
                </div>
                <% }
                    if (request.getAttribute("size") != null) { %>
                <div class="col-md-6">
                    <h1>Measurements</h1>
                    <% House house = (House) request.getAttribute("size");%>

                    <table class="table table-striped">
                        <tr>
                            <th>2x4 Bricks</th>
                            <th>2x2 Bricks</th> 
                            <th>2x1 Bricks</th>
                        </tr>
                        <tr>
                            <td><%= house.getX4Quantity()%></td>
                            <td><%= house.getX2Quantity()%></td>
                            <td><%= house.getX1Quantity()%></td>
                        </tr>
                    </table>
                    <div class="form-group">
                        <form name="placeOrder" action="FrontController" method="Post">
                            <input type="hidden" name="command" value="placeOrder">
                            <input class="btn btn-primary" type="submit" name="order" value="Order">
                        </form>
                    </div>
                </div>
                <% }
                    if (request.getAttribute("ordernumber") != null) {%>
                <div class="col-md-6">
                    <h1>Order confirmed!</h1>
                    <p>Ordernumber: <%= (int) request.getAttribute("ordernumber")%></p>
                    <p>Your order has been confirmed, and will be sent as soon as possible.</p>
                </div>
                <%}
                    if (request.getAttribute("personalOrders") != null) {
                        List<Order> personalOrders = (List<Order>) request.getAttribute("personalOrders"); %>
                <div class="col-md-6">
                    <h1>Your orders</h1>
                    <%@include file="Include/logout.jsp" %>
                    <table class="table table-striped">
                        <tr>
                            <th>OrderID</th>
                            <th>Height</th>
                            <th>Length</th> 
                            <th>Width</th>
                            <th>Status</th>
                            <th>Order details</th>
                        </tr>
                        <% for (Order order : personalOrders) {%>
                        <tr>
                            <td><%= order.getOrdernumber()%></td>
                            <td><%= order.getHeight()%></td>
                            <td><%= order.getLength()%></td>
                            <td><%= order.getWidth()%></td>
                            <td><%= order.getStatus()%></td>
                            <td>
                                <div class="form-group">
                                    <form name="orderdetails" action="FrontController" method="Post">
                                        <input type="hidden" name="command" value="orderdetails">
                                        <input type="hidden" name="orderID" value="<%= order.getOrdernumber()%>">
                                        <input type="hidden" name="height" value="<%= order.getHeight()%>">
                                        <input type="hidden" name="width" value="<%= order.getWidth()%>">
                                        <input type="hidden" name="length" value="<%= order.getLength()%>">
                                        <input class="btn btn-primary" type="submit" name="order" value="Order details">
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <% }%>
                    </table>
                </div>
                <%}%>

                <% if (request.getAttribute("house") != null) {
                        House house = (House) request.getAttribute("house");
                        int orderID = (int) request.getAttribute("orderID");%>
                <div class="col-md-6">
                    <h1>Order Details</h1>
                    <p>Ordernumber: <%= orderID%></p>
                    <table class="table table-striped">
                        <tr>
                            <th>2x4 Bricks</th>
                            <th>2x2 Bricks</th> 
                            <th>2x1 Bricks</th>
                        </tr>
                        <tr>
                            <td><%= house.getX4Quantity()%></td>
                            <td><%= house.getX2Quantity()%></td>
                            <td><%= house.getX1Quantity()%></td>
                        </tr>
                    </table>
                </div>
                <% }%>
            </div>
        </div>
    </body>
</html>
