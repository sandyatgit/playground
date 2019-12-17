package com.playground;

import com.sun.tools.javac.util.List;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeOverlappingZipCodes {
    static class ZipCodeRange {
        int x;
        int y;

        ZipCodeRange(int x,int y){
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "("+x+","+y+")";
        }


    }

    //Assumption left range is always smaller  or equal to  right range
    // No space constraint


    public static void main(String... s){
        // If the input = [94133,94133] [94200,94299] [94226,94399]
        //If the input = [94133,94133] [94200,94299] [94226,94399]


        MergeOverlappingZipCodes.ZipCodeRange r1 = new MergeOverlappingZipCodes.ZipCodeRange(94133,94133);
        MergeOverlappingZipCodes.ZipCodeRange r2 = new MergeOverlappingZipCodes.ZipCodeRange(94200,94299);
        MergeOverlappingZipCodes.ZipCodeRange r3 = new MergeOverlappingZipCodes.ZipCodeRange(94226,94399);
        MergeOverlappingZipCodes.ZipCodeRange r4 = new MergeOverlappingZipCodes.ZipCodeRange(94105,94133);


        ZipCodeRange[] intervals = new ZipCodeRange[]{r1,r2,r3,r4};


        printZipCodeRanges(intervals);

        mergeOverlappingZipCodesInBruteForce(intervals);
    }

    private static void printZipCodeRanges(ZipCodeRange[] intervals) {
        System.out.println(" ");
        Arrays.stream(intervals).forEach(System.out::print);
    }

    private static LinkedList<ZipCodeRange> mergeOverlappingZipCodesInBruteForce(ZipCodeRange[] intervals) {
        LinkedList<ZipCodeRange> range = new LinkedList<>();

        return range;
    }

}
