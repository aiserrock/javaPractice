/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplethreaddaemon;

/**
 *
 * @author nadezhda
 */
class ThreadTest implements Runnable {

    public final static ThreadGroup GROUP = new ThreadGroup("Daemon demo");
    private int start;

    public ThreadTest(int s) {
        start = (s % 2 == 0) ? s : s + 1;
        new Thread(GROUP, this, "Thread " + start).start();
        System.out.println("Thread " + start + " started");
    }

    @Override
    public void run() {
        for (int i = start; i > 0; i--) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }

            if (start > 2 && i == start / 2) {
                new ThreadTest(i);
            }
        }
    }
}

class DaemonDemo extends Thread {

    public DaemonDemo() {
        super("Daemon demo thread");
        setDaemon(true);
        start();
    }

    public void run() {
        Thread threads[] = new Thread[10];
        while (true) {
            int count = ThreadTest.GROUP.activeCount();
            if (threads.length < count) {
                threads = new Thread[count + 10];
            }
            count = ThreadTest.GROUP.enumerate(threads);

            System.out.println("Daemon");
            for (int i = 0; i < count; i++) {
                System.out.print(threads[i].getName() + ", ");
            }
            System.out.println();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class ExampleThreadDaemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ThreadTest(16);
        new DaemonDemo();
    }

}
