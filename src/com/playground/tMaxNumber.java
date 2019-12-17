package com.playground;

public class tMaxNumber {

    public static void main(String... s){
       System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }

    public static int thirdMax(int[] nums) {
        int fMax = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int tMax  = Integer.MIN_VALUE;
        boolean tMaxSet = false;
        for(int i =0; i < nums.length; i++){
            if(nums[i] >= fMax){
                if(nums[i] == fMax){
                    continue;
                }
                tMax = sMax;
                sMax = fMax;
                fMax = nums[i];
            }else if(nums[i] >= sMax){
                if(nums[i] == sMax){
                    continue;
                }
                tMax = sMax;
                sMax = nums[i];
            }else if(nums[i] >= tMax){
                tMaxSet=true;
                tMax = nums[i];
            }
        }
        // if there is no third max, then return the first highest
        if(!tMaxSet){
            return fMax;
        }else{
            return tMax;
        }
    }
}
