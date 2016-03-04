/*************************************************************************
 * Name: Brian Levine
 * Email: bmlevine11@gmail.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public static final Comparator<Point> SLOPE_ORDER = new SlopeOrder();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    private static class SlopeOrder implements Comparator<Point>{

        public int compare(Point q1, Point q2){

//            double slopeToQ1 = slopeTo(q1);
//            double slopeToQ2 = slopeTo(q2);
            double slopeTo = q1.slopeTo(q2);

//            if(slopeToQ1 > slopeToQ2){ return -1;}
//            if(slopeToQ1 == slopeToQ2){ return 0;}

            return 1;

        }
    }
    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        return (float)(that.y-this.y)/(that.x-this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if(this.y < that.y) return -1;
        if(this.y == that.y && this.x < that.x) return -1;
        if(this.y == that.y && this.x == that.x) return 0;
        return +1;
    }

    // return string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
//        Point p1 = new Point(30,99);
//        Point p2 = new Point(6,2);
//        Point p3 = new Point(2,7);
//
//        System.out.println(p1.slopeTo(p3));
    }
}