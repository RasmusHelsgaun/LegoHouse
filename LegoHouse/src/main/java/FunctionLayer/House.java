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
public class House {

    private int x4Quantity;
    private int x2Quantity;
    private int x1Quantity;

    public House(int x4Quantity, int x2Quantity, int x1Quantity) {
        this.x4Quantity = x4Quantity;
        this.x2Quantity = x2Quantity;
        this.x1Quantity = x1Quantity;
    }

    public int getX4Quantity() {
        return x4Quantity;
    }

    public int getX2Quantity() {
        return x2Quantity;
    }

    public int getX1Quantity() {
        return x1Quantity;
    }
}
