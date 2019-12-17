package com.playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingArrayList {
    public static void main(String... s){
        List<String> data = Arrays.asList(new String[]{"abc","dbc","cabe","ted"});
        Collections.sort(data);
        data.stream().forEach(d->System.out.println(d));
    }
}
