package com.playground;

import java.util.Arrays;
import java.util.Comparator;


public class CheckIfSquaresOverlap {

    class Square{
        Coordinates bottomLeft;
        Coordinates bottomRight;
        Coordinates topLeft;
        Coordinates topRight;

        Square(Coordinates bottomLeft, Coordinates bottomRight, Coordinates topLeft, Coordinates topRight){
            bottomLeft = bottomLeft;
            bottomRight = bottomRight;
            topLeft = topLeft;
            topRight = topRight;
        }

    }

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


    private  int[][] square1 = new int[2][2];
    private int[][] square2 = new int[2][2];

    public static void main(String... s6){
        CheckIfSquaresOverlap overlap = new CheckIfSquaresOverlap();




        Coordinates c1 = overlap.new Coordinates(0, 0);
        Coordinates c2 = overlap.new Coordinates(6, 6);
        Coordinates c3 = overlap.new Coordinates(6, 0);
        Coordinates c4 = overlap.new Coordinates(0, 6);

        Coordinates[] coordinates1 = new Coordinates[]{c1,c2,c3,c4};

        Square s1 = overlap.new Square(c1,c2,c3,c4);





        Coordinates c5 = overlap.new Coordinates(10, 20);
        Coordinates c6 = overlap.new Coordinates(5, 5);
        Coordinates c7 = overlap.new Coordinates(20, 5);
        Coordinates c8 = overlap.new Coordinates(10, 0);
        Square s2 = overlap.new Square(c5,c6,c7,c8);
        Coordinates[] coordinates2 = new Coordinates[]{c5,c6,c7,c8};




        System.out.println(overlap.findIfSquaresMerge(coordinates1,coordinates2));
    }

    private static void printCoordinates(Coordinates[] corrdinates) {
        System.out.println("\n");
        Arrays.stream(corrdinates).forEach(System.out::print);
    }

    private boolean findIfSquaresMerge(Coordinates[] s1, Coordinates[] s2) {
        sortData(s1);
        sortData(s2);
        CheckIfSquaresMerge(s1,s2);
        printCoordinates(s1);
        printCoordinates(s2);
        return false;
    }

    private void CheckIfSquaresMerge(Coordinates[] s1, Coordinates[] s2) {

    }

    private void sortData(Coordinates[] s1) {
        Arrays.sort(s1,new Comparator<Coordinates>(){

            @Override
            public int compare(Coordinates o1, Coordinates o2) {
                int value = Integer.compare(o1.x,o2.x);
                if(value == 0){
                   return Integer.compare(o1.y,o2.y);
                }
                return value;

            }
        });
    }





}
