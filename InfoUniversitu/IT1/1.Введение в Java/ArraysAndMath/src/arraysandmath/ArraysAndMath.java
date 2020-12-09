/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysandmath;

import java.util.Arrays;

/**
 *
 * @author nadezhda
 */
public class ArraysAndMath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double c=5, y=8;
        double z = Math.max(c, y);
        
        int n = 10;
        int a[] = new int[n];
        for(int i=0; i<a.length; i++)
            a[i] = (int)(Math.random()*10);
        
        for(int x:a)
            System.out.println(x+" * "+x+" = "+Math.pow(x, 2));
        
        Arrays.sort(a);
        
        int k = 5;
        int ik = Arrays.binarySearch(a, k);
        System.out.println("Индекс числа " + k + " в массиве = "+ik);

        int b[] = Arrays.copyOf(a, n);
        
        System.out.println(Arrays.toString(b));
        //System.out.println(b);
    }
    
}
