package com.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kcombinatins {

    public static void main(String... s){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        compute(4,2,1,new ArrayList<Integer>(), res);
        res.stream().forEach(x -> {
            System.out.println("");
            x.stream().forEach(y -> System.out.print(y));
        });
    }

    private static void compute(int n, int k, int startIndex, List<Integer> data, List<List<Integer>> res){
        if(data.size() == k){
            res.add(new ArrayList<Integer>(data));
        }
        for(int i=startIndex; i <= n; i++){
            data.add(i);
            compute(n,k,i+1,data, res);
            data.remove(data.size()-1);
        }

    }

    private static void myrecursiveCoputer(int n, int k, int sIndex, List<List<Integer>> res,List<Integer> data ){
        if(data.size() == k){
            res.add(new ArrayList<>(data));
            return;
        }
        for(int i = sIndex; i <= n; i++){
            data.add(i);
            myrecursiveCoputer(n,k,i+1,res,data);
            data.remove(data.size()-1);
        }
    }

    private static List<List<Integer>>  myiterative(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(n==1 && k==1){
            res.add(Arrays.asList(1));
        }
        for(int i=1; i <= n; i++){
            List<Integer> data = new ArrayList<>();
            data.add(i);
            int count = i;
            while(count <= n){
                for(int j = count+1;j <= n;j++ ){
                    data.add(j);
                    if(data.size() == k){
                        res.add(data);
                        break;
                    }
                }

                data = new ArrayList<>();
                data.add(i);
                count++;
            }
        }
        return res;

    }


}
