package com.playground;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer,Node> link = new HashMap<Integer,Node>();
    int capacity;
    int count =0;
    Node head;
    Node leaf;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = link.get(key);
        if(n == null){
            return -1;
        }
        adjustNodes(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = link.get(key);
        if(n != null){
            n.value = value;
            link.put(key,n);
            adjustNodes(n);
            return;
        }
        link.put(key,addNewNode(key,value));
    }

    private Node addNewNode(int key, int value){
        Node n = new Node();
        n.key = key;
        n.value= value;
        if(count == capacity){
            //remove head and make next element head;
            link.remove(head.key);
            head = head.next;
            if(head != null)
             head.prev = null;
            count--;
        }
        n.prev = leaf;
        if(leaf !=  null)
            leaf.next = n;
        leaf = n;
        if(capacity == 1){
            head = n;
            leaf = n;
        }
        //if its first item
        if(head == null)
            head = n;
         count++;
        return n;

    }

    //check if the node is leaf?
    private void adjustNodes(Node n){
        // no need to shuffle
        if(count ==1 ){
            leaf = n;
            head = n;
            return;
        }
        //if the current node is leaf, no need to shuffle
        if(n == leaf){
            return;
        }
        // remove node safely from chain.
        Node tmpPrev  = n.prev;
        Node tmpNext = n.next;
        //currNode is head
        if(tmpPrev == null){
            head = tmpNext;
            tmpNext.prev = null;
        }else{
            tmpPrev.next = tmpNext;
            tmpNext.prev = tmpPrev;
        }

        //orphan the node
        n.next = null;
        n.prev = null;

        // make the currNode leaf
        leaf.next = n;
        n.prev = leaf;
        leaf = n;
    }



    class Node{
        Node next;
        Node prev;
        int key;
        int value;
    }






    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String... s){
         /**LRUCache cache = new LRUCache( 2  );

         cache.put(1, 1);
         cache.put(2, 2);
         System.out.println(cache.get(1));       // returns 1
         cache.put(3, 3);    // evicts key 2
         System.out.println(cache.get(2));       // returns -1 (not found)
         cache.put(4, 4);    // evicts key 1
         System.out.println(cache.get(1));       // returns -1 (not found)
         System.out.println(cache.get(3));       // returns 3
         System.out.println(cache.get(4));       // returns 4*/


        /**LRUCache cache = new LRUCache( 1 );
         cache.put(2, 1);
         System.out.println(cache.get(2));       // returns 1
         cache.put(3, 2);    // evicts key 2
         System.out.println(cache.get(2));       // returns -1 (not found)
         System.out.println(cache.get(3)); */      // returns 2

        /**LRUCache cache = new LRUCache( 2  );
         cache.put(2, 1);
         cache.put(2, 2);
         System.out.println(cache.get(2));       // returns 2
         cache.put(1, 1);
         cache.put(4, 1);
         System.out.println(cache.get(2));*/       // returns -1 (not found)*/

        LRUCache cache = new LRUCache( 3  );
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


}


 /* Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */