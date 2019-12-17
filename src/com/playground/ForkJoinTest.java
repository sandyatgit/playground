package com.playground;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {



    public static void main(String... s){
        ForkJoinTest test = new ForkJoinTest();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(test.new PowerOf(7,4));

    }


    class PowerOf extends RecursiveTask<Long>{
        int powerOf ;
        int base;



        PowerOf(int powerOf, int base){
           this.powerOf = powerOf;
           this.base = base;
        }

        @Override
        protected Long compute() {
            if(powerOf <=  base){
                int count = 0;
                int data =1 ;
                while(count == powerOf){
                    data = data*base;
                    count++;
                }
                return (long)base*base;
            }else{

               PowerOf p1= new PowerOf(powerOf/base,base);
               PowerOf p2= new PowerOf(powerOf/base,base);
               ForkJoinTask.invokeAll(p1,p2);
                long data =  p1.join()*p2.join();
                System.out.println("**************************");
                System.out.println("p1.powerOf = " +p1.powerOf);
                System.out.println("p2.powerOf = " +p1.powerOf);
                System.out.println("combined Data  = "+ data);
                System.out.println("Thread Id  = "+ Thread.currentThread().getId());
                System.out.println("**************************");
                return data;
            }
        }
    }

}
