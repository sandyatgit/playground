package com.playground;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StringAndPossibleSynonymCounts {
    public static void main(String[] args) {
        String str = "warm cold hot HOT icy sizzling COLD warm day";
        Map<String, Integer> words= countWordsWithSynonyms(countWords(str),synonyms);
        words.keySet().stream().forEach(x -> System.out.println(x+" , "+words.get(x)));

    }

    /*
     * Q1 - For the given input string, return a map of case insensitive
     * words and their counts. Do not worry about punctuation or special
     * characters.
     */
    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> data = new HashMap();
        StringBuffer str = new StringBuffer();
        for(int i=0; i < input.length(); i++){
            if(input.charAt(i) != ' '){
                //if its uppercase, then convert it to lowercase.
                if(input.charAt(i) >= 65 && input.charAt(i) <= 90){
                    char c = ((char)(input.charAt(i) + 32));
                    str.append(c);
                }else{
                    str.append(input.charAt(i));
                }
                continue;

            }
            addWordsToMap(data, str);
        }
        addWordsToMap(data, str);
        return data;
    }

    private static void addWordsToMap(Map<String, Integer> data, StringBuffer str) {
        if (data.containsKey(str.toString())) {
            int count = data.get(str.toString());
            data.put(str.toString(), count + 1);
        } else {
            data.put(str.toString(), 1);
        }
        str.delete(0, str.length());
    }

    /*
     * Q2 - Taking the map from Part 1 and the String[][] of synonyms as
     * inputs, return a map of the words and their counts, combining the count
     * of all synonyms for a given word.
     *
     * Synonyms are symmetric and transitive.
     * The final map can contain any one of synonyms.
     *
     * input: {warm=2, sizzling=1, cold=2, hot=2, day=1, icy=1}
     * output: warm=5, sizzling=5, cold=3, hot=5, day=1, icy=3
     */

    static String[][] synonyms = {
            {"hot", "warm"},
            {"warm", "sizzling"},
            {"cold", "cool"},
            {"icy", "cold"}};
    //hot -> warm
    // warm -> [hot, sizzling]
    // warm -> sizzling

    public static Map<String, Integer> countWordsWithSynonyms( Map<String, Integer> wordMap,String[][] synonyms)
    {

        Map<String, Integer> finalWordCount = new HashMap();
        Map<String, List<String>> source =  createSourceDataInLookUpFriendlyDataStructure(synonyms);

        for(String word : wordMap.keySet()){
            Set<String> visitedStr = new HashSet();
            int count =wordMap.get(word);
            visitedStr.add(word);
            count =findCountofAllPossibleSynonyms(source,visitedStr,wordMap,word,count);
            finalWordCount.put(word,count);
        }
        return finalWordCount;
    }

    //create source data
    private static Map<String, List<String>> createSourceDataInLookUpFriendlyDataStructure(String[][] synonyms) {
        Map<String, List<String>> source = new HashMap();
        for(int i =0 ; i < synonyms.length; i++){
            List<String> relatedWords = null;
            if(source.containsKey(synonyms[i][0])){
                relatedWords = source.get(synonyms[i][0]);
                relatedWords.add(synonyms[i][1]);
            }else{
                relatedWords = new ArrayList<String>();
                relatedWords.add(synonyms[i][1]);
            }
            source.put(synonyms[i][0],relatedWords);

            if(source.containsKey(synonyms[i][1])){
                relatedWords = source.get(synonyms[i][1]);
                relatedWords.add(synonyms[i][0]);
            }else{
                relatedWords = new ArrayList<String>();
                relatedWords.add(synonyms[i][0]);
            }
            source.put(synonyms[i][1],relatedWords);
        }
        return source;
    }


    private static int findCountofAllPossibleSynonyms(Map<String, List<String>> source, Set<String> visitedStr, Map<String, Integer> wordMap,String curr, int count){
        List<String> chainedWord = source.get(curr);
        if(chainedWord == null){
            return count;
        }
        for(String currWord : chainedWord){
            if(wordMap.containsKey(currWord)){
                if(visitedStr.contains(currWord)){
                    continue;
                }
                visitedStr.add(currWord);
                count = count + wordMap.get(currWord);
                count = findCountofAllPossibleSynonyms(source,visitedStr,wordMap,currWord,count);
            }
        }
        return count;
    }

}

