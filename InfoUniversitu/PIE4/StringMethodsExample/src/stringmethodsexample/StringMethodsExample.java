/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmethodsexample;

import java.util.Random;

/**
 *
 * @author lagutina
 */
public class StringMethodsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String aboutCat = "Cat - it sounds good!";
        String[] cats = {"Vasya", "Barsik", "Murzik"};
        String s = new String();
        char[] chars = {'c', 'a', 't'};
        String str = new String(chars);

//        char[] chars = {'c', 'a', 't', 'a', 'm', 'a', 'r', 'a', 'n'};
//        String str = new String(chars, 0, 3);

        int digit = 4;
        String paws = " feet";
        aboutCat = digit + paws;

        String testString = "Kitten";
        char myChar = testString.charAt(2);
        System.out.println(myChar);
        
        //s = "Kitten";

        if (testString.equals(s)) {
            System.out.println("Stroki ravny");
        } else {
            System.out.println("Stroki ne ravny");
        }

        if (testString.compareTo(s) == 0) {
            System.out.println("Stroki ravny");
        } else {
            System.out.println("Stroki ne ravny");
        }

        if (testString.equalsIgnoreCase(s)) {
            System.out.println("Stroki ravny");
        } else {
            System.out.println("Stroki ne ravny");
        }

        if (testString.compareToIgnoreCase(s) == 0) {
            System.out.println("Stroki ravny");
        } else {
            System.out.println("Stroki ne ravny");
        }

        if (testString.contains("tt")) {
            System.out.println(testString + " soderzhit tt");
        } else {
            System.out.println(testString + " ne soderzhit tt");
        }

        int p = testString.indexOf('t');
        System.out.println("t : " + p);
        p = testString.indexOf('y');
        System.out.println("y : " + p);
        p = testString.indexOf('t', 4);
        System.out.println("t : " + p);
        p = testString.indexOf("tt");
        System.out.println("tt : " + testString.indexOf("tt"));

        if (testString.matches("[A-Z][a-z]+")) {
            System.out.println(testString + " nachinaetsya s bolshoi bukvy");
        }

        testString = testString.replace("tt", "t");
        System.out.println(testString);
        testString = testString.replaceAll("tt", "t");
        System.out.println(testString);

        String catnames = "Vasya Ryzhyk Barsik    Murzik";
        String aCats[] = catnames.split(" +");
        System.out.println();
        for (String cat : aCats) {
            System.out.println(cat);
        }
        System.out.println();

        s = catnames.substring(6, 12);
        System.out.println(s);
        int s1 = catnames.indexOf('R');
        int s2 = catnames.indexOf('k');
        s = catnames.substring(s1, s2+1);
        System.out.println(s);
        System.out.println(s.toUpperCase());

        String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int STR_LENGTH = 9; // длина генерируемой строки
        Random random = new Random();
        String builder = "";
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder = builder + ch;
        }
        System.out.println(builder);
        String formatString = "We are printing double variable (%f), string ('%s') and integer variable (%d).";
        System.out.println(String.format(formatString, 2.3, "Example", 10));

        String w = "www.mysite.com";
        boolean isContain1 = w.contains("mysite");
        System.out.println(isContain1);

        boolean isContain2 = w.contains("mysite.ru");
        System.out.println(isContain2);
    }
}
