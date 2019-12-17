package com.playground;

import java.util.HashSet;
import java.util.Set;

public class Trie {

    public static void main(String... s){
        Trie t = new Trie();
        t.getAllWords().stream().forEach(System.out::println);
    }

        public void addWord(String word) {
        }

        /**
         * Returns all the words in the trie.
         */
        public Set<String> getAllWords() {
            Set<String> probableWords = new HashSet<>();
            String word = "trie";
            char[] source = word.toCharArray();
            probableWords.add(word);
           for(int i=0; i < word.length(); i++){
               for(int j = i+1; j < word.length(); j++){
                   char tmp = source[j];
                   source[j] = source[i];
                   source[i] = tmp;
                   probableWords.add(new String(source));
                   source = word.toCharArray();
               }
           }
           return probableWords;

        }

        /**
         * Returns a random word from current set of words. Each word must have the equal probability of being returned.
         */
        public String getRandomWord() {
            return null;
        }


}
