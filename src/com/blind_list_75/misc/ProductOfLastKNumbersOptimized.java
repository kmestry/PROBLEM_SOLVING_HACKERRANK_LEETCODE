package com.blind_list_75.misc;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbersOptimized {

    static List<Integer> prod;
    static int p;

    public ProductOfLastKNumbersOptimized() {
        prod = new ArrayList<>();
        p = 1;
    }

    public static void main(String[] args) {
        ProductOfLastKNumbersOptimized productOfNumbers = new ProductOfLastKNumbersOptimized();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        productOfNumbers.getProduct(2);
        productOfNumbers.getProduct(3);
        productOfNumbers.getProduct(4);
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2);
    }

    public void add(int num) {
        if (num == 0) {
            prod = new ArrayList<>();
            p = 1;
            return;
        }
        p *= num;
        prod.add(p);
    }

    public int getProduct(int k) {
        if (prod.size() < k) return 0;
        int ans = prod.get(prod.size() - 1);
        if (prod.size() == k) return ans;
        return (ans / prod.get(prod.size() - 1 - k));
    }
}
