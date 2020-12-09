/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringbufferexample;

/**
 *
 * @author nadezhda
 */
public class StringBufferExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuffer b = new StringBuffer();
        StringBuffer strb = new StringBuffer("Text");
        
        String s = "Example";
        StringBuffer sb = new StringBuffer(s);
        
//        System.out.println(s);
//        System.out.println(sb);
        
//        s += " example";
//        sb.append(" example");
//        System.out.println(s);
//        System.out.println(sb);
//        
//        String s1,s2;
//        s1 = s.substring(2, 5);
//        s2 = sb.substring(2, 5);
//        System.out.println(s1);
//        System.out.println(s2);
//        
//        s = s.replace("e", "E");
//        sb.replace(6, 7, "E");
//        System.out.println(s);
//        System.out.println(sb);
//        
//        sb.insert(2, "yy");
//        System.out.println(sb);
//        
//        sb.delete(2, 4);
//        System.out.println(sb);
        
//        sb.delete(8, 14);
        StringBuffer tmp = new StringBuffer(s);
//        tmp.delete(8, 14);
        s = tmp.toString();
        System.out.println(s);
        System.out.println(sb);
    }
    
}
