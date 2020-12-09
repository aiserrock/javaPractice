/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personssortexample;

import java.util.*;

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

    public int hashCode() { return name.hashCode() + age; }

    public int compareTo(Person p) { return name.compareTo(p.name); }
}

class PersonAgeComparator implements Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
	return p1.getAge() - p2.getAge();
    }
}
public class PersonsSortExample
{
    public static void main(String args[])
    {
	TreeSet<Person> data = new TreeSet<Person>();
	data.add(new Person("Петров", 31));
	data.add(new Person("Иванов", 45));
	data.add(new Person("Смирнов", 20));
	data.add(new Person("Смирнов", 20)); // такой элемент уже есть
	System.out.println(data); // вывод отсортирован по фамилиям
	// Копирование содержимого множества в список
	ArrayList<Person> data2 = new ArrayList<Person>(data);
	Collections.sort(data2, new PersonAgeComparator());
	System.out.println(data2); // вывод отсортирован по возрасту
    }
}
