/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rasmus
 */
public class Order {
    private final int ordernumber;
    private final int height;
    private final int length;
    private final int width;
    private String status;

    public Order(int ordernumber, int height, int length, int width, String status) {
        this.ordernumber = ordernumber;
        this.height = height;
        this.length = length;
        this.width = width;
        this.status = status;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
