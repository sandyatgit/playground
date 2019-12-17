package com.playground;

import sun.tools.tree.NewArrayExpression;

public class NumArray {

        private int[] sum = null;

        public static void main(String... s){
            NumArray n = new NumArray(new int[]{-2,0,3,-5,2,-1});
            System.out.println(n.sumRange(0,2));
            System.out.println(n.sumRange(2,5));
            System.out.println(n.sumRange(0,5));

        }

        public NumArray(int[] nums) {
            sum = new int[nums.length];
            for(int i=0; i < nums.length; i++){
                if(i==0){
                    sum[i] = nums[i];
                }else{
                    sum[i] = nums[i] + sum[i-1];
                }

            }

        }

        public int sumRange(int i, int j) {
            if(i ==0){
                return  sum[j];
            }else{
                return sum[j]-sum[i-1];
            }
        }
    }

