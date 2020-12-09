/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanapp;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author student
 */
public class Schoolkid extends Human {

    class Subject {

        public String name;
        public int ball;

        public Subject(String name, int ball) {
            this.name = name;
            this.ball = ball;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Subject)) {
                return false;
            }
            Subject tmp = (Subject) o;
            return name.equals(tmp.name) && ball == tmp.ball;
        }
    }

    private ArrayList<Subject> sub;
    private int placeS, placeD, placeR, numSch;

    public Schoolkid(String name, int age, int numSch) {
        super(name, age);
        sub = new ArrayList<>();
        placeS = placeD = placeR = -1;
        this.numSch = numSch;
    }

    public void addSubject(String name, int ball) {
        sub.add(new Subject(name, ball));
    }

    public void addPlaceSchool(int p) {
        placeS = p;
    }

    public void addPlaceDistrict(int p) {
        placeD = p;
    }

    public void addPlaceRegion(int p) {
        placeR = p;
    }

    @Override
    public boolean isGrant() {
//        if (isGoodRating() && isOlimp() && isСertainSub()) {
//            return true;
//        }
//        return false;
        return isGoodRating() && isOlimp() && isСertainSub();
    }

    private boolean isGoodRating() {
        for (Subject s : sub) {
            if (s.ball < 4) {
                return false;
            }
        }
        return true;
    }

    private boolean isOlimp() {
        if ((placeR >= 0) || (placeD >= 3) || (placeS == 1)) {
            return true;
        }
        return false;
    }

    private boolean isСertainSub() {
        if (!sub.contains(new Subject("Math", 5))) {
            return false;
        }
        if (!sub.contains(new Subject("RusLan", 5))) {
            return false;
        }
        if (!sub.contains(new Subject("History", 5))) {
            return false;
        }
        if (!sub.contains(new Subject("EnglLan", 5))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " schoolkid";
    }

    public double midBall() {
        double m = 0;
        for (Subject s : sub) {
            m += s.ball;
        }
        return m / sub.size();
    }
}

class SchoolkidBallComparator implements Comparator<Schoolkid> {

    public int compare(Schoolkid s1, Schoolkid s2) {
        if (s1.midBall() < s2.midBall()) {
            return -1;
        }
        if (s1.midBall() > s2.midBall()) {
            return 1;
        }
        return 0;
    }
}
