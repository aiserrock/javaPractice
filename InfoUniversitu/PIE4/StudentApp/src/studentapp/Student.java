/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.util.Arrays;

/**
 *
 * @author nadezhda
 */
public class Student {

    private final int MAXLEN = 40;
    private int rating[], size;
    private String name;

    public Student() {
        size = 0;
        rating = new int[MAXLEN];
        name = "Petrov Vasya";
    }

    public Student(String name) {
        size = 0;
        rating = new int[MAXLEN];
        this.name = name;
    }

    public Student(String name, int rating[]) throws Exception {
        if(rating.length > MAXLEN)
            throw new Exception("Illegal size rating");
        size = rating.length;
        this.rating = new int[MAXLEN];
        for (int i = 0; i < size; i++) {
            if(!(rating[i]>=2 && rating[i]<=5))
                throw new Exception("Illegal rating");
            this.rating[i] = rating[i];
        }
        //System.arraycopy(rating, 0, this.rating, 0, size);
        this.name = name;
    }

    public Student(Student student) {
        size = student.size;
        this.rating = new int[MAXLEN];
        System.arraycopy(student.rating, 0, this.rating, 0, size);
        this.name = student.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRating(int value) throws Exception {
        if(!(value>=2 && value<=5))
                throw new Exception("Illegal rating " + Integer.toString(value));
        rating[size] = value;
        size++;
    }
    private boolean isExcellent () {
        for (int i: rating)
            if (i!=5 && i!=0)
                return false;
        return true;
    }
    private boolean isLoser () {
        for (int i: rating)
            if (i==2)
                return true;
        return false;
    }
    @Override
    public String toString () {
        if (isExcellent ())
            return name+" - Excellent";
        if (isLoser ())
            return name+" - Loser";
        return name+" - Normal";
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student tmp = (Student)o;
            if( Arrays.equals(rating, tmp.rating) && name == tmp.name)
                return true;
            else 
                return false;
        }
        else
            return false;
            
    }
    
}
