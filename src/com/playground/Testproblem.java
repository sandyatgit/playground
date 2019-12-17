package com.playground;

import java.util.Arrays;
import java.util.Comparator;

public class Testproblem {

    static class Interval{
        int x;
        int y;
        Interval(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    //(2,12)(2,14)(3,11)(5,10)(6,14)(8,15)(15,23)

    public static void findCommonIntervalsWithsorting(Interval[] intervals){
        System.out.println("findCommonIntervalsWithsorting : Before common Interval");
        display(intervals);
        boolean go = true;
        int i =0;
        while(go){
            for(int j =i+1 ; j < intervals.length;j++){
                if(intervals[i].y >= intervals[j].y){
                    intervals[j].x = -1;
                    intervals[j].y = -1;
                }else{
                    if(intervals[i].x == intervals[j].x){
                        intervals[i].x = -1;
                        intervals[i].y = -1;
                    }
                    i=j;

                }
                if(i == intervals.length -1 || j == intervals.length -1){
                    go = false;
                }
                if(i==j){
                    break;
                }
            }
        }
        System.out.println("findCommonIntervalsWithsorting : After common Interval");
        display(intervals);
    }
    public static void findCommonIntervalsWithoutsorting(Interval[] intervals){

        System.out.println("findCommonIntervalsWithoutsorting : Before common Interval");
        display(intervals);

        for(int i =0 ;i < intervals.length; i++){
            for(int j =i+1; j < intervals.length; j++){
                if(intervals[j].x == -1){
                    continue;
                }else if(intervals[i].x == -1){
                    break;
                }else if((intervals[i].x < intervals[j].x) && (intervals[i].y > intervals[j].y)){
                    intervals[j].x = -1;
                    intervals[j].y = -1;
                }else if((intervals[i].x < intervals[j].x) && (intervals[i].y == intervals[j].y)){
                    intervals[j].x = -1;
                    intervals[j].y = -1;
                }else if((intervals[i].x == intervals[j].x) && (intervals[i].y == intervals[j].y)){
                    intervals[i].x = -1;
                    intervals[i].y = -1;
                    break;
                }else if((intervals[i].x > intervals[j].x) && (intervals[i].y < intervals[j].y)){
                    intervals[i].x = -1;
                    intervals[i].y = -1;
                    break;
                }else if((intervals[i].x > intervals[j].x) && (intervals[i].y == intervals[j].y)){
                    intervals[i].x = -1;
                    intervals[i].y = -1;
                    break;
                }else if((intervals[i].x == intervals[j].x) && (intervals[i].y < intervals[j].y)){
                    intervals[i].x = -1;
                    intervals[i].y = -1;
                    break;
                }
            }
        }
/**
 *  for making i irrelevant
 *   j.x < i.x && j.y > </>
 */


        System.out.println("findCommonIntervalsWithoutsorting : After common Interval");
        display(intervals);

    }


   // (5,10)(2,12)(2,14)(15,23)(3,11)(6,14)(8,13)
    public static void main(String... s){
        Interval i1 = new Interval(5,10);
        Interval i2 = new Interval(2,12);
        Interval i3 = new Interval(2,14);
        Interval i4 = new Interval(9,13);
        Interval i5 = new Interval(3,11);
        Interval i6 = new Interval(6,14);
        Interval i7 = new Interval(8,15);
        Interval i8 = new Interval(15,23);
        Interval[] intervals = new Interval[]{ i1,i2,i3,i4,i5,i6,i7,i8};
        Interval[] intervalsAfterSort = new Interval[]{ i1,i2,i3,i4,i5,i6,i7,i8};
        System.out.println("************************************************************");
        findCommonIntervalsWithoutsorting(intervals);

        Arrays.sort(intervalsAfterSort, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return Integer.compare(o1.x,o2.x);
                    }
                }
        );
        System.out.println("************************************************************");

      //  findCommonIntervalsWithsorting(intervalsAfterSort);

    }
    public static void display(Interval[] intervals){
        for(int i =0 ; i < intervals.length; i++){
            System.out.print("("+intervals[i].x+","+intervals[i].y+")");
            if(i == intervals.length-1){
                break;
            }
            System.out.print(",");
        }
        System.out.println("");
    }
}
