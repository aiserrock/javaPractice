/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstexamplejava;

/**
 *
 * @author lagutina
 */
public class FirstExampleJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a=2, b=10;
        b=a+b;
        boolean flag=true;
        if(a==2)
            System.out.println("Rezult "+a+" "+b);
        for(int i=1; i<10; i++)
            System.out.println(i*i);
        if(less5(-6)){};
        double x=16;
        double y=Math.sqrt(x);
    }
    
    public static boolean less5 (int n) {
        if(n<5 && n>-5)
            return true;
        return false;
    }
}
