package com.playground;

public class Solution1 {

    public static void main(String... s){
        System.out.println(solution2(">>><<<>>>>"));
    }

    public static String solution(String angles) {
        if(angles.length() <1){
            return "";
        }
        boolean begIndex = true;
        int countStart = 0;
        int countEnd = 0;
        StringBuffer frontData = new StringBuffer();
        for(int i =0 ; i < angles.length(); i++){
            if(angles.charAt(i) == '>' && begIndex){
                frontData.append("<");
            }else if(angles.charAt(i) == '<'){
                begIndex = false;
                countStart++;
            }else{
                countEnd++;
            }
        }
        int diff = countStart - countEnd;
        frontData.append(angles);
        for(int i =0 ; i < diff; i++){
            frontData.append(">");
        }
        return frontData.toString();
    }

    //>>>> <>>>>>

    //<<>>>>><<<>>
    //<< <<>>>>><<<>>
    public static String solution2(String angles) {
        StringBuffer str = new StringBuffer();
        if(angles.length() <1){
            return "";
        }
        int frontTags = 0;
        for(int i =0 ; i < angles.length(); i++){
            if(angles.charAt(i) == '>'){
                if(frontTags ==  0){
                    str.append("<");
                }else{
                    frontTags--;
                }
            }else if(angles.charAt(i) == '<'){
                frontTags++;
            }
        }
        str.append(angles);
        for(int i =0 ; i < frontTags; i++){
            str.append(">");
        }


        return str.toString();

    }
}
