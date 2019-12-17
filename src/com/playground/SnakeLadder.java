package com.playground;

import java.util.Random;


/**
 * Created by z002bbt on 8/11/17.
 */
public class SnakeLadder {
    private static Random random = new Random();
    private static int maxBoardIndex = 8;
    private static int curr_x = 0;
    private static int curr_y = -1;

    private static final String STAY = "stay";



    private static final String[][] board = new String[maxBoardIndex][maxBoardIndex];

    static{
        for(int i = 0; i < maxBoardIndex; i++){
            int snake = -1;
            int ladder = -1;
            if(i == 0){
                ladder = random.nextInt(maxBoardIndex);
            }else  if(i == maxBoardIndex -1){
                snake = random.nextInt(maxBoardIndex);
            }else{
                snake = random.nextInt(maxBoardIndex);
                ladder = random.nextInt(maxBoardIndex);
            }

            for(int j = 0; j< maxBoardIndex; j++){
                // if its last index , dont assign a snake
                if(j == i && j== maxBoardIndex -1){
                    board[i][j] = STAY;
                }else if(j==snake){
                   StringBuffer str = new StringBuffer();
                   int x = random.nextInt(i);
                   int y = random.nextInt(i);
                   str.append(x);
                   str.append(",");
                   str.append(y);
                   board[i][j] = str.toString();
               }else if(j == ladder){
                   StringBuffer str = new StringBuffer();
                   int min = i+1;
                   int x = random.nextInt((maxBoardIndex - min))+min;
                   int y = random.nextInt((maxBoardIndex - i))+i;
                   str.append(x);
                   str.append(",");
                   str.append(y);
                   board[i][j] = str.toString();
               }else{
                   board[i][j] = STAY;
               }
            }
        }
    }
    public static void main(String... s){
        printBoard();
        System.out.println(" ************************  Game starts *******************************");
        try{
            boolean play = true;
            int diceThrow = 1;
            while(play){
                if(moveDiceAndCheckIfGameIsOver(rollDice(diceThrow))){
                    System.out.println("******************************* Dice move ends for no "+diceThrow+" ****************************************");
                    play = false;
                }else{
                    executeCurrentCell(diceThrow);
                }
                diceThrow++;
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
        System.out.println(" **********************  Game ends **********************************");
    }

    private static void executeCurrentCell(int diceThrow) {
        String currentCell = board[curr_x][curr_y];
        if(!currentCell.equals(STAY)){
            System.out.println("***** Executing current Cell action for dice throw "+diceThrow+" ******");
            System.out.println("Before executeCurrentCell = ("+curr_x+","+curr_y+")");
            String[] xandy = currentCell.split(",");
            curr_x = Integer.valueOf(xandy[0]);
            curr_y=Integer.valueOf(xandy[1]);
            System.out.println("After executeCurrentCell = ("+curr_x+","+curr_y+")");
            int leftOver = maxBoardIndex - (curr_y+1);
            System.out.println("After executeCurrentCell leftover is  =  "+leftOver);
            System.out.println("******************************* Dice move ends for no "+diceThrow+" ****************************************");
        }
    }


    private static boolean moveDiceAndCheckIfGameIsOver(int num){
        //return moveDiceByCoveredCellAndCheckIfGameIsOver(num);
        //return moveDiceByRecurssionAndCheckIfGameIsOver(num);
        return moveDiceByLeftOverAndCheckIfGameIsOver(num);
    }

    private static boolean moveDiceByRecurssionAndCheckIfGameIsOver(int num){
        System.out.println("Dice is to be moved by "+ num);
        System.out.println("Before Dice move = ("+curr_x+","+curr_y+")");
        int leftOver = maxBoardIndex - (curr_y+1);
        System.out.println("Before Dice move leftover is = "+leftOver);

        if(curr_x == (maxBoardIndex-1) && leftOver < num){
            System.out.println("Game over");
            return true;
        }else if(leftOver < num){
            System.out.println("left Over is lesser than dice Number, so increment x by 1 and reset y to -1");
            curr_x++;
            int remaining  =  num - leftOver;
            curr_y = -1;
            System.out.println("After Dice move = ("+curr_x+","+curr_y+")");
            System.out.println("after Dice move leftover_y = "+leftOver);
            return moveDiceByRecurssionAndCheckIfGameIsOver(remaining);
        }else{
            System.out.println("left Over is more than dice Number, so movie just y coordinates");
            curr_y = curr_y + num;
            System.out.println("After Dice move = ("+curr_x+","+curr_y+")");
            System.out.println("after Dice move leftover is = "+leftOver);
            return false;
        }
    }

    private static boolean moveDiceByCoveredCellAndCheckIfGameIsOver(int num){
        System.out.println("Dice is to be moved by "+ num);
        System.out.println("Before Dice move = ("+curr_x+","+curr_y+")");
        boolean isGameOver = false;
        int y = (num+(curr_y+1))%(maxBoardIndex);
        int x = (num+(curr_y+1))/(maxBoardIndex);
        if(y==0){
            curr_y = (maxBoardIndex-1);
            if(curr_x == 0){
                curr_x = x;
            }else{
                curr_x= curr_x+(x-1);
            }
        }else{
            curr_y = y-1;
            curr_x = curr_x+x;
        }
        System.out.println("After Dice move = ("+curr_x+","+curr_y+")");
        if(curr_x >= maxBoardIndex ){
            System.out.println("Game over");
            isGameOver= true;
        }
        return isGameOver;
    }

    private static boolean moveDiceByLeftOverAndCheckIfGameIsOver(int num){
        System.out.println("Dice is to be moved by "+ num);
        System.out.println("Before Dice move = ("+curr_x+","+curr_y+")");
        boolean isGameOver = false;
        int leftOver = maxBoardIndex - (curr_y+1);
        if(num > leftOver){
            curr_x++;
            num = num - leftOver;
            curr_y = -1;
        }
        int y = num%(maxBoardIndex);
        int x = num/(maxBoardIndex);
        if(y==0){
            curr_y = (maxBoardIndex-1);
            if(curr_x == 0){
                curr_x = curr_x+ x;
            }else{
                curr_x= curr_x+(x-1);
            }
        }else{
            curr_x = curr_x+x;
            curr_y = curr_y+y;
        }
        System.out.println("After Dice move = ("+curr_x+","+curr_y+")");
        if(curr_x >= maxBoardIndex ){
            System.out.println("Game over");
            isGameOver= true;
        }
        return isGameOver;
    }

    private static void printBoard(){
        for(int i = 0; i < maxBoardIndex; i++){
            System.out.println("\n");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n");
            for(int j = 0; j< maxBoardIndex; j++){
                System.out.print("board["+i+"]["+j+"] = "+board[i][j]+" \t ");
            }
        }
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static int rollDice(int diceThrow){
        int min = 2;
        int max = 12;
        int diceNum =  random.nextInt((max-min)+1)+min;
        System.out.println("******************************* Dice move starts for no "+diceThrow+" ****************************************");
        return diceNum;
    }

}
