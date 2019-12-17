package com.playground;

public class LongestCommonSubsequence {
    private static final LongestCommonSubsequence inst  = new LongestCommonSubsequence();

    public static void main(String... s){
        String b = "abcdezh";
        String a = "123bcdefcdezg";
        System.out.println(inst.findLongestCommonSubSequence(a,b));
        System.out.println(inst.lca(a,b));
        System.out.println(inst.lcaWithRecu(a,b,1,1,new int[a.length()+1][b.length()+1],0));
    }

    private String findLongestCommonSubSequence(String a, String b) {
        int maxLength = -1;
        String longestSubString = null;
        for(int i=0;i<a.length();i++){
            for(int j=0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                   int[] currLen =  getCommonSubSequence(a,b,i+1,j+1);
                   if(maxLength < currLen[0]){
                       maxLength = currLen[0];
                       longestSubString = b.substring(j,currLen[1]+1);
                   }
                   j=currLen[1];
                }
            }
        }
        return longestSubString;
    }
    private int[] getCommonSubSequence(String a , String b , int m, int n){
        int count =1 ;
        while(a.charAt(m) == b.charAt(n)){
            m++;
            n++;
            count++;
            continue;
        }
        return new int[]{count,n-1};
    }

    private int lca(String a , String b){
        int[][] matrix = new int[a.length()+1][b.length()+1];
        int maxLength = 0;
        int maxI = -1;
        int maxJ = -1;
        for(int i=1;i < a.length();i++){
            for(int j = 1; j <b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    System.out.println("a["+i+"] = "+a.charAt(i)+" b["+j+"] = "+b.charAt(j));
                    matrix[i][j] = matrix[i-1][j-1]+1;
                    if(maxLength < matrix[i][j]){
                        maxLength = matrix[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                }else{
                    matrix[i][j] = 0;
                }

            }
        }
        System.out.println("maxI = "+maxI+" maxJ = "+maxJ);
        return maxLength;
    }

    private int lcaWithRecu(String a, String b , int m, int n, int[][] matrix, int maxLength){
        if(m == a.length()-1 || n == b.length()-1){
            return maxLength;
        }
        if(a.charAt(m-1) == b.charAt(n-1)){
            System.out.println("MATCHING a["+m+"] = "+a.charAt(m)+" b["+n+"] = "+b.charAt(n));
            matrix[m][n] = matrix[m-1][n-1]+1;
            if(maxLength < matrix[m][n]){
                maxLength = matrix[m][n];
            }
            return lcaWithRecu(a,b,m+1,n+1,matrix,maxLength);
        }
        System.out.println("NOT MATCHING a["+m+"] = "+a.charAt(m)+" b["+n+"] = "+b.charAt(n));

        return lcaWithRecu(a,b,m+1,n+1,matrix,maxLength);

    }

    public int longestCommonSubstring(char str1[], char str2[]){
        int T[][] = new int[str1.length+1][str2.length+1];

        int max = 0;
        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = T[i-1][j-1] +1;
                    if(max < T[i][j]){
                        max = T[i][j];
                    }
                }
            }
        }
        return max;
    }
}
