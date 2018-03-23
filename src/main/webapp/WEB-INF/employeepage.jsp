<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Employee home page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <% User user = (User) request.getSession().getAttribute("user");%>
                    <h1>Hello <%= (String) user.getEmail()%> </h1>
                    <%@include file="Include/logout.jsp" %>
                    <% List<Order> allOrders = (List<Order>) request.getAttribute("allOrders"); %>
                    <table class="table table-striped">
                        <tr>
                            <th>OrderID</th>
                            <th>Height</th>
                            <th>Length</th> 
                            <th>Width</th>
                            <th>Status</th>
                            <th>Order details</th>
                        </tr>
                        <% for (Order order : allOrders) {%>
                        <tr>
                            <td><%= order.getOrdernumber()%></td>
                            <td><%= order.getHeight()%></td>
                            <td><%= order.getLength()%></td>
                            <td><%= order.getWidth()%></td>
                            <td><%= order.getStatus()%></td>
                            <% if (order.getStatus().equals("Pending")) {%>
                            <td>
                                <div class="form-group">
                                    <form name="changestatus" action="FrontController" method="Post">
                                        <input type="hidden" name="command" value="changestatus">
                                        <input type="hidden" name="orderID" value="<%= order.getOrdernumber()%>">
                                        <input class="btn btn-primary" type="submit" name="order" value="Send order">
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <%}
                            }%>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
