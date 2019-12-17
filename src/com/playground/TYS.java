package com.playground;

import java.util.ArrayList;
import java.util.List;

public class TYS {

    public static void main(String... s){
        String data = "geek";
        //combine(data,new StringBuffer(),0);
        //permute(data.toCharArray(),0);
        permute(new int[]{1,2,3});
    }


    private static void permute(char[] ch, int index){
        boolean[] visitedChars = new boolean[26];
        if(index == ch.length-1){
            System.out.println(String.valueOf(ch));
        }
        for(int i = index; i < ch.length; i++){
            if(visitedChars[ch[i] - 'a'] == true){
                continue;
            }
            visitedChars[ch[i] - 'a'] = true;
            swap(ch,index,i);
            permute(ch,index+1);
            swap(ch,index,i);
        }

    }

    private static void swap(char[] ch, int index, int i) {
        char tmp =ch[index];
        ch[index] = ch[i];
        ch[i] = tmp;
    }

    private static void combine(String data, StringBuffer str, int index){
        boolean[] visitedChars = new boolean[26];
        System.out.println(str.toString());

        for(int i = index; i < data.length(); i++){
            if(visitedChars[data.charAt(i) - 'a'] == true){
                continue;
            }
            str.append(data.charAt(i));
            visitedChars[data.charAt(i) - 'a'] = true;
            combine(data,str,i+1);
            str.deleteCharAt(str.length()-1);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        helper(nums, new ArrayList<>(), permutations);
        permutations.stream().forEach(x -> {
            System.out.println("");
            x.stream().forEach(y -> System.out.print(y));
        });
        return permutations;
    }

    private static  void helper(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> permutations) {
        if (tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i <= tempList.size(); i++) {
            tempList.add(i, nums[tempList.size()]);
            helper(nums, tempList, permutations);
            tempList.remove(i);
        }
    }


}
