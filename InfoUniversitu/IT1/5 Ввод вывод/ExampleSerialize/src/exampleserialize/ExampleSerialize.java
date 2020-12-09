/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleserialize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author nadezhda
 */
public class ExampleSerialize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            GregorianCalendar d = new GregorianCalendar();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("date.ser"));
            oos.writeObject(d);
            //oos.flush();
            oos.close();
            Thread.sleep(3000);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("date.ser"));
            GregorianCalendar oldDate = (GregorianCalendar) ois.readObject();
            ois.close();
            GregorianCalendar newDate = new GregorianCalendar();
            System.out.println("Old time = "
                    + oldDate.get(Calendar.HOUR) + ":"
                    + oldDate.get(Calendar.MINUTE) + ":"
                    + oldDate.get(Calendar.SECOND) + "\nNew time = "
                    + newDate.get(Calendar.HOUR) + ":"
                    + newDate.get(Calendar.MINUTE) + ":"
                    + newDate.get(Calendar.SECOND));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        try {
//            File data = new File("person.ser");
//            Person person;
//            if (data.exists()) {
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data));
//                person = (Person) ois.readObject();
//                ois.close();
//            } else {
//                System.out.println("Enter person data");
//                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
//                if (str.split(" +").length != 2) {
//                    throw new IOException("incorrectly: " + str);
//                }
//                person = new Person(str.split(" +")[0], Integer.parseInt(str.split(" +")[1]));
//            }
//            System.out.println(person.getName()+" "+person.getAge());
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(data));
//            oos.writeObject(person);
//            oos.close();
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

    }
}
