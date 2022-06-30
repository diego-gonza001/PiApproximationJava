
//import awt package which contains Point class
import java.awt.*;
//import util package which contains Scanner class
import java.util.*;

public class PiApproximation { // start PiApproximation class

    // class constant radius of circle inscribed in square
    public final static double RADIUS = 500;

    public static void main(String[] args) { // start main()

        // instantiate new instance of the Scanner class
        Scanner input = new Scanner(System.in);

        // int to hold amount of points user wants to use to approximate Pi
        int totalPoints;

        // prompt user for how many points they want to use to approximate Pi
        System.out.print("How many points do you want to use to approximate Pi?");

        // assign inputted amount into *points* and convert to int
        totalPoints = (int) input.nextDouble();

        // pass *totalPoints* to calculate() and return Pi estimate
        System.out.println(calculate(totalPoints));

    } // end main()

    /*
     * calculate Pi estimate
     * 
     * @param total points to calculate with
     * 
     * @return Pi estimate
     */
    public static double calculate(int totalPoints) { // start calculate()

        // declare array that will hold points with give *points* amount
        Point[] allPoints = new Point[totalPoints];

        // declare int that will hold amount of points inside circle with radius of 500
        int insideCircle = 0;

        // assign each point a random location on a 1000 by 1000 unit square and center
        // at the origin
        for (int i = 0; i < allPoints.length; i++) {

            // instatiate new Point with cordinates (0,0) as to not be null
            allPoints[i] = new Point();

            // give point random x and y value that fits constraints above
            allPoints[i].setLocation(Math.random() * 1000 - 500, Math.random() * 1000 - 500);

            // determain if point is inside circle of radius using the Pythagorean Theorum
            if (Math.pow(allPoints[i].getX(), 2) + Math.pow(allPoints[i].getY(), 2) <= Math.pow(RADIUS, 2)) {
                // incriment counter of total points inside circle
                insideCircle++;
            }

            // print out point location with class toString()
            // System.out.println(allPoints[i]);

        }

        // return *insideCircle* / *totalPoints*
        return 4.0 * insideCircle / totalPoints;

    } // end calculate()

} // end PiApproximation class
