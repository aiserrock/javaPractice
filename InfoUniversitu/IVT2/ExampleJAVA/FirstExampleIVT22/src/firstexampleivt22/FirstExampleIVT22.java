/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstexampleivt22;

/**
 *
 * @author lagutina
 */
public class FirstExampleIVT22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a = 0;
        double b = 2, c = 3;
        if (a != 0) {
            double D = b * b - 4 * a * c;
            if (D > 0) {
                double x1 = (-b - Math.sqrt(D)) / (2 * a);
                double x2 = (-b + Math.sqrt(D)) / (2 * a);
                System.out.println("X1=" + x1 + ", X2=" + x2);

            } else if (D == 0) {
                System.out.println("X=" + (-b / (2 * a)));
            } else {
                System.out.println("No solution!");
            }
        } else {
            System.out.println("Is not square!");
        }
        /*for (int i = 0; i < 10; i++) {
            if (i > 0) {
                System.out.println("Is not square!");
            }
        }*/
    }
}
