/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personssortexample;

import java.util.*;

class Person implements Comparable<Person> {

    private String name;

    public String getName() {
        return name;
    }
    private int age;

    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) throws PersonException {
        this.name = name;
        if(age<0) throw new PersonException(name, age);
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        return ((Person) obj).name.equals(name) && ((Person) obj).age == age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.name);
    }
}

class PersonAgeComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

class PersonException extends Exception {
    private String name;
    private int age;

    public PersonException(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String getMessage() {
        return "Error age = "+age+" in "+name;
    }
}

public class PersonsSortExample {

    public static void main(String args[]) {
        TreeSet<Person> data = new TreeSet<Person>();
//        try {
//        data.add(new Person("Сидоров", 31));
//        data.add(new Person("Иванов", 45));
//        data.add(new Person("Петров", -20));
//        data.add(new Person("Петров", 20));
//        } catch (PersonException e) {
//            System.err.println(e.getMessage());
//        }
        System.out.println("Введите данные по строчно");
        Scanner sc = new Scanner(System.in);
        try {
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.equals(""))
                break;
            String d[] = s.split(" ");
            Person p = new Person(d[0], Integer.parseInt(d[1]));
            data.add(p);
        }
        } catch (PersonException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(data);

        ArrayList<Person> data2 = new ArrayList<Person>(data);
        Collections.sort(data2);
        //Collections.sort(data2, new PersonAgeComparator());
        System.out.println(data2);
    }
}
