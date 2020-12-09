/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentclassexample;

/**
 *
 * @author student
 */
public class Student {

    private String name;
    private final int MAXLEN = 40;
    private int rating[] = new int[MAXLEN], size;

    public Student() {
        name = "";
//        rating = new int[MAXLEN];
        size = 0;
    }

    public Student(String name) {
        size = 0;
//        rating = new int[MAXLEN];
        this.name = name;
    }

    public Student(String name, int rating[]) {
        size = rating.length;
//        this.rating = new int[MAXLEN];
//        for (int i = 0; i < size; i++) {
//            this.rating[i] = rating[i];
//        }
        System.arraycopy(rating, 0, this.rating, 0, size);
        this.name = name;
    }

    public Student(Student student) {
        size = student.size;
//        this.rating = new int[MAXLEN];
        System.arraycopy(student.rating, 0, this.rating, 0, size);
        this.name = student.name;
    }

    public String getName() {
//        return name;
        return new String(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRating(int value) {
        if (value > 1 && value < 6 && size < MAXLEN) {
            rating[size] = value;
            size++;
        }
    }

    private boolean isExcellent() {
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (rating[i] != 5) {
                return false;
            }
        }
        return true;
    }

    private boolean isLoser() {
        for (int i : rating) {
            if (i == 2) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (isExcellent()) {
            return name + " - Excellent";
        }
        if (isLoser()) {
            return name + " - Loser";
        }
        return name + " - Normal";
    }

//    public void printRating() {
//        if (isExcellent()) {
//            System.out.println(name + " - Excellent");
//        }
//        if (isLoser()) {
//            System.out.println(name + " - Loser");
//        }
//    }
}
