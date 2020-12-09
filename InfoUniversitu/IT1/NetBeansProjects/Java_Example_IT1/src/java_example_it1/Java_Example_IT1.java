package java_example_it1;

import java.util.Random;


public class Java_Example_IT1 {

    public static void main(String[] args) 
    {
        Multiplication.table();
        String str[] = {"Обезьяна", "Курица", "Собака", "Свинья", "Крыса", 
            "Корова", "Тигр", "Заяц", "Дракон", "Змея", "Лошадь", "Овца"};
        
        int x = 2012;
        
        System.out.println(str[x % 12]);
    }
}

class Multiplication{
    public static void table()
    {
        int i, j;
        
        
        System.out.print("    ");
        for(i = 1; i < 10; i++)
            System.out.format("%4d", i);
        System.out.println("\n");
        
        for(i = 1; i < 10; i++)
        {
            System.out.format("%3d  ", i);
            for(j = 1; j < 10; j++)
                System.out.format("%3d ", i * j);
            System.out.println();
        }
    }
}