/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classstudentivt21;

/**
 *
 * @author lagutina
 */
public class ClassStudentIVT21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student vasya = new Student("Petrov Vasya");
        vasya.addRating(4);
        vasya.addRating(2);
        //vasya.printRating();
        System.out.println(vasya);
        System.out.println(vasya.getName());
    }
}
