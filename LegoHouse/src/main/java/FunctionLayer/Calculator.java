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
public class Calculator {

    private final int brick4 = 4;
    private final int brick2 = 2;
    private final int brick1 = 1;
    private final int brickDepth = 2;
    private int x4Quantity = 0;
    private int x2Quantity = 0;
    private int x1Quantity = 0;
    private int surfaceArea;
    private boolean connectedRow = false;

    public House size(int width, int length, int height) {

        int row = length;

        //Sides without anything is calculated until, i == height, where it changes to Sides with door / window.
        for (int i = 1; i <= (height * 2); i++) {
            if (connectedRow) {
                surfaceArea = (row - (brickDepth * 2));
                connectedRow = false;
            }
            else {
                surfaceArea = row;
                connectedRow = true;
            }
            x4Quantity += (surfaceArea / brick4) * 2;
            surfaceArea = surfaceArea % brick4;
            x2Quantity += (surfaceArea / brick2) * 2;
            surfaceArea = surfaceArea % brick2;
            x1Quantity += (surfaceArea / brick1) * 2;

            if (i == height) {
                row = width;
                connectedRow = true;
            }
        }

        /*As we need a door and a window, we have to remove some bricks.
        If the lengthSides only consists of 2x4-bricks, we have to remove four 2x4-bricks and add four 2x2-bricks.
        Else we have to remove one 2x4- and two 2x2-bricks.
         */
        if (length % brick4 == 0) {
            x4Quantity -= 4;
            x2Quantity += 4;
        }
        else {
            x4Quantity -= 1;
            x2Quantity -= 2;
        }
        return new House(x4Quantity, x2Quantity, x1Quantity);
    }
}
