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
public class PointApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point a = new Point();
        Point b = new Point(1,-3), c = new Point (3.5);
        Point d = a;
        
        double sum = b.getX()+b.getY();
        b.setX(-2);
        System.out.println(b);
        
        if(b.equals(c))
            System.out.println(b+"="+c);
        else System.out.println(b+"!="+c);
        
        Rectangle r = new Rectangle(-1, -1, 3, 4);
        Rectangle r2 = new Rectangle(a,b);
        System.out.println(r2.square());
        Point p = new Point();
        if(r.conteinPoint(p))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}
