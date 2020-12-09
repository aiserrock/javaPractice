/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examplearrayivt22;
import java.util.Scanner;

/**
 *
 * @author lagutina
 */
public class ExampleArrayIVT22 {

    /**
     * @param args the command line arguments
     */
    public static void MaximumArrayPrint (int a[]) {
        int max, kmax;
        max = a[0];
        kmax = 1;
        for(int i=1; i<a.length; i++)
            if(a[i]> max) {
                max = a[i];
                kmax = 1;
            } 
            else if (a[i] == max)
                kmax++;
        System.out.println("MAX=" + max +" Kmax=" + kmax);
                
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Enter size array");
        if(sc.hasNextInt()) {
            n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i<n; i++)
                if(sc.hasNextInt())
                    a[i] = sc.nextInt();
                else {
                    System.out.println("Error element");
                    break;
                }
            System.out.println("Array size = "+a.length);
            MaximumArrayPrint(a);
        }
        else
            System.out.println("Error size");
    }

}
