package com.playground;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StringAndPossibleSynonymCountsWithNode {
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
        //create hashmap with count of lowercase words as all synonyms are in lowercase.
        Map<String, Integer> wordCount = new HashMap();
        String[] words  = input.split(" ");

        for(String word : words){
            int count = 1;
            String lowerCaseWord = word.toLowerCase();
            if(wordCount.containsKey(lowerCaseWord)){
                count = count + wordCount.get(lowerCaseWord);
            }
            wordCount.put(lowerCaseWord, count);
        }
        return wordCount;
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
        Map<String, Node> source =  createSourceDataInLookUpFriendlyDataStructure(synonyms);

        for(String word : wordMap.keySet()){
            Set<String> visitedNodes = new HashSet();
            int count =wordMap.get(word);
            visitedNodes.add(word);
            count = findCountofAllPossibleSynonyms(source,visitedNodes,wordMap,word,count);
            finalWordCount.put(word,count);
        }
        return finalWordCount;
    }

    //create source data
    private static Map<String, Node> createSourceDataInLookUpFriendlyDataStructure(String[][] synonyms) {
        Map<String, Node> source = new HashMap();


        for(int i =0 ; i < synonyms.length; i++){
            Node parentNode = getNode(source,synonyms[i][0]);
            Node synonymNode = getNode(source,synonyms[i][1]);

            //add dependency between Nodes
            parentNode.addNodes(synonymNode);
            source.put(synonyms[i][0],parentNode);

            //add dependency between Nodes
            synonymNode.addNodes(parentNode);
            source.put(synonyms[i][1],synonymNode);
        }
        return source;
    }

    //create new Node or get from source.
    private static Node getNode( Map<String, Node> source, String synonym) {
        Node node = null;
        if (source.containsKey(synonym)) {
            node = source.get(synonym);
        } else {
            node = new Node(synonym);
        }
        return node;
    }

    //get  count of all possible synonyms for a word.
    private static int findCountofAllPossibleSynonyms(Map<String, Node> source, Set<String> visitedNodes, Map<String, Integer> wordMap, String curr, int count){
        Node childNodes = source.get(curr);
        if(childNodes == null){
            return count;
        }

        for(Node node : childNodes.nodes){
            if(wordMap.containsKey(node.value)){
                if(visitedNodes.contains(node.value)){
                    continue;
                }
                visitedNodes.add(node.value);
                count = count + wordMap.get(node.value);
                count = findCountofAllPossibleSynonyms(source,visitedNodes,wordMap,node.value,count);
            }
        }
        return count;
    }

   //Node class to hold word and its synonyms
   static  class Node{
        String value;
        List<Node> nodes = new ArrayList();
        private Node(String value){
            this.value=value;
        }
        private void addNodes(Node n){
            nodes.add(n);
        }
    }

}

