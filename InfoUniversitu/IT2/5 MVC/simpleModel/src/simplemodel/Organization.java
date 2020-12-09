/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodel;

import java.time.LocalDate;

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
    
    public Organization(String name, int personnel, String holiday, LocalDate date, double drinkVolume){
        this.name = name;
        this.personnel =personnel;
        this.holiday = holiday;
        this.date = date;
        this.drinkVolume = drinkVolume;
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
    }
    
}
