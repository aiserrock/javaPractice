/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfeiceapp;

/**
 *
 * @author nadezhda
 */
public class Array implements MyArray {
    int[] array = new int[100];
    int size = 0;//количество использованных элементов
    @Override
    public int get(int i) {
        return array[i];
    }

    @Override
    public int add(int value) {
       array[size] = value;
        size++;
        if(size==array.length){//если массив закончился
            int[] temparray = new int[size * 2];
            for(int i = 0; i < size;i++){
                temparray[i] = array[i];
            }
            array = temparray;
        }
        return size-1;
    }

    @Override
    public int size() {
        return size;
    }
    @Override 
    public void printKonsole(){
        System.out.println("Array");
        for(int i = 0; i < size;i++)
            System.out.print(array[i]);
        System.out.println();
    }
}
