package com.playground;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public static void main(String... s){
        int[][] data = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        new CourseSchedule().findOrder(4, data);
    }
    class Node{
        int x;
        Node next;
        Node prev;
        Node(int x){
            this.x =x;
        }
        void addNext(Node n){
            next = n;
        }
        void addPrev(Node n){
            prev = n;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        Node root = null;
        Map<Integer,Node> nodes = new HashMap<Integer,Node>();
        for(int i =0; i < prerequisites.length; i++){
            int prereqCourse = prerequisites[i][1];
            int currentCourse = prerequisites[i][0];
            Node curr = nodes.get(currentCourse);
            if(curr == null){
                curr = new Node(currentCourse);
                nodes.put(curr.x,curr);
            }

            Node prereq = nodes.get(prereqCourse);
            if(prereq == null){
                prereq = new Node(prereqCourse);
                nodes.put(prereq.x,prereq);
            }

            Node currtmpNext = curr.next;
            Node currtmpPrev = curr.prev;

            if(currtmpPrev != null)
                currtmpPrev.addNext(currtmpNext);

            if(currtmpNext != null)
                currtmpNext.addPrev(currtmpPrev);

            Node prereqtmpNext = prereq.next;
            prereq.addNext(curr);
            curr.addNext(prereqtmpNext);
            curr.addPrev(prereq);
            if(prereqtmpNext != null)
                prereqtmpNext.addPrev(curr);

            if(curr.prev == null){
                root = curr;
            }else if(prereq.prev == null){
                root = prereq;
            }

        }

        Node curr = root;
        while(curr!= null){
            System.out.println(curr.x);
            curr = curr.next;
        }
        return null;

    }
}
