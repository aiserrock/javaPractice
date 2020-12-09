/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentappinoutexception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class StudentAppInOutException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ArrayList<Student> listStud = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            String w;
            while ((w = reader.readLine()) != null) {
                String[] a = w.trim().split(" +");
                if(a.length<2) 
                    throw new Exception("No data");
                Student st = new Student(a[0]);
                for (int i = 1; i < a.length; i++) {
                    st.addRating(Integer.parseInt(a[i]));
                }
//                System.out.println(st);
                listStud.add(st);
            }
            System.out.println(listStud);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        }
        catch(IOException ex){
            System.out.println("Error data file");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
