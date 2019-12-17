package com.playground;

import java.util.ArrayList;
import java.util.Random;

public class EfficientBetsAndProbability {
        private static Random random = new Random();
        public static void main(String[] args) {
            // write your code in Java SE 8
            prepToPlaceBet();
        }

        private static void prepToPlaceBet(){
            ArrayList<Integer> result = new ArrayList<Integer>();
            int betAmount = 50;
            int existing = -1;
            boolean placeBet = false;
            //keep watching bets.
            int counter = 0;
            while(true){
                int currResult = random.nextInt(2);
                if(placeBet){
                    betAmount = placeBet(existing,currResult,betAmount);
                    System.out.println("current betAmount = "+ betAmount);

                    if(betAmount ==0 || betAmount ==100) {
                        System.out.println("betting finished");
                        break;
                    }
                }
                result.add(currResult);
                if(existing == -1){
                    existing = currResult;
                }
                if(existing == currResult){
                    counter++;
                }else{
                    counter = 1;
                    existing = currResult;
                }
                if(counter >= 4){
                     placeBet = true;
                }

            }
        }

        private static int placeBet(int prev, int curr, int betAmount){
            if(prev == 1){
                return placeBetOnZero(betAmount,curr);
            }else{
                return placeBetOnOne(betAmount,curr);
            }
        }

        private static int placeBetOnZero(int betAmount, int curr) {
            //placed bet on 0
            if(curr == 0){
                return betAmount+10;
            }else{
                return  betAmount-10;
            }
        }

        private static int placeBetOnOne(int betAmount, int curr) {
            //placed bet on 1
            if(curr == 1){
                return betAmount+10;
            }else{
                return  betAmount-10;
            }
        }


}

