package com.unsa.solved;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MultiplyCheckerTest {
    private BigInteger a, b;
    private BigInteger expected;
    private MultiplyChecker checker;
    @Before
    public void initialize() {
        checker = new MultiplyChecker();
    }
    public MultiplyCheckerTest(BigInteger a, BigInteger b, BigInteger expected) {
        this.a = a;
        this.b = b;
        this.expected = checker.multiplyChecker(a, b);
    }
    @Parameterized.Parameters
    public static Collection<Object[]> multipliedNumbers() {
        return Arrays.asList(new Object[][] {
            {  },
            {  }
        });
    }
}
