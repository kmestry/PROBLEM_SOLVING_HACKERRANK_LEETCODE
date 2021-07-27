package com.blind_list_75.misc;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers {


    List<Integer> list;
    List<Integer> prefix;

    public ProductOfLastKNumbers() {
        list = new ArrayList<>();
        prefix = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
        prefix.add(1);
        int last = list.get(list.size() - 1);
        int index = prefix.size() - 1;
        prefix.set(index, last);

        for (int i = prefix.size() - 2; i >= 0; i--) {
            prefix.set(i, list.get(i) * prefix.get(i + 1));
        }
    }

    public int getProduct(int k) {
        // int product = 1;
        // int index = list.size() - 1;
        // while(k > 0){
        //     product *= list.get(index);
        //     index--;
        //     k--;
        // }
        // return product;
        return prefix.get(prefix.size() - k);
    }
}
