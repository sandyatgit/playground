package com.playground;

public class Combinations {
    public static void main(String... s){
        combine("abcd",new StringBuffer(), 0);
        //combo("abcd","");
    }

    static void combine(String instr, StringBuffer outstr, int index)
    {
        boolean[] visitedChars = new boolean[26];
        for (int i = index; i < instr.length(); i++)
        {
            if(visitedChars[instr.charAt(i) - 'a'] == true){
                continue;
            }
            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            visitedChars[instr.charAt(i) - 'a'] = true;
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }
    private static void swap(char[] ch, int index, int i) {
        char tmp =ch[index];
        ch[index] = ch[i];
        ch[i] = tmp;
    }




    static void firstKCom(String instr, StringBuffer outstr, int index)
    {
        boolean[] visitedChars = new boolean[26];
        for (int i = index; i < instr.length(); i++)
        {
            if(visitedChars[instr.charAt(i) - 'a'] == true){
                continue;
            }
            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            visitedChars[instr.charAt(i) - 'a'] = true;
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    static void combo( String s,String prefix)
    {
        int N = s.length();

        System.out.println(prefix);

        for (int i = 0 ; i < N ; i++)
            combo(s.substring(i+1),prefix + s.charAt(i));
    }







}
