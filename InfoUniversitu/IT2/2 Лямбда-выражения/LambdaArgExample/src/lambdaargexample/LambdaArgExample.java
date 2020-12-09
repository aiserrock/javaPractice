/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaargexample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author nadezhda
 */
interface NumberTest {

    boolean test(int n);
}

interface Test<T> {

    boolean test(T n);
}

public class LambdaArgExample {

    /**
     * @param args the command line arguments
     *
     * public static void printStr(int n, NumberTest flag, String ms) { if
     * (flag.test(n)) { System.out.println(n + " " + ms); } else {
     * System.out.println(n + " non-" + ms); } }
     */
    public static void printStr(int n, Test<Integer> flag, String ms) {
        if (flag.test(n)) {
            System.out.println(n + " " + ms);
        } else {
            System.out.println(n + " non-" + ms);
        }
    }

    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        printStr(153, (n) -> {
            int st = 0, x = n, a = 0;
            while (x > 0) {
                x = x / 10;
                st++;
            }
            x = n;
            while (x > 0) {
                a += (int) Math.pow(x % 10, st);
                x = x / 10;
            }
            return a == n;
        }, "pluperfect digital invariant");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sumAll(numbers, n -> true));
        System.out.println(sumAll(numbers, n -> n % 2 == 0));
        System.out.println(sumAll(numbers, n -> n > 3));
    }

}
