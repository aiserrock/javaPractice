package lab_6exceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab_6exceptions 
{

    public static void main(String[] args) 
    {
        String name;
        int age, mark_rus, mark_math, olymp_city, olymp_region;
        Student st;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
       while(sc.hasNextLine())
       {
           name = sc.nextLine();
           
           if("exit".equals(name.toLowerCase()))
               break;
           
           if(sc.hasNextInt())
            age = sc.nextInt();
           else
               age = 0;
          if(sc.hasNextInt())
            mark_rus = sc.nextInt();
          else
              mark_rus = 0;
          if(sc.hasNextInt())
             mark_math = sc.nextInt();
          else
             mark_math = 0;
          if(sc.hasNextInt())
            olymp_city = sc.nextInt();
          else
              olymp_city = 0;
          if(sc.hasNextInt())
            olymp_region = sc.nextInt();
          else
              olymp_region = 0;
           
           try{
           st = new Student(name, age, mark_rus, mark_math, olymp_city, olymp_region);
           if(st.isGood())
               students.add(st);
           }
           catch(Exception e){
               System.out.println(e);
               return;
           }
           name = sc.nextLine();
       }
       
       System.out.println(students);
        
    }
    
}
