package com.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FriendsRequest {
    public static void main(String... s){
        System.out.println(new FriendsRequest().numFriendRequests(new int[]{20,30,100,110,120}));
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        Map<Integer,Integer> reqs = new HashMap<>();
        for(int i=0;i<ages.length;i++){
            int A = ages[i];
            float magicNumberA = (A/2.0f)+7;
            int j = binarySearch(magicNumberA,ages,i);
            reqs.put(A,(i-j));
        }

        int total=0;
        for(int n:ages) {
            total = total+reqs.get(n);
        }
        return total;
    }

    private int binarySearch(float magicNumber, int[] ages,int j) {
        int i=0;
        while(i<j){
            int mid = (j-i)/2+i;
            if(ages[mid] <= magicNumber){
                i=mid+1;
                continue;
            }
            j = mid;
        }
        return i;
    }
}
