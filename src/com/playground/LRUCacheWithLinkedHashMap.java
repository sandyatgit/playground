package com.playground;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {

    public static void main(String... s){




           /** LRUCache cache = new LRUCacheWithLinkedHashMap().new LRUCache( 2  );

             cache.put(1, 1);
             cache.put(2, 2);
             System.out.println(cache.get(1));       // returns 1
             cache.put(3, 3);    // evicts key 2
             System.out.println(cache.get(2));       // returns -1 (not found)
             cache.put(4, 4);    // evicts key 1
             System.out.println(cache.get(1));       // returns -1 (not found)
             System.out.println(cache.get(3));       // returns 3
             System.out.println(cache.get(4));       // returns 4*/


             /**LRUCache cache = new LRUCacheWithLinkedHashMap().new LRUCache( 1 );
             cache.put(2, 1);
             System.out.println(cache.get(2));       // returns 1
             cache.put(3, 2);    // evicts key 2
             System.out.println(cache.get(2));       // returns -1 (not found)
             System.out.println(cache.get(3));       // returns 2*/

             /**LRUCache cache = new LRUCacheWithLinkedHashMap().new LRUCache( 2  );
             cache.put(2, 1);
             cache.put(2, 2);
             System.out.println(cache.get(2));       // returns 2
             cache.put(1, 1);
             cache.put(4, 1);
             System.out.println(cache.get(2)); */      // returns -1 (not found)*/

            LRUCache cache = new LRUCacheWithLinkedHashMap().new LRUCache( 3  );
            cache.put(1, 1);
            cache.put(2, 2);
            cache.put(3, 3);
            cache.put(4, 4);
            System.out.println(cache.get(4)); // return 4
            System.out.println(cache.get(3)); // return 3
            System.out.println(cache.get(2)); // return 2
            System.out.println(cache.get(1)); // return -1
            cache.put(5, 5); // evict 4 and add 5 in the front. {5,2,3}
            System.out.println(cache.get(1)); //return -1
            System.out.println(cache.get(2));//return 2 {2,5,3}
            System.out.println(cache.get(3));//return 3 {3,2,5}
            System.out.println(cache.get(4)); //return -1
            System.out.println(cache.get(5));//return 5 {5,3,2}
            //expected output [4,3,2,-1,-1,2,3,-1,5]
        }




    class LRUCache<K,V> extends LinkedHashMap<K, V> {
        int capacity;

        public LRUCache(int capacity){
            this.capacity = capacity;
        }


        @Override
        public V get(Object key) {
            V data = super.get(key);
            if(data == null){
                return (V)Integer.valueOf(-1);
            }else{
                remove((K)key);
                put((K) key,data);
            }
            return data;
        }

        public V put(K key, V value) {
            V data = super.get(key);
            if(data == null){
                return super.put((K) key,value);
            }else{
                super.remove((K)key);
                super.put((K) key,value);
            }
            return value;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity? true: false;
        }
    }

    //Another way to implement LRUCache with LinkedHashMap
    class LRUCacheOwn<K,V>  {
        int capacity;
        private  Map<K,V> cache;

        public LRUCacheOwn(int capacity){
            this.capacity = capacity;
            this.cache = new LinkedHashMap<K, V>(){

                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > capacity;
                }
            };
        }


        public V get(Object key) {
            V data = cache.get(key);
            if(data == null){
                return (V)Integer.valueOf(-1);
            }else{
                cache.remove((K)key);
                cache.put((K) key,data);
            }
            return data;
        }

        public V put(K key, V value) {
            V data = cache.get(key);
            if(data == null){
                return cache.put((K) key,value);
            }else{
                cache.remove((K)key);
                cache.put((K) key,value);
            }
            return data;
        }
    }


}
