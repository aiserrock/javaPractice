/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistexample;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lagutina
 */
public class ArrayListExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<10; i++)
            a.add(i*i);
        System.out.println(a);
        int k=0;
        for(int i: a)
            if(i==0)
                k++;
        
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Ann", 25));
        String name = "Pit";
        int age = 13;
        Person x= new Person(name, age);
        persons.add(x);
        System.out.println(persons);
        int indexPit = persons.indexOf(new Person("Pit", 13));
        System.out.println(indexPit);
        persons.add(new Person("Bill", 28));
        Collections.sort(persons);
        System.out.println(persons);
        Person max = Collections.max(persons);
        System.out.println(max);
        Collections.sort(persons, new PersonAgeComparator());
        System.out.println(persons);
    }
}
