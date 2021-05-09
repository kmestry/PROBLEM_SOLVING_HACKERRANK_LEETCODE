package com.coding.practise.mcq;

public class Child extends Base {
    int count;

    public Child(int number, int count) {
        super(number);
        this.count = count;
    }

    // this should be first statement in constructor body
    /*public Child(int count) {
        super(0);
        this(count,0);
    }*/

    // there is not default constructor in Base class
   /* Child(int count){
        this.count = count;
    }*/

    //correct answer
    Child(int count) {
        this(count, 0);
    }

    //Base(int) cannot be applied to ()
   /* Child(int count) {
        super();
        this.count = count;
    }*/
}
