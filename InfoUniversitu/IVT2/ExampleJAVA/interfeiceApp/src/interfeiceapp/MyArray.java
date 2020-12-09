/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfeiceapp;

/**
 *
 * @author nadezhda
 */
public interface MyArray {
    int get(int i);//возвращает элемент по индексу
    int add(int value);//кладет элемент в конец массива возвращает его индекс
    int size();//возвращает размер массива
    void printKonsole();
}
