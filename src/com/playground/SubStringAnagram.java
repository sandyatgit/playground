package com.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubStringAnagram {
    public static void main(String... s){
         String A = "bdac";
         String B = "Cbdcyatr";
         System.out.println(findSubstringPermutation(A,B));
         //this is not correct.
        //System.out.println(findSubstringPermutationWithSorting(A,B));
    }

    private static boolean findSubstringPermutationWithSorting(String a, String b) {
        if(a.length() > b.length()){
            return false;
        }
        char[] charData = a.toCharArray();
        char[] charData1 = b.toCharArray();
        Arrays.sort(charData);
        Arrays.sort(charData1);
        boolean isAnagram = false;
        for(int i =0;i < charData1.length; i++){
            if((charData1.length-i) < charData.length-1){
                    break;
            }
            int temp = i;
            for(int j =0; j < charData.length; j++){
                if(charData1[temp++] != charData[j]){
                    break;
                }
                if(j == charData.length-1){
                    isAnagram = true;
                }
            }
            if(isAnagram){
                return true;
            }
        }
        return false;
    }

    private static boolean findSubstringPermutation(String a, String b) {
        if(a.length() > b.length()){
            return false;
        }
        Map<Character,Integer> data = new HashMap();
        for(int i = 0; i < a.length(); i++){
            data.put(a.charAt(i),data.getOrDefault(a.charAt(i),0) +1);
        }
        for(int j=0; j < b.length(); j++){
            if(b.length()-j >= a.length()){
                Map<Character,Integer> data2 = getSubStringFromB(b,a.length(),j);
                if(checkIfthereisAanagram(data,data2)){
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private static Map<Character,Integer> getSubStringFromB(String b, int len, int startIndex){
        Map<Character,Integer> data = new HashMap();
        for(int i=startIndex; i < startIndex+len; i++){
            data.put(b.charAt(i),data.getOrDefault(b.charAt(i),0) +1);
        }
        return data;
    }
    private static boolean checkIfthereisAanagram(Map<Character, Integer> data1, Map<Character, Integer> data2) {
        for(Character c : data1.keySet()){
            if(data2.containsKey(c) && (data2.get(c) - data1.get(c) == 0)){
                continue;
            }
            return false;
        }
        return true;
    }

    private static void sortCharacters(String a){
        char[] data = a.toCharArray();
        Arrays.sort(data);
        System.out.println(new String(data));
    }

}
