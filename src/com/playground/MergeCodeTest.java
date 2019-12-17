package com.playground;

import java.util.*;

public class MergeCodeTest {


    public static void main(String... s){
        int[][] data = createIntervals();



       /* System.out.println("\n **************************** Executing  findCommonIntervalsBruteForceNoExtraStorage ******************");

        //O(n2)
        printIntervals(data,"Original Data before findCommonIntervalsBruteForceNoExtraStorage");
        findCommonIntervalsBruteForceNoExtraStorage(int1);
        printIntervals(data,"Original Data After findCommonIntervalsBruteForceNoExtraStorage");*/

        System.out.println("\n\n\n **************************** Executing  findCommonIntervalsEfficientTimeAndExtraStorage ******************");
        //o(n)
        printIntervals(data,"Original Data before findCommonIntervalsEfficientTimeAndExtraStorage");
        int[][] mergedIntervals = findCommonIntervalsEfficientTimeAndExtraStorage(data);
        printIntervals(mergedIntervals,"Merged intervals");

       /* System.out.println("\n\n\n **************************** Executing  findCommonIntervalsEfficientTimeAndNoExtraStorage ******************");

        //o(n)
        printIntervals(data,"Original Data before findCommonIntervalsEfficientTimeAndNoExtraStorage");
        findCommonIntervalsEfficientTimeAndNoExtraStorage(int3);
        printIntervals(data,"Original Data After findCommonIntervalsEfficientTimeAndNoExtraStorage");*/

    }

    private static void printIntervals(int[][] intervals, String message) {
        System.out.println("\n"+message+"****");
        System.out.println(Arrays.deepToString(intervals));

    }

    private static int[][] findCommonIntervalsEfficientTimeAndExtraStorage(int[][] intervals){
        if(intervals.length < 1){
            return new int[0][0];
        }
        List<int[]> data = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        printIntervals(intervals,"Sorted inside findCommonIntervalsEfficientTimeAndExtraStorage");

        data.add(0,intervals[0]);
        for(int i=1,x=0; i < intervals.length; i++){
            int[] currInterval = data.get(x);
            if(intervals[i][0] <= currInterval[1]){
                if(intervals[i][1] > currInterval[1]){
                    currInterval[1] = intervals[i][1];
                }
            }else{
                x++;
                data.add(x,intervals[i]);
            }
        }
        return (int[][]) data.toArray(new int[data.size()][2]);
    }

    private static int[][] createIntervals() {
        int[][] data = {{5,10},{2,12},{2,14},{9,13},{25,27},{3,11},{6,14},{8,15},{15,23},{2,23},{26,29},{30,35},{2,14}};
        /***
         * 5 10
         * 2 12
         * 2 14
         */

       return data;
    }

}
