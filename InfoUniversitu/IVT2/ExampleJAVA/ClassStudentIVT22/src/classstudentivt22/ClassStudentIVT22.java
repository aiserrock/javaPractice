/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classstudentivt22;

/**
 *
 * @author lagutina
 */
public class ClassStudentIVT22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student vasya = new Student("Petrov Vasya");
        vasya.addRating(5);
        vasya.addRating(3);
        //vasya.printRating();
        System.out.println(vasya);

    }
}
