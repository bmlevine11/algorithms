/**
 * Created on 2/19/15.
 * @author brianlevine
 */
public class Brute {
    public static void main(String[] args) {
        int N = StdIn.readInt(); // number of coordinate pairs
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(StdIn.readInt(),StdIn.readInt());
        }

        java.util.Arrays.sort(points, Point.SLOPE_ORDER);
    }
}
