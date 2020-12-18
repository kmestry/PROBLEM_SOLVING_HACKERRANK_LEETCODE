package com.java;

public class OverrideTest {

    class Base {
        final public void show() {
            System.out.println("base::show called");
        }
    }

    class Derived extends Base {

        //show()' cannot override 'show()' in 'com.java.OverrideTest.Base'; overridden method is final

//        public void show(){
//            System.out.println("derived: show called");
//        }
    }
}
