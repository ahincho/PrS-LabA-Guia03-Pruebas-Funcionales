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
            
        });
    }
    // Esta prueba se ejecutara 25 veces
    @Test
    public void testMultiplyNumberChecker() {
        System.out.println("Parameterized Max : max(" + this.a + ", " + this.b + ") = " + this.expected);
        assertEquals(expected, maxChecker.max(a, b));
    }
}