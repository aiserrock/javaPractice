/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paramtypeexample;

/**
 *
 * @author nadezhda
 */
class ExampleParam<T, V> {
    T ob1;
    V ob2;
    
    ExampleParam(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }
    
    void showTypes() {
        System.out.println("Тип T: " + ob1.getClass().getName());
        System.out.println("Тип V: " + ob2.getClass().getName());
    }
    
    T getob1() {
        return ob1;
    }
    
    V getob2() {
        return ob2;
    }
    
}
public class ParamTypeExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    ExampleParam<Integer, String> exampleParamObj = new ExampleParam<>(25, "Текст");
    
    exampleParamObj.showTypes();

    int value = exampleParamObj.getob1();
    System.out.println("Значение: " + value);
    
    String str = exampleParamObj.getob2();
    System.out.println("Значение: " + str);
    }
    
}
