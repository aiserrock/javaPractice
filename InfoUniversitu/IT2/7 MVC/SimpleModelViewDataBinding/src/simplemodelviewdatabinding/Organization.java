/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodelviewdatabinding;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
    private StringProperty drinkVolumeString;
    public StringProperty drinkVolumeStringProperty() {
        if (drinkVolumeString == null) {
            drinkVolumeString = new SimpleStringProperty();
        }
        return drinkVolumeString;
    }
    public final void setDrinkVolumeString(String value) {
        drinkVolumeStringProperty().set(value);
    }

    public final String getDrinkVolumeString() {
        return drinkVolumeStringProperty().get();
    }
    
    public Organization(String name, int personnel, String holiday, LocalDate date, double drinkVolume){
        this.name = name;
        this.personnel =personnel;
        this.holiday = holiday;
        this.date = date;
this.drinkVolume = drinkVolume;
        setDrinkVolumeString(Double.toString(drinkVolume));
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
    public void increaseDrinkVolume() {
        drinkVolume++;
        setDrinkVolumeString(Double.toString(drinkVolume));
    }
    
}
