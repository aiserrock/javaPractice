/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapiexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author nadezhda
 */
public class StreamApiExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String data = "Contains the collections framework, legacy collection classes, event model, date and time facilities, internationalization, and miscellaneous utility classes";
        Stream<String> streamStr = Arrays.stream(data.split("[, ]+"));
        long r = streamStr.filter(s -> s.startsWith("c")).count();
        System.out.println(r);
        System.out.println(Arrays.stream(data.split("[, ]+")).filter(s -> s.startsWith("c")).count());

        ArrayList<Integer> testValues = new ArrayList();
        testValues.add(15);
        testValues.add(1);
        testValues.add(2);
        testValues.add(100);
        testValues.add(50);

        Optional<Integer> maxValue = testValues.stream().max(Integer::compareTo);
        System.out.println("MaxValue = " + maxValue.get());
        Optional<Integer> minValue = testValues.stream().min(Integer::compareTo);
        System.out.println("MinValue = " + minValue.get());

        Optional<Integer> maxValueOdd = testValues.stream().filter(p -> p % 2 != 0).max(Integer::compareTo);
        System.out.println("maxValueOdd = " + maxValueOdd.get());

        List<String> collection = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        System.out.println();
        collection.stream().map(String::toUpperCase).peek((e)
                -> System.out.print("," + e)).collect(Collectors.toList());
        System.out.println();
        
        List<String> newCollection =  collection.stream().filter(p->p.length()<4).collect(Collectors.toList());
        System.out.println(newCollection);

        data = "1 2 3 4 5 6 7 8 9";
        System.out.println("Rezult = " + Arrays.stream(data.split("[ ]+")).map(s -> Integer.parseInt(s))
                .filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0));

        /* 
        Stream<String> streamNumData = Arrays.stream(data.split("[ ]+"));
        Stream<Integer> streamNum = streamNumData.map(s -> Integer.parseInt(s));
        Integer sumOdd = streamNum.filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println("sumOdd = " + sumOdd);
         */
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Петров", 31, Person.Sex.MAN));
        people.add(new Person("Иванов", 45, Person.Sex.MAN));
        people.add(new Person("Смирнов", 20, Person.Sex.MAN));

        System.out.println("Name = " + people.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).get().getName());

        people.stream().sorted().forEach((p) -> System.out.print(" " + p));
        System.out.println();

        System.out.println(people.stream().filter((p) -> p.getAge() >= 18)
                .filter((p) -> (p.getSex() == Person.Sex.WOMEN && p.getAge() < 55)
                || (p.getSex() == Person.Sex.MAN && p.getAge() < 60)).count());
    }

}
