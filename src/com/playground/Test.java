package com.playground;

public class Test {

    public static void main(String... s){
        System.out.println(new Test().solution("((3(7))",0));
    }
    public static long solution(String p, long index) {
        int len = p.length();
        //Stack<Character> data = new Stack<>();
        if(index > len){
            return -1;
        }
        if(index < 0){
            return -1;
        }
        int count = 1;
        String a[] = new String[len];
        for(int i=0,j=0; i < p.length(); i++){
            char c = p.charAt(i);
            if(c == '('){
                if(i == index){
                    a[j] = c +":"+i;
                }else{
                    a[j] = String.valueOf(c);
                }
                j++;
            }else if(c == ')'){
                if(j > 0){
                    j = j-count;
                    if(a[j].equals('(')){
                        count++;
                        continue;
                    }else if(a[j].contains(":")){

                        int ind = Integer.valueOf(a[j].substring(a[j].indexOf(':')+1));
                        if(ind == index){
                            return i;
                        }
                    }

                }else{
                    return -1;
                }
            }
        }
        return -1;
    }
}
