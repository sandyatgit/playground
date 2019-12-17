package com.playground;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String... s){
        Solution2 s1 = new Solution2();
        s1.combine(9,3);
        s1.permute(3);
        //List<int[]> data = s1.generate(4,3);
        /*for(int[] intd : data){
            System.out.println("");
            for(int i=0; i<intd.length; i++){
                System.out.print(intd[i]+",");
            }
        }*/
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
       // compute(n,k,1,res,new ArrayList());
        res = compute(n,k);
        res.stream().forEach(x -> {
            System.out.println("");
            x.stream().forEach(y -> System.out.print(y));
        });
        return res;
    }

    public List<List<Integer>> permute(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // compute(n,k,1,res,new ArrayList());
        permute(3,1,res, new ArrayList<>());
        res.stream().forEach(x
                -> {
            System.out.println("");
            x.stream().forEach(y -> System.out.print(y));
        });
        return res;
    }

    static void compute(int n, int k, int sIndex, List<List<Integer>> res,List<Integer> data ){
        if(data.size() == k){
            res.add(new ArrayList<>(data));
            return;
        }
        for(int i = sIndex; i <= n; i++){
            data.add(i);
            compute(n,k,i+1,res,data);
            data.remove(data.size()-1);
        }
    }

    static void permute(int n,  int sIndex, List<List<Integer>> res,List<Integer> data ){
        if(data.size() == n){
            res.add(new ArrayList<>(data));
            return;
        }
        for(int i = sIndex; i <= n; i++){
            data.add(i);
            //compute(n,k,sIndex+1,res,data);
            data.remove(data.size()-1);
        }
    }

    static List<List<Integer>>  compute(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
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

    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];
        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

         while (combination[r - 1] < n) {
            combinations.add(combination.clone());
           // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
           }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
            combination[i] = combination[i - 1] + 1;
            }
         }
       return combinations;
    }
}
