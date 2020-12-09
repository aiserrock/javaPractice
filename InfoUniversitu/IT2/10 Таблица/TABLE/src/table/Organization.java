/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nadezhda
 */
public class Organization {

    private SimpleStringProperty name;
    private SimpleStringProperty bossName;
    private SimpleIntegerProperty personnel;

    public Organization(String name, String bossName, int personnel) {
        this.name = new SimpleStringProperty(name);
        this.bossName = new SimpleStringProperty(bossName);
        this.personnel = new SimpleIntegerProperty(personnel);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getBossName() {
        return bossName.get();
    }

    public void setBossName(String bossName) {
        this.bossName.set(bossName);
    }

    public int getPersonnel() {
        return personnel.get();
    }

    public void setPersonnel(int personnel) {
        this.personnel.set(personnel);
    }

}
