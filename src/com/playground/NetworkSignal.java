package com.playground;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NetworkSignal {


        public static void main(String... s){
            int[][] data = {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
            System.out.println(new NetworkSignal().networkDelayTime(data,3,1));
        }



    class Node{
        int value;
        boolean visited;
        Map<Node, Integer> linkedData = new HashMap();

        Node(int value){
            this.value = value;
        }
    }

    private Node[] nodes = null;

    public int networkDelayTime(int[][] times, int N, int K) {
        nodes = new Node[N+1];
        for(int i = 0; i< times.length; i++){
            formNodes(times[i],N,K);
        }
        int maxHops =  sendSignal(nodes[K],0,0);
        for(Node n : nodes){
            if(!n.visited){
                return -1;
            }
        }
        return maxHops;
    }

    private int sendSignal(Node kNode,int hops, int maxHops){
        Set<Node> dests = kNode.linkedData.keySet();
        kNode.visited = true;
        if(dests.isEmpty()){
            return hops;
        }
        for(Node dest :  dests){
            if(!dest.visited)
                maxHops = sendSignal(dest,hops+kNode.linkedData.get(dest),maxHops);
        }
        if(maxHops > hops){
            return maxHops;
        }else{
            return hops;
        }
    }


    private void formNodes(int[] times, int N, int K){
        Node source = null;
        Node dest  = null;
        int distance = -1;
        if(nodes[times[0]] != null)
            source =  nodes[times[0]];
        else{
            source = new Node(times[0]);
            nodes[times[0]] = source;
        }

        if(nodes[times[1]] != null)
            dest =  nodes[times[1]];
        else{
            dest = new Node(times[1]);
            nodes[times[1]] = dest;
        }
        source.linkedData.put(dest,times[2]);
    }

}
