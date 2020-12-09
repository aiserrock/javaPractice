/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfeiceapp;

/**
 *
 * @author nadezhda
 */
public class InterfeiceApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyArray superArray = new Array();
        superArray = new LinkedList();
        method(superArray);
        superArray = new Array();
        method(superArray);
    }
    public static void method(MyArray a) {
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(3);
        System.out.println();
        System.out.println(a.get(2));
        a.printKonsole();
    }
}
