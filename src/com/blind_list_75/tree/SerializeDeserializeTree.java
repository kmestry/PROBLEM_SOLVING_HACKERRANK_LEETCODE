package com.blind_list_75.tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    StringBuilder sbPre = new StringBuilder();
    StringBuilder sbIn = new StringBuilder();

    public String serialize(TreeNode root) {

        if (root == null) return null;
        preOrder(root);
        inOrder(root);

        sbPre.deleteCharAt(sbPre.length() - 1);
        sbIn.deleteCharAt(sbIn.length() - 1);
        String serialized = sbPre.append("=").append(sbIn).toString();
        // System.out.println(serialized);
        // 1 2 3 4 5  preorder
        // 2 1 4 3 5  inorder

        return serialized;
    }


    private void preOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        sbPre.append(root.val).append(",");
        preOrder(root.left);
        preOrder(root.right);

    }

    private void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        sbIn.append(root.val).append(",");
        inOrder(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        // 1 2 3 4 5  preorder
        // 2 1 4 3 5  inorder
        String[] strings = data.split("=");
        String preOrder = strings[0];
        String inOrder = strings[1];

        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();

        String[] preInts = preOrder.split(",");
        for (String p : preInts) {
            preOrderList.add(Integer.parseInt(p));
        }
        String[] inInts = inOrder.split(",");
        for (String i : inInts) {
            inOrderList.add(Integer.parseInt(i));
        }


        return helper(preOrderList, inOrderList, 0, preOrderList.size() - 1, 0, inOrderList.size() - 1);
    }

    private TreeNode helper(List<Integer> pList, List<Integer> iList, int pS, int pE, int iS,
                            int iE) {

        if (pS > pE) {
            return null;
        }
        TreeNode node = new TreeNode(pList.get(pS));

        int index = -1;
        for (int i = 0; i < iList.size(); i++) {
            if (node.val == iList.get(i)) {
                index = i;
                break;
            }
        }
        int left = index - iS;
        // 1 2 3 4 5  preorder
        //  2 1 4 3 5  inorder

        node.left = helper(pList, iList, pS + 1, pS + left, iS, index - 1);
        node.right = helper(pList, iList, pS + left + 1, pE, index + 1, iE);

        return node;
    }
}
