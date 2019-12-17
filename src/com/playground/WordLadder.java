package com.playground;

import org.omg.CORBA.PolicyError;

import java.util.*;

public class WordLadder {
    /**
     * Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
     *              start = TOON
     *              target = PLEA
     * Output: 7
     * Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
     */


    private static Map<String,List<String>> loadedData = new HashMap();
    private static Set<String> visitedString = new HashSet<>();
    private static Map<Integer,List<String>> allAvailablePaths = new HashMap<>();
    private static int mintHeight = -1;

    static{



    }

    public static void main(String... s){
        List<String> dictionary = new ArrayList<>();
        dictionary.add("POON");
        dictionary.add("PLEE");
        dictionary.add("SAME");
        dictionary.add("TOLN");


        dictionary.add("COIA");
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
        createDictionary(dictionary,"TOON");
        printDictionary();


        //findATargetPath("TOON", 1,"PLEA",new ArrayList<String>());
        List<String> finalConnections = new ArrayList<String>();
        findATargetPath("TOON",1,"PLEA",finalConnections);
        //reset visited string for new program
        visitedString = new HashSet<>();
        printConnections(finalConnections);
        Queue<String> words = new Queue<>();
        words.enqueue("TOON");

        System.out.println("Shortest path = "+findShortestPath("PLEA",1,words));
        //findAlltargetPath("TOON", 1,"PLEA",finalConnections);

        //
    }

    private static void printConnections(List<String> finalConnections) {
        allAvailablePaths.entrySet().forEach(v -> {
            System.out.println("lenght = "+v.getKey());
            List<String> values = v.getValue();
            Collections.reverse(values);
            values.stream().forEach(k -> {
                System.out.print(k);
                if(values.get(values.size()-1) != k){
                    System.out.print(",");
                }
            });
        });
        finalConnections.stream().forEach(k->System.out.print(k+","));


       // finalConnections.printStack();
    }

    private static int findShortestPath(String target, int level, Queue<String> words){
        List<String> currWords = new ArrayList<>();
        while(true){
           String value =  words.dequeue();
           if(value == null){
               break;
           }else{
               visitedString.add(value);
               currWords.add(value);
           }
        }
        if(currWords.isEmpty()){
            return -1;
        }
        level = level+1;
        System.out.println("START : ***************** level "+level+"***********************");
        for(String currWord : currWords){
            for(String d : loadedData.get(currWord)){
                if(d.equals(target)){
                    return level;
                }
                if(!visitedString.contains(d)) {
                    System.out.println(d);
                    words.enqueue(d);
                }
            }
        }

        System.out.println("END : ***************** level "+level+"***********************");
        return findShortestPath(target,level,words);
    }


    private static boolean findAlltargetPath(String base, int level, String target,List<String> finalConnections) {

        if(base == null){
            return false;
        }
        if(base.equals(target)){
            return true;
        }

        if(visitedString.contains(base)){
            return false;
        }
        visitedString.add(base);

        List<String> connections = loadedData.get(base);
        finalConnections.add(level+":"+ base);


        ++level;

        for(String conn : connections) {
            boolean isConnectionFound = findAlltargetPath(conn, level, target, finalConnections);

            if (isConnectionFound) {
                if(mintHeight ==-1){
                    mintHeight = level;
                }
                if(level < mintHeight){
                    mintHeight = level;
                    System.out.println("min height = "+mintHeight);
                }
                finalConnections.add(level+":"+ conn);
                System.out.println("Connection found at level "+level);
                continue;


            } else {
                continue;
            }
        }
        return false;
    }


    private static boolean findATargetPath(String base, int level, String target,List<String> finalConnections) {

        if(base == null){
            return false;
        }
        if(base.equals(target)){
            return true;
        }
        if(visitedString.contains(base)){
            return false;
        }
        visitedString.add(base);

        List<String> connections = loadedData.get(base);
        ++level;
        for(String conn : connections) {
            boolean isConnectionFound = findATargetPath(conn, level, target, finalConnections);

            if (isConnectionFound) {
                finalConnections.add(level+":"+ conn);
                if (level == 2) {
                    finalConnections.add(level-1+":"+ base);
                    allAvailablePaths.put(finalConnections.size(),finalConnections);
                }
                return true;
            } else {
                continue;
            }
        }
        return false;
    }


