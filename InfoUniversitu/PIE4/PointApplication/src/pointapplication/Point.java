/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointapplication;

/**
 *
 * @author student
 */
public class Point {
    private double x,y;
    public Point() {
        x = 0;
        y = 0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(double x) {
        this.x = x;
        this.y = x;
    }
    public Point(Point p) {
        x = p.x;
        y = p.y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return new String("("+ x +", "+ y +")");
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point) {
            Point p = (Point)obj;
            return (p.x == x) && (p.y == y);
        }
            return false;
    }
    
}
