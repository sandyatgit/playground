package com.playground;


import java.util.Arrays;
import java.util.Random;

public class TraverseTree {

    static int min = 10;
    static int max = 100;
    static int level = 4;

    public static void main(String... s){
        Node root1 = new Node(25);
        Node root = new Node(1);

        //createData(root);
        createSequentialData(root);
        //createPictureData(root1);

        System.out.println("*************** PreOrder Traveersal *********************");

       // printDataWithDFSPreOrder(root,1);


        System.out.println("\n*************** InOrder Traveersal *********************");

       // printDataWithDFSInOrder(root,1);

        System.out.println("\n*************** PostOrder Traveersal *********************");

       // printDataWithDFSPostOrder(root,1);

        System.out.println("\n*************** PostOrder Traveersal *********************");

       // Queue<Node> q =  new TraverseTree().new Queue();




        //q.enqueue(root);
        //printDataWithLevelOrderTraversalOnRecursive(q,1);
       Node unBroot = new Node(2) ;
        createUnBalacnedBData(unBroot);
        System.out.println(findHeightOfTree(unBroot));


    }

    private static int findHeightOfRTree(Node root){
        int level = 0;
        if(root != null){
            level =1;
        }
        Node n = root;
        while(n.right != null){
            level++;
            n = n.right;
        }
        return level;
    }

    private static int findHeightOfLTree(Node root){
        int level = 0;
        if(root != null){
            level =1;
        }
        Node n = root;
        while(n.left != null){
            level++;
            n = n.left;
        }
        return level;
    }

    static int lHeight;
    static int rHright;
    private static int findHeightOfTree(Node n) {
        if(n == null){
            return 0;
        }
        lHeight = findHeightOfTree(n.left);
        rHright = findHeightOfTree(n.right);
        if(lHeight > rHright){
            return lHeight +1 ;
        }else{
            return rHright +1 ;
        }

    }

    private static void printDataWithLevelOrderTraversalWithoutQueue(int level) {


    }


    private static void printDataWithLevelOrderTraversal(Queue<Node> q , int level) {
        while(true){
            Node n = q.dequeue();
            if(n == null){
                break;

            }
            System.out.println(n);
            if(n.left != null) {
                q.enqueue(n.left);
            }
            if(n.right != null) {
                q.enqueue(n.right);
            }
        }

    }



    private static void printDataWithLevelOrderTraversalOnRecursive(Queue<Node> q , int level) {
            System.out.println("************ level "+level+"*******************");
            Node n =  null;
            Queue<Node> eq = null;
            while((n = q.dequeue()) != null){
                System.out.println(n);
                if(n.left != null) {
                    if(eq == null)
                        eq = new TraverseTree().new Queue<Node>();
                    eq.enqueue(n.left);
                }
                if(n.right != null) {
                    if(eq == null)
                        eq = new TraverseTree().new Queue<Node>();
                    eq.enqueue(n.right);
                }
            }
            if(eq != null)
                printDataWithLevelOrderTraversalOnRecursive(eq,++level);
    }




    private static void createSequentialData(Node root) {
       /** *************** PreOrder Traveersal *********************
                1,2,4,8,9,5,10,11,3,6,12,13,7,14,15,
            *************** InOrder Traveersal *********************
                8,4,9,2,10,5,11,1,12,6,13,3,14,7,15,
            *************** PostOrder Traveersal *********************
                8,9,4,10,11,5,2,12,13,6,14,15,7,3,1,
        */
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left= new Node(6);
        root.right.right= new Node(7);
        root.left.left.left= new Node(8);
        root.left.left.right= new Node(9);
        root.left.right.left= new Node(10);
        root.left.right.right= new Node(11);

        root.right.left.left= new Node(12);
        root.right.left.right= new Node(13);
        root.right.right.left= new Node(14);
        root.right.right.right= new Node(15);
    }

    private static void createPictureData(Node root){
        //Pre order : 25,15,10,4,12,22,18,24,50,35,31,44,70,66,90
        //In order : 4,10,12,15,18,22,24,25,31,35,44,50,66,70,90
        //PostOrder : 4,12,10,18,24,22,15,31,44,35,66,90,70,50,25
        root.left= new Node(15);
        root.right= new Node(50);
        root.left.left= new Node(10);
        root.left.right= new Node(22);
        root.right.left= new Node(35);
        root.right.right= new Node(70);
        root.left.left.left= new Node(4);
        root.left.left.right= new Node(12);
        root.left.right.left= new Node(18);
        root.left.right.right= new Node(24);

        root.right.left.left= new Node(31);
        root.right.left.right= new Node(44);
        root.right.right.left= new Node(66);
        root.right.right.right= new Node(90);
    }

