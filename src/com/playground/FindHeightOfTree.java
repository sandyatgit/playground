package com.playground;

import java.util.LinkedList;
import java.util.Queue;

public class FindHeightOfTree {

    private static  FindHeightOfTree height = new FindHeightOfTree();
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public  static void main(String... s){
        Integer[] data = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = height.new TreeNode(data[0]);
        createData(data,root,0);
       System.out.println(height.maxDepth(root));
        System.out.println(height.minDepth(root));


    }

    private static void createData(Integer[] nodes, TreeNode node, int index) {
        int currIndex = 2*index+1;
        if(currIndex < nodes.length && nodes[currIndex] != null){
            node.left = height.new TreeNode(nodes[currIndex]);
            createData(nodes,node.left,currIndex);
        }
        if(currIndex+1 < nodes.length && nodes[currIndex] != null){
            node.right = height.new TreeNode(nodes[currIndex+1]);
            createData(nodes,node.right,currIndex+1);
        }
    }

    public  int maxDepth(TreeNode root) {
        return maxDepth(root,0,0)+1;
    }

    private  int maxDepth(TreeNode node , int height, int maxHeight){
        if(node == null){
            return height-1;
        }
        maxHeight = maxDepth(node.left,height+1,maxHeight);
        height = maxDepth(node.right,height+1,maxHeight);
        if(maxHeight > height){
            return maxHeight;
        }else{
            return height;
        }
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> data = new LinkedList<TreeNode>();
        data.add(root);
        return minDepth(data,1);
    }

    private int minDepth(Queue<TreeNode> data, int height){

        Queue<TreeNode> newData = new LinkedList();
        if(data.isEmpty()){
            return height;
        }

        while(!data.isEmpty()){
            TreeNode currNode = data.remove();
            if(currNode.left == null && currNode.right == null){
                return height;
            }
            if(currNode.left != null)
                newData.add(currNode.left);
            if(currNode.right != null)
                newData.add(currNode.right);
        }

        return minDepth(newData,height+1);
    }


}
