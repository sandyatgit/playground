package com.playground;

import java.util.*;

public class LongestSubarray {

    public static void main(String[] s){
        //10,20,30,40,50,60,70
        //int[] data = {5,1,3,2,9,0,4,5,0,0,0,1,7};
        int[] data = {-5, 8, -14, -2, -4, -12};
        System.out.println(data);
        Arrays.stream(new LongestSubarray().findLargestSubArrayEfficient(data, -6)).forEach(System.out::println);
    }

    private int[] copiedMethod(int[] arr,  int k){
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < arr.length; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {
                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        System.out.println(maxLen);
        return new int[0];
    }

    private int[] findLargestSubArrayEfficient(int[]data, int finalSum){
        Map<Integer,Integer> trackData = new HashMap<Integer,Integer>();
        int[] finalData = null;
        int sum = 0;
        int start = -1;
        int end = -1;
        int maxlength = 0;
        for(int i=0; i < data.length; i++){
            sum = sum + data[i];
            if(sum == finalSum){
                maxlength = i+1;
                start = 0;
                end = i;
            }
            if(!trackData.containsKey(sum)){
                trackData.put(sum, i);
            }

            int diff = sum - finalSum;
            if(trackData.containsKey(diff)) {
                if (maxlength < (i - trackData.get(diff))){
                    maxlength = (i - trackData.get(diff));
                    start = trackData.get(diff)+1;
                    end = i;
                  }
            }
        }

        if(start == -1){
            return new int[0];
        }
        int count=0;

        finalData = new int[maxlength];
        for(int i=start; i <=end; i++){
            finalData[count++] = data[i];
        }

        return finalData;
    }


    private int[] findLargestSubArray(int[] data, int finalSum){
        int start =-1;
        int end = -1;
        int maxLength = 0;
        for(int i=0; i < data.length; i++){
            int sum =data[i];
            int counter = 1;
            boolean sumReached = false;
            if(sum == finalSum){
                sumReached = true;
            }else if(data[i] > finalSum){
                continue;
            }
            for(int j=i+1; j < data.length; j++){
                sum = sum + data[j];
                if(sum > finalSum){
                    if(sumReached && counter > maxLength){
                        start = i;
                        end = j-1;
                        maxLength = (end-start)+1;
                    }
                    break;

                }
                counter++;
                if(sum == finalSum){
                    sumReached = true;
                }

            }
        }
        if(start == -1){
            return new int[0];
        }else{
            int [] d = new int[(end-start)+1];
            int count = 0;
            for(int i=start; i <= end; i++){
                d[count] = data[i];
                count++;
            }
            return d;
        }
    }
}
