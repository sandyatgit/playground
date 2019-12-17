package com.playground;

import java.util.ArrayList;
import java.util.List;

public class DecodeNum {
    private List<List<String>> data = new ArrayList<>();

    public static void main(String... s){
        System.out.println(new DecodeNum().numDecodings("1274"));
    }

    public int numDecodings(String s) {
        data.add(new ArrayList<>());
        findComms(s,data,0);
        if(data.get(data.size()-1).isEmpty()){
            data.remove(data.size()-1);
        }

        return data.size();
    }
    public boolean findComms(String s, List<List<String>> data, int count){
        if(s.length() <= 0 ){
            return false;
        }
        List<String> list  = data.get(data.size()-1);
        StringBuffer s1 = new StringBuffer();
        for(int i=0 ; i < s.length(); i++){
            s1.append(s.charAt(i));
            int value = Integer.valueOf(s1.toString());
            if(value < 1 || value > 26){
                break;
            }
            list.add(s1.toString());
            boolean combs = findComms(s.substring(i+1),data,count+1);
            if(!combs){
                list = new ArrayList();
                list.addAll(data.get(data.size()-1));
                data.add(list);
            }else{
                list = data.get(data.size()-1);
            }
            list.remove(count);
        }
        return true;

    }
}
