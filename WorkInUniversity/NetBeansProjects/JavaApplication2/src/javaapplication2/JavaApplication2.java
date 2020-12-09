/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Collections;
public class JavaApplication2 {




    public static void main(String[] args) {
        ArrayList<EmployeeOfAnEnterprise> a = new ArrayList<>();
        EmployeeOfAnEnterprise Ivanov= new EmployeeOfAnEnterprise("Ivanov",15000);
        EmployeeOfAnEnterprise Petrov= new EmployeeOfAnEnterprise("Petrov",12000);
        EmployeeOfAnEnterprise Sidorov= new EmployeeOfAnEnterprise("Sidorov",20000);
        a.add(Sidorov);
        a.add(Petrov);
        a.add(Ivanov);
        System.out.println("salary Ivanov 15 days :"+Ivanov.ProportionSalary(15));
        System.out.println(Collections.min(a));
    }
    
}
