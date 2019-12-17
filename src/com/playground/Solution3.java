package com.playground;

import java.util.Arrays;

public class Solution3 {
    public static void main(String... s){
       System.out.println(new Solution3().getPermutation(3,7));
    }
    public String getPermutation(int n, int k) {
        char[] c = createCharArray(n);
        permute(c,n,k,0,0);
        return String.valueOf(c);
    }

    private char[] createCharArray(int n){
        char[] str = new char[n];
        for(int i=0,j=1; i< n; i++,j++){
            str[i] = (char)(j+'0');
        }
        return str;
    }
    private int permute(char[] c, int n, int k, int sIndex, int count){
        if(sIndex == n){
            //create string
            System.out.println(++count  + " " + Arrays.toString(c));
            return count;
        }
        for(int i = sIndex; i< c.length ; i++){
            swap(c,i,sIndex);
            count = permute(c,n,k,sIndex+1,count);
            if(count == k){
                break;
            }
            swap(c,i,sIndex);
        }
        return count;
    }

    private void swap(char[] c, int i, int j){
        if(i == j){
            return;
        }
        char tmp = c[j];
        c[j] = c[i];
        c[i] = tmp;
    }

}
