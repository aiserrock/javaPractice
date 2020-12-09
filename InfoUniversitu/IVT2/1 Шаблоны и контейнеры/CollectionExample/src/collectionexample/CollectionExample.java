/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionexample;

import java.util.*;
import java.io.*;

/**
 *
 * @author nadezhda
 */
class Point implements Comparable<Point> {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        if (x != ((Point) obj).x) {
            return false;
        }
        if (y != ((Point) obj).y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (int) x;
        result = 37 * result + (int) y;
        return result;
    }

    @Override
    public int compareTo(Point p) {
        double diff = (x * x + y * y) - (p.x * p.x + p.y * p.y);
        return (int) (Math.signum(diff));
    }
}

public class CollectionExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        try {
//            ArrayList<Integer> collection1 = new ArrayList<Integer>();
//            HashSet<Integer> collection2 = new HashSet<Integer>();
//            TreeSet<Integer> collection3 = new TreeSet<Integer>();
//            Scanner in = new Scanner(new File("data.txt"));
//            while (in.hasNextInt()) {
//                int x = in.nextInt();
//                collection1.add(x);
//                collection2.add(x);
//                collection3.add(x);
//            }
//            System.out.println("ArrayList for Integer");
//            System.out.println(collection1);
//            System.out.println("HashSet for Integer");
//            System.out.println(collection2);
//            System.out.println("TreeSet for Integer");
//            System.out.println(collection3);
//        } catch (IOException e) {
//            System.out.println("In/out error");
//        }
        try {
            ArrayList<Point> collection1 = new ArrayList<Point>();
            HashSet<Point> collection2 = new HashSet<Point>();
            TreeSet<Point> collection3 = new TreeSet<Point>();
            Scanner in = new Scanner(new File("dataPoint.txt"));
            //int sum = 0;
            while (in.hasNextInt()) {
                double x = in.nextInt();
                if (in.hasNextInt()) {
                    double y = in.nextInt();
                    collection1.add(new Point(x, y));
                    collection2.add(new Point(x, y));
                    collection3.add(new Point(x, y));
                }
            }
            System.out.println("ArrayList for Point");
            System.out.println(collection1);
            System.out.println("HashSet for Point");
            System.out.println(collection2);
            System.out.println("TreeSet for Point");
            System.out.println(collection3);
        } catch (IOException e) {
            System.out.println("In/out points error");
        }
    }
}
