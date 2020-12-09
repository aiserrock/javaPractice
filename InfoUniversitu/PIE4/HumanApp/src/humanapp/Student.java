/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanapp;

import java.util.ArrayList;

/**
 *
 * @author lagutina
 */
public class Student extends Human {

    private ArrayList<Integer> rating;
    private int course3 = 0, course4 = 0;
    
    public Student (String name, int age) {
        super(name, age);
        rating = new ArrayList<>();
    }

    public void addRating(int ball) {
        rating.add(ball);
    }

    public void addCourse3(int ball) {
        course3 = ball;
    }

    public void addCourse4(int ball) {
        course4 = ball;
    }

    @Override
    public boolean isGrant() {
        return isGoodRating() && isGoodCourse();
    }

    private boolean isGoodRating() {
        double sum = 0;
        for (int x : rating) {
            sum += x;
        }
        return (sum / rating.size()) >= 4.75;
    }

    private boolean isGoodCourse() {
        return ((course3 == 5 && course4 == 0) || (course3 == 5 && course4 == 5));
    }
    @Override
    public String toString() {
        return super.toString() + " student";
    }
}
