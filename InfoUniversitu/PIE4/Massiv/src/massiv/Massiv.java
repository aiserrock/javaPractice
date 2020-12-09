/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massiv;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author nadezhda
 */
public class Massiv {

    /**
     * @param args the command line arguments
     */
    public static int enterDim() {
        int x = -1;
        Scanner s = new Scanner(System.in);
        while (x <= 0) {
            if (s.hasNextInt()) {
                x = s.nextInt();
                if (x > 0) {
                    return x;
                } else {
                    System.out.println("Negative!");
                }
            } else {
                System.out.println("It is not number!");
                String str = s.nextLine();
            }
        }
        return x;
    }

    public static int enterNum() {
        int x;
        Scanner s = new Scanner(System.in);
        while (true) {
            if (s.hasNextInt()) {
                x = s.nextInt();
                return x;
            } else {
                System.out.println("It is not number!");
                String str = s.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //int a[];
        int n;
        Random random = new Random();
        System.out.println("Enter size: ");
        n = enterDim();
        int a[] = new int[n];
        //System.out.println("Enter elements: ");
        int k = 0;
        //Scanner s = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
              a[i] = random.nextInt(6);
//            a[i] = enterNum();
//            while (true) {
//                if (s.hasNextInt()) {
//                    a[i] = s.nextInt();
//                    break;
//                } else {
//                    System.out.println("It is not number!");
//                    String str = s.nextLine();
//                }
//            }
            if (a[i] != 0) {
                k++;
            }
        }
        int b[] = new int[k];
        System.out.println(k);
        for (int i = 0, j = 0; i < n; i++) {
            if (a[i] != 0) {
                b[j] = a[i];
                j++;
            }
        }
        System.out.println("Old : ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nNew : ");
        for (int i = 0; i < k; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
