package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBST {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        helper(root1, list1);
        helper(root2, list2);
        //System.out.println("list1" + list1);
        //System.out.println("list2"+list2);
        list1.addAll(list2);
        Collections.sort(list1);
        return list1;

    }

    private void helper(TreeNode root, List list) {

        if (root == null) return;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);

    }
}