    private static void printDictionary() {
        loadedData.entrySet().stream().forEach(k-> System.out.println("key = "+k.getKey()+" , value = "+k.getValue()));
    }

    public static void createDictionary(List<String> dictionary, String startingWord){
        dictionary.add(startingWord);
        List<String> connectionsForBase  = null;
        String base = null;
        for(int i =0; i < dictionary.size(); i++){
            base = dictionary.get(i);
            if(loadedData.containsKey(base)){
                connectionsForBase = loadedData.get(base);
            }else{
                connectionsForBase = new LinkedList<>();
                loadedData.put(base,connectionsForBase);
            }
            for(int j=i+1;j<dictionary.size();j++){
                int differences = 0;
                String curr = dictionary.get(j);
                if(base.length() == curr.length()){
                    for(int k=0; k < base.length(); k++){
                        if(base.charAt(k) != curr.charAt(k)){
                            differences++;
                        }
                        if(differences > 1){
                            break;
                        }
                    }
                    if(differences ==1) {
                        connectionsForBase.add(curr);
                        if (loadedData.containsKey(curr)) {
                            loadedData.get(curr).add(base);
                        } else {
                            loadedData.put(curr, new LinkedList<>());
                            loadedData.get(curr).add(base);
                        }
                    }
                }
            }
        }
        Iterator<String> itr = dictionary.iterator();

        while(itr.hasNext()){
            String text = itr.next();
            if(loadedData.containsKey(text)){
                continue;
            }else{
                loadedData.put(text,new LinkedList<String>());

            }


        }

    }



    static class Queue<T>{
        private int  defaultQueueSize = 10;
        private T[] data;
        private int index;
        private int dequeueIndex;

        Queue(){
            index = -1;
            dequeueIndex = -1;
            data = (T[])new Object[defaultQueueSize];
        }

        private void enqueue(T val){
            if(val == null){
                return;
            }
            index++;
            if(index == defaultQueueSize){
                reallocate();
            }
            data[index] = val;
        }

        private void reallocate() {
            defaultQueueSize = defaultQueueSize+10;
            T[] newqueue = (T[])new Object[defaultQueueSize];
            System.out.println("Before Copy");

            Arrays.stream(data).forEach(System.out::print);
            copyData(data,newqueue);
            data = newqueue;
            System.out.println("After Copy");

            Arrays.stream(data).forEach(System.out::print);
        }

        private void copyData(T[] queue, T[] newqueue) {

            for(int i=0;i < queue.length; i++){
                newqueue[i] = queue[i];
            }

        }

        private void printQueue(){
            Arrays.stream(data).forEach(System.out::print);
        }

        private boolean isEmpty(){
            if(dequeueIndex == index){
                return true;
            }
            if(index == -1){
                return true;
            }
            return false;
        }

        private T dequeue(){
            if(index == -1){
                System.out.println("No items in data");
                return null;
            }if(dequeueIndex == index){
                System.out.println("No items in data");
                return null;
            }
            T value = data[++dequeueIndex];
            return value;
        }

    }


    static class Stack<T>{
        private int  defaultQueueSize = 10;
        private T[] data;
        private int index;


        Stack(){
            index = -1;
            data = (T[])new Object[defaultQueueSize];
        }

        private void push(T val){
            if(val == null){
                return;
            }
            index++;
            if(index == defaultQueueSize){
                defaultQueueSize = defaultQueueSize+10;
                T[] newqueue = (T[])new Object[defaultQueueSize];
                System.out.println("Before Copy");

                Arrays.stream(data).forEach(System.out::print);
                copyData(data,newqueue);
                data = newqueue;
                System.out.println("After Copy");

                Arrays.stream(data).forEach(System.out::print);

            }
            data[index] = val;
        }

        private void copyData(T[] queue, T[] newqueue) {

            for(int i=0;i < queue.length; i++){
                newqueue[i] = queue[i];
            }

        }

        private void printStack(){
            String value = (String)pop();
            while(value != null){
                System.out.print(value+",");
                value = (String)pop();;
            }
        }

        private T pop(){
            if(index == -1){
                System.out.println("\n");
                System.out.println("No items in data");
                return null;
            }
            T value = data[index--];
            return value;
        }

    }



}
