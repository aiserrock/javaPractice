package sample;

import javafx.beans.property.*;

import java.util.*;

public class Model {
    private StringProperty namePerson;

    public StringProperty namePersonStringProperty() {
        if (namePerson == null) {
            namePerson = new SimpleStringProperty();
        }
        return namePerson;
    }

    public final void setNamePerson(String value) {
        namePersonStringProperty().set(value);
    }

    public final String getNamePerson() {
        return namePersonStringProperty().get();
    }

    private IntegerProperty personAge;

    public IntegerProperty personAgeIntegerProperty() {
        if (personAge == null) {
            personAge = new SimpleIntegerProperty();
        }
        return personAge;
    }
    public final void setPersonAge(Integer value) {
        personAgeIntegerProperty().set(value);
    }

    public final Integer getPersonAge() {
        return personAgeIntegerProperty().get();
    }

    private StringProperty status;

    public StringProperty WhatStatus() {

        if(personAge.get() < 12){
            status = new SimpleStringProperty("Детство");
        }
        if(personAge.get() > 11 && personAge.get() < 20){
            status = new SimpleStringProperty("Юношество");
        }
        if(personAge.getValue().compareTo(Integer.valueOf(36))<0 && personAge.getValue().compareTo(Integer.valueOf(19))>0){
            status = new SimpleStringProperty("Молодость");
        }
        if(personAge.getValue().compareTo(Integer.valueOf(35))>0){
            status = new SimpleStringProperty("Зрелость");
        }
        return status;
    }

    public final String getStatus() {
        return WhatStatus().get();
    }

    public Model(String namePerson, int personAge,String status){
        setNamePerson(namePerson);
        setPersonAge(personAge);
    }

}
