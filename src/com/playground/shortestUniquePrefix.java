package com.playground;

import java.util.*;

public class shortestUniquePrefix {

public static void main(String... s){
    List<String> data = Arrays.asList(new String[]{"zebra", "dog", "duck", "dove","zebras","test",});
    // data = Arrays.asList(new String[]{"geeksgeeks", "geeksquiz", "geeksforgeeks"});
    List<String> results = findShortestUniquePrefixWithOptimizedNestedLoop(data);
    System.out.println("Final results");
    System.out.println("***************");
    results.stream().forEach(System.out::println);

}


    private static List<String> findShortestUniquePrefixWithEfficient(List<String> data){
        List<String> results = new ArrayList<>();

        return results;

    }

    private List<String> findUniqueIndexes(Map<String,List<String>> uniquePrefixes, List<String> data , String data1){
        List<String> results = new ArrayList<>();
        String shortestUniquePath = null;
        for(String d : data){
            String tmp = findShortUniquePrefix(uniquePrefixes.get(d).get(0),data1);
            if(shortestUniquePath == null){
                shortestUniquePath = tmp;
            }else if(tmp.length() > shortestUniquePath.length()){
                shortestUniquePath = tmp;
            }
        }
        return results;
    }
    private static List<String> findShortestUniquePrefixWithOptimizedNestedLoop(List<String> data) {
        List<String> results = new ArrayList<>();
        Collections.sort(data);
        System.out.println("Sorted data **********");
        data.stream().forEach(System.out::println);
        System.out.println("***************");
        int currUniqueCharIndex = 0;
        int nextUniqueCharIndex = 0;
        for(int i =0 ; i < data.size(); i++){
            String data1 = data.get(i);
            String shortUniquePath = null;
            if(i == nextUniqueCharIndex){
                currUniqueCharIndex = nextUniqueCharIndex;
            }
            for(int j=currUniqueCharIndex; j < data.size(); j++){
                String data2 = data.get(j);
                if(data1.charAt(0) == data2.charAt(0)){
                    String tmp = findShortUniquePrefix(data1,data2);
                    if(shortUniquePath == null)
                        shortUniquePath =  tmp;
                    else if(tmp.length() > shortUniquePath.length()){
                        shortUniquePath =  tmp;
                    }
                    continue;
                }
                nextUniqueCharIndex = j;
                break;

            }
            results.add(shortUniquePath);
        }
        return results;
    }

    private static List<String> findShortestUniquePrefixNestedLoop(List<String> data) {
        List<String> results = new ArrayList<>();
        for(int i=0; i < data.size();i++){
            String data1 = data.get(i);
            String shortUniquePath = null;
            for(int j=i+1; j < data.size(); j++){
                if(i==j){
                    continue;
                }
                String data2 = data.get(j);
                String tmp = findShortUniquePrefix(data1,data2);
                if(shortUniquePath == null){
                    shortUniquePath = tmp;
                }else if(tmp.length() > shortUniquePath.length()){
                    shortUniquePath = tmp;
                }
            }
            results.add(shortUniquePath);
        }
        return results;
    }

    private static String findShortUniquePrefix(String data1, String data2) {
        if(data1.equals(data2)){
            return String.valueOf(data1.charAt(0));
        }
        int len = data1.length() < data2.length() ? data1.length() : data2.length();
        StringBuffer str = new StringBuffer();
        for(int i =0; i< len;i++){
            if(data1.charAt(i) == data2.charAt(i)){
                str.append(data1.charAt(i));
                continue;
            }
            break;
        }
        if(str.length() >  0){
            if(str.length() == data1.length()){
                return  str.toString();
            }
            return str.toString()+ data1.charAt(str.length());
        }
        return String.valueOf(data1.charAt(0));
    }


}
