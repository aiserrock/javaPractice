package lab_6exceptions;

import static java.lang.System.arraycopy;

public class Student 
{
    //fields
    private String name;
    private int age;
    private int mark_rus, mark_math;
    private int olymp_city, olymp_region;
    
    //constructors
    public Student()
    {
        name = null;
        age = 0;
        mark_rus = 0;
        mark_math = 0;
        olymp_city = 0;
        olymp_region = 0;
    }
    
    public Student(String name, int age, int mark_rus, int mark_math, int olymp_city, int olymp_region) throws Exception
    {
        if(name.matches("[A-Z][a-z]*"))
            this.name = name;
        else throw new Exception(name);
        
        if(age > 0)
            this.age = age;
        else throw new Exception("Incorrect age");
        
        if(mark_rus < 2 || mark_math < 2 || mark_rus > 5 || mark_math > 5)
            throw new Exception("Incorrect mark(s)");
        else
        {
            this.mark_math = mark_math;
            this.mark_rus = mark_rus;
        }
        
        if(olymp_city < 0 || olymp_region < 0)
            throw new Exception("Incorrect place");
        else
        {
            this.olymp_city = olymp_city;
            this.olymp_region = olymp_region;
        }
    }
    //methods
    @Override
    public String toString()
    {
        return name;
    }
    
    public boolean isGood()
    {
        return mark_rus == 5 && mark_math == 5 && ((olymp_city != 0 && olymp_city < 4) || olymp_region != 0);
    }
 }
