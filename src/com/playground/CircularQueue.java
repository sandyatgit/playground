package com.playground;

import java.util.Arrays;

public class CircularQueue {

    private int maxCapacity = 10;
    private Integer[] data;
    private int currIndex;
    private int dequeueIndex;
    private boolean overflow;

    public CircularQueue(){
        data = new Integer[maxCapacity];
        currIndex = -1;
        dequeueIndex = -1;
    }

    private void  enqueue(int d){
        if(overflow){
            if(currIndex < dequeueIndex){
                currIndex++;
                data[currIndex] = d;
            }else{
                copyDatatoNewArray(data,maxCapacity);
                currIndex++;
                data[currIndex] = d;
                System.out.println("inside overflow : Created additional space for   "+d);
            }
        }else if(currIndex == maxCapacity-1){
            overflow = true;
            if(dequeueIndex == -1){
                maxCapacity = maxCapacity+10;
                Arrays.copyOf(data,maxCapacity);
                currIndex++;
                data[currIndex] = d;
                System.out.println("Created additional space for   "+d);

            }{
                data[0]= d;
                currIndex = 0;
            }
        }else{
            currIndex++;
            data[currIndex] = d;
        }
    }

    private void copyDatatoNewArray(Integer[] data, int maxCapacity) {
        int tmp = maxCapacity;
        maxCapacity = maxCapacity+10;
        Integer[] newData = new Integer[maxCapacity];
        int j = 0;
        for(int i=dequeueIndex+1; i < tmp;i++){
            newData[j++] = data[i];
        }
        for(int i=0; i <= currIndex;i++){
            newData[j++] = data[i];
        }
        this.data = newData;
        currIndex = --j;
        dequeueIndex = -1;
    }

    private int dequeue(){
        if(overflow){
            if(dequeueIndex == maxCapacity-1){
                dequeueIndex = 0;
                overflow = false;
                System.out.println("**** resetting overflow to false*****");
                return data[dequeueIndex];
            }else{
                dequeueIndex++;
                return data[dequeueIndex];
            }
        }else{
            dequeueIndex++;
            return data[dequeueIndex];
        }
    }

    private void printArrayValues(){
        for(int i=0;i < data.length; i++){
            if(data[i] != null){
                System.out.println(i +" = "+data[i]);

            }
        }
    }

    private void printQueueData(){
        if(overflow){
            System.out.println("*** is overflow ******");

            for(int i=dequeueIndex+1; i < maxCapacity; i++){

                System.out.println("data["+i +"] = "+data[i]);
            }

            for(int i = 0; i <= currIndex; i++){

                System.out.println("data["+i +"] = "+data[i]);
            }
        }else{
            for(int i=dequeueIndex+1;i <= currIndex; i++){
                    System.out.println("data["+i +"] = "+data[i]);


            }
        }

    }

    public static void main(String... s){
        CircularQueue q = new CircularQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);


        System.out.println("dequeued item = "+q.dequeue());
        q.enqueue(10);
        q.enqueue(11);
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        q.enqueue(12);
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        System.out.println("dequeued item = "+q.dequeue());
        q.enqueue(13);
        q.enqueue(14);
        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.enqueue(18);
        q.enqueue(19);
        q.enqueue(20);
        q.enqueue(21);
        q.enqueue(22);

        q.printQueueData();

        System.out.println("***** printing array items *******");
        q.printArrayValues();

    }
}

