/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.House;
import FunctionLayer.LegoHouseException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus
 */
public class Calculate extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        String _width = request.getParameter("width");
        String _length = request.getParameter("width");
        String _height = request.getParameter("height");
        if (_width.isEmpty() || _length.isEmpty() || _height.isEmpty()) {
            throw new LegoHouseException("Invalid input.", "customerpage");
        }

        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter("height"));
        if (width < 8 || width > 100 || length < 10 || length > 100 || height < 4 || height > 100) {
            throw new LegoHouseException("Invalid input.", "customerpage");
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("width", width);
            session.setAttribute("length", length);
            session.setAttribute("height", height);
            House house = LogicFacade.calculateBricks(width, length, height);
            request.setAttribute("size", house);
        }
        return "customerpage";
    }

}
