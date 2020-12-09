/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussapp;

/**
 *
 * @author zaikin
 */
public class BussApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buss buss1= new Buss(54,40,400);
        Buss buss2=new Buss(45,500,30);
       
        if(buss1.occupiedPlaceCost()>11000)
            System.out.println("rent");
        else
            System.out.println("Nr");
        if(buss2.occupiedPlaceCost()>11000)
            System.out.println("rent");
        else
            System.out.println("Nr");
        
        
        
    }
    
}
