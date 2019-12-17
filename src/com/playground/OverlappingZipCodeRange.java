package com.playground;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class OverlappingZipCodeRange {

     static class ZipCodeRange {
        int lowerBound;
        int upperBound;

        ZipCodeRange(int lowerBound,int upperBound){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
        public String toString() {
            return "("+lowerBound+","+upperBound+")";
        }


    }



    public static void main(String... s){
        System.out.println(" ***********************************************************************************************************************************************");
        //first data set
        // [94133,94133] [94200,94299] [94226,94399]
        //Expected output
        //[94133,94133] [94200,94399]
        ZipCodeRange[] range1 =  createFirstDataSet();
        startProcessing(range1);


        System.out.println(" ***********************************************************************************************************************************************");
        //Second data set
        // [94133,94133] [94200,94299] [94600,94699]
        //Expected output
        //[94133,94133] [94200,94299] [94600,94699]
        ZipCodeRange[] range2 =  createSecondDataSet();
        startProcessing(range2);


        System.out.println(" ***********************************************************************************************************************************************");
        //Third data set
        // [94133,94133] [94200,94200] [94600,94600]
        //Expected output
        //[94133,94133] [94200,94200] [94600,94600]
        ZipCodeRange[] range3 = createThirdDataSet();;
        startProcessing(range3);

        System.out.println(" ***********************************************************************************************************************************************");
        //Fourth data set
        // [94133,94133] [94133,94133] [94133,94133]
        //Expected output
        //[94133,94133]
        ZipCodeRange[] range4 = createFourthDataSet();;
        startProcessing(range4);

    }




    /**
     * Start processing the zipcode ranges
     * @param range
     */
    private static void startProcessing(ZipCodeRange[] range) {
        System.out.println("\n **************************** START : Executing  mergeOverlappingZipCodes ******************");
        printZipCodeRanges(range,"Source data before execution");
        Stack<ZipCodeRange> mergedZipCodeRanges = mergeOverlappingZipCodes(range);
        printMergedRanges(mergedZipCodeRanges,"Merged intervals ");
        printZipCodeRanges(range,"Source data after execution");
        System.out.println("\n\n ****************************END :  Executing  mergeOverlappingZipCodes ******************");

    }

    /**
     * print zip code ranges from array
     * @param ranges
     * @param message
     */
    private static void printZipCodeRanges(OverlappingZipCodeRange.ZipCodeRange[] ranges, String message){
        System.out.println("\n\n ****"+message+"****");
        Arrays.stream(ranges).forEach(System.out::print);
    }

    /**
     * print Merged ranges from stack
     * @param mergedZipCodeRanges
     * @param message
     */
    private static void printMergedRanges(Stack<ZipCodeRange> mergedZipCodeRanges,String message) {
        System.out.println("\n\n ****"+message+"****");
        mergedZipCodeRanges.stream().forEach(System.out::print);
    }

    /**
     * Merge overlapping zip codes.
     *  Step 1:  Sort the ranges by lower bound .
     *  Step 2: Add the first element from range in stack
     *  Step 3 : Create a for loop and start iterating ranges from index 1
     *     check if the  current iteration range  is overlapping with  peeked item in stack
     *     if so , extend the upperbound range of  the peeked element in stack
     *   if not add the current iteration range in the stack
     *   repeat Step3 until index reaches the last element in the rang
     *
     *   Step 1 time complexity is o(nlogn)
     *   Step 3 time complexity is 0(n)
     *   Space complexity is o(n). we need to create a new datastructure to hold the merged ranges
     *
     * @param  ranges
     * @return Stack
     */
    private static Stack<ZipCodeRange> mergeOverlappingZipCodes(ZipCodeRange[] ranges) {
        Stack<ZipCodeRange> commonIntervals = new Stack<>();

        if(ranges == null || ranges.length < 1){
            return commonIntervals;
        }
        Arrays.sort(ranges, new Comparator<ZipCodeRange>() {
            @Override
            public int compare(ZipCodeRange o1, ZipCodeRange o2) {
                return Integer.compare(o1.lowerBound,o2.lowerBound);
            }
        });
        printZipCodeRanges(ranges,"Sorted data as part of execution");

        commonIntervals.push(deepCopyInterval(ranges[0]));
        for(int i=1; i < ranges.length; i++){
            ZipCodeRange currInterval = commonIntervals.peek();
            if(ranges[i].lowerBound <= currInterval.upperBound){
                if(ranges[i].upperBound  > currInterval.upperBound){
                    currInterval.upperBound = ranges[i].upperBound;
                }
            }else{
                commonIntervals.push(deepCopyInterval(ranges[i]));
            }
        }
        return commonIntervals;

    }

    /**
     * this is needed to ensure that the source is not impacted when the range is constantly modified with overlapping zipcodes
     * @param range
     * @return new ZipCodeRange
     */
    private static ZipCodeRange deepCopyInterval(ZipCodeRange range) {
        return new ZipCodeRange(range.lowerBound,range.upperBound);
    }

    /**
     * data creation methods
     * @param
     * @return array of ZipCodeRange
     */
    //[94133,94133] [94200,94299] [94226,94399]
    private static ZipCodeRange[] createFirstDataSet() {
        ZipCodeRange r1 = new OverlappingZipCodeRange.ZipCodeRange(94133,94133);
        ZipCodeRange r2 = new OverlappingZipCodeRange.ZipCodeRange(94226,94399);
        ZipCodeRange r3 = new OverlappingZipCodeRange.ZipCodeRange(94200,94299);

        return new OverlappingZipCodeRange.ZipCodeRange[]{r1,r2,r3};
    }

    /**
     * data creation methods
     * @param
     * @return array of ZipCodeRange
     */
    //[94133,94133] [94200,94299] [94600,94699]
    private static ZipCodeRange[] createSecondDataSet() {
        ZipCodeRange r1 = new OverlappingZipCodeRange.ZipCodeRange(94133,94133);
        ZipCodeRange r2 = new OverlappingZipCodeRange.ZipCodeRange(94600,94699);
        ZipCodeRange r3 = new OverlappingZipCodeRange.ZipCodeRange(94200,94299);

        return new OverlappingZipCodeRange.ZipCodeRange[]{r1,r2,r3};
    }


    /**
     * data creation methods
     * @param
     * @return array of ZipCodeRange
     */
    // [94133,94133] [94200,94200] [94600,94600]
    private static ZipCodeRange[] createThirdDataSet() {
        ZipCodeRange r1 = new OverlappingZipCodeRange.ZipCodeRange(94133,94133);
        ZipCodeRange r2 = new OverlappingZipCodeRange.ZipCodeRange(94600,94600);
        ZipCodeRange r3 = new OverlappingZipCodeRange.ZipCodeRange(94200,94200);

        return new OverlappingZipCodeRange.ZipCodeRange[]{r1,r2,r3};
    }


    /**
     * data creation methods
     * @param
     * @return array of ZipCodeRange
     */
    // [94133,94133] [94133,94133] [94133,94133]
    private static ZipCodeRange[] createFourthDataSet() {
        ZipCodeRange r1 = new OverlappingZipCodeRange.ZipCodeRange(94133,94133);
        ZipCodeRange r2 = new OverlappingZipCodeRange.ZipCodeRange(94133,94133);
        ZipCodeRange r3 = new OverlappingZipCodeRange.ZipCodeRange(94133,94133);

        return new OverlappingZipCodeRange.ZipCodeRange[]{r1,r2,r3};
    }

}


