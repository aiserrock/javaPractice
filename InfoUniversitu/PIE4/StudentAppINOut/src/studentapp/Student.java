/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.util.Comparator;

/**
 *
 * @author nadezhda
 */
public class Student implements Comparable<Student>{

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

    public Student(String name, int rating[]) {
        size = rating.length;
        this.rating = new int[MAXLEN];
        for (int i = 0; i < size; i++) {
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

    public void addRating(int value) {
        rating[size] = value;
        size++;
    }
    
    public double getRating () {
        double s=0;
        for (int i=0; i<size; i++)
            s+=rating[i];
        return s/size;
    }
    private boolean isExcellent () {
        for (int i: rating)
            if (i!=5&&i!=0)
                return false;
        return true;
    }
    private boolean isLoser () {
        for (int i: rating)
            if (i==2)
                return true;
        return false;
    }
    public String toString () {
        if (isExcellent ())
            return name+" - Excellent";
        if (isLoser ())
            return name+" - Loser";
        return name+" - Normal";
    }
    
    @Override
    public int compareTo (Student p) {
        return name.compareTo(p.name);
    }
    
}

class StudentRatingComparator implements Comparator<Student> {
    @Override
    public int compare(Student p1, Student p2) {
        return (int)Math.signum(p1.getRating()-p2.getRating());
    }
}
