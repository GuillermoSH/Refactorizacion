package es.iespuerto.refactorizacion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumeroTest {
    int[] arrayNumero;
    Numero numero;

    @Test
    public void arrayNuloTest() {
        numero = new Numero(0);
        arrayNumero = numero.getPrimos();
        assertEquals(0,arrayNumero.length);
    }

    @Test
    public void array2Test() {
        numero = new Numero(2);
        arrayNumero = numero.getPrimos();
        assertEquals(1, arrayNumero.length);
        assertEquals(2, arrayNumero[0]);
    }

    @Test
    public void array3Test() {
        numero = new Numero(3);
        arrayNumero = numero.getPrimos();
        assertEquals(3, arrayNumero[1]);
        assertEquals(3, arrayNumero[1]);

    }

    @Test
    public void array100Test() {
        numero = new Numero(100);
        arrayNumero = numero.getPrimos();
        assertEquals(97, arrayNumero[24]);

    }
}
