/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodeldialogclass;

import java.time.LocalDate;

/**
 *
 * @author nadezhda
 */
public class Organization {

    private String name;
    private String  subject1;
    private String  subject2;
    private String subject3;
    private String status;

    public Organization(String name, String subject1, String subject2, String subject3) {
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public String getName() {
        return name;
    }

    public String getSubject1() {
        return subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    private int getSumm() {
        return Integer.parseInt(subject1)+Integer.parseInt(subject2)+Integer.parseInt(subject3);
    }

    public String getStatus(){
        if(getSumm()>233){
            status="Вы можете пройти на все направления";
        }else{
            if((getSumm()<234) && (getSumm()>209)){
                status="Вы можете пройти на Прикладной мыслитель и Кабалистика и ворожба";
            }else{
                if((getSumm()<210)&&(getSumm()>202)){
                    status="Вы можете пройти на Кабалистика и ворожба";
                }else{
                    status="Вы никуда не проходите";
                }
            }
        }
        return status;
    }

}
