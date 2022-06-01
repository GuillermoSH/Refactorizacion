package es.iespuerto.refactorizacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MoneyTest {
    private static final int CANTIDAD = 30;
    private static final String EUR = "EUR";
    Money money;

    @BeforeEach
    public void beforeEach() {
        if (money == null) {
            money = new Money(CANTIDAD,EUR);
        }
    }

    @Test
    public void monedaNotNullTest() {
        assertNotNull(money,"El objeto moneda no puede ser nulo.");
    }

    @Test
    public void obtenerCantidadTest() {
        assertEquals(30,money.getCantidad(),"Debe coincidir con la cantidad 30");
    }

    @Test
    public void obtenerMonedaTest() {
        assertEquals("EUR",money.getMoneda(),"Debe coincidir con la moneda 'EUR'");
    }
}
