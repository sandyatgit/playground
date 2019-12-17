package com.playground;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoDMaze {

    private static int [][] maze = new int[][]{
                    {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}

            };

    class Coordinates{
        int x;
        int y;
        Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return x*y;
        }

        @Override
        public boolean equals(Object c1){
            Coordinates coord = (Coordinates)c1;
            return this.x == coord.x && this.y == coord.y;
        }
    }

    private static TwoDMaze inst = new TwoDMaze();

    //1,3 -> 4,11

    public static void main(String... s){
        System.out.println(maze[1][3]);
        System.out.println(maze[4][11]);
        Queue<Coordinates> data = new LinkedList<>();
        Coordinates start = inst.new Coordinates(1,3);
        Coordinates end = inst.new Coordinates(0,1);
        data.add(start);
        Set<Coordinates> visitedLocs = new HashSet<>();
        visitedLocs.add(start);
        //System.out.println(inst.checkIfThereisaPath(data, end,visitedLocs,1));
        System.out.println(inst.checkIfThereisaPathDFS(start,end,visitedLocs,1));
    }

    private  boolean checkIfThereisaPath(Queue<Coordinates> data, Coordinates end, Set<Coordinates> visitedLocs, int count) {
        System.out.println();

        System.out.println("count ="+count);
        count = count+1;
        if(data.isEmpty()){
            return false;
        }
        Coordinates curr =  data.poll();

        System.out.print("x ="+curr.x+" y = "+ curr.y);


        if(curr.equals(end)){
            return true;
        }


        //move down
        if(curr.x < maze.length && maze[curr.x+1][curr.y] == 0){
            Coordinates c = new Coordinates(curr.x+1,curr.y);
            if(!visitedLocs.contains(c)){
                data.add(c);
                visitedLocs.add(c);
            }

        }
        //move right
        if(curr.y < maze[curr.x].length && maze[curr.x][curr.y+1] == 0){

            Coordinates c = new Coordinates(curr.x,curr.y+1);
            if(!visitedLocs.contains(c)){
                data.add(c);
                visitedLocs.add(c);
            }

        }

        //move up
        if(curr.x > -1  && maze[curr.x-1][curr.y] == 0){
            Coordinates c = new Coordinates(curr.x-1,curr.y);
            if(!visitedLocs.contains(c)){
                data.add(c);
                visitedLocs.add(c);
            }
        }

        //move left
        if(curr.y > -1  && maze[curr.x][curr.y-1] == 0){
            Coordinates c = new Coordinates(curr.x,curr.y-1);
            if(!visitedLocs.contains(c)){
                data.add(c);
                visitedLocs.add(c);
            }
        }

        return checkIfThereisaPath(data,end,visitedLocs,count);



    }

    private  boolean checkIfThereisaPathDFS(Coordinates start, Coordinates end, Set<Coordinates> visitedLocs, int count) {
        System.out.println();

        System.out.print("x ="+start.x+" y = "+ start.y);

        if(start.equals(end)){
            return true;
        }

        //move down
        if(start.x < maze.length && maze[start.x+1][start.y] == 0){
            Coordinates c = new Coordinates(start.x+1,start.y);
            if(!visitedLocs.contains(c)){
                visitedLocs.add(c);
                if(checkIfThereisaPathDFS(c,end,visitedLocs,count)){
                    return true;
                }
            }

        }
        //move right
        if(start.y < maze[start.x].length && maze[start.x][start.y+1] == 0){

            Coordinates c = new Coordinates(start.x,start.y+1);
            if(!visitedLocs.contains(c)){
                visitedLocs.add(c);
                if(checkIfThereisaPathDFS(c,end,visitedLocs,count)){
                    return true;
                }
            }

        }

        //move up
        if(start.x > -1  && maze[start.x-1][start.y] == 0){
            Coordinates c = new Coordinates(start.x-1,start.y);
            if(!visitedLocs.contains(c)){
                visitedLocs.add(c);
                if(checkIfThereisaPathDFS(c,end,visitedLocs,count)){
                    return true;
                }
            }
        }

        //move left
        if(start.y > -1  && maze[start.x][start.y-1] == 0){
            Coordinates c = new Coordinates(start.x,start.y-1);
            if(!visitedLocs.contains(c)){
                visitedLocs.add(c);
                if(checkIfThereisaPathDFS(c,end,visitedLocs,count)){
                    return true;
                }
            }
        }
        return false;

    }


}

