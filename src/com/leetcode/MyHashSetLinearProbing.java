package com.leetcode;

public class MyHashSetLinearProbing {

    int[] buckets;
    boolean isZeroKeyInserted = false;
    private int bucketSize = 10;
    private int capacity = 0;

    /**
     * Initialize your data structure here.
     */
    //visited node is -13
    public MyHashSetLinearProbing() {
        this.buckets = new int[bucketSize];
    }

    public static void main(String[] args) {
        MyHashSetLinearProbing obj = new MyHashSetLinearProbing();
        //18,41,21,83,0,10000,1000000
        //[58],[0],[14],[14],[91],[6],[58],[66],[51],[16],[40],[52],[48],[40],[42],[85],[36],[16],[0],[43],[6],[3],[25],[99],[66],[60],[58]
        obj.add(58);
        System.out.println("obj = " + obj.contains(0));
        obj.add(14);
        System.out.println("obj = " + obj.contains(14));
        obj.remove(91);
        obj.add(6);
        System.out.println("obj = " + obj.contains(58));

        obj.add(66);
        obj.add(51);
        obj.add(16);
        obj.add(40);
        obj.add(52);
        obj.add(48);

        System.out.println("obj = " + obj.contains(40));

        obj.add(42);
        obj.add(85);
        obj.add(36);

        System.out.println("obj = " + obj.contains(16));
        obj.remove(0);
        System.out.println("obj = " + obj.contains(43));
        System.out.println("obj = " + obj.contains(6));


    }

    public void add(int key) {

        rehash(key);
        if (!contains(key)) {

            if (key == 0) {
                isZeroKeyInserted = true;
                return;
            }
            int hash = hashValue(key, bucketSize);
            if (buckets[hash] == 0) {
                buckets[hash] = key;
            } else {
                //collision.
                boolean isIndexFound = false;
                for (int i = hash; i < buckets.length; i++) {
                    if (buckets[i] == 0) {
                        buckets[i] = key;
                        isIndexFound = true;
                        System.out.println("Index found when collision occurred " + isIndexFound);
                        capacity++;
                        return;
                    }
                }
                if (!isIndexFound) {
                    //search space in start of array
                    for (int i = 0; i < hash; i++) {
                        if (buckets[i] == 0) {
                            buckets[i] = key;
                            isIndexFound = true;
                            System.out.println("Index found when collision occurred " + isIndexFound);
                            capacity++;
                            return;
                        }
                    }
                }
            }
            capacity++;
        }
        System.out.println("ELement Already present in hashset " + key);

    }

    private void rehash(int key) {
        //rehashing
        if (capacity > ((bucketSize / 2) + 2)) {
            System.out.println(" REHASHING LOAD IS HIGH!!!");
            bucketSize = bucketSize * 2;
            int[] newBucket = new int[bucketSize];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != 0 && buckets[i] != -10 && buckets[i] != -15) {
                    int newHash = hashValue(buckets[i], bucketSize);


                    if (newBucket[newHash] == 0) {
                        newBucket[newHash] = buckets[i];
                    } else {
                        //collision. in new bucket as well
                        boolean isIndexFound = false;
                        for (int jj = newHash; jj < newBucket.length; jj++) {
                            if (newBucket[jj] == 0) {
                                newBucket[jj] = buckets[jj];
                                isIndexFound = true;
                                System.out.println("Index found when collision occurred " + isIndexFound);
                                // capacity++;
                                break;
                            }
                        }
                        if (!isIndexFound) {
                            //search space in start of array
                            for (int kk = 0; kk < newHash; kk++) {
                                if (newBucket[kk] == 0) {
                                    newBucket[kk] = buckets[kk];
                                    isIndexFound = true;
                                    System.out.println("Index found when collision occurred " + isIndexFound);
                                    // capacity++;
                                    break;
                                }
                            }
                        }
                    }


                    // newBucket[newHash] = buckets[i];
                }
            }

            buckets = newBucket.clone();
           /* int newHashKeyValue = hashValue(key, bucketSize);
            if (buckets[newHashKeyValue] == 0) {
                buckets[newHashKeyValue] = key;
            }*/
        }
        System.out.println(" CAPACITY IS NOT YET REACHED ");
    }

    public void remove(int key) {
        int indexOfKey = returnIndexOfKey(key);
        System.out.println("indexOfKey = " + indexOfKey);
        if (indexOfKey > 0) {
            buckets[indexOfKey] = 0; //marker value to not stop searching if its 0. if we set 0 there is issue in searching.
            //mark with some other value to not stop searching if it encounters 0 .
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (key == 0) {
            return isZeroKeyInserted;
        }
        int hash = hashValue(key, bucketSize);
        if (buckets[hash] != 0 && buckets[hash] == key) {
            return true;
        } else {
            boolean isElementFound = false;
            for (int i = hash + 1; i < buckets.length; i++) {
                if (buckets[i] == key) {
                    isElementFound = true;
                    return true;
                }
            }
            if (!isElementFound) {
                for (int i = 0; i < hash; i++) {
                    if (buckets[i] == key) {
                        isElementFound = true;
                        return true;
                    }
                }
            }
        }
        return false;

    }


    public int returnIndexOfKey(int key) {
        if (key == 0) {
            isZeroKeyInserted = false;
            return -10; // marker to distinguish
        }
        int hash = hashValue(key, bucketSize);
        if (buckets[hash] != 0 && buckets[hash] == key) {
            return hash;
        } else {
            boolean isElementFound = false;
            for (int i = hash + 1; i < buckets.length; i++) {
                if (buckets[i] == key) {
                    isElementFound = true;
                    return i;
                }
            }
            if (!isElementFound) {
                for (int i = 0; i < hash; i++) {
                    if (buckets[i] == key) {
                        isElementFound = true;
                        return i;
                    }
                }
            }
        }

        return -10;
    }


    private int hashValue(int key, int bucketSize) {

        int hash = (key) % bucketSize;
        return hash;

    }

}
