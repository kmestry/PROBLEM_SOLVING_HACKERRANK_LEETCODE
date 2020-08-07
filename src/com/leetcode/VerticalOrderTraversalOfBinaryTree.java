package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalOfBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));


        new VerticalOrderTraversalOfBinaryTree().verticalTraversal(treeNode);

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<NodePosition> nodePositionList = new ArrayList<>();

        List<List<Integer>> resultList = new ArrayList<>();

        dfsHelper(root, 0, 0, nodePositionList);

        Collections.sort(nodePositionList);

        int currentX = nodePositionList.get(0).x;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(nodePositionList.get(0).value);

        for (int i = 1; i < nodePositionList.size(); i++) {

            if (nodePositionList.get(i).x == currentX) {
                integerList.add(nodePositionList.get(i).value);
            } else {
                resultList.add(integerList);
                integerList = new ArrayList<>();
                integerList.add(nodePositionList.get(i).value);
                currentX = nodePositionList.get(i).x;
            }


        }
        if (!integerList.isEmpty()) {
            resultList.add(integerList);
        }


        return resultList;

    }

    private void dfsHelper(TreeNode root, int x, int y, List<NodePosition> nodePositionList) {

        if (root == null)
            return;

        NodePosition nodePosition = new NodePosition(x, y, root.val);
        nodePositionList.add(nodePosition);

        dfsHelper(root.left, x - 1, y - 1, nodePositionList);
        dfsHelper(root.right, x + 1, y - 1, nodePositionList);

    }


}

class NodePosition implements Comparable<NodePosition> {
    int x;  // ascending
    int y; //descending
    int value; //ascending.

    public NodePosition(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }


    @Override
    public int compareTo(NodePosition o) {
        int result;
        if (this.x != o.x) {
            result = Integer.compare(this.x, o.x);
        } else if (this.y != o.y) {
            result = Integer.compare(o.y, this.y);
        } else {
            result = Integer.compare(this.value, o.value);
        }

        return result;
    }


}
