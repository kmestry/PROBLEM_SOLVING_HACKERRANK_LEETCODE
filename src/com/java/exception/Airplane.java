package com.java.exception;

import java.io.IOException;

public class Airplane {
    public Airplane() throws IOException {
        System.out.println("airplane");
        throw new IOException();
    }
}
