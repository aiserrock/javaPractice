/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        File filein = new File("data.txt");
        File fileout = new File("rezult.txt");
        String str;
        int n;
        Student stud;
        ArrayList<Student> listSt = new ArrayList<Student>();
        try {
            Scanner in = new Scanner(filein);
            while (in.hasNextLine()) {
                str = in.nextLine();
                stud = new Student(str);
                if (in.hasNextInt()) {
                    n = in.nextInt();
                    for (int i = 0; i < n; i++) {
                    stud.addRating(in.nextInt());
                    }
                } else {
                    throw new IOException();
             
                }
                listSt.add(stud);
                if(in.hasNextLine())
                str = in.nextLine();
            }
            in.close();
            System.out.println(listSt);
            for(int i=0; i<listSt.size();i++)
                System.out.println(listSt.get(i).getName());
            
            for(Student i:listSt)
                System.out.println(i.getName());
            
            FileWriter out = new FileWriter(fileout);
            for(int i=0; i<listSt.size();i++)
                out.write(listSt.get(i).toString()+"\n");
            out.close();
        } catch (IOException e) {
            System.out.println("Input file error");
        }
    }
}
