package es.iespuerto.refactorizacion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import es.iespuerto.refactorizacion.Fecha;

public class FechaTest {

    Fecha fecha = new Fecha (20, 6, 2008);
    Fecha mesMal1 = new Fecha (21, 0, 3000);
    Fecha mesMal2 = new Fecha (21, 13, 3000);
    Fecha diaMal1 = new Fecha (0, 11, 2000);
    Fecha diaMal2 = new Fecha (32, 11, 2000);
    Fecha diaMalNoviembre = new Fecha (31, 11, 2000);
    Fecha diaBienDiciembre = new Fecha (31, 12, 2000);
    Fecha diaMalFebrero = new Fecha (30, 2, 2008);
    Fecha diaBienFebreroBisiesto1 = new Fecha (29, 2, 2008);
    Fecha diaBienFebreroBisiesto2 = new Fecha (29, 2, 2000);
    Fecha diaMalFebreroBisiesto1 = new Fecha (29, 2, 2007);
    Fecha diaMalFebreroBisiesto2 = new Fecha (29, 2, 1900);


    @Test
    public void fechaCorrectaTest() {
        assertTrue(fecha.valida(),
                "La fecha debe de ser correcta");
    }
    @Test
    public void mesIncorrectoTest() {
        assertFalse(mesMal1.valida(),
                "La fecha debe de ser invalida");

    }

    @Test
    public void mesIncorrecto2Test() {
        assertFalse(mesMal2.valida(),
                "La fecha debe de ser invalida");
    }
    @Test
    public void diaIncorrectoTest() {
        assertFalse(diaMal1.valida(),
                "La fecha debe de ser invalida");
    }
    @Test
    public void diaIncorrecto2Test() {
        assertFalse(diaMal2.valida(),
                "La fecha debe de ser invalida");
    }
    @Test
    public void noviembreIncorrectoTest() {
        assertFalse(diaMalNoviembre.valida(),
                "La fecha debe de ser invalida");
    }
    @Test
    public void diciembreCorrectoTest() {
        assertTrue(diaBienDiciembre.valida(),
                "La fecha debe de ser valida");
    }
    @Test
    public void febreroIncorrectoTest() {
        assertFalse(diaMalFebrero.valida(),
                "La fecha debe de ser invalida");
    }
    @Test
    public void diaBienFebreroBisiestoTest() {
        assertTrue(diaBienFebreroBisiesto1.valida(),
                "La fecha debe de ser valida");
    }
    @Test
    public void diaBienFebreroBisiesto2Test() {
        assertTrue(diaBienFebreroBisiesto2.valida(),
                "La fecha debe de ser valida");
    }
    @Test
    public void diaMalFebreroBisiesto1Test() {
        assertFalse(diaMalFebreroBisiesto1.valida(),
                "La fecha debe de ser invalida");
    }
    @Test
    public void diaMalFebreroBisiesto2Test() {
        assertFalse(diaMalFebreroBisiesto2.valida(),
                "La fecha debe de ser invalida");
    }
}
