/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

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
public class Orderlist extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userID = (int) user.getId();
        List<Order> personalOrders = LogicFacade.personalOrders(userID);
        request.setAttribute("personalOrders", personalOrders);
        return "customerpage";
    }
    
}
