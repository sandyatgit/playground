package com.playground;

import java.util.*;

public class test1 {
    public static ArrayList<String> prefixEfficient(ArrayList<String> a) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, String> validSubs = new HashMap<String, String>();
        HashSet<String> usedSubs = new HashSet<String>();

        for (String option : a) {
            for(int i = 0; i <= option.length(); i++) {
                String sub = option.substring(0, i);
                if(usedSubs.contains(sub)) {
                    validSubs.remove(sub);
                } else {
                    validSubs.put(sub, option);
                    usedSubs.add(sub);
                }
            }
        }

        Iterator it = validSubs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            //it.remove(); // avoids a ConcurrentModificationException
        }

//        for(String s: a){
//            if(validSubs.containsKey(s))
//                result.add(validSubs.get(s));
//        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("bearcat");
        a.add("bert");
//        a.add("duck");
//        a.add("dove");
        ArrayList<String> result = prefixEfficient(a);
        System.out.println(a);
        System.out.println(result);
    }
}
