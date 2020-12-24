package com.leetcode;

public class NextGreatestElement3 {

    /* Traverse backwards from the array
     1. Find the position in array where a[i] < a[i + 1] . This is first index.
     2. Traverse backward. Find index which is having value greater than first index value.
     3. Swap(a[index1] ,  a[index2])
     Reverse everything from index + 1 to last*/

    public static void main(String[] args) {
        //113
        new NextGreatestElement3().nextGreaterElement(1999999999);
    }

    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int[] intArray = new int[chars.length];
        int index = 0;
        for (char c : chars) {
            intArray[index] = Character.getNumericValue(c);
            index++;
        }

        int firstElement = -10;
        int firstIndex = -10;
        for (int i = intArray.length - 1; i >= 1; i--) {
            if (intArray[i - 1] < intArray[i]) {
                firstElement = intArray[i - 1];
                firstIndex = i - 1;
                break;
            }
        }

        if (firstElement == -10) {
            return -1;
        }
        int secondIndex = -10;
        for (int i = intArray.length - 1; i >= 1; i--) {
            if (intArray[i] > firstElement) {
                secondIndex = i;
                break;
            }
        }
        //swap
        int temp1 = firstElement;
        int temp2 = intArray[secondIndex];
        intArray[firstIndex] = temp2;
        intArray[secondIndex] = temp1;

        //reverse

        int left = firstIndex + 1;
        int right = intArray.length - 1;

        while (left <= right) {
            int temp = intArray[left];
            intArray[left] = intArray[right];
            intArray[right] = temp;
            left++;
            right--;
        }

        long power = 1;
        long num = 0;
        for (int i = intArray.length - 1; i >= 0; i--) {
            num += power * intArray[i];
            power = power * 10;
        }
        if (num > Integer.MAX_VALUE)
            return -1;

        return (int) num;
    }
}
