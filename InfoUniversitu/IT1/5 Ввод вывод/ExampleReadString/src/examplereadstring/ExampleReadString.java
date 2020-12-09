/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplereadstring;

import java.util.Scanner;

/**
 *
 * @author пользователь
 */
public class ExampleReadString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String data;
        if(sc.hasNextLine())
            data = sc.nextLine();
        else return;
        
        String []a =data.split(" +");
        
        int rating[] =new int[a.length-1];
        for(int i=0; i<rating.length;i++)
            rating[i]=Integer.parseInt(a[i+1]);
        
        boolean isExellence = true;
        for(int x:rating)
            if(x!=5)
                isExellence = false;
        if(isExellence)
            System.out.println(a[0]+" - exsellence");
        else
            System.out.println(a[0] + " - normal");
    }
    
}
