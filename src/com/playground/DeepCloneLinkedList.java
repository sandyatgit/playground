package com.playground;

import java.util.HashMap;
import java.util.Map;

public class DeepCloneLinkedList {


// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}


        public Node copyRandomList(Node head) {
            Map<Integer,Node> data = new HashMap<>();
            Node chead = null;
            Node cPhead = null;
            Node currNode = head;
            while(currNode != null){
                Node node = null;
                //check if the node is already created in hashmap
                if(data.containsKey(currNode.val)){
                    node = data.get(currNode.val);
                }else{
                    node = new Node();
                    node.val = currNode.val;
                    data.put(node.val,node);
                }
                //assign this current node to "next" of previous node.
                if(cPhead != null){
                    cPhead.next=node;
                }
                //assign this as previous node before going to next iteratoin.
                cPhead = node;
                // if its first node, then assign it as head.
                if(chead == null){
                    chead = node;
                }
                //assign next node to iterate. 
                currNode = currNode.next;

                if(currNode.random == null){
                    continue;
                }

                //create stub random node;
                Node cRandomNode = null;
                if(data.containsKey(currNode.random.val)){
                    cRandomNode = data.get(currNode.random.val);

                }else{
                    cRandomNode = new Node();
                    cRandomNode.val = currNode.random.val;
                    data.put(cRandomNode.val, cRandomNode);
                }
                //assign random to random property of currNode
                node.random = cRandomNode;



            }
            return chead;
        }

}
