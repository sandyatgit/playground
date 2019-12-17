package com.playground;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class Mulithreading {
    static Mulithreading inst = new Mulithreading();

    public static void main(String... s){
        Map<Integer,String> source = new HashMap<>();
        Producer produce = inst.new Producer<Integer,String>(source);
        Consumer consume = inst.new Consumer<Integer,String>(source);


        ExecutorService executors = Executors.newFixedThreadPool(10);

        Runnable task1 = () ->{
            IntStream.range(1,10).forEach(x -> produce.produce(x,x+"|thread1"));
        };

        Runnable task2 = new Runnable(){
            @Override
            public void run() {
                IntStream.range(1,10).forEach(x -> produce.produce(x,x+"|thread2"));
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                consume.consume();
            }
        };

        Callable<Boolean> call1 = () -> {
            IntStream.range(1,10).forEach(x -> produce.produce(x,x+"|thread1"));
            return true;
        };

        Callable<Boolean> call2 = () -> {
            IntStream.range(1,20).forEach(x -> produce.produce(x,x+"|thread2"));
            return true;
        };

        Callable<Boolean> call3 = () -> {
            consume.consume();
            return true;
        };

        try{
            executors.invokeAll(Arrays.asList(call1,call2,call3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //executors.submit(task1);
        //executors.submit(task2);
        //executors.submit(task3);

        executors.shutdown();



    }



    class Producer<K,V>{
        Map<K,V> source = null;
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Producer(Map<K,V> source){
            this.source = source;
        }

        public void produce(K key, V data){
            Lock wLock = lock.writeLock();
            wLock.lock();
            try{
                System.out.println("to be produced. key = "+key+" value = "+ data);
                source.put(key,data);
            }finally{
                wLock.unlock();
            }
        }

    }

    class Consumer<K,V>{
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Map<K,V> source = null;
        Consumer(Map<K,V> source){
            this.source = source;
        }

        public void consume(){
            int count = 0;
            Lock rLock = lock.readLock();
            try {

                while(count < 2){
                    rLock.lock();
                    Iterator itr  = source.keySet().iterator();
                    while (itr.hasNext()) {
                        K d = (K)itr.next();
                        System.out.println("consumed data . key = "+d+" value = "+ source.get(d));
                    }
                    count++;
                    rLock.unlock();
                    Thread.sleep(1000);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                rLock.unlock();
            }



        }



    }
}
