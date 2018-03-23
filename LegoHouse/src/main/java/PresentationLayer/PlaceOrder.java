/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoHouseException;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus
 */
public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        try {
            HttpSession session = request.getSession();
            int width = (int) session.getAttribute("width");
            int length = (int) session.getAttribute("length");
            int height = (int) session.getAttribute("height");
            User user = (User) session.getAttribute("user");

            int ordernumber = LogicFacade.insertOrder(user, width, length, height);
            request.setAttribute("ordernumber", ordernumber);

            session.removeAttribute("width");
            session.removeAttribute("length");
            session.removeAttribute("height");
            return "customerpage";
        }
        catch (NullPointerException e) {
            throw new LegoHouseException("Go to \"Show Orders\", to preview your orderconfirmation", "customerpage");
        }
    }
}
