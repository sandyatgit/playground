package com.playground;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MultiThreadedExample1 {

    public static void main(String... s){
        Executor executor = Executors.newFixedThreadPool(3);
        PrintThreads t = null;
        for(int i=1; i<= 3; i++){
            t = new MultiThreadedExample1().new PrintThreads(i);
            executor.execute(t);
        }
    }


        public MultiThreadedExample1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

        class PrintThreads implements Runnable{
            private int name;

            private PrintThreads(int i){
                name = i;
            }

            public void run(){
                System.out.println(name);
            }
        }
    }

