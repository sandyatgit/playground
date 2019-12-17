package com.playground;

public class RecursionTest {

    public static void main(String... s){
        System.out.println(findPowerOf(4,4,0,1));
        System.out.println(elegantFindPowerOf(4,4));
        System.out.println(fibonnaciSeries(7, 1,1,0));
    }

    private static int findPowerOf(int base, int powerOf, int currCount, int total){
        currCount++;
        if(currCount > powerOf){
            return total;
        }
        return findPowerOf(base,powerOf,currCount,base*total);
    }

    private static int elegantFindPowerOf(int base, int powerOf){
        if(powerOf ==0){
            return 1;
        }
        return base * elegantFindPowerOf(base,powerOf-1);
    }

    private static int fibonnaciSeries(int n, int total, int currCount, int prevTotal){
        if(currCount == n ){
            return total;
        }
        System.out.print(total);
        int tmp = total;
        total  = total+prevTotal;
        prevTotal=tmp;
        return fibonnaciSeries(n,total, ++currCount,prevTotal);
    }
}
