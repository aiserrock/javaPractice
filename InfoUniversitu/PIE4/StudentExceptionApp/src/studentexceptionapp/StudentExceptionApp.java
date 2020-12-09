/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentexceptionapp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author пользователь
 */
public class StudentExceptionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File fileIn = new File("dataFiles//data.txt");
            File fileOut = new File("out.txt");
            Scanner sc = new Scanner(fileIn);
            PrintWriter pw = new PrintWriter(fileOut);
            
            String str;

            ArrayList<Student> listSt = new ArrayList<Student>();
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                String a[] = str.trim().split(" +");
                try {
                    if (a.length < 3) {
                        throw new Exception("No data");
                    }
                    if (!a[0].matches("[A-Z][a-z]+")) {
                        throw new Exception("Name error");
                    }
                    if (!a[1].matches("[A-Z][a-z]+")) {
                        throw new Exception("Name error");
                    }
                    Student tmp = new Student(a[0], a[1]);
                    for (int i = 2; i < a.length; i++) {
                        tmp.addBall(Integer.parseInt(a[i]));
                    }
                    System.out.println("New student: " + tmp);
                    listSt.add(tmp);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(listSt);
            for(Student x:listSt)
                pw.println(x.getName()+" "+x.meanBall());
            pw.close();
//        Collections.sort(listSt);
//        System.out.println(listSt);
//        Collections.sort(listSt, new StudentBallComparator());
//        System.out.println(listSt);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
