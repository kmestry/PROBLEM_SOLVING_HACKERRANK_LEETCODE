package com.blind_list_75.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeOptimized {

    public static void main(String[] args) {
        SerializeDeserializeOptimized serializeDeserializeOptimized = new SerializeDeserializeOptimized();
        TreeNode node = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        TreeNode root = new TreeNode(1, new TreeNode(2), node);
        serializeDeserializeOptimized.serialize(root);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "X";
        //preorder
        String left = serialize(root.left);
        String right = serialize(root.right);

        String res = root.val + "," + left + "," + right;
        // System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : strings) {
            queue.offer(s);
        }

        return queueDes(queue);
    }

    private TreeNode queueDes(Queue<String> queue) {
        if (queue.size() == 0) return null;
        String str = queue.poll();
        if (str.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));

        node.left = queueDes(queue);
        node.right = queueDes(queue);

        return node;
    }
}
