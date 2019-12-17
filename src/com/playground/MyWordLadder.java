package com.playground;

import java.util.*;


public class MyWordLadder {
    private static MyWordLadder ourInstance = new MyWordLadder();

     class Node{
         String value;
         List<Node> adjacentNodes;

         Node(String value){
             this.value = value;
         }

         public void addAdjacentNodes(Node n){
             if(adjacentNodes == null){
                 adjacentNodes = new ArrayList<>();
             }
             adjacentNodes.add(n);
         }
         public String toString(){
             return this.value;
         }

    }

    public static MyWordLadder getInstance() {
        return ourInstance;
    }


        public static void main(String... s){
            MyWordLadder ladder = new MyWordLadder();
            ladder.findLadders("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        }



        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
          Node rootNode = createGraph(beginWord,wordList);
         // findShortestPath(rootNode, String beginWord, String endWord);
          return null;
        }

        private int findShortestPath(Node currNode, String beginWord, String endWord){

            if(currNode.toString().equals(endWord)){
                return 0;
            }


            return -1;

        }




        private Node createGraph(String beginWord,List<String> wordList) {
         Map<String,Node> visitedNodes = new HashMap<>();
         Node rootNode = null;
         for(int i=-1; i < wordList.size(); i++){
             String curr ;
             Node currNode = null;
             if(i ==-1){
                 curr = beginWord;
                 rootNode = new Node(curr);
                 currNode = rootNode;
             }else{
                 curr = wordList.get(i);
                 if(visitedNodes.containsKey(curr)){
                     currNode = visitedNodes.get(curr);
                 }else{
                     currNode = new Node(curr);
                     visitedNodes.put(curr,currNode);
                 }
             }
             for(int j =i+1; j < wordList.size(); j++){
                 String currItr = wordList.get(j);
                 int diff = 0;
                 if(currItr.length() != curr.length()){
                     continue;
                 }
                 if(currItr.equals(curr)){
                     continue;
                 }
                 for(int k =0; k < curr.length(); k++){
                     if(curr.charAt(k) != currItr.charAt(k)){
                         diff++;
                     }
                     if(diff > 2){
                         break;
                     }
                 }
                 if(diff == 1){
                     Node node = visitedNodes.get(currItr);
                     if(node == null){
                         node = new Node(currItr);
                         visitedNodes.put(currItr,node);
                     }
                     //parent node is null, create one and add it

                     currNode.addAdjacentNodes(node);

                 }
             }
         }
         return rootNode;

        }


}
