/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parammethodexample;

/**
 *
 * @author nadezhda
 */
public class ParamMethodExample {

    /**
     * @param args the command line arguments
     */
    public static <T extends Comparable<T> >
            boolean isIn (T x, T[] a) {
                for(int i=0; i<a.length; i++)
                    if (x.equals(a[i]))
                        return true;
                return false;
            }
    public static void main(String[] args) {
        // TODO code application logic here
        Integer num[] = {1,2,3,4,5};
        if(isIn(2,num))
            System.out.println("2 in array");
        String str[] ={"one", "two", "three", "four", "five"};
        if(isIn("two1",str))
            System.out.println("two in array");
    }
    
}
