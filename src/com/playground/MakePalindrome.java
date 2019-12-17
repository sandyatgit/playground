package com.playground;

public class MakePalindrome {

    public static void main(String... s){
        System.out.println( new MakePalindrome().isValidPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println( new MakePalindrome().isValidPalindrome("abac"));
        System.out.println( new MakePalindrome().isValidPalindrome("lucul"));
        System.out.println( new MakePalindrome().isValidPalindrome("lucucl"));
        System.out.println( new MakePalindrome().isValidPalindrome("abc"));
        System.out.println( new MakePalindrome().isValidPalindrome("lcucupucul"));



        //alucrarccla
                //lcucupucul





    }

    public boolean isValidPalindrome(String s){
        return makePalindrome(s, true);
    }
    public boolean makePalindrome(String s, boolean removeChar){
        for(int i=0,j=s.length()-1; i < s.length(); i++,j--){
            if(i ==j || i > j){
                break;
            }
            if(s.charAt(i) != s.charAt(j)){
                if(removeChar){
                    if( !makePalindrome(s.substring(i,j),false)){
                        return makePalindrome(s.substring(i+1,j+1), false);
                    }else{
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }


    public boolean validPalindromeExisting(String s) {
        {

            int i = 0;
            System.out.println("i="+i);
            int j = s.length()-1;
            System.out.println("j="+i);
            boolean changedChar = false;
            System.out.println("i="+i);
            System.out.println("j="+i);
            while(true){
                if(i > j || i==j){
                    break;
                }
                if(s.charAt(i) == s.charAt(j)){
                    j--;
                    i++;
                    continue;
                }else if(!changedChar){
                    int tmpi = i+1;
                    if(s.charAt(tmpi) == s.charAt(j)){
                        changedChar= true;
                        j--;
                        i=i+2;
                        continue;
                    }
                    int tmpj = j-1;
                    if(s.charAt(i) == s.charAt(tmpj)){
                        changedChar= true;
                        j=j-2;
                        i++;
                        continue;
                    }
                    if(i == j-1){
                        changedChar= true;
                        j--;
                        i++;
                        continue;
                    }
                    return false;
                }else{
                    return false;
                }




            }
            return true;
        }
    }


}
