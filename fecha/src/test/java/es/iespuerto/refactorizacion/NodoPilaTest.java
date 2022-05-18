package es.iespuerto.refactorizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodoPilaTest {
    NodoPila nodoPila1 = null;
    NodoPila nodoPila2 = null;
    NodoPila nodoPila3 = null;

    @BeforeEach
    public void beforeEach() {
        nodoPila1 = new NodoPila();
        nodoPila2 = new NodoPila(12);
        nodoPila3 = new NodoPila(12, nodoPila1);
    }

    @Test
    public void getElementoTest() {
        assertEquals(12, nodoPila3.getElemento());
    }

    @Test
    public void getSiguienteTest() {
        assertEquals(nodoPila1, nodoPila3.getSiguiente());
    }
}
