/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

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
    private boolean isExcellent () {
        for (int i: rating)
            if (i!=5)
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
    
}
