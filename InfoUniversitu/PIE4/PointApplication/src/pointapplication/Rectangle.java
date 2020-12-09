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
public class Rectangle {
    private Point a, b;
    public Rectangle () {
        a = new Point(0,1);
        b = new Point(1,0);
    }
    public Rectangle (double x1, double y1, double x2, double y2) {
        a = new Point(x1,y1);
        b = new Point(x2,y2);
    }
    public Rectangle (Point v1, Point v2) {
        a = new Point(v1);
        b = new Point(v2);
    }
    public double square () {
        return Math.abs(a.getX() - b.getX()) * Math.abs(a.getY() - b.getY());
    }
    public boolean conteinPoint(Point p) {
        return ((a.getX() < p.getX() && p.getX() <b.getX()) ||  (b.getX() < p.getX() && p.getX() <a.getX()))
                && ((a.getY() < p.getY() && p.getY() <b.getY()) ||  (b.getY() < p.getY() && p.getY() <a.getY()));
    }
    
}
