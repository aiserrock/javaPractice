/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classstudentivt21;

/**
 *
 * @author lagutina
 */
public class Student {

    private String name;
    private final int MAXLEN = 40;
    private int rating[], size;

//    public Student() {
//        size = 0;
//        rating = new int[MAXLEN];
//        name = "Petrov Vasya";
//    }
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

    private boolean isExcellent() {
        for (int i=0; i < size; i++) {
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
    
    public void printRating() {
        if (isExcellent())
            System.out.println(name + " - Excellent");
        if (isLoser())
            System.out.println(name + " - Loser");
    }

    @Override
    public String toString() {
        if (isExcellent()) {
            return name + " - Excellent";
        }
        if (isLoser()) {
            return name + " - Loser";
        }
        return name + " - Normal";
    }
   public void addRating(int value) {
       if( value > 1 && value < 6 && size < MAXLEN) {
            rating[size] = value;
            size++;
       }
    } 
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
