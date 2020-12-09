/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsapp;
import java.io.*;

/**
 *
 * @author nadezhda
 */
public class StringsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s, buf="";
        try {
            BufferedReader in = new BufferedReader(new FileReader("data.txt"));
            PrintWriter out = new PrintWriter("rezult.txt");
            while ((s = in.readLine()) != null) {
                if(s.indexOf(".")==-1){
                    buf+=s+"\n";
                }
                else {
                    while(s.indexOf(".")!=-1) {
                        buf+=s.substring(0, s.indexOf("."));
                        //String[] a=buf.split("[ ,]+");
                        if(buf.split("[ ,]+").length>10)
                            out.print(buf+".");
                        buf="";
                        s=s.substring(s.indexOf(".")+1);
                    }
                    buf=s+"\n";
                }
            }
            out.close();
            in.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
