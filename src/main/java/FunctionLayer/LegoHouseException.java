package FunctionLayer;

/**
 * The purpose of LoginSampleException is to...
 * @author kasper
 */
public class LegoHouseException extends Exception {
    private String page;

    public LegoHouseException(String msg, String page) {
        super(msg);
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
