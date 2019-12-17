package com.playground;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AddTwoNumbers {
    public static void main(String... s){
        //Input: (2 -> 4 -> 3) + (5 -> 6 -> 7)
/*9
879

1558
8551



        9 7 6
        9 7 8
        8 5 51*/




//[9]
//[1,9,9,9,9,9,9,9,9,9]
       // [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//[5,6,4]



        Dataset1 dataset1 = new Dataset1().invoke();
        ListNode l1 = dataset1.getL1();
        ListNode l2 = dataset1.getL4();

        Dataset2 dataset2 = new Dataset2().invoke();
        ListNode l3 = dataset2.getL1();
        ListNode l4 = dataset2.getL4();



        ListNode n = new AddTwoNumbers().addTwoNumbersEfficient(l3,l4);
        ListNode tmp = n;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbersEfficient(ListNode l1, ListNode l2){
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        ListNode curL3 = null;
        ListNode tmpNode = null;
        int sum = 0;
        int carryOver = 0;
        while(true){



                if(curL1 == null && curL2 == null){
                    if(tmpNode != null && carryOver > 0){
                        tmpNode.next = new ListNode(carryOver);
                    }
                    break;
                }
                if(curL1 != null && curL2 != null){
                    sum = carryOver + curL1.val + curL2.val;
                    carryOver = sum/10;
                    sum = sum%10;
                    curL2 = curL2.next;
                    curL1 = curL1.next;
                }else if(curL1 != null){
                    sum = carryOver+ curL1.val;
                    carryOver = sum/10;
                    sum = sum%10;
                    curL1 = curL1.next;
                }else{
                    sum = carryOver+ curL2.val;
                    carryOver = sum/10;
                    sum = sum%10;
                    curL2 = curL2.next;
                }
                if(tmpNode == null){
                    curL3 = new ListNode(sum);
                    tmpNode = curL3;
                }else{
                    tmpNode.next = new ListNode(sum);
                    tmpNode = tmpNode.next;
                }
            }

        return curL3;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum1 = BigInteger.valueOf(0);
        BigInteger sum2 = BigInteger.valueOf(0);
        int i=0;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        while(true){
            if(curL1 == null && curL2 == null){
                break;
            }
            if(curL1 != null){

                    sum1 =  sum1.add(BigInteger.valueOf(((long)curL1.val * Math.round(Math.pow(10,i)))));


                curL1 = curL1.next;
            }
            if(curL2 != null){

                    sum2 = sum2.add(BigInteger.valueOf(curL2.val * Math.round(Math.pow(10,i))));


                curL2 = curL2.next;
            }

            i++;
        }
        i=0;
        BigInteger total = sum1.add(sum2);
        ListNode l3 = new ListNode(0);
        ListNode curL3 = l3;
        while(true){
            curL3.val  = total.mod(BigInteger.valueOf(10)).intValue();
            total = total.divide(BigInteger.valueOf(10));
            if(total.equals(BigInteger.valueOf(0))){
                break;
            }
            curL3.next = new ListNode(0);
            curL3 = curL3.next;
        }
        return l3;
    }

    private static class Dataset1 {
        private ListNode l1;
        private ListNode l4;

        public ListNode getL1() {
            return l1;
        }

        public ListNode getL4() {
            return l4;
        }

        public Dataset1 invoke() {
            l1 = new ListNode(5);
            ListNode l2 =new ListNode(6);
            ListNode l3 = new ListNode(4);
            l1.next = l2;
            l2.next = l3;

            l4 = new ListNode(1);
            ListNode l5 =new ListNode(0);
            ListNode l6 = new ListNode(0);
            ListNode l7 = new ListNode(0);
            ListNode l8 = new ListNode(0);
            ListNode l9 = new ListNode(0);
            ListNode l10 = new ListNode(0);
            ListNode l11 = new ListNode(0);
            ListNode l12 = new ListNode(0);
            ListNode l13 = new ListNode(0);
            ListNode l14 = new ListNode(0);
            ListNode l15 = new ListNode(0);
            ListNode l16 = new ListNode(0);
            ListNode l17 = new ListNode(0);
            ListNode l18 = new ListNode(0);
            ListNode l19 = new ListNode(0);
            ListNode l20 = new ListNode(0);
            ListNode l21 = new ListNode(0);
            ListNode l22 = new ListNode(0);
            ListNode l23 = new ListNode(0);
            ListNode l24 = new ListNode(0);
            ListNode l25 = new ListNode(0);
            ListNode l26 = new ListNode(0);
            ListNode l27 = new ListNode(0);
            ListNode l28 = new ListNode(0);
            ListNode l29 = new ListNode(0);
            ListNode l30 = new ListNode(0);
            ListNode l31 = new ListNode(0);
            ListNode l32 = new ListNode(0);
            ListNode l33 = new ListNode(0);
            ListNode l34 = new ListNode(1);


            l4.next = l5;
            l5.next = l6;
            l6.next = l7;
            l7.next = l8;
            l8.next = l9;
            l9.next = l10;
            l10.next = l11;
            l11.next = l12;
            l12.next = l13;
            l13.next = l14;
            l14.next = l15;
            l15.next = l16;
            l16.next = l17;
            l17.next = l18;
            l18.next = l19;
            l19.next = l20;
            l20.next = l21;
            l21.next = l22;
            l22.next = l23;
            l23.next = l24;
            l24.next = l25;
            l25.next = l26;
            l26.next = l27;
            l27.next = l28;
            l28.next = l29;
            l29.next = l30;
            l30.next = l31;
            l31.next = l32;
            l32.next = l33;
            l33.next = l34;
            return this;
        }
    }

    private static class Dataset2 {
        private ListNode l1;
        private ListNode l4;

        public ListNode getL1() {
            return l1;
        }

        public ListNode getL4() {
            return l4;
        }

        //1 07
        //5 7 8
        //6 7 5 1


       // 532
        //532
         //1064
        //4601
        public Dataset2 invoke() {
            l1 = new ListNode(2);
            ListNode l2 =new ListNode(3);
            ListNode l3 = new ListNode(5);
            l1.next = l2;
            l2.next = l3;

            l4 = new ListNode(2);
            ListNode l5 =new ListNode(3);
            ListNode l6 = new ListNode(5);


            l4.next = l5;
            l5.next = l6;
            l6.next = null;

            return this;
        }
    }
}
