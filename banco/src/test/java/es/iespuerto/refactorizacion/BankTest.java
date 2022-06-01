package es.iespuerto.refactorizacion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Money euros;
    Money dolares;
    Bank banco;
    final int cantidad = 30;

    @BeforeEach
    public void beforeEach() {
        euros = new Money(cantidad, "EUR");
        dolares = new Money(cantidad, "USD");
        banco = new Bank();
    }

    @Test
    public void exchangeEurosToEurosTest() {
        assertEquals(cantidad, banco.exchange(euros, "EUR").getCantidad(),
                "El paso de euros a euros debe ser la misma cantidad");
    }

    @Test
    public void exchangeEurosToDolaresTest() {
        int resultado = 130 * cantidad / 100;
        assertEquals(resultado, banco.exchange(euros, "USD").getCantidad(),
                "El paso de euros a dolares debe ser igual a la cantidad por 130 partido de 100");
    }

    @Test
    public void exchangeDolaresToDolaresTest() {
        assertEquals(cantidad, banco.exchange(dolares, "USD").getCantidad(),
                "El paso de dolares a dolares debe ser la misma cantidad");
    }

    @Test
    public void exchangeDolaresToEurosTest() {
        int resultado = 100 * cantidad / 130;
        assertEquals(resultado, banco.exchange(dolares, "EUR").getCantidad(),
                "El paso de dolares a euros debe ser igual a la cantidad por 100 partido de 130");
    }
}
