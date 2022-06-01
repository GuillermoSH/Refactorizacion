package es.iespuerto.refactorizacion;

import org.junit.jupiter.api.BeforeEach;

public class AritmeticaTest {
    Aritmetica aritmetica;

    @BeforeEach
    public void beforeEach () {
        if (aritmetica == null) {
            aritmetica = new Aritmetica();
        }
    }
}
