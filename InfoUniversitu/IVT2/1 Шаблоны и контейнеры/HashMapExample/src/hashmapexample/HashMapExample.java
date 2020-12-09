/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapexample;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author nadezhda
 */
public class HashMapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TreeMap<String, Integer> phoneBook = new TreeMap<String, Integer>();

        phoneBook.put("John", 234154);
        phoneBook.put("Peter", 320967);
        phoneBook.put("Mary", 251718);
        phoneBook.put("Ann", 657112);
        phoneBook.put("Mary", 251719);

        System.out.println("Phone Mary - " + phoneBook.get("Mary"));
        System.out.println("Phone Alex - " + phoneBook.get("Alex"));

        System.out.println("\nSIZE: " + phoneBook.size());

        System.out.println("\nKEYS:");
        for (String s : phoneBook.keySet()) {
            System.out.println(s);
        }

        System.out.println("\nVALUES:");
        for (int val : phoneBook.values()) {
            System.out.println(val);
        }

        System.out.println("\nALL:");
        for (Map.Entry entry : phoneBook.entrySet()) {
            System.out.println("Phone " + entry.getKey() + " - " + entry.getValue());
        }
        
        phoneBook.remove("Ann");
        
        System.out.println("\nALL:");
        for (Map.Entry entry : phoneBook.entrySet()) {
            System.out.println("Phone " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
