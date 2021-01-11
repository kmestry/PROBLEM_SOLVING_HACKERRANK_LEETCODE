package com.leetcode;

public class CreateSortedArrayThroughInstructions {

    public static void main(String[] args) {
        new CreateSortedArrayThroughInstructions().createSortedArray(new int[]{1, 2, 3, 6, 5, 4});
    }

    public int createSortedArray(int[] instructions) {
        Fenwick tree = new Fenwick(100002);
        long cost = 0;
        long MOD = 1000000007;

        for (int i = 0; i < instructions.length; i++) {
            int leftCost = tree.query(instructions[i] - 1);
            int rightCost = i - tree.query(instructions[i]);
            cost += Math.min(leftCost, rightCost);
            tree.add(instructions[i], 1);
        }

        return (int) (cost % MOD);
    }

    class Fenwick {
        int[] tree;
        int m;

        public Fenwick(int size) {
            tree = new int[size];
            m = size;
        }

        public void add(int index, int value) {
            while (index < m) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
