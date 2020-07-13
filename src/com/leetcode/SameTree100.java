package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SameTree100 {

    public static void main(String[] args) {

        boolean result = compareTreeSize(Arrays.asList(5, -685, -755, null, -714, null, null, -462, -649, null, -497, -589, -622, null, null, null, -484, null, null, 434, -400, null, -225, -381, null, -325, null, null, null, -95, -183, null, null, null, 2970, 2770, 373, 313, 240, 150, 74, null, null, null, null, null, 1620, 1357, 1237, 701, 527, 519, -203, null, null, null, 624, null, null, 913, 712, null, 725, null, 817, null, null, 972, null, 1227, 1056, null, 1133, null, null, null, 1246, null, 1283, null, null, 1538, 1439, null, null, 1583, null, null, 2342, 2235, 2136, 1945, 1736, 1670, null, null, 1745, null, 1852, 1834, null, null, 1929, null, null, 1954, 1952, null, null, 2030, null, 2098, null, null, 2219, null, null, 2249, null, null, 2593, 2553, 2370, null, 2467, 2427, null, null, null, null, 2661, null, 2694, 2692, null, null, null, 2913, 2838, null, null, null, 3620, 3337, 3228, 2988, null, 3072, 3053, 3007, null, null, null, 3174, 3109, null, 3115, null, null, null, 3262, null, null, 3574, 3434, 3349, null, 3384, null, null, 3490, 3465, null, null, null, null, 4201, 3874, 3658, null, 3760, 3686, null, null, 3855, null, null, 3885, null, 4187, 3971, null, 4058, null, 4100, null, null, null, 4262, null, null),
                Arrays.asList(5, -685, -755, null, -714, null, null, -462, -649, null, -497, -589, -622, null, null, null, -484, null, null, 434, -400, null, -225, -381, null, -325, null, null, null, -95, -183, null, null, null, 2970, 2770, 373, 313, 240, 150, 74, null, null, null, null, null, 1620, 1357, 1237, 701, 527, 519, -203, null, null, null, 624, null, null, 913, 712, null, 725, null, 817, null, null, 972, null, 1227, 1056, null, 1133, null, null, null, 1246, null, 1283, null, null, 1538, 1439, null, null, 1583, null, null, 2342, 2235, 2136, 1945, 1736, 1670, null, null, 1745, null, 1852, 1834, null, null, 1929, null, null, 1954, 1952, null, null, 2030, null, 2098, null, null, 2219, null, null, 2249, null, null, 2593, 2553, 2370, null, 2467, 2427, null, null, null, null, 2661, null, 2694, 2692, null, null, null, 2913, 2838, null, null, null, 3620, 3337, 3228, 2988, null, 3072, 3053, 3007, null, null, null, 3174, 3109, null, 3115, null, null, null, 3262, null, null, 3574, 3434, 3349, null, 3384, null, null, 3490, 3465, null, null, null, null, 4201, 3874, 3658, null, 3760, 3686, null, null, 3855, null, null, 3885, null, 4187, 3971, null, 4058, null, 4100, null, null, null, 4262, null, null));

        System.out.println("result = " + result);

    }

    public static void preOrderDFSTraversal(TreeNode node, List<Integer> list) {

        if (node == null) {
            list.add(null);
            return;
        }
        TreeNode traversalNode = node;
        list.add(traversalNode.val);

        SameTree100.preOrderDFSTraversal(traversalNode.left, list);

        SameTree100.preOrderDFSTraversal(traversalNode.right, list);

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> firstTreeList = new LinkedList<>();
        List<Integer> secondTreeList = new LinkedList<>();

        preOrderDFSTraversal(p, firstTreeList);
        preOrderDFSTraversal(q, secondTreeList);
        System.out.println("firstTreeList = " + firstTreeList);
        System.out.println("secondTreeList = " + secondTreeList);


        if (firstTreeList.size() != secondTreeList.size())
            return false;

        return compareTreeSize(firstTreeList, secondTreeList);


    }

    public static boolean compareTreeSize(List<Integer> firstList, List<Integer> secondList) {

        int maxTreeSize = firstList.size() > secondList.size() ? firstList.size() : secondList.size();
        for (int i = 0; i < maxTreeSize; i++) {
            if (firstList.get(i) == null) {
                if (secondList.get(i) != firstList.get(i)) {
                    return false;
                }
            } else if (!firstList.get(i).equals(secondList.get(i))) {
                return false;
            }

        }
        return true;
    }
}
