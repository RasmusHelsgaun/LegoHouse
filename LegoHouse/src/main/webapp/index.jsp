<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Welcome page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1>LEGO-Housing</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h3>Login</h3>
                    <div class="form-group">
                        <form name="login" action="FrontController" method="POST">
                            <input class="form-control" type="hidden" name="command" value="login">
                            Email:<br>
                            <input class="form-control" type="text" name="email" placeholder="Username">
                            <br>
                            Password:<br>
                            <input class="form-control" type="password" name="password">
                            <br>
                            <input class="btn btn-primary" type="submit" value="Login">
                        </form>
                    </div>
                    <% String error = (String) request.getAttribute("error");
                        if (error != null) {%>
                    <H2>Error!</h2>
                    <p><%= error%>
                        <% }
                        %>
                </div>
                <div class="col-md-6">
                    <h3>Register</h3>
                    <div class="form-group">
                        <form name="register" action="FrontController" method="POST">
                            <input class="form-control" type="hidden" name="command" value="register">
                            Email:<br>
                            <input class="form-control" type="text" name="email" placeholder="someone@nowhere.com">
                            <br>
                            Password:<br>
                            <input class="form-control" type="password" name="password1">
                            <br>
                            Retype Password:<br>
                            <input class="form-control" type="password" name="password2">
                            <br>
                            <input class="btn btn-primary" type="submit" value="Register">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
