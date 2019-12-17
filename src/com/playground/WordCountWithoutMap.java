package com.playground;

import java.util.Arrays;
import java.util.List;

public class WordCountWithoutMap {
    public static void main(String... s){
        List<String> data = Arrays.asList("trie","trees","tree","tip","zero","zeros","zero","trip");
        Trie t =  new WordCountWithoutMap().new Trie();
        for(String d : data){
            t.addWord(d.toCharArray());
        }

        t.printAllWords();
    }

    class Trie{
        Node root = new Node();

        void addWord(char[] s){
            Node prevNode = root;
            Node currNode = null;
            for(int i=0; i < s.length; i++){
                currNode = prevNode.data[s[i] - 'a'];
                if(currNode == null){
                    currNode = new Node(s[i]);
                    prevNode.data[s[i] - 'a'] = currNode;
                }
                prevNode = currNode;
            }
            if(currNode != null){
                currNode.leaf = true;
                currNode.count= currNode.count+1;
            }
        }

        public void printAllWords(){
            printWords(root,new StringBuffer());
        }

        //tree
        //trees
        //trie
        private void printWords(Node n,StringBuffer str) {
            if(n.leaf){
                System.out.println(str.toString() + " count = "+n.count);

            }
            for(int i=0; i < n.data.length; i++){
                if(n.data[i] != null){
                    str.append(n.data[i].value);
                    printWords(n.data[i],str);
                }else if(i==25){
                    str.deleteCharAt(str.length()-1);
                }
            }

        }


        class Node{
            char value;
            int count;
            boolean leaf;
            public Node(){
            }
            public Node(char c){
                value =c ;
            }
            Node[] data = new Node[26];
        }

    }
}
