package com.playground;

import java.util.*;

public class LeetCodeExample {

    public static void main(String... s){
        List<String> dictionary = new ArrayList<>();
        dictionary.add("POON");
        dictionary.add("PLEE");
        dictionary.add("SAME");
        dictionary.add("TOLN");


        //dictionary.add("COIA");
        dictionary.add("COEA");
        dictionary.add("POEA");
        dictionary.add("COIN");// adding this value before "POIE" will make the current logic fail as method wont function any link from COIN .
        dictionary.add("COIT");
        dictionary.add("CLIT");
        dictionary.add("PLIT");
        dictionary.add("PLET");
        dictionary.add("POIE");
        dictionary.add("PLEA");
        dictionary.add("PLIE");
        dictionary.add("POINT");
        dictionary.add("POIN");

        //findATargetPath("TOON", 1,"PLEA",new ArrayList<String>());
      //  List<String> finalConnections = new ArrayList<String>();
        List<List<String>> result = new LeetCodeExample().findLadders("TOON", "PLEA",dictionary);
        result.stream().forEach(System.out::println);

    }


        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> result = new ArrayList<List<String>>();

            HashSet<String> unvisited = new HashSet<>();
            unvisited.addAll(wordList);

            LinkedList<Node> queue = new LinkedList<>();
            Node node = new Node(beginWord,0,null);
            queue.offer(node);

            int minLen = Integer.MAX_VALUE;
            while(!queue.isEmpty()){
                Node top = queue.poll();

                //top if have shorter result already
                if(result.size()>0 && top.depth>minLen){
                    return result;
                }

                for(int i=0; i<top.word.length(); i++){
                    char c = top.word.charAt(i);
                    char[] arr = top.word.toCharArray();
                    for(char j='z'; j>='a'; j--){
                        if(j==c){
                            continue;
                        }
                        arr[i]=j;
                        String t = new String(arr);

                        if(t.equals(endWord)){
                            //add to result
                            List<String> aResult = new ArrayList<>();
                            aResult.add(endWord);
                            Node p = top;
                            while(p!=null){
                                aResult.add(p.word);
                                p = p.prev;
                            }

                            Collections.reverse(aResult);
                            result.add(aResult);

                            //stop if get shorter result
                            if(top.depth<=minLen){
                                minLen=top.depth;
                            }else{
                                return result;
                            }
                        }

                        if(unvisited.contains(t)){
                            Node n=new Node(t,top.depth+1,top);
                            queue.offer(n);
                            unvisited.remove(t);
                        }
                    }
                }
            }

            return result;
        }


    class Node{
        public String word;
        public int depth;
        public Node prev;

        public Node(String word, int depth, Node prev){
            this.word=word;
            this.depth=depth;
            this.prev=prev;
        }
    }
}
