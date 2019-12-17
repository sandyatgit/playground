package com.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by z002bbt on 7/31/17.
 */
public class Java8Examples {

    public static void main(String... s) {
        Java8Examples obj = new Java8Examples();
        //List<String> data1 = Arrays.asList("test1", "test2", "test3","LRUCacheWithLinkedHashMap","test1", "test2", "test3","LRUCacheWithLinkedHashMap",);
        List<Integer> data1 = new ArrayList<>();

       // List<String> data2 = Arrays.asList("test1", "test2");
        List<Integer> data2 = new ArrayList<>();
        for(int i=0 ; i < 100000; i++){
            data1.add(i);
        }

        for(int i =50 ; i < 150000; i++){
            data2.add(i);
        }
        System.out.println("**********  Find mod in the list of numbers in Pre Java 8  ************");
        obj.preJava8ImplFindMod(data1, data2);
        System.out.println("**********  Find mod in the list of numbers in  Post Java 8  ************");
        obj.java8ImplFindMod(data1,data2);
        System.out.println("**********  Find Common Numbers in 2  list  in Pre Java 8  ************");
        obj.preJava8ImplFindNumberInOtherList(data1, data2);
        System.out.println("**********  Find Common Numbers in 2  list  in  Post Java 8  ************");
        obj.java8ImplFindNumberInOtherList(data1,data2);
    }

    private   void java8ImplFindNumberInOtherList(List<Integer> data1, List<Integer> data2) {
        long currTime = System.currentTimeMillis();
        // data1.stream().forEach(data -> System.out.println(data));
        //List<Integer> filteredList = data1.stream().filter(data -> data2.contains(data)).collect(Collectors.toList());
         List<Integer> filteredList = data1.parallelStream().filter(data1::contains).collect(Collectors.toList());


        System.out.println("total time in java8 loop = " +String.valueOf(System.currentTimeMillis() - currTime)+"ms");
    }

    private  void java8ImplFindMod(List<Integer> data1, List<Integer> data2) {
        long currTime = System.currentTimeMillis();


        //List<Integer> filteredList = data1.stream().filter(data -> (data%2 == 0)).collect(Collectors.toList());
       List<Integer> filteredList = data1.stream().filter(data -> (data%2 == 0)).collect(Collectors.toList());

        System.out.println("total time in java8 loop = " +String.valueOf(System.currentTimeMillis() - currTime)+"ms");

       // List number = Arrays.asList(2,3,4,5);
        //int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
       // System.out.println(filteredList);
    }

    private  void preJava8ImplFindNumberInOtherList(List<Integer> data1, List<Integer> data2) {
        long currTime = System.currentTimeMillis();
        List<Integer> filteredData = new ArrayList<>();
        for(Integer data:data1){
            if(data2.contains(data)){
                filteredData.add(data);
            }
        }

        System.out.println("total time in java7 loop = " +String.valueOf(System.currentTimeMillis() - currTime)+"ms");
        //System.out.println(filteredData);
    }


    private  void preJava8ImplFindMod(List<Integer> data1, List<Integer> data2) {
        long currTime = System.currentTimeMillis();
        List<Integer> filteredData = new ArrayList<>();
        for(Integer carrier:data1){
            if(carrier %2 ==0){
                filteredData.add(carrier);
            }
        }

        System.out.println("total time in java7 loop = " +String.valueOf(System.currentTimeMillis() - currTime)+"ms");
        //System.out.println(filteredData);
    }





}
