/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanapp;

/**
 *
 * @author student
 */
abstract public class Human implements Comparable<Human>{
    
    private String name;
    private int age;
    public Human() {
        name = "";
        age = 0;
    }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    abstract public boolean isGrant();
    
    @Override
    public String toString(){
        return name+"("+age+")";
    }

    @Override
    public int compareTo(Human o) {
       return name.compareTo(o.name);
    }
}
