package com.aritra.grabhouse.interview.design;

/**
 * @author aritra
 */
public class Solution {

    /**
     * @param args command line arguments
     */
    public static void main(String args[]) {
        int X = 10, Y = 10;
        Plateau plateau = new Plateau(X, Y);

        int x, y;
        Heading heading;

        x = 2;
        y = 2;
        heading = Heading.E;
        Position position = new Position(x, y, heading);

        Robot robot = new Robot(position, plateau);

    }

}
