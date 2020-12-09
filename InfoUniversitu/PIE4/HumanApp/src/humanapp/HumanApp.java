/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author student
 */
public class HumanApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader inSchool = new BufferedReader(new FileReader("schoolkid.txt"));
            BufferedReader inStud = new BufferedReader(new FileReader("student.txt"));
            ArrayList<Human> listLearner = new ArrayList<>();
            ArrayList<Schoolkid> listSchool = new ArrayList<>();
            ArrayList<Student> listStud = new ArrayList<>();
            String s;
            while ((s = inSchool.readLine()) != null) {
                String[] a = s.trim().split(" +");
                Schoolkid tmp = new Schoolkid(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]));
                tmp.addPlaceSchool(Integer.parseInt(a[3]));
                tmp.addPlaceDistrict(Integer.parseInt(a[4]));
                tmp.addPlaceRegion(Integer.parseInt(a[5]));
                for (int i = 6; i < a.length; i += 2) {
                    tmp.addSubject(a[i], Integer.parseInt(a[i + 1]));
                }
                listLearner.add(tmp);
                listSchool.add(tmp);
            }
            while ((s = inStud.readLine()) != null) {
                String[] a = s.trim().split(" +");
                Student tmp = new Student(a[0], Integer.parseInt(a[1]));
                tmp.addCourse3(Integer.parseInt(a[2]));
                tmp.addCourse4(Integer.parseInt(a[3]));
                for (int i = 4; i < a.length; i++) {
                    tmp.addRating(Integer.parseInt(a[i]));
                }
                listLearner.add(tmp);
                listStud.add(tmp);
            }
            inSchool.close();
            inStud.close();
            
            ArrayList<Human> listGrant = new ArrayList<>();
            for(Human h: listLearner)
                if(h.isGrant())
                    listGrant.add(h);
            Collections.sort(listGrant);
            System.out.println(listGrant);
            System.out.println(Collections.max(listSchool, new SchoolkidBallComparator()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
