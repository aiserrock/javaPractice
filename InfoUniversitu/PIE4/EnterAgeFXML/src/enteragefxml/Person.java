/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteragefxml;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author local
 */
public class Person {
    
    private String name;

    public String getName() {
        return name;
    }
    
    public void setName(String name) throws Exception {
        if(!name.matches("[А-Я][а-я]*"))
            throw new Exception("Ошибка ввода имени");
        this.name = name;
    }
    private int age;

    public int getAge() {
        return age;
    }
    
    public void setAge(String year) throws Exception{
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        if (year.matches("[0-9]+")) {
            age = calendar.get(Calendar.YEAR) - Integer.parseInt(year);
        } else
             throw new Exception("Ошибка ввода года рождения");
    }
    
    public Person() {
        name="";
        age=0;
    }
    
    public Person(String name, String year) throws Exception{
        if(!name.matches("[А-Я][а-я]*"))
            throw new Exception("Ошибка ввода имени");
        this.name = name;
        setAge(year);
    }
    
    public String getStatus(){
        if(age<12) 
            return name+": Детство";
        if(age<20)
            return name+": Юность";
        if(age<36)
            return name+": Молодость";
        return "Зрелость";
                 
    }
    
}
