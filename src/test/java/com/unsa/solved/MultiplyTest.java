package com.unsa.solved;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;

// JUnit Test for Multiply function implemented by BigInteger Class

public class MultiplyTest 
{
    BigInteger a, b, answer;
    // Here A is 0 and B is between -1 and 1
    @Test
    public void aZeroAndBZero() {
        a = new BigInteger("0");
        b = new BigInteger("0");
        answer = a.multiply(b);
        assertEquals("a * b = 0 : a = 0 and b = 0", new BigInteger("0"), answer);
    }
    @Test
    public void aZeroAndBOne() {
        a = new BigInteger("0");
        b = new BigInteger("1");
        answer = a.multiply(b);
        assertEquals("a * b = 0 : a = 0 and b = 1", new BigInteger("0"), answer);
    }
    @Test
    public void aZeroAndBMinusOne() {
        a = new BigInteger("0");
        b = new BigInteger("-1");
        answer = a.multiply(b);
        assertEquals("a * b = 0 : a = 0 and b = -1", new BigInteger("0"), answer);
    }
    // Here A is -1 and B is between -1 and 1
    @Test
    public void aMinusOneAndBZero() {
        a = new BigInteger("-1");
        b = new BigInteger("0");
        answer = a.multiply(b);
        assertEquals("a * b = 0 : a = -1 and b = 0", new BigInteger("0"), answer);
    }
    @Test
    public void aMinusOneAndBOne() {
        a = new BigInteger("-1");
        b = new BigInteger("1");
        answer = a.multiply(b);
        assertEquals("a * b = -1 : a = -1 and b = 1", new BigInteger("-1"), answer);
    }
    @Test
    public void aMinusOneAndBMinusOne() {
        a = new BigInteger("-1");
        b = new BigInteger("-1");
        answer = a.multiply(b);
        assertEquals("a * b = 1 : a = -1 and b = -1", new BigInteger("1"), answer);
    }
    // Here A is 1 and B is between -1 and 1
    @Test
    public void aOneAndBZero() {
        a = new BigInteger("1");
        b = new BigInteger("0");
        answer = a.multiply(b);
        assertEquals("a * b = 0 : a = 1 and b = 0", new BigInteger("0"), answer);
    }
    @Test
    public void aOneAndBOne() {
        a = new BigInteger("1");
        b = new BigInteger("1");
        answer = a.multiply(b);
        assertEquals("a * b = 1 : a = 1 and b = 1", new BigInteger("1"), answer);
    }
    @Test
    public void aOneAndBMinusOne() {
        a = new BigInteger("1");
        b = new BigInteger("-1");
        answer = a.multiply(b);
        assertEquals("a * b = -1 : a = 1 and b = -1", new BigInteger("-1"), answer);
    }
}