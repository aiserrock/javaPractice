/*package triangle;
 import java.util.Scanner;

 public class Triangle {


 public static double enterNum() {
 double x=-1;
 Scanner s = new Scanner(System.in);
 while(x<=0) {
 System.out.println("Enter side triangle: ");
 if (s.hasNextDouble()) {
 x = s.nextDouble();
 if(x>0)
 return x;
 else
 System.out.println("Negative!");  
 }
 else
 System.out.println("It is not number!");
 }
 return x;
 }
 public static void main(String[] args) {
 // TODO code application logic here
 double a = enterNum();
 double b = enterNum();
 double c = enterNum();
 }
 }
 */
package triangle;

import java.util.Scanner;

public class Triangle {

    public static double enterNum() {
        double x = -1;
        Scanner s = new Scanner(System.in);
        while (x <= 0) {
            if (s.hasNextDouble()) {
                x = s.nextDouble();
                if (x > 0) {
                    return x;
                } else {
                    System.out.println("Negative! Re-enter the side!");
                }
            } else {
                System.out.println("It is not number! Re-enter the side!");
                String str = s.nextLine();
            }
        }
        return x;
    }

    public static boolean isTriangle(double a, double b, double c) {
        if ((a < b + c) && (b < c + a) && (c < a + b)) {
            return true;
        }
        return false;
    }

    public static double area(double a, double b, double c) {
        double p = ((a + b + c) / 2);
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return S;
    }

    public static double radiusCircumscribedCircle(double a, double b, double c, double S) {
        double R = (a * b * c) / (4 * S);
        return R;
    }

    public static boolean isTriangleInCircle(double r, double R) {
        if (r >= R) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
// TODO code application logic here
        System.out.println("Enter sides of the triangle:");
        System.out.print("a = ");
        double a = enterNum();
        System.out.print("b = ");
        double b = enterNum();
        System.out.print("c = ");
        double c = enterNum();
        if (!isTriangle(a, b, c)) {
            System.out.println("This is not a triangle");
            return;
        }
        System.out.println("Enter radius of the circle: ");
        double r = enterNum();
        double R = radiusCircumscribedCircle(a, b, c, area(a, b, c));
        if (isTriangleInCircle(r, R)) {
            System.out.println("Vhodit");
        } else {
            System.out.println("ne vhodit");
        }
    }
}