/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personsortexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparable<Person>
{
   
    private String name;
    public String getName() { return name; }
    private int age;
    public int getAge() { return age; }
    
    public Person(String name, int age) { this.name = name; this.age = age; }
    
    public String toString() { return name + " (" + age + ")"; }
    
    public boolean equals(Object obj)
    {
	if(!(obj instanceof Person))
	    return false;
	return ((Person)obj).name.equals(name) && ((Person)obj).age == age;
    }
    
    public int compareTo(Person p) { return name.compareTo(p.name); }
}

class PersonAgeComparator implements Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
	return p1.getAge() - p2.getAge();
    }
}
public class PersonSortExample
{
    public static void main(String args[])
    {
	ArrayList<Person> data = new ArrayList<Person>();
	data.add(new Person("Петров", 31));
	data.add(new Person("Иванов", 45));
	data.add(new Person("Смирнов", 20));
	Collections.sort(data);
	System.out.println(data);
	//Collections.sort(data, new PersonAgeComparator());
        Collections.sort(data, (p1,p2)-> p1.getAge() - p2.getAge());
	System.out.println(data); // вывод отсортирован по возрасту
    }
}
