package DBAccess;

import FunctionLayer.LegoHouseException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new LegoHouseException(ex.getMessage(), "index");
        }
    }

    public static User login(String email, String password) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            }
            else {
                throw new LegoHouseException("Could not validate user", "index");
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage(), "index");
        }
    }

    public static int insertOrder(User user, int width, int length, int height) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, height, width, length) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setInt(2, height);
            ps.setInt(3, width);
            ps.setInt(4, length);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            return ids.getInt(1);
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new LegoHouseException(ex.getMessage(), "customerpage");
        }
    }

    public static List<Order> personalOrders(int userID) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE userID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                List<Order> personalOrders = new ArrayList();
                do {
                    int ordernumber = rs.getInt(1);
                    int height = rs.getInt(3);
                    int width = rs.getInt(4);
                    int length = rs.getInt(5);
                    String status = rs.getString(6);
                    Order order = new Order(ordernumber, height, length, width, status);
                    personalOrders.add(order);
                }
                while (rs.next());
                return personalOrders;
            }
            else {
                throw new LegoHouseException("You dont have any orders", "customerpage");
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage(), "index");
        }
    }

    public static List<Order> allOrders() throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                List<Order> allOrders = new ArrayList();
                do {
                    int ordernumber = rs.getInt(1);
                    int height = rs.getInt(3);
                    int width = rs.getInt(4);
                    int length = rs.getInt(5);
                    String status = rs.getString(6);
                    Order order = new Order(ordernumber, height, length, width, status);
                    allOrders.add(order);
                }
                while (rs.next());
                return allOrders;
            }
            else {
                throw new LegoHouseException("No orders has been placed in the shop", "employeepage");
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage(), "index");
        }
    }

    public static List<Order> updateStatus(int ordernumber) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "update orders set status=? where ordernumber=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "Sent");
            ps.setInt(2, ordernumber);
            ps.executeUpdate();
            SQL = "SELECT * FROM orders;";
            ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
                List<Order> allOrders = new ArrayList();
                while(rs.next()) {
                    ordernumber = rs.getInt(1);
                    int height = rs.getInt(3);
                    int width = rs.getInt(4);
                    int length = rs.getInt(5);
                    String status = rs.getString(6);
                    Order order = new Order(ordernumber, height, length, width, status);
                    allOrders.add(order);
                }
                return allOrders;
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage(), "index");
        }
    }
}
