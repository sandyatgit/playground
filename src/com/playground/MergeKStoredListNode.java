package com.playground;

public class MergeKStoredListNode {

    private class ListNode{
      int val;
      ListNode next;
      ListNode(int x){
          val = x;
      }
    }

    public static void main(String... s){
        MergeKStoredListNode inst = new MergeKStoredListNode();
        ListNode l1 = inst.createListNodes(new int[]{1,4,5});
        ListNode l2 =inst.createListNodes(new int[]{1,3,4});
        ListNode l3 = inst.createListNodes(new int[]{2,6});

        ListNode l4 = inst.createListNodes(new int[]{2});
        ListNode l5 =inst.createListNodes(new int[]{});
        ListNode l6 = inst.createListNodes(new int[]{-1});
        ListNode finalO = inst.mergeKLists(new ListNode[]{l4,l5,l6});
        printListNodes(finalO);

    }

    private static void printListNodes(ListNode finalO) {
        System.out.println();
        ListNode tmp =finalO;
        while(true){
            System.out.print(tmp.val);

            tmp = tmp.next;
            if(tmp != null){
                System.out.print(",");
            }else{
                break;
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = null;
        if(lists.length == 0){
            return merged;
        }
        if(lists.length < 2){
            return lists[0];
        }
        for(int i =1 ; i < lists.length; i++){
            if(i == 1){
                merged = mergeTwoNodes(lists[0],lists[1]);
            }else{
                printListNodes(merged);
                merged =mergeTwoNodes(merged, lists[i]);
            }
        }
        return merged;


    }

    private ListNode createListNodes(int[] data){
        ListNode tbr = null;
        ListNode prev = null;
        for(int i=0; i< data.length; i++){
            if(tbr == null){
                tbr = new ListNode(data[i]);
                prev = tbr;
            }else{
               ListNode curr =  new ListNode(data[i]);
               prev.next = curr;
               prev = curr;

            }
        }
        return tbr;

    }

    private ListNode mergeTwoNodes(ListNode node , ListNode node2){
        ListNode root = null;
        if(node == null){
            return node2;
        }else if(node2 == null){
            return node;
        }
        ListNode curr = null;
        ListNode l1Node = node;
        ListNode l2Node = node2;
        while(l1Node != null && l2Node != null){
            if(l2Node.val > l1Node.val){
                if(root == null){
                    root = l1Node;
                }else{
                    curr.next = l1Node;
                }
                curr = l1Node;
                l1Node = l1Node.next;
            }else{
                if(root == null){
                    root = l2Node;
                }else{
                    curr.next = l2Node;

                }
                curr = l2Node;
                l2Node = l2Node.next;
            }

        }

        if(l1Node != null){
            curr.next = l1Node;

        }else if(l2Node != null){
            curr.next = l2Node;
        }

        return root;
    }
}
