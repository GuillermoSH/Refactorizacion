package es.iespuerto.refactorizacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculadoraTest {
    Calculadora calculo1 = null;
    NodoPila abajo = null;

    @BeforeEach
    public void beforeEach() {
        abajo = new NodoPila();
        calculo1 = new Calculadora(12, abajo);
    }

    @Test
    public void getAbajoTest() {
        assertEquals(abajo,calculo1.getAbajo());
    }

    @Test
    public void getDatoTest() {
        assertEquals(12,calculo1.getDato());
    }
}
