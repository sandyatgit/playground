package com.playground;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest2 {

    public static void main(String... s){
        ForkJoinTest test = new ForkJoinTest();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        //pool.invoke(test.new RecursiveSum(50l));

    }

    class RecursiveSum extends RecursiveTask<Long>{
        long start;
        long end;

        RecursiveSum(long numbers){
            new RecursiveSum(0,numbers,0);
        }
        RecursiveSum(long start, long end, long mid){
            start = start;
            end = end;
        }
        @Override
        public Long compute(){
            long mid = (start + end)/2;
            RecursiveSum r1 = new RecursiveSum(start,end,mid);
            RecursiveSum r2 = new RecursiveSum(start,end,mid);

            return null;
        }
    }
}
