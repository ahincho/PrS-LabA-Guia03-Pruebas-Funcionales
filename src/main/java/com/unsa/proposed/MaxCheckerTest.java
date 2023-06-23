package com.unsa.proposed;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxCheckerTest {
    private BigInteger a, b;
    private BigInteger expected;
    private MaxChecker maxChecker;
    @Before
    public void initialize() {
        this.maxChecker = new MaxChecker();
    }
    // Cada parametro debe colocarse como argumento aqui.
    // Cada vez que el trigger se dispara, pasara los argumentos a partir
    // de los parametros que definimos en el metodo max()
    public MaxCheckerTest(BigInteger a, BigInteger b, BigInteger expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }
    // Se crean 25 casos de pruebas debido a que existe 5 particiones para A y tambien 5 particiones para B
     @Parameterized.Parameters
    public static Collection<Object[]> multipliedNumbers() {
        return Arrays.asList(new Object[][] {
            // A = Large Negative and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("-1000000"), new BigInteger("1000000"), new BigInteger("1000000") },
            { new BigInteger("-2000000"), new BigInteger("2000"), new BigInteger("2000") },
            { new BigInteger("-3000000"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-4000000"), new BigInteger("-3000"), new BigInteger("-3000") },
            { new BigInteger("-5000000"), new BigInteger("-4000000"), new BigInteger("-4000000") },
            // A = Small Negative and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("-6000"), new BigInteger("5000000"), new BigInteger("5000000") },
            { new BigInteger("-7000"), new BigInteger("6000"), new BigInteger("6000") },
            { new BigInteger("-8000"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-9000"), new BigInteger("-7000"), new BigInteger("-7000") },
            { new BigInteger("-10000"), new BigInteger("-8000000"), new BigInteger("-10000") },
            // A = 0 and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("0"), new BigInteger("9000000"), new BigInteger("9000000") },
            { new BigInteger("0"), new BigInteger("10000"), new BigInteger("10000") },
            { new BigInteger("0"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-11000"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-12000000"), new BigInteger("0") },
            // A = Small Positive and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("11000"), new BigInteger("13000000"), new BigInteger("13000000") },
            { new BigInteger("12000"), new BigInteger("14000"), new BigInteger("14000") },
            { new BigInteger("13000"), new BigInteger("0"), new BigInteger("13000") },
            { new BigInteger("14000"), new BigInteger("-15000"), new BigInteger("14000") },
            { new BigInteger("15000"), new BigInteger("-16000000"), new BigInteger("15000") },
            // A = Large Positive and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("17000000"), new BigInteger("50000000"), new BigInteger("50000000") },
            { new BigInteger("1800000"), new BigInteger("28000"), new BigInteger("1800000") },
            { new BigInteger("19000000"), new BigInteger("0"), new BigInteger("19000000") },
            { new BigInteger("30000000"), new BigInteger("-29000"), new BigInteger("30000000") },
            { new BigInteger("40000000"), new BigInteger("-30000000"), new BigInteger("40000000") }
        });
    }
    // Esta prueba se ejecutara 25 veces
    @Test
    public void testMultiplyNumberChecker() {
        System.out.println("Parameterized Max : max(" + this.a + ", " + this.b + ") = " + this.expected);
        assertEquals(expected, maxChecker.max(a, b));
    }
}