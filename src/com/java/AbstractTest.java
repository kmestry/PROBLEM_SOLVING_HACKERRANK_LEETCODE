package com.java;

public abstract class AbstractTest {

    public static void main(String[] args) {
        AbstractTest obj = new AbstractTest() {
            @Override
            public int getNum() {
                return 22;
            }
        };
        AbstractTest.Bar barObj = obj.new Bar() {
            @Override
            public int getNum() {
                return 57;
            }
        };

        System.out.println("obj.getNum() = " + obj.getNum());
        System.out.println("barObj.getNum() = " + barObj.getNum());
    }

    public int getNum() {
        return 45;
    }

    public abstract class Bar {
        public int getNum() {
            return 38;
        }

    }
}

