/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodelviewdatabinding;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nadezhda
 */
public class Organization {
    private StringProperty name;
    
    public StringProperty nameStringProperty() {
        if (name == null) {
            name = new SimpleStringProperty();
        }
        return name;
    }
    
    public final void setName(String value) {
        nameStringProperty().set(value);
    }

    public final String getName() {
        return nameStringProperty().get();
    }
    
    private int personnel;
    private String holiday;
    private LocalDate date;
    private DoubleProperty drinkVolume;

    public DoubleProperty drinkVolumeProperty() {
        if (drinkVolume == null) {
            drinkVolume = new SimpleDoubleProperty();
        }
        return drinkVolume;
    }
    public final void setDrinkVolume(Double value) {
        drinkVolumeProperty().set(value);
    }

    public final Double getDrinkVolume() {
        return drinkVolumeProperty().get();
    }
    
    public Organization(String name, int personnel, String holiday, LocalDate date, double drinkVolume){
        setName(name);
        this.personnel =personnel;
        this.holiday = holiday;
        this.date = date;
        setDrinkVolume(drinkVolume);
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
}
