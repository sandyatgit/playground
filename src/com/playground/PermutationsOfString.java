package com.playground;

public class PermutationsOfString {
    public static void main(String... s){
        //String a = "bdac";
        String a = "bdac";

        printPermutationsOfString(a);
        printPermutn(a, new StringBuffer(),0);
    }

    private static void printPermutationsOfString(String a) {

    }

    // Function to print all the permutations of str
    static void printPermutn(String str, StringBuffer ans , int height)
    {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans.toString() + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(i != 0)
                ans.delete(height-1,ans.length());
            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutn(ros, ans.append(ch),++height);

        }
    }



}
