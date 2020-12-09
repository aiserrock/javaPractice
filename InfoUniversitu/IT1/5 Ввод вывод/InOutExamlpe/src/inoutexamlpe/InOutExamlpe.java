/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inoutexamlpe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nadezhda
 */
public class InOutExamlpe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        // Read line
//        try {
//            System.out.println("Enter line:");
//            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
//            System.out.println(str);
//
//            System.out.println("Enter line:");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            String w = reader.readLine();
//            while (!w.isEmpty()) { 
//                System.out.println(w);
//                w = reader.readLine();
//            }
//
//            System.out.println("Enter data:");
//            w = reader.readLine();
//            String[] a = w.trim().split(" +");
//            double sb = 0;
//            for (int i = 1; i < a.length; i++) {
//                sb += Double.parseDouble(a[i]);
//            }
//            System.out.println("Student " + a[0] + ". Average = " + (sb / (a.length - 1)));
//        } catch (IOException e) {
//            System.out.println("Error consol data");
//        }
//        try {
//
//            BufferedReader in = new BufferedReader(new FileReader("data.txt"));
//            PrintWriter out = new PrintWriter("rezult.txt");
//
//            String str = in.readLine();
//            out.println(str);
//            System.out.println(str);
//
//            while ((str = in.readLine()) != null) {
//                out.println(str);
//                System.out.println(str);
//            }
//            out.close();
//            in.close();
//
//            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
//            String w;
//            w = reader.readLine();
//            String[] a = w.trim().split(" +");
//            double sb = 0;
//            for (int i = 1; i < a.length; i++) {
//                sb += Double.parseDouble(a[i]);
//            }
//            System.out.println("Student " + a[0] + ". Average = " + (sb / (a.length - 1)));
//        } catch (IOException e) {
//            System.out.println("Error data");
//        }

//        File filein = new File("data.txt");
//        File fileout = new File("rezult.txt");
//        System.out.println("About file " + filein.getName());
//        System.out.println(filein.getAbsoluteFile());// return File
//        System.out.println(filein.getAbsolutePath());
//        System.out.println(filein.getPath());
//        System.out.println(filein.lastModified());
//        System.out.println(new Date(filein.lastModified()));
//        fileout.renameTo(new File("fileout.txt"));

//        Date myDate = new Date(filein.lastModified());
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd−MM−yyyy");
//        System.out.println(formatDate.format(myDate));
//
//        System.out.println(new SimpleDateFormat("dd−MM−yyyy HH−mm−ss").
//                format(new Date(new File("data.txt").lastModified())));
//
//        try {
//
//            BufferedReader in = new BufferedReader(new FileReader(filein));
//            PrintWriter out = new PrintWriter(fileout);
//            PrintWriter add = new PrintWriter(new FileOutputStream("test.txt", true));
//            add.write("AAA");
//            add.close();
//            PrintWriter add2 = new PrintWriter(new FileOutputStream(fileout, true));
//            
//            String str = in.readLine();
//            out.println(str);
//            System.out.println(str);
//
//            while ((str = in.readLine()) != null) {
//                out.println(str);
//                System.out.println(str);
//            }
//            out.close();
//            in.close();
//        } catch (IOException e) {
//            System.out.println("Error data file");
//        }
    }

}
