package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    private static final String URL = "jdbc:mysql://138.68.68.38:3306/useradmin";
    private static final String USERNAME = "kirsten1";
    private static final String PASSWORD = "testserver";
//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTCF
//    private static final String URL = "jdbc:mysql://46.101.253.149:3306/useradmin";
//    private static final String USERNAME = "doorkeeper";
//    private static final String PASSWORD = "bank3*andyouarein";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
