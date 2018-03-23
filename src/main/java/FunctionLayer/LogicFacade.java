package FunctionLayer;

import DBAccess.UserMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LegoHouseException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LegoHouseException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static House calculateBricks(int width, int length, int height) {
        Calculator cal = new Calculator();
        return cal.size(width, length, height);
    }

    public static int insertOrder(User user, int width, int length, int height) throws LegoHouseException {
        return UserMapper.insertOrder(user, width, length, height);
    }

    public static List<Order> personalOrders(int userID) throws LegoHouseException {
        return UserMapper.personalOrders(userID);
    }

    public static List<Order> allOrders() throws LegoHouseException {
        return UserMapper.allOrders();
    }

    public static List<Order> updateStatus(int ordernumber) throws LegoHouseException {
        return UserMapper.updateStatus(ordernumber);
    }
}