    private static void createUnBalacnedBData(Node root){

        root.left= new Node(7);
        root.right= new Node(5);
        root.left.left= new Node(2);
        root.left.right= new Node(6);
        root.right.right= new Node(9);
        root.right.right.left= new Node(4);

        root.left.right.left= new Node(5);
        root.left.right.right= new Node(11);



    }

    private static void createData(Node m) {

        createLRNode(m, 1);
        System.out.println("*************** level = 0**********************");
        System.out.println("value = " + m.value);
    }

    private static void printDataWithDFSPreOrder(Node m, int level) {

        if(m == null){
            return;
        }
        System.out.print(m.value +",");
        printDataWithDFSPreOrder(m.left,level);
        printDataWithDFSPreOrder(m.right,level);

        return;

    }

    private static void printDataWithDFSInOrder(Node m, int level) {

        if(m == null){
            return;
        }
        printDataWithDFSInOrder(m.left,level);
        System.out.print(m.value +",");

        printDataWithDFSInOrder(m.right,level);
        return;


    }


    private static void printDataWithDFSPostOrder(Node m, int level) {

        if(m == null){
            return;
        }
        printDataWithDFSPostOrder(m.left,level);

        printDataWithDFSPostOrder(m.right,level);
        System.out.print(m.value +",");

        return;


    }


    private static void createLRNode(Node parent, int height){
        if(height == level){
            return;
        }

        height++;

        Node l = new Node(new Random().nextInt(max-min +1)+min);
        parent.left = l;

        Node r = new Node(new Random().nextInt(max-min +1)+min);
        parent.right = r;

         createLRNode(l,height);
         createLRNode(r,height);

        return;

    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value){
            this.value = value;
        }

        private int getValue(){
            return value;
        }
        public String toString(){
            return String.valueOf(value);
        }
    }

     class Stack<T>{
        private int  defaultQueueSize = 10;
        private T[] data;
        private int index;


        Stack(){
            index = -1;
            data = (T[])new Object[defaultQueueSize];
        }

        private void push(T val){
            if(val == null){
                return;
            }
            index++;
            if(index == defaultQueueSize){
                defaultQueueSize = defaultQueueSize+10;
                T[] newqueue = (T[])new Object[defaultQueueSize];
                System.out.println("Before Copy");

                Arrays.stream(data).forEach(System.out::print);
                copyData(data,newqueue);
                data = newqueue;
                System.out.println("After Copy");

                Arrays.stream(data).forEach(System.out::print);

            }
            data[index] = val;
        }

         private void copyData(T[] queue, T[] newqueue) {

            for(int i=0;i < queue.length; i++){
                newqueue[i] = queue[i];
            }

         }

         private void printStack(){
            Arrays.stream(data).forEach(System.out::print);
         }

         private T pop(){
            if(index == -1){
                System.out.println("No items in data");
            }
            T value = data[index--];
            return value;
        }

    }

    class Queue<T>{
        private int  defaultQueueSize = 10;
        private T[] data;
        private int index;
        private int dequeueIndex;

        Queue(){
            index = -1;
            dequeueIndex = 0;
            data = (T[])new Object[defaultQueueSize];
        }

        private void enqueue(T val){
            if(val == null){
                return;
            }
            index++;
            if(index == defaultQueueSize){
                reallocate();
            }
            data[index] = val;
        }

        private void reallocate() {
            defaultQueueSize = defaultQueueSize+10;
            T[] newqueue = (T[])new Object[defaultQueueSize];
            System.out.println("Before Copy");

            Arrays.stream(data).forEach(System.out::print);
            copyData(data,newqueue);
            data = newqueue;
            System.out.println("After Copy");

            Arrays.stream(data).forEach(System.out::print);
        }

        private void copyData(T[] queue, T[] newqueue) {

            for(int i=0;i < queue.length; i++){
                newqueue[i] = queue[i];
            }

        }

        private void printQueue(){
            Arrays.stream(data).forEach(System.out::print);
        }

        private boolean isEmpty(){
            if(dequeueIndex == index){
                return true;
            }
            return false;
        }

        private T dequeue(){
            if(index == -1){
                System.out.println("No items in data");
            }
            T value = data[dequeueIndex++];
            return value;
        }

    }
}
