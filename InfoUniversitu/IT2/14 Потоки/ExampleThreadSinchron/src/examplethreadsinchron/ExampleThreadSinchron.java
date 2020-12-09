/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplethreadsinchron;

/**
 *
 * @author nadezhda
 */

//class CommonResource{
//     
//    int x=1;
//}

class CommonResource{
     
    int x=1;
    synchronized void increment(){
        for (int i = 1; i < 5; i++){
            System.out.printf("%s \t x = %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}

class CountThread implements Runnable{
 
    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }
    public void run(){
//        for (int i = 1; i < 5; i++){
//            System.out.printf("%s \t x = %d \n", Thread.currentThread().getName(), res.x);
//            res.x++;
//            try{
//                Thread.sleep(2000);
//            }
//            catch(InterruptedException e){}
//        }
        res.increment();
    }
}

public class ExampleThreadSinchron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 4; i++){
             
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Поток "+ i);
            t.start();
        }
    }
    
}
