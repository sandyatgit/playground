package com.playground;

import java.util.LinkedList;
import java.util.Queue;

public class TraverseTreeZigZag {
    static Node tree = null;

    static TraverseTreeZigZag inst = new TraverseTreeZigZag();

    class Node{
        int value;
        Node right;
        Node left;

        Node(int value){
            this.value = value;
        }
    }

    public static void main(String... s){
        int[] data = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        inst.constructTree(data);
        Queue<Node> holder = new LinkedList<>();
        ((LinkedList<Node>) holder).add(tree);
        inst.printTree(holder);
         holder = new LinkedList<>();
        ((LinkedList<Node>) holder).add(tree);
        inst.printTreeinZigZag(holder,1);
    }

    //1 - 0
    //23 - 1,2
    //4567 - 3,4,5,6
    //89101112131415 7,8,9,10,11,12,13,14

    private void constructTree(int[] data){
        Queue<Node> holder = new LinkedList<>();
        tree = inst.new Node(data[0]);
        holder.add(tree);
        int startSize = 1;
        Node curr = null;
        while(!holder.isEmpty() && startSize < data.length){
         curr =  holder.poll();
         curr.left = inst.new Node(data[startSize]);;
         curr.right = inst.new Node(data[startSize+1]);
         holder.add(curr.left);
         holder.add(curr.right);
         startSize = startSize+2;
        }


    }

    private void printTree(Queue<Node> holder){
        if(holder.isEmpty()){
            return ;
        }
        System.out.println();
        int count = holder.size();
        for(int i =0; i < count; i++){
            Node curr = holder.poll();
            System.out.print(curr.value+",");
            if(curr.left != null)
                ((LinkedList<Node>) holder).add(curr.left);
            if(curr.right != null)
                ((LinkedList<Node>) holder).add(curr.right);
        }
        printTree(holder);
    }


    private void printTreeinZigZag(Queue<Node> holder, int iterCount){
        if(holder.isEmpty()){
            return ;
        }
        System.out.println();
        int count = holder.size();
        for(int i =0; i < count; i++){
            Node curr = holder.poll();
            System.out.print(curr.value+",");
            if(curr.left != null)
                ((LinkedList<Node>) holder).add(curr.left);
            if(curr.right != null)
                ((LinkedList<Node>) holder).add(curr.right);
        }
        printTreeinZigZag(holder,iterCount+1);
    }


}
