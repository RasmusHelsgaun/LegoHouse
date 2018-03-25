package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of Connector is to...
 *
 * @author kasper
 */
public class Connector {

    private static final String URL = "jdbc:mysql://138.68.68.38:3306/legohouse";
//    private static final String IP = "138.68.68.38";
//    private static final String PORT = "3306";
//    private static final String DATABASE = "legohouse";
    private static final String USERNAME = "kirsten1";
    private static final String PASSWORD = "testserver";
//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTCF
//    private static final String URL = "jdbc:mysql://46.101.253.149:3306/useradmin";
//    private static final String USERNAME = "doorkeeper";
//    private static final String PASSWORD = "bank3*andyouarein";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        if (singleton == null) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?useUnicode=true&amp;characterEncoding=utf8";
//            conn = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
//        }
//        catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
//            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return conn;
//    }
}
