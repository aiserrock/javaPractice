/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentexceptionapp;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author пользователь
 */
public class Student implements Comparable<Student>{
    String name;
    ArrayList<Integer> rating;
    
    Student() {
        name = "Vasya Petrov";
        rating = new ArrayList<Integer>();
        rating.add(4);
        rating.add(4);
        rating.add(4);
    }
    
    Student(String name1, String name2, int []rating) throws Exception {
        name = name1+" "+name2;
        this.rating = new ArrayList<Integer>();
        for(int x:rating)
            if(x>=2 && x<=5)
                this.rating.add(x);
        else
                throw new Exception("Rating error");
    }
    
    Student(String name1, String name2) {
        name = name1+" "+name2;
        this.rating = new ArrayList<Integer>();
    }
    
    Student (Student st) {
        name = st.name;
        rating = new ArrayList<Integer>();
        rating.addAll(st.rating);
    }
    
    public String getName() {
        return new String(name);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addBall(int x) throws Exception {
        if(x>=2 && x<=5)
                rating.add(x);
        else
                throw new Exception("Ball error");
        
    }
    
    public double meanBall() {
        if(rating.size()==0)
            return 0;
        double m=0;
        for(int x:rating)
            m+=x;
        return m/rating.size();
    }
    
    private boolean isExcellence () {
        for(int x:rating)
            if(x!=5 && x!=0)
                return false;
        return true;
    }
    private boolean isLooser () {
        for(int x:rating)
            if(x==2)
                return true;
        return false;
    }
    @Override
    public String toString () {
        if(isExcellence())
            return name +" is Excellence";
        if(isLooser())
            return name + " is Looser";
        return name + " is Normal";
    }
    
    @Override
    public int compareTo(Student t) {
        String s1 = name.split(" +")[1]+" "+name.split(" +")[0];
        String s2 = t.name.split(" +")[1]+" "+t.name.split(" +")[0];
        return s1.compareTo(s2);
    }
    
    @Override
    public boolean equals(Object t) {
        if(!(t instanceof Student))
            return false;
        if(((Student)t).name.equals(name))
            return true;
//        if(((Student)t).compareTo(this)==0)
//            return true;
        return false;
    }
    
}

class StudentBallComparator implements Comparator<Student> {
    @Override
    public int compare(Student t1, Student t2) {
        return (int)Math.signum(t1.meanBall() - t2.meanBall());
    }
}

