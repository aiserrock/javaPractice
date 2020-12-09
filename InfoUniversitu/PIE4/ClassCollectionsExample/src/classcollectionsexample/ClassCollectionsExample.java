/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classcollectionsexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nadezhda
 */
public class ClassCollectionsExample {

    /**
     * @param args the command line arguments
     */
    static void print(List<Integer> c) {
        System.out.println();
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        Collections.shuffle(list);
        print(list);
        Collections.sort(list);
        print(list);
        Collections.reverse(list);
        print(list);
        Collections.rotate(list, 3);
        print(list);
        System.out.println("\nmin: " + Collections.min(list));
        System.out.println("\nmax: " + Collections.max(list));
        int min = Collections.min(list);
        //list.remove(min);
        //list.remove(new Integer(min));
        print(list);
    }
}
