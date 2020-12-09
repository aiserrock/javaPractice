/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerexample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nadezhda
 */
public class ScannerExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Enter lines:");
        str = sc.nextLine();

        while (!str.isEmpty()) {
            System.out.println(str);
            str = sc.nextLine();
        }

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter rating:");
        double sb = 0;
        int k = 0;
        while (sc.hasNextInt()) {
            sb += sc.nextInt();
            k++;
        }
        System.out.println("Student " + name + ". Average = " + (sb / k));

        try {
            Scanner fsc = new Scanner(new File("student.txt"));
            while (fsc.hasNextLine()) {
                String sname = fsc.nextLine();
                double sum = 0;
                int kol = 0;
                while (fsc.hasNextInt()) {
                    sum += fsc.nextInt();
                    kol++;
                }
                System.out.println("Student " + sname + ". Average = " + (sum / kol));
                if(fsc.hasNextLine()) 
                    sname = fsc.nextLine();
            }
        } catch (IOException e) {
	    System.out.println(e.getMessage());
        }
    }

}
