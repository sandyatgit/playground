package com.playground;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class IntervalProbs {

     static class Interval{
        int x;
        int y;
        Interval(int x,int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "("+x+","+y+")";
        }
    }

    // (5,10)(2,12)(2,14)(15,23)(3,11)(6,14)(8,13)
    // (-1,-1),(-1,-1),(2,14),(-1,-1),(-1,-1),(-1,-1),(8,15),(15,23)
    //(2,23)

    public static void main(String... s){
        Interval[] int1 = createIntervals();

        Interval[] int2 =  createIntervals();

        Interval[] int3 =  createIntervals();

        System.out.println("\n **************************** Executing  findCommonIntervalsBruteForceNoExtraStorage ******************");

        //O(n2)
        printIntervals(int1,"Original Data before findCommonIntervalsBruteForceNoExtraStorage");
        findCommonIntervalsBruteForceNoExtraStorage(int1);
        printIntervals(int1,"Original Data After findCommonIntervalsBruteForceNoExtraStorage");

        System.out.println("\n\n\n **************************** Executing  findCommonIntervalsEfficientTimeAndExtraStorage ******************");
        //o(n)
        printIntervals(int2,"Original Data before findCommonIntervalsEfficientTimeAndExtraStorage");
        Stack<Interval> mergedIntervals = findCommonIntervalsEfficientTimeAndExtraStorage(int2);
        printMergedIntervals(mergedIntervals);
        printIntervals(int2,"Original Data after findCommonIntervalsEfficientTimeAndExtraStorage");

        System.out.println("\n\n\n **************************** Executing  findCommonIntervalsEfficientTimeAndNoExtraStorage ******************");

        //o(n)
        printIntervals(int3,"Original Data before findCommonIntervalsEfficientTimeAndNoExtraStorage");
        findCommonIntervalsEfficientTimeAndNoExtraStorage(int3);
        printIntervals(int3,"Original Data After findCommonIntervalsEfficientTimeAndNoExtraStorage");

    }

    private static void printMergedIntervals(Stack<Interval> mergedIntervals) {
        System.out.println("\n **** Merged intervals after findCommonIntervalsEfficientTimeAndExtraStorage ****");
         mergedIntervals.stream().forEach(System.out::print);
    }

    private static Interval[] createIntervals() {
        Interval i1 = new Interval(5,10);
        Interval i2 = new Interval(2,12);
        Interval i3 = new Interval(2,14);
        Interval i4 = new Interval(9,13);
        Interval i5 = new Interval(25,27);
        Interval i6 = new Interval(3,11);
        Interval i7 = new Interval(6,14);
        Interval i8 = new Interval(8,15);
        Interval i9 = new Interval(15,23);
        Interval i10 = new Interval(2,23);
        Interval i11 = new Interval(26,29);
        Interval i12 = new Interval(30,35);
        Interval i13 = new Interval(2,14);


        return new Interval[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13};
    }

    private static void printIntervals(Interval[] intervals,String message) {
        System.out.println("\n"+message+"****");
        Arrays.stream(intervals).forEach(System.out::print);
    }

    private static Stack<Interval> findCommonIntervalsEfficientTimeAndExtraStorage(Interval[] intervals){
        Stack<Interval> commonIntervals = new Stack<>();

        if(intervals == null || intervals.length < 1){
             return commonIntervals;
         }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.x,o2.x);
            }
        });
        printIntervals(intervals,"Sorted inside findCommonIntervalsEfficientTimeAndExtraStorage");

        commonIntervals.push(deepCopyInterval(intervals[0]));
        for(int i=1; i < intervals.length; i++){
            Interval currInterval = commonIntervals.peek();
            if(intervals[i].x <= currInterval.y){
                if(intervals[i].y  > currInterval.y){
                    currInterval.y = intervals[i].y;
                }
            }else{
                commonIntervals.push(deepCopyInterval(intervals[i]));
            }
        }
        return commonIntervals;
    }

    private static Interval deepCopyInterval(Interval interval) {
        return new Interval(interval.x,interval.y);
    }

    private static void findCommonIntervalsEfficientTimeAndNoExtraStorage(Interval[] intervals){

        if(intervals == null || intervals.length < 1){
            return ;
        }
         Arrays.sort(intervals, new Comparator<Interval>() {
             @Override
             public int compare(Interval o1, Interval o2) {
                 return Integer.compare(o1.x,o2.x);
             }
         });

        printIntervals(intervals,"Sorted inside findCommonIntervalsEfficientTimeAndNoExtraStorage");
        int i=0;
        int j = i+1;
        while(true){
            if(j == intervals.length){
                break;
            }
            if(intervals[j].x <= intervals[i].y){
                if(intervals[j].y <= intervals[i].y){
                    intervals[j].x = -1;
                    intervals[j].y =-1;
                    j++;
                }else{
                    intervals[i].y = intervals[j].y;
                    intervals[j].x = -1;
                    intervals[j].y =-1;
                    j++;
                }
            }else{
                i = j;
                j++;
            }
        }
    }

    private static void findCommonIntervalsBruteForceNoExtraStorage(Interval[] intervals) {
         for(int i=0;i < intervals.length;i++){
             for(int j=i+1;j< intervals.length;j++){
                 if(intervals[i].x==-1 && intervals[i].y == -1){
                     break;
                 }
                 if(intervals[j].x >= intervals[i].x && intervals[j].x <= intervals[i].y){
                        if(intervals[j].y <= intervals[i].y){
                            intervals[j].x =-1;
                            intervals[j].y = -1;
                        }else{
                            intervals[j].x =-1;
                            intervals[i].y = intervals[j].y;
                            intervals[j].y = -1;
                        }
                 }else if(intervals[i].x >= intervals[j].x && intervals[i].x <= intervals[j].y){
                     if(intervals[i].y <= intervals[j].y){
                         intervals[i].x =-1;
                         intervals[i].y = -1;
                         break;
                     }else{
                         intervals[i].x =-1;
                         intervals[j].y = intervals[i].y;
                         intervals[i].y = -1;
                         break;
                     }
                 }
             }
         }

    }

}
