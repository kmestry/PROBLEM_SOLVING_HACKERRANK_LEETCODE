package com.coding.practise.mcq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsTest {

    public static Iterator reverse(List list) {
        Collections.reverse(list);
        return list.iterator();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        //issue here
      /*  for (Object obj : reverse(list)){

        }*/
    }
}
