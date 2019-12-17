package com.playground;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lengthoflastword {
    public static void main(String ... s){
        String d1 = "Hello world yt 12 tt";
        String[] splittedData = d1.split(" ");
        //System.out.println(splittedData[splittedData.length-1].length());


        //System.out.println(data.substring(data.lastIndexOf(" ")+1,data.length()).length());

        String[] str = CustomStringTokenizer(d1);
        System.out.println(str[str.length-1]);

    }

    private static String[] CustomStringTokenizer(String d1) {
        List<String> data = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        for(int i=0; i < d1.length();i++){
            if(d1.charAt(i) == ' '){
                data.add(str.toString());
               str.delete(0,str.length());
               continue;
            }
            str.append(d1.charAt(i));
        }
        if(str.length() > 0){
            data.add(str.toString());
        }
        return data.toArray(new String[0]);
    }
}
