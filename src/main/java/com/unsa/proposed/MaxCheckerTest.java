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
            { new BigInteger("-2").pow(131), new BigInteger("2").pow(80), new BigInteger("2").pow(80) },
            { new BigInteger("-2").pow(121), new BigInteger("2").pow(20), new BigInteger("2").pow(20) },
            { new BigInteger("-2").pow(81), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-2").pow(141), new BigInteger("-2").pow(21), new BigInteger("-2").pow(21) },
            { new BigInteger("-2").pow(101), new BigInteger("-2").pow(101), new BigInteger("-2").pow(101) },
            // A = Small Negative and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("-3").pow(21), new BigInteger("3").pow(100), new BigInteger("3").pow(100) },
            { new BigInteger("-3").pow(23), new BigInteger("3").pow(52), new BigInteger("3").pow(52) },
            { new BigInteger("-3").pow(27), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("-3").pow(31), new BigInteger("-3").pow(59), new BigInteger("-3").pow(31) },
            { new BigInteger("-3").pow(33), new BigInteger("-3").pow(121), new BigInteger("-3").pow(33) },
            // A = 0 and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("0"), new BigInteger("5").pow(120), new BigInteger("5").pow(120) },
            { new BigInteger("0"), new BigInteger("5").pow(30), new BigInteger("5").pow(30) },
            { new BigInteger("0"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-5").pow(31), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("-5").pow(121), new BigInteger("0") },
            // A = Small Positive and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("7").pow(10), new BigInteger("7").pow(140), new BigInteger("7").pow(140) },
            { new BigInteger("7").pow(15), new BigInteger("7").pow(20), new BigInteger("7").pow(20) },
            { new BigInteger("7").pow(25), new BigInteger("0"), new BigInteger("7").pow(25) },
            { new BigInteger("7").pow(35), new BigInteger("-7").pow(31), new BigInteger("7").pow(35) },
            { new BigInteger("7").pow(40), new BigInteger("-7").pow(151), new BigInteger("7").pow(40) },
            // A = Large Positive and B = { Large Positive, Small Positive, 0, Small Negative, Large Negative }
            { new BigInteger("8").pow(120), new BigInteger("8").pow(120), new BigInteger("8").pow(120) },
            { new BigInteger("8").pow(130), new BigInteger("8").pow(20), new BigInteger("8").pow(20) },
            { new BigInteger("8").pow(150), new BigInteger("0"), new BigInteger("8").pow(150) },
            { new BigInteger("8").pow(170), new BigInteger("-8").pow(31), new BigInteger("8").pow(170) },
            { new BigInteger("8").pow(180), new BigInteger("-8").pow(131), new BigInteger("8").pow(180) }
        });
    }
    // Esta prueba se ejecutara 25 veces
    @Test
    public void testMultiplyNumberChecker() {
        System.out.println("Parameterized Max : max(" + this.a + ", " + this.b + ") = " + this.expected);
        assertEquals(expected, maxChecker.max(a, b));
    }
}