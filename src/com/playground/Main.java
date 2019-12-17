package com.playground;

public class Main {

    public static void main(String[] args) {

        for(int i=0 ; i <= 15 ; i++){
            if(i%3 == 0 && i%5 == 0){
                System.out.println("i = " +i);
                System.out.println("Fizz Bizz");
            }else if(i%3 == 0){
                System.out.println("i = " +i);
                System.out.println("Fizz");
            }else if(i%5 == 0){
                System.out.println("i = " +i);
                System.out.println("Bizz");
            }
        }
	// write your code here
    }
}
