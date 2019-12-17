package com.playground;

import java.util.*;

public class CheckIFStringsCanbeSeperated {

    public static void main(String... s) {

        String d1 = "cars";
        int j =0;
        System.out.println(d1.charAt(j+=2));
        System.out.println(j);
        //"cars"
               // ["car","ca","rs]


        //"aaaaaaa"
                //["aaaa","aaa"]

        //"applepenapple"
               // ["apple","pen"]
        System.out.println(new CheckIFStringsCanbeSeperated().wordBreak("applepenapple", Arrays.asList("apple","pen","rs")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> data = new HashSet(wordDict);

        if(Efficient(data, s)){
            return true;
        }

        return false;
    }

    public boolean Efficient(Set<String> data, String s){
        if(s.length() == 0){
            return true;
        }
        StringBuffer str = new StringBuffer();
        for(int i=0; i < s.length(); i++){
            str.append(s.charAt(i));
            if(data.contains(str.toString())){
                if(!Efficient(data,s.substring(i+1))){
                    continue;
                }else{
                    return true;
                }

            }
        }
        return false;
    }

    public boolean BruteForce(Set<String> data, String s){
        if(data.contains(s)){
            return true;
        }

        for(String d : data){
            boolean matched = false;
            int len = 0;
            if(d.length() < s.length()){
                len = d.length();
            }else{
                len = s.length();
            }
            for(int i =0; i < len; i++){
                if(s.charAt(i) != d.charAt(i)){
                    break;
                }else if(i == len-1){
                    matched = true;
                }
            }
            if(matched){
                if(!BruteForce(data, s.substring(len))){
                    continue;
                }else{
                    return true;
                }
            }
        }
        return false;
    }


}
