package com.playground;

import java.util.*;

public class FindIfFilsHaveCircularDependency {

    class File{
        String name;
        List<File> dependencies;
        File(String name){
            this.name = name;
        }

        void add(File dependency){
            dependencies = (dependencies == null)? new ArrayList<>() : dependencies;
            dependencies.add(dependency);
        }
    }

    public static void main(String... s){
        File a = new FindIfFilsHaveCircularDependency().createData();
        Queue<File> data = new LinkedList<>();
        Set<File> visitedNodes = new HashSet<File>();
        data.addAll(a.dependencies);
        visitedNodes.addAll(a.dependencies);
        System.out.println(new FindIfFilsHaveCircularDependency().checkIfThereIsCyclicDepdency(a,data,visitedNodes));
    }


    private static boolean checkIfThereIsCyclicDepdency(File a, Queue<File> depdencies, Set<File> visitedNodes) {

        File curr = depdencies.poll();
        if(curr == null){
            return false;
        }

        if(curr.equals(a)){
            return true;
        }
        if(curr.dependencies != null){
            for(File b : curr.dependencies){
                if(!visitedNodes.contains(b)){
                    depdencies.add(b);
                    visitedNodes.add(b);
                }
            }
        }
        return checkIfThereIsCyclicDepdency(a,depdencies,visitedNodes);
    }


    private File createData1(){
        File A = new File("com.abc.A");
        File B  = new File("com.abc.B");
        File C = new File("com.abc.C");
        File D = new File("com.abc.D");
        File E = new File("com.abc.E");

        A.add(B);
        A.add(C);

        B.add(C);
        B.add(E);

        C.add(D);

        E.add(C);

        return B;
    }
    private File createData(){
        File A = new File("com.abc.A");
        File B  = new File("com.abc.B");
        File C = new File("com.abc.C");
        File D = new File("com.abc.D");
        File E = new File("com.abc.E");
        File F = new File("com.abc.F");
        File Z = new File("com.abc.Z");
        File X = new File("com.abc.X");
        File Y = new File("com.abc.Y");
        A.add(B);
        A.add(C);
        A.add(Y);

        B.add(C);
        B.add(D);

        C.add(X);
        C.add(B);

        D.add(E);
        D.add(F);

        F.add(B);
        F.add(D);

        X.add(Z);
        X.add(B);

        Z.add(X);
        Z.add(Y);

        Y.add(A);

        return A;
    }
}
