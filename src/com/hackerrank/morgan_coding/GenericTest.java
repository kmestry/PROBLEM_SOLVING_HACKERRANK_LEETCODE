package com.hackerrank.morgan_coding;

public class GenericTest<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
  /*  public void inspect(U u){
        System.out.println("T:" + t.getClass().getName());
        System.out.println("U :" + u.getClass().getName());
    }*/
}
