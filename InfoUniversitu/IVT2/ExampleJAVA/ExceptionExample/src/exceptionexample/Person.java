/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionexample;

/**
 *
 * @author nadezhda
 */
public class Person implements Comparable<Person> {

    private String name;

    public String getName() {
        return name;
    }
    private int age;

    public int getAge() {
        return age;
    }
    
    public void setAge(int age) throws PersonAgeException{
        if(age<0)
            throw new PersonAgeException(age);
    }

    public Person(String name, int age) throws Exception{
        this.name = name;
        if(age<0)
            throw new Exception("Error age");
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        return ((Person) obj).name.equals(name) && ((Person) obj).age == age;
    }

    public int compareTo(Person p) {
        return name.compareTo(p.name);
    }
}

class PersonAgeException extends Exception {
    int ageError;
    public PersonAgeException(int ageError){
        this.ageError = ageError;
    }
    public int getValueError(){
        return ageError;
    }
}
