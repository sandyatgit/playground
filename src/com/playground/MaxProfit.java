package com.playground;

public class MaxProfit {
    public static void main(String... s) {
       // long[] data = new long[]{6,1,1000,0,-1,10000,0,100,3,74,-1,10};
        long[] data = new long[]{-1,-100,-99,0,1,-1,-4};

        System.out.println(new MaxProfit().efficientSolution(data));
    }

    public static long solution(long[] a) {
        if(a.length < 1){
            return 0;
        }
        long maxProfit = -99999;
        for(int i=0; i < a.length; i++){
            for(int j=i+1; j < a.length; j++){
                if((a[j] - a[i]) > maxProfit){
                    maxProfit = a[j] - a[i];
                }
            }
        }
        return maxProfit;
    }

    public static long efficientSolution(long[] a) {
        if(a.length < 1){
            return 0;
        }
        long maxProfit = 0;
        int minIndex = -1;

        for(int i=0; i < a.length; i++){
            if(i==0){
                minIndex =i;
                maxProfit = i-i;
                continue;
            }
            if((a[i] - a[minIndex]) > maxProfit){
                maxProfit = (a[i] - a[minIndex]);
            }else if(a[i] < a[minIndex]){
                minIndex = i;
            }

        }
        return maxProfit;
    }
}
