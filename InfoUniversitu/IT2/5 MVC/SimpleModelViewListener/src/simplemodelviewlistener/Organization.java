/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodelviewlistener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author nadezhda
 */
public class Organization {
    private String name;
    private int personnel;
    private String holiday;
    private LocalDate date;
    private double drinkVolume;
    private ArrayList<Listener> listeners;
    
    public Organization(String name, int personnel, String holiday, LocalDate date, double drinkVolume){
        this.name = name;
        this.personnel =personnel;
        this.holiday = holiday;
        this.date = date;
        this.drinkVolume = drinkVolume;
        listeners = new ArrayList<Listener>();
    }
    public String getName() {
        return name;
    }
    public int getPersonnel(){
        return personnel;
    }
    public String getHoliday() {
        return holiday;
    }
    public LocalDate getDate () {
        return date;
    }
    public double getDrinkVolume() {
        return drinkVolume;
    }
    public void increaseDrinkVolume() {
        drinkVolume++;
        fire();
    }
    void addListener(Listener l) {
    listeners.add(l);
    }
    void deleteListener(Listener l) {
        Iterator<Listener> iter = listeners.iterator();
        while (iter.hasNext()) {
            Listener e = iter.next(); 
            if (e.equals(l)) {
                    iter.remove();
            }
        }
    }

    void fire() {
        for(Listener l: listeners)
            l.dataChanged();
    }
    
}
