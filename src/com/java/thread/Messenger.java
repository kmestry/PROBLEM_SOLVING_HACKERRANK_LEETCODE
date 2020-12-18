package com.java.thread;

public class Messenger implements Runnable {

    private final String name;

    public Messenger(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        new Thread(new Messenger("Wallace")).start();
        new Thread(new Messenger("Gromit")).start();
    }

    @Override
    public void run() {
        message(1);
       /* try {
            Thread.sleep(1340);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        message(2);
    }

    private synchronized void message(int n) {
        System.out.println(name + " - " + n + " ");
    }
}
