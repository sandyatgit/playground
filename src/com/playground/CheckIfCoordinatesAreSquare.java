package com.playground;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Comparator;

public class CheckIfCoordinatesAreSquare  {
    class Coordinates{
        int x;
        int y;
        Coordinates(int x, int y){
            this.x =x;
            this.y = y;
        }
        public String toString(){
            return "("+x+","+y+")";
        }
    }


    public static void main(String[] args) {
        CheckIfCoordinatesAreSquare s1 = new CheckIfCoordinatesAreSquare();

        Coordinates c1 = s1.new Coordinates(10, 20);
        Coordinates c2 = s1.new Coordinates(5, 5);
        Coordinates c3 = s1.new Coordinates(5, 20);
        Coordinates c4 = s1.new Coordinates(10, 10);


        Coordinates[] corrdinates = new Coordinates[]{c1, c2,c3,c4};
        System.out.println("Before sorting");
        printCoordinates(corrdinates);
        s1.checkIfSquare(corrdinates);
        System.out.println("\nAfter sorting");
        printCoordinates(corrdinates);

    }

    private static void printCoordinates(Coordinates[] corrdinates) {
        Arrays.stream(corrdinates).forEach(System.out::print);
    }



    private void checkIfSquare(Coordinates[] corrdinates ) {

        Arrays.sort(corrdinates, new Comparator<Coordinates>(){
            @Override
            public int compare(Coordinates o1, Coordinates o2) {
                int value = Integer.compare(o1.x, o2.x) ;
                if(value == 0){
                    return Integer.compare(o1.y, o2.y);
                }
                return value;
            }

        });



    }


}
