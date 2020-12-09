/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nadezhda
 */
public class StudentApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student vasya = new Student("Petrov Vasya");
        try {
            vasya.addRating(4);
            System.out.println(vasya);
            Student petrov = new Student("Petrov Vasya");
            petrov.addRating(4);
            petrov.addRating(5);
            if (vasya.equals(petrov)) {
                System.out.println("equals");
            } else {
                System.out.println("no equals");
            }

            File filein = new File("data.txt");
            File fileout = new File("rezult.txt");
            String str;
            int n;
            Student stud;
            Scanner in = new Scanner(filein);
            if (in.hasNextLine()) {
                str = in.nextLine();
                stud = new Student(str);
                if (in.hasNextInt()) {
                    n = in.nextInt();
                } else {
                    throw new Exception("Data error");
                }
                for (int i = 0; i < n; i++) {
                    stud.addRating(in.nextInt());
                }

                System.out.println(stud);

                in.close();

                FileWriter out = new FileWriter(fileout);
                out.write(stud.toString() + "\n");
                out.close();
            } else {
                System.out.println("Data error");
            }
        } catch (IOException e) {
            System.out.println("Input file error");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
