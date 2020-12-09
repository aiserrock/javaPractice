/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vektormain;

/**
 *
 * @author superuser
 */
public class Point {
    protected double x,y,z;
    public Point(){
    }
    public Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public String toString() {
        return new String(x+","+y+","+z);
    }
    
}
