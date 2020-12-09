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
        WhatStatus();
    }

    public final Integer getPersonAge() {
        return personAgeIntegerProperty().get();
    }

    private StringProperty status = new SimpleStringProperty();

    private StringProperty WhatStatus() {

        if(personAge.get() < 12){
            status.set("Детство");
        }
        if(personAge.get() > 11 && personAge.get() < 20){
            status.set("Юношество");
        }
        if(personAge.get() > 19 && personAge.get() < 36){
            status.set("Молодость");
        }
        if(personAge.get() > 35){
            status.set("Зрелость");
        }
        return status;
    }

    public final StringProperty getStatus() {
        return status;
    }


    private IntegerProperty person$;

    public IntegerProperty person$IntegerProperty() {
        if (person$ == null) {
            person$ = new SimpleIntegerProperty();
        }
        return person$;
    }
    public final void setPerson$(Integer value) {
        int old = person$IntegerProperty().get();
        person$IntegerProperty().set(value.intValue()+old);
        WhatStatus$();
    }

    public final Integer getPerson$() {
        return person$IntegerProperty().get();
    }


    private StringProperty status$ = new SimpleStringProperty();

    private StringProperty WhatStatus$() {

        if(person$.get() < 0){
            status$.set("bankrupt");
        }
        if(person$.get() > 0 && person$.get() < 100){
            status$.set("poorMan");
        }
        if(person$.get() > 100 && person$.get() < 1000){
            status$.set("sufficiency");
        }
        if(person$.get() > 1000 && person$.get() < 100000){
            status$.set("middleClass");
        }
        if(person$.get() > 1000000 && person$.get() < 200000){
            status$.set("millionaire");
        }
        if(person$.get() > 2000000 && person$.get() < 1000000000){
            status$.set("multiMillionaire");
        }
        if(person$.get() > 1000000000){
            status$.set("billionaire");
        }
        return status$;
    }

    public final StringProperty getStatus$() {
        return status$;
    }

    public Model(String namePerson, int personAge,int person$){
        setNamePerson(namePerson);
        setPersonAge(personAge);
        setPerson$(person$);
    }

}
