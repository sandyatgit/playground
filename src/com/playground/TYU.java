package com.playground;

public class TYU {

    public static void main(String... s){
        String data = "abcd";
        data = "geek";
        //findPermutationsOfString(data,"");
        //permute(data,"");
        permutations(data.toCharArray(),0);
    }

    private static void findPermutationsOfString(String currString, String result) {

        if(currString == null || currString.length() ==0){
            System.out.println(result);
            return;
        }
        boolean[] visitedChars = new boolean[26];

        for(int i=0; i < currString.length(); i++){
            char ch = currString.charAt(i);
            if(visitedChars[ch-'a'] == true) {
                continue;
            }
            visitedChars[ch-'a'] = true;
            String modifiedString = currString.substring(0, i) + currString.substring(i+1);
            findPermutationsOfString(modifiedString,  result+ch);

        }
    }

    // Utility function to swap two characters in a character array
    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // Recursive function to generate all permutations of a String
    private static void permutations(char[] ch, int currentIndex)
    {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }
        boolean[] visitedChars = new boolean[26];
        for (int i = currentIndex; i < ch.length; i++)
        {
            if(visitedChars[ch[i]-'a'] == true) {
                continue;
            }
            visitedChars[ch[i]-'a'] = true;
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }


    static void permute( String s,String prefix)
    {
        int N = s.length();

        if (N == 0)
            System.out.println(" " + prefix);

        for (int i = 0 ; i < N ; i++)
            permute( s.substring(0, i) + s.substring(i+1),prefix + s.charAt(i));
    }



}
