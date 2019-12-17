package com.playground;
// you can also use imports, for example:
// import java.util.*;

// you can write to stderr for debugging purposes, e.g.
// System.err.println("this is a debug message");

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

class BetsAndProbability {
    private static Random random = new Random();
    public static void main(String[] args) {
        // write your code in Java SE 8
        prepToPlaceBet();
    }

    private static void prepToPlaceBet(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int betAmount = 50;
        boolean finishBetting= false;
        int existing = -1;
        //keep watching bets.
        while(true){
            int currResult = random.nextInt(2);
            result.add(currResult);
            existing = currResult;

            //take the last four items from arrayList.
            int minIndex = result.size() > 4 ? result.size()-4 : 0;

            //if there are atleast four bets , then check if its good to placeBet
            if(result.size() >= 4){
                for(int i = result.size()-1; i >=minIndex ; i--){
                    if(existing == result.get(i)){
                        //if the minIndex(4th element) then one can placeBet.
                        if(i == minIndex){
                            betAmount = placeBet(existing,betAmount);
                            System.out.println("current Bet amount = "+betAmount);
                            if(betAmount ==0 || betAmount ==100){
                                System.out.println("betting finished");

                                finishBetting = true;
                            }
                        }

                    }else{
                        break;
                    }
                }
            }
            if(finishBetting){
                break;
            }
        }
    }



    private static int placeBet(int previousResult, int betAmount){
        int currentResult = random.nextInt(2);
        if(previousResult == 1){
            //placed bet on 1
            if(currentResult == 0){
                betAmount =  betAmount+10;
            }else{
                betAmount =  betAmount-10;
            }

        }else{
            //placed bet on 0
            if(currentResult ==1){
                betAmount =  betAmount+10;
            }else{
                betAmount =  betAmount-10;
            }
        }

        return betAmount;
    }


}


