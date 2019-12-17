package com.playground;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanNumbers {

    public static void main(String... s){
        System.out.println(new RomanNumbers().intToRoman(58));
    }

    public String intToRoman(int num) {
        Map<Integer,String> baseM = new HashMap();
        baseM.put(1,"I");
        baseM.put(5,"V");
        baseM.put(10,"X");
        baseM.put(50,"L");
        baseM.put(100,"C");
        baseM.put(500,"D");
        baseM.put(1000,"M");

        Stack<String> str = new Stack();
        int base = 1;
        int mod = 0;
        while(num != 0){
            mod = num%10;
            if(mod != 0){
                str.push(getRoman(mod,base,baseM));
            }
            num = num/10;
            base = base*10;
        }

        return str.toString();
    }


    private String getRoman(int num, int base,Map<Integer,String> baseM){
        StringBuffer str = new StringBuffer();
            if (num < 4) {
                for (int i = 1; i <= num; i++) {
                    str.append(baseM.get(base));
                }
            } else if (num == 4) {
                str.append(baseM.get(base));
                str.append(baseM.get(base * 5));
            } else if (num == 5) {
                str.append(baseM.get(base * 5));
            } else if (num < 9) {
                str.append(baseM.get(base * 5));
                for (int i = 6; i <= num; i++) {
                    str.append(baseM.get(base));
                }
            } else if (num == 9) {
                str.append(baseM.get(base));
                str.append(baseM.get(base * 10));
            }
            return str.toString();
        }

}
