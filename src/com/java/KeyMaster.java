package com.java;

import java.util.HashSet;
import java.util.Set;

public class KeyMaster {
    public int i;

    public KeyMaster(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyMaster keyMaster = (KeyMaster) o;

        return i == keyMaster.i;
    }

    @Override
    public int hashCode() {
        return 434 * i % 10;
    }
}

class MapIt {
    public static void main(String[] args) {
        Set<KeyMaster> set = new HashSet<KeyMaster>();
        KeyMaster k1 = new KeyMaster(1);
        KeyMaster k2 = new KeyMaster(2);
        set.add(k1);
        set.add(k1);
        set.add(k2);
        set.add(k2);
        System.out.print(set.size() + ":");
        k2.i = 1;
        System.out.print(set.size() + ":");
        set.remove(k1);
        System.out.print(set.size() + ":");
        set.remove(k2);
        System.out.print(set.size());
    }
}
