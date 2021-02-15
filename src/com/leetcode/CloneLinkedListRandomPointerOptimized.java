package com.leetcode;

//original list is not preserved in this approach
public class CloneLinkedListRandomPointerOptimized {

    public Node_RandomPointerClone copyRandomList(Node_RandomPointerClone head) {
        if (head == null) {
            return null;
        }
        Node_RandomPointerClone temp = head;
        Node_RandomPointerClone copy = new Node_RandomPointerClone(Integer.MAX_VALUE);
        Node_RandomPointerClone copyTemp = copy;
        while (temp != null) {
            copyTemp.next = new Node_RandomPointerClone(temp.val);
            copyTemp = copyTemp.next;
            temp = temp.next;
        }
        temp = head;
        copyTemp = copy.next;
        System.out.println(copyTemp.val);
        while (temp != null) {
            temp.next = copyTemp.next;
            temp = temp.next;
            copyTemp = copyTemp.next;
        }

        temp = head;
        copyTemp = copy.next;

        while (copyTemp != null) {
            copyTemp.random = temp.random;
            temp = temp.next;
            copyTemp = copyTemp.next;
        }

        copyTemp = copy.next;

        while (copyTemp != null && temp != null) {
            if (copyTemp.random != null)
                copyTemp.random = copyTemp.random.random.next;

            copyTemp = copyTemp.next;
        }


        return copy.next;
    }
}
