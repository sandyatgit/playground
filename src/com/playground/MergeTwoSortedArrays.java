package com.playground;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String... s){
       // int[] a = {1,5,6,7,9,11,0,0,0,0,0};
        //int[] b = {2,4,6,9,13};


        //int[] a = {11,15,16,17,19,21,0,0,0,0,0};
        //int[] b = {2,4,6,9,13};

        int[] a = {91,92,93,420,421,423,0,0,0,0,0};
        int[] b = {11,12,13,19,419};


        //int[] a = {11,15,16,17,19,21};
        //int[] b = {2,4,6,9,13};
        //Arrays.stream(new MergeTwoSortedArrays().mergeTwoSortedArrays(a,b)).forEach(System.out::println);
        //Arrays.stream(new MergeTwoSortedArrays().mergeTwoSortedArraysInPlace(a,6,b,5)).forEach(System.out::println);

    }


    public void merge(int[] a, int m, int[] b, int n) {
        int i = n-1;
        int j = m-1;
        int count = a.length;
        while(i>=0 && j >=0){
            if(b[i] >= a[j]){
                a[--count] = b[i];
                i--;
            }else{
                a[--count] = a[j];
                j--;
            }
        }
        if(i >= 0){
            while(i >= 0){
                a[--count] = b[i--];
            }
        }
        if(j >= 0){
            while(j >= 0){
                a[--count] = a[j--];
            }
        }
    }


    private int[] mergeTwoSortedArrays(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int count = (a.length+b.length)-1;
        int i = b.length-1;
        int j = a.length-1;
        while(i>=0 && j >=0){

            if(b[i] >= a[j]){
                c[count]=b[i];
                i--;
            }else{
                c[count]=a[j];
                j--;
            }
            count--;
        }
        if(i >=0 ){
            while( i >= 0 && count >= 0){
                c[count--]=b[i--];
            }

        }else if(j >=0 ){
            while( j >= 0 && count >= 0){
                c[count--]=a[j--];
            }
        }

        return c;
    }


    /*private int[] mergeTwoSortedArrays(int[] a , int[] b){
        if(a.length == 0){
            return b;
        }
        if(b.length == 0){
            return a;
        }
        int[] c = new int[a.length+b.length];
        int aindex =0;
        int bindex =0;

        int counter = -1;
        if(b[bindex] > a[aindex]){
            c[++counter] = a[aindex];
        }

        while(true){
            if(bindex >= b.length){
                if(aindex >= a.length){
                    break;
                }else{
                    int start = aindex+1;
                    for(int i = start; i< a.length; i++){
                        c[++counter] = a[i];
                    }
                    break;
                }
            }else if(aindex >= a.length){
                if(bindex >= b.length){
                    break;
                }else{
                    for(int i = bindex; i< b.length; i++){
                        c[++counter] = b[i];
                    }
                    break;
                }
            }
            if(b[bindex] <= a[aindex]){
                c[++counter] = b[bindex];
                bindex++;
                continue;
            }
            if((b[bindex] > a[aindex]) && aindex == a.length-1){

                c[++counter] = b[bindex];
                bindex++;
                continue;
            }
            if((b[bindex] > a[aindex]) && (b[bindex]<=a[aindex + 1])){

                c[++counter] = b[bindex];
                bindex++;
                continue;
            }
            aindex++;
            c[++counter] = a[aindex];
        }

return c;

    }*/
}
