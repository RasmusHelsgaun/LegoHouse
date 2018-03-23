package PresentationLayer;

import FunctionLayer.LegoHouseException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new LoginLogout() );
        commands.put( "logout", new LoginLogout() );
        commands.put( "register", new Register() );
        commands.put( "calculate", new Calculate() );
        commands.put( "placeOrder", new PlaceOrder() );
        commands.put( "orderlist", new Orderlist() );
        commands.put( "orderdetails", new Orderdetails() );
        commands.put( "changestatus", new Orderdetails() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LegoHouseException;

}
