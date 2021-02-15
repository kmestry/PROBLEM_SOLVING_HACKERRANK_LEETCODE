package com.java.concurrent_util_java2blogsite.semaphore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BoundedArrayList {

    private final Semaphore semaphore;
    private final List arrayList;

    public BoundedArrayList(int limit) {
        this.semaphore = new Semaphore(limit);
        this.arrayList = Collections.synchronizedList(new ArrayList<>());
    }


    public boolean add(String t) throws InterruptedException {
        boolean added = false;
        semaphore.acquire();
       /* try {
            added = arrayList.add(t);
            return added;
        } finally {
            if (!added)
                semaphore.release();
        }*/
        return arrayList.add(t);
    }


    /*
     * remove element from the list and call semaphore.release method
     * */
    public boolean remove(String t) {
        boolean wasRemoved = arrayList.remove(t);
        if (wasRemoved)
            semaphore.release();
        return wasRemoved;
    }

    public void remove(int index) {
        arrayList.remove(index);
        semaphore.release();
    }

    public List getArraylist() {
        return arrayList;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }


}
