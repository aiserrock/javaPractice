/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleserialize;

import java.io.Serializable;

/**
 *
 * @author nadezhda
 */
public class Person implements Serializable {

    private String name;

    public String getName() {
        return name;
    }
    private int age;

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
