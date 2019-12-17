package com.playground;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    static SymmetricTree inst = new SymmetricTree();
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String... s){
        int[] nodes = new int[]{1,2,2,3,4,4,3,5,6,7,8,8,7,6,5};
        TreeNode data = inst.new TreeNode(nodes[0]);
        createData(nodes,data,0);
        System.out.println(inst.isSymmetric(data));
    }




           //0//     1
           //1//  2        2
          //2//  3 4      4 3
          //3// 5 6 7 8  8 7 6 5
   /* i=0 i 1 i=2
    i=1 i=3 i=4
    i=2 i=5 i=6
    i=3 i=7 i =8
    i=4 i=9,i=10
    i=3 i=7 i=8
    i=5 i=11 i=12
    i=6 i=13 i=14*/




    private static void createData(int[] nodes, TreeNode node, int index) {
        int currIndex = 2*index+1;
        if(currIndex < nodes.length){
            node.left = inst.new TreeNode(nodes[currIndex]);
            createData(nodes,node.left,currIndex);
        }
        if(currIndex+1 < nodes.length){
            node.right = inst.new TreeNode(nodes[currIndex+1]);
            createData(nodes,node.right,currIndex+1);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        //return isSymmetricDFS(root.left,root.right);
        Queue<TreeNode> left = new LinkedList();
        left.add(root.left);
        Queue<TreeNode> right = new LinkedList();
        right.add(root.right);
        return isSymmetricBFS(left,right);
    }

    public boolean isSymmetricBFS(Queue<TreeNode> left, Queue<TreeNode> right) {
        if(left.isEmpty() && right.isEmpty()){
            return true;
        }
        if(left.size() != right.size()){
            return false;
        }

        Queue<TreeNode> nextleft = new LinkedList();
        Queue<TreeNode> nextRight = new LinkedList();


        while(!left.isEmpty()){
            TreeNode leftNode = left.poll();
            TreeNode rightNode = right.poll();
            if(leftNode.val != rightNode.val){
                return false;
            }
            if(leftNode.left != null)
                nextleft.add(leftNode.left);
            if(leftNode.right != null)
                nextleft.add(leftNode.right);
            if(rightNode.right != null)
                nextRight.add(rightNode.right);
            if(rightNode.left != null)
                nextRight.add(rightNode.left);
        }
        if(!right.isEmpty()){
            return false;
        }

        if(!isSymmetricBFS(nextleft,nextRight)){
            return false;
        }
        return true;

    }

    private boolean isSymmetricDFS(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
       if(!isSymmetricDFS(left.left,right.right)){
           return false;
       }
        if(!isSymmetricDFS(left.right,right.left)){
            return false;
        }
        return true;

    }
}
