/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplethread;

/**
 *
 * @author nadezhda
 */
class ThreadTest implements Runnable {

    @Override
    public void run() {
        double calc;
        for (int i = 0; i < 50000; i++) {
            calc = Math.sin(i * i);
            if (i % 10000 == 0) {
                System.out.println(Thread.currentThread().getName()
                        + " counts " + i / 10000);
            }
        }
    }
}

public class ExampleThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t[] = new Thread[3];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new ThreadTest(),
                    "Thread " + i);
            t[i].setPriority(Thread.MIN_PRIORITY
                    + (Thread.MAX_PRIORITY
                    - Thread.MIN_PRIORITY) / t.length * i);
        }
        // Запуск потоков
        for (int i = 0; i < t.length; i++) {
            t[i].start();
            System.out.println(t[i].getName() + " started");
        }
    }

}
