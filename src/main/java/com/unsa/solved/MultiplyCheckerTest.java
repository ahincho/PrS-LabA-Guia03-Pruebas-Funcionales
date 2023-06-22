package com.unsa.solved;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MultiplyCheckerTest {
    private BigInteger a, b;
    private BigInteger expected;
    private MultiplyChecker multiplyChecker;
    @Before
    public void initialize() {
        this.multiplyChecker = new MultiplyChecker();
    }
    public MultiplyCheckerTest(BigInteger a, BigInteger b, BigInteger expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> multipliedNumbers() {
        return Arrays.asList(new Object[][] {
            // A = Large Negative and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("-1000000"), new BigInteger("1000000"), new BigInteger("-1000000000000") },
            { new BigInteger("-2000000"), new BigInteger("1000"), new BigInteger("-2000000000") },
            { new BigInteger("-3000000"), new BigInteger("1"), new BigInteger("-3000000") },
            { new BigInteger("-4000000"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-5000000"), new BigInteger("-1"), new BigInteger("5000000") },
            { new BigInteger("-6000000"), new BigInteger("-1000"), new BigInteger("6000000000") },
            { new BigInteger("-7000000"), new BigInteger("-1000000"), new BigInteger("7000000000000") },
            // A = Small Negative and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("-1000"), new BigInteger("2000000"), new BigInteger("-2000000000") },
            { new BigInteger("-2000"), new BigInteger("2000"), new BigInteger("-4000000") },
            { new BigInteger("-3000"), new BigInteger("1"), new BigInteger("-3000") },
            { new BigInteger("-4000"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-5000"), new BigInteger("-1"), new BigInteger("5000") },
            { new BigInteger("-6000"), new BigInteger("-2000"), new BigInteger("12000000") },
            { new BigInteger("-7000"), new BigInteger("-2000000"), new BigInteger("14000000000") },
            // A = -1 and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("-1"), new BigInteger("3000000"), new BigInteger("-3000000") },
            { new BigInteger("-1"), new BigInteger("4000"), new BigInteger("-4000") },
            { new BigInteger("-1"), new BigInteger("1"), new BigInteger("-1") },
            { new BigInteger("-1"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-1"), new BigInteger("-1"), new BigInteger("1") },
            { new BigInteger("-1"), new BigInteger("-5000"), new BigInteger("5000") },
            { new BigInteger("-1"), new BigInteger("-6000000"), new BigInteger("6000000") },
            // A = 0 and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("0"), new BigInteger("7000000"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("8000"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("1"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-1"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-9000"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-10000000"), new BigInteger("0") },
            // A = 1 and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("1"), new BigInteger("11000000"), new BigInteger("11000000") },
            { new BigInteger("1"), new BigInteger("12000"), new BigInteger("12000") },
            { new BigInteger("1"), new BigInteger("1"), new BigInteger("1") },
            { new BigInteger("1"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("1"), new BigInteger("-1"), new BigInteger("-1") },
            { new BigInteger("1"), new BigInteger("-13000"), new BigInteger("-13000") },
            { new BigInteger("1"), new BigInteger("-14000000"), new BigInteger("-14000000") },
            // A = Small Positive and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("8000"), new BigInteger("15000000"), new BigInteger("120000000000") },
            { new BigInteger("9000"), new BigInteger("16000"), new BigInteger("144000000") },
            { new BigInteger("10000"), new BigInteger("1"), new BigInteger("10000") },
            { new BigInteger("11000"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("12000"), new BigInteger("-1"), new BigInteger("-12000") },
            { new BigInteger("13000"), new BigInteger("-17000"), new BigInteger("-221000000") },
            { new BigInteger("14000"), new BigInteger("-18000000"), new BigInteger("-252000000000") },
            // A = Large Positive and B = { Large Positive, Small Positive, 1, 0, -1, Small Negative, Large Negative }
            { new BigInteger("20000000"), new BigInteger("19000000"), new BigInteger("380000000000000") },
            { new BigInteger("30000000"), new BigInteger("20000"), new BigInteger("600000000000") },
            { new BigInteger("40000000"), new BigInteger("1"), new BigInteger("40000000") },
            { new BigInteger("50000000"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("60000000"), new BigInteger("-1"), new BigInteger("-60000000") },
            { new BigInteger("70000000"), new BigInteger("-21000"), new BigInteger("-1470000000000") },
            { new BigInteger("80000000"), new BigInteger("-22000000"), new BigInteger("-1760000000000000") },
        });
    }
    @Test
    public void testMultiplyNumberChecker() {
        System.out.println("Parameterized Multiply : " + this.a + " * " + this.b + " = " + this.expected);
        assertEquals(expected, multiplyChecker.multiply(a, b));
    }
}
