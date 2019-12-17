package com.playground;

import java.util.*;

public class Solution {

    public static void main(String... s){
        System.out.println(solution("who wants hot watermelon?"));
    }




    public static long solution(String s) {
         Map<Character,Integer> data = new HashMap<>();
         Set<Character> reduntantData = new HashSet<>();
        for(int i =0 ; i < s.length(); i++){
            if(!data.containsKey(s.charAt(i)) && reduntantData.contains(s.charAt(i))){
                //do nothing
            }else if(data.containsKey(s.charAt(i))){
                reduntantData.add(s.charAt(i));
                data.remove(s.charAt(i));
            }else{
                data.put(s.charAt(i),i);
            }
        }


        Iterator<Character> finalData = data.keySet().iterator();
        int leastValue = -1;
        while(finalData.hasNext()){
            Character localData = finalData.next();
            int value = data.get(localData);
            if(leastValue == -1){
                leastValue = value;
            }else if(value < leastValue){
                leastValue = value;
            }
        }
        return leastValue;
    }

}
