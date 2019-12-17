package com.playground;

import java.util.*;

public class wordBreak2 {

    public static void main(String... s) {
        //data source 1
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> finalData = new wordBreak2().wordBreak("pineapplepenapple", wordDict);

        //data source 2
        //List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        //List<String> finalData = new wordBreak2().wordBreak("catsanddog", wordDict);

        for(String data : finalData){
            System.out.println(data);
        }

    }



    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> word = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> memo = new HashMap<>(); // <Starting index, rst list>
        return dfs(s, 0, word, memo);
    }

    public List<String> dfs(String s, int start, Set<String> dict, HashMap<Integer, List<String>> memo) {
        if (memo.containsKey(start))
            return memo.get(start);

        List<String> rst = new ArrayList<>();
        if (start == s.length()) {
            rst.add("");
            return rst;
        }
        String curr = s.substring(start);
        for (String word: dict) {
            if (curr.startsWith(word)) {
                List<String> sublist = dfs(s, start + word.length(), dict, memo);
                for (String sub : sublist) {
                    rst.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        memo.put(start, rst);
        return rst;
    }




    private  boolean findAllPossibleWords(String s, List<String> temp, List<String> permanent, Set<String> source){
        if(s == null || s.length() <1){
            return false;
        }
        StringBuffer charData = new StringBuffer();
        for(int i =0 ; i < s.length(); i++){
            charData.append(s.charAt(i));
            if(source.contains(charData.toString())){
                if(temp == null){
                    temp = new ArrayList<>();
                }
                temp.add(charData.toString());
                if( i != s.length()-1){
                    boolean foundValues = findAllPossibleWords(s.substring(i+1),temp,permanent,source);
                    if(foundValues == true){
                        permanent.add(extractString(temp));
                    }
                }
                if(i == s.length()-1){
                    permanent.add(extractString(temp));
                }
                temp.remove(temp.size()-1);
            }else{
                continue;
            }
        }
        return false;
    }

    private  String extractString(List<String> temp) {
        StringBuffer str = new StringBuffer();
        for(int i =0 ; i < temp.size(); i++){
            str.append(temp.get(i));
            if(i != temp.size()-1){
                str.append(" ");
            }
        }
        return str.toString();
    }

    /*public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> source = new HashSet<String>(wordDict);
        List<String> finalWords = new ArrayList<>();
        findAllPossibleWords(s,null,finalWords,source);
        return finalWords;
    }*/






}
