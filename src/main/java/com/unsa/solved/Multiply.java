package com.unsa.solved;

import java.math.BigInteger;

public class Multiply {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("123456789123");
        BigInteger b = new BigInteger("987654321987");
        System.out.println("a * b = " + a.multiply(b));
    }
}
