package com.geeksforgeeks;

import java.util.ArrayList;

public class QuadraticEquationRoot {

    public static void main(String[] args) {
        QuadraticEquationRoot quadraticEquationRoot = new QuadraticEquationRoot();
        //'/752 904 164'
        //quadraticEquationRoot.quadraticRoots(242, 8, -982);
        quadraticEquationRoot.quadraticRoots(752, 904, 164);
    }

    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here

        ArrayList<Integer> list = new ArrayList<>();

        int val1 = b * b - 4 * a * c;
        if (val1 < 0) {
            list.add(-1);
            return list;
        }

        double doubleSqrt =  Math.sqrt(val1);
        int divisor = 2 * a;

        double root1Val1 =  (-b + doubleSqrt);
        double root2Val2 =  (-b - doubleSqrt);

        double root1 =  (root1Val1 / (double) divisor);
        double root2 = (root2Val2 / (double) divisor);


        list.add((int) Math.floor(root1));
        list.add((int) Math.floor(root2));
        list.sort((o1, o2) -> o2-o1);

        return list;
    }
}
