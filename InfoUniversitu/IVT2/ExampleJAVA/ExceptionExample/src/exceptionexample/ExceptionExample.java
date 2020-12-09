/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionexample;

/**
 *
 * @author nadezhda
 */
public class ExceptionExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int d = 0;
//        int a = 42 / d;
//        String str = "5," + "6";
//        double r = Double.parseDouble(str);
        try {
            Person p = new Person("Vasya", 10);
            p.setAge(-5);

        } catch (PersonAgeException e) {
            System.out.println("Error in value "+e.getValueError());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
