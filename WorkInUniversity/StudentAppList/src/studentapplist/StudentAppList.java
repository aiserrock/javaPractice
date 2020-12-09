/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapplist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lagutina
 */
public class StudentAppList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("Enter data: ");
//        Scanner sc = new Scanner(System.in);
//        String str;
//        str = sc.nextLine();
//        String a[] = str.trim().split(" +");
////        System.out.println(Arrays.toString(a));
//        Student vasya = new Student(a[0]);
//        for(int i=1; i<a.length; i++)
//            vasya.addRating(Integer.parseInt(a[i]));
//        System.out.println(vasya);
//        ArrayList<Integer> arInt = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        String str;
//        str = sc.nextLine();
//        String a[] = str.trim().split(" +");
//        for (int i = 0; i < a.length; i++) {
//            arInt.add(Integer.parseInt(a[i]));
//        }
//        System.out.println(arInt);
//        for(int s=0, i=0;i<arInt.size();i++)
//            s+=arInt.get(i);

        ArrayList<Student> listStud = new ArrayList<>();
        System.out.println("Enter data: ");
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        while (!str.isEmpty()) {
            String a[] = str.trim().split(" +");
            Student t = new Student(a[0]);
            for (int i = 1; i < a.length; i++) {
                t.addRating(Integer.parseInt(a[i]));
            }
            listStud.add(t);
            str = sc.nextLine();
        }
        System.out.println(listStud);
        for(int i=0; i< listStud.size(); i++)
            if(listStud.get(i).getName().equals("Petr"))
                listStud.get(i).addRating(2);
        System.out.println(listStud);
    }

}
