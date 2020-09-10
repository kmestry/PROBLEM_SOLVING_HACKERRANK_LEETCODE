package com.leetcode;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        //version1 = "7.5.2.4", version2 = "7.5.3"

        String[] array1 = version1.split("\\.");

        String[] array2 = version2.split("\\.");

        int array1Pointer = 0;
        int array2Pointer = 0;

        while (array1Pointer < array1.length || array2Pointer < array2.length) {


            int val1 = array1Pointer >= array1.length ? 0 : Integer.parseInt(array1[array1Pointer]);
            int val2 = array2Pointer >= array2.length ? 0 : Integer.parseInt(array2[array2Pointer]);


            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            } else {
                array1Pointer++;
                array2Pointer++;
            }

        }

        return 0;
    }

}
