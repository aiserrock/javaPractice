/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Zaikin
 */
public class EmployeeOfAnEnterprise  implements Comparable<EmployeeOfAnEnterprise>{
   private String name = new String();
   private double salary=0;
   
    public EmployeeOfAnEnterprise () {
    }
    
    public EmployeeOfAnEnterprise (EmployeeOfAnEnterprise e) {
        salary = e.salary;
        name = new String(e.name);
    }
    public EmployeeOfAnEnterprise(String name, double salary) {
        this.salary = salary;//oklad
        this.name = name;
    }
    @Override
    public String toString() {
        return new String("name :"+name +", salary :"+salary);
    }
    public String getName() {
        return new String(name);
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double ProportionSalary(int day){
        return (double)day/22*salary;
    }

    @Override
    public int compareTo(EmployeeOfAnEnterprise o) {
       return (int) Math.signum(salary-o.salary);
    }
    
    
}
