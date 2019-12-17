package com.playground;

import java.util.*;

public class InvalidParanthesis {
    public static void main(String... s){
        InvalidParanthesis v = new InvalidParanthesis();
        System.out.println(v.removeInvalidParentheses(")()("));
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> data = new ArrayList<String>();
        Set<String> finalData = new HashSet<>();
        int start = 0;
        int end = 0;
        boolean containsParanthesis = false;
        boolean containsAlphabets = false;

        StringBuffer nonParanthesis = new StringBuffer();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                start++;
                containsParanthesis= true;
            }else if(s.charAt(i) == ')'){
                end++;
                containsParanthesis= true;
            }else{
                nonParanthesis.append(s.charAt(i));
            }
        }

        if(!containsParanthesis){
            data.add(s);
            return data;
        }

        int removeStart = 0;
        int removeEnd = 0;
        if(start > end){
            removeStart = start-end;
        }else{
            removeEnd = end - start;
        }

        if(removeStart > 0){
            findCombinations('(',finalData,s,removeStart);
        }else if(removeEnd > 0){
            findCombinations(')',finalData,s,removeEnd);
        }else if(isValid(s)){
            data.add(s);
            return data;
        }else if(nonParanthesis.length() > 0){
            data.add(nonParanthesis.toString());
            return data;
        }


        if(finalData.size() == 0){
            data.add("");
            return data;
        }
        data= new ArrayList<>(finalData);
        return data;

    }


    public void findCombinations(char c, Set<String> data,String s, int removalCount){
        int removedData = 0;
        StringBuffer str = new StringBuffer();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == c){
                removedData++;
                if(removedData == removalCount){
                    str.append(s.substring(i+1,s.length()));
                    if(!data.contains(str.toString()) && isValid(str.toString())){
                        data.add(str.toString());
                    };
                    removedData = 0;
                    str.delete(0, str.length());
                    str.append(s.substring(0,i+1));
                }
            }else{
                str.append(s.charAt(i));
            }
        }
    }


    public  boolean isValid(String s) {
        Stack<Character> data = new Stack();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                data.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(data.empty()){
                    return false;
                }
                if(data.pop() != '('){
                    return false;
                }

            }else if(s.charAt(i) == '}'){
                if(data.peek() == null){
                    return false;
                }
                if(data.pop() != '{'){
                    return false;
                }

            }else if(s.charAt(i) == ']'){
                if(data.peek() == null){
                    return false;
                }
                if(data.pop() != '['){
                    return false;
                }

            }
        }
        if(!data.empty()&& data.pop() != null){
            return false;
        }
        return true;
    }

}
