package com.playground;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class SortingValues {

    private static Map<String,Integer> p1 = new HashMap<String,Integer>();


    public static void main(String... s){
        populateData();
        System.out.println("Completed population and starting sorting");

        sortData();
    }

    private static void populateData() {
        for(int i = 0; i < 30000 ;i++){
            Double random = Math.random()*((1000-50)+1)+50;
            p1.put("item"+i,random.intValue());
        }

        //p1.entrySet().stream().forEach(e -> System.out.println(e));
        System.out.println("***************************************");

        for(Map.Entry<String,Integer> data :  p1.entrySet()){
           // System.out.println(data.getKey()+"="+data.getValue());
        }
        System.out.println("***************************************");
       // p1.forEach((k,v) -> System.out.println(k+"="+v));
        System.out.println("***************************************");
    }

    private static void sortData() {


        // let's sort this map by values first
        long s1 = System.currentTimeMillis();

        Map<String, Integer> sorted = p1.entrySet().stream().sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue())).collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Time taken for streams-linkedhashmap way : "+String.valueOf((System.currentTimeMillis()-s1))+"ms");
        System.out.println("***************************************");


        long s2 = System.currentTimeMillis();

        //Map<String, Integer> sorted = p1.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
               // toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
       // sorted.entrySet().stream().forEach(e -> System.out.println(e.getKey()+"="+e.getValue()));


        List sortedOnes = p1.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue())).limit(5).collect(Collectors.toList());
        //sortedOnes.stream().forEach(System.out::println);


        System.out.println("Time taken for streams list way : "+String.valueOf((System.currentTimeMillis()-s2))+"ms");

        System.out.println("***************************************");
        long s3 = System.currentTimeMillis();

        Iterator<Map.Entry<String, Integer>> i = p1.entrySet().iterator();

        SortedArrayList<Map.Entry<String, Integer>> entries = new SortedArrayList<>();

        while(i.hasNext()){
            entries.add(i.next());
        }
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //entries.stream().forEach(System.out::println);

        System.out.println("Time taken for conventional way : "+String.valueOf((System.currentTimeMillis()-s3))+"ms");


        long s4 = System.currentTimeMillis();

        Iterator<Map.Entry<String, Integer>> i1 = p1.entrySet().iterator();

        SortedArrayList<Map.Entry<String, Integer>> sList = new SortedArrayList<>();

        while(i1.hasNext()){
            sList.insertSorted(i1.next());
        }

        //sList.stream().forEach(System.out::println);

        System.out.println("Time taken for conventional way with custom sortedList : "+String.valueOf((System.currentTimeMillis()-s4))+"ms");
    }

    static class SortedArrayList<T> extends ArrayList<T> {


        @SuppressWarnings("unchecked")
        public void insertSorted(T value) {
            add(value);
            Comparable<T> cmp = (Comparable<T>) ((Map.Entry<String, Integer>)value).getValue();
            Integer currValue =  ((Map.Entry<String, Integer>)value).getValue();


            for (int i = size()-1; i > 0 && currValue.compareTo(((Map.Entry<String, Integer>)get(i-1)).getValue())<0 ; i--)
                    Collections.swap(this, i, i-1);
        }
    }

}
