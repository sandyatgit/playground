package com.playground;

public class PBV {

    public static void main(String... s){
        Integer count = 1;
        intCount(count);
        System.out.println(count);
    }

    public static void intCount(Integer count){
        if(count == 5){
            return;
        }
        count = count +1;
        intCount(count);
        System.out.println(count);
    }
}
