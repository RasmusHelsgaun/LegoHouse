/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.House;
import FunctionLayer.LegoHouseException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus
 */
public class Orderdetails extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        if (request.getParameter("command").equals("orderdetails")) {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            int height = Integer.parseInt(request.getParameter("height"));
            int width = Integer.parseInt(request.getParameter("width"));
            int length = Integer.parseInt(request.getParameter("length"));

            House house = LogicFacade.calculateBricks(width, length, height);
            request.setAttribute("house", house);
            request.setAttribute("orderID", orderID);
            
            return new Orderlist().execute(request, response);
        }
        else {
            int ordernumber = Integer.parseInt(request.getParameter("orderID"));
            List<Order> allOrders = LogicFacade.updateStatus(ordernumber);
            request.setAttribute("allOrders", allOrders);
            return "employeepage";
        }
    }

}
