package com.playground;

import java.util.List;

public class TestBed {
    static int[] arr = {1,1,0,1,1,1,0};
    static int[] preSum = new int[arr.length + 1];
    static int[] preSum1 = new int[arr.length];


    public static void main(String[] args) {
        for(int i=1;i<preSum.length;i++) {
            if(arr[i-1] == 1)
                preSum[i] = preSum[i-1] + 1;
            else
                preSum[i] = preSum[i-1];
        }
        System.out.println(howManyOnesInRage(2, 6));

        for(int i=0;i < arr.length;i++){
            if(i ==0){
                preSum1[0] = arr[i];
            }else {
                preSum1[i] = preSum1[i-1]+arr[i];
            }
        }
        System.out.println(preSum1[6]-preSum[2]);
        System.out.println(reverseJustLetters("abcd-EF-ga"));
    }

    private static int howManyOnesInRage(int i, int j) {
        return preSum[j+1] - preSum[i];
    }

    //abcd-EF-gat
    //tbcd-EF-gaa
    //tacd-EF-gba
    //tagd-EF-cba
    //tagd-EF-cba
    //tagF-Ed-cba
    private static String reverseJustLetters(String s){
            int i =0;
            int j = s.length()-1;
            char[] d = new char[j+1];
            while(i<=j){
                if(s.charAt(i) == '-'){
                    d[i++] = '-';
                }else if(s.charAt(j) == '-'){
                    d[j--] = '-';
                }else{
                    d[i]= s.charAt(j);
                    d[j]=s.charAt(i);
                    i++;
                    j--;
                }
            }
            return new String(d);

    }



}
