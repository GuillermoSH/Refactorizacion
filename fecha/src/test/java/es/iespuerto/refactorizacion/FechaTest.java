package es.iespuerto.refactorizacion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FechaTest {
    Fecha fecha = new Fecha(20, 6, 2008);

    @Test
    public void fechaCorrectaTest() {
        assertTrue(fecha.valida(), "La fecha debe de ser correcta");
    }

    @Test
    public void mesIncorrectoTest() {
        Fecha mesMal1 = new Fecha(21, 0, 3000);

        assertFalse(mesMal1.valida(), "La fecha debe de ser invalida");

    }

    @Test
    public void mesIncorrecto2Test() {
        Fecha mesMal2 = new Fecha(21, 13, 3000);

        assertFalse(mesMal2.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void diaIncorrectoTest() {
        Fecha diaMal1 = new Fecha(0, 11, 2000);

        assertFalse(diaMal1.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void diaIncorrecto2Test() {
        Fecha diaMal2 = new Fecha(32, 11, 2000);

        assertFalse(diaMal2.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void noviembreIncorrectoTest() {
        Fecha diaMalNoviembre = new Fecha(31, 11, 2000);

        assertFalse(diaMalNoviembre.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void diciembreCorrectoTest() {
        Fecha diaBienDiciembre = new Fecha(31, 12, 2000);

        assertTrue(diaBienDiciembre.valida(), "La fecha debe de ser valida");
    }

    @Test
    public void febreroIncorrectoTest() {
        Fecha diaMalFebrero = new Fecha(30, 2, 2008);

        assertFalse(diaMalFebrero.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void diaBienFebreroBisiestoTest() {
        Fecha diaBienFebreroBisiesto1 = new Fecha(29, 2, 2008);

        assertTrue(diaBienFebreroBisiesto1.valida(), "La fecha debe de ser valida");
    }

    @Test
    public void diaBienFebreroBisiesto2Test() {
        Fecha diaBienFebreroBisiesto2 = new Fecha(29, 2, 2000);

        assertTrue(diaBienFebreroBisiesto2.valida(), "La fecha debe de ser valida");
    }

    @Test
    public void diaMalFebreroBisiesto1Test() {
        Fecha diaMalFebreroBisiesto1 = new Fecha(29, 2, 2007);

        assertFalse(diaMalFebreroBisiesto1.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void diaMalFebreroBisiesto2Test() {
        Fecha diaMalFebreroBisiesto2 = new Fecha(29, 2, 1900);

        assertFalse(diaMalFebreroBisiesto2.valida(), "La fecha debe de ser invalida");
    }

    @Test
    public void imprimeFechaTest() {
        fecha = new Fecha(2, 2, 2002);

        assertEquals("02/02/2002", fecha.imprimeFecha());
    }
}
