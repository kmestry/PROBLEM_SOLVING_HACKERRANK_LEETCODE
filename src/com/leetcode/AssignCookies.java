package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AssignCookies {

    public static void main(String[] args) {

        new AssignCookies().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
    }

    //[1,2], [1,2,3]
    public int findContentChildren(int[] greedyIndexArray, int[] cookieSizeArray) {


        List<Integer> cookieSizeList = Arrays.stream(cookieSizeArray).boxed().collect(Collectors.toList());
        Collections.sort(cookieSizeList);
        int counter = 0;
        for (int i = 0; i < greedyIndexArray.length; i++) {
            int greedIndex = greedyIndexArray[i];
            if (cookieSizeList.isEmpty()) return counter;
            for (int j = 0; j < cookieSizeList.size(); j++) {
                if (cookieSizeList.get(j) >= greedIndex) {
                    counter++;
                    cookieSizeList.remove(j);
                    break;
                }
            }
        }

        return counter;
    }


    public int findContentChildrenOptimized(int[] greedyIndexArray, int[] cookieSizeArray) {

        //https://www.youtube.com/watch?v=1JDh9O7GDyA

        Arrays.sort(greedyIndexArray);
        Arrays.sort(cookieSizeArray);

        int i = greedyIndexArray.length - 1;
        int j = cookieSizeArray.length - 1;

        int contentChildren = 0;
        while (i >= 0 && j >= 0) {

            if (cookieSizeArray[j] >= greedyIndexArray[i]) {
                contentChildren++;
                i--;
                j--;
            } else {
                i--;
            }
        }

        return contentChildren;
    }


}
