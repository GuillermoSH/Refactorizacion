package es.iespuerto.refactorizacion;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.*;

public class EjercicioArraysTest {
    EjercicioArrays alumnado1 = null;
    List<Integer> notasControl = null;
    List<Integer> notasPracticas = null;

    @BeforeEach
    public void beforeEach() {
        alumnado1 = new EjercicioArrays(10);
        notasControl = new ArrayList<>(Arrays.asList(2, 5, 10, 7, 4, 1, 6, 9, 0, 8));
        notasPracticas = new ArrayList<>(Arrays.asList(3, 1, 4, 5, 1, 2, 9, 8, 10, 2));
    }

    @Test
    public void obtenerAluMaxNotaTest() {
        assertEquals(3, alumnado1.obtenerAluMaxNota(notasControl));
    }

    @Test
    public void obtenerAluMinNotaTest() {
        assertEquals(9, alumnado1.obtenerAluMinNota(notasControl));
    }

    @Test
    public void porcentajeCalificacionesTest() {
        double[] porcentajes = new double[11];
        double[] sumaNotas = new double[11];

        for (int i = 0; i < sumaNotas.length; i++) {
            for (int j = 0; j < notasControl.size(); j++) {
                if (notasControl.get(j) == i) {
                    sumaNotas[i]++;
                }
            }
        }

        for (int i=0;i<porcentajes.length;i++) {
            porcentajes[i]= sumaNotas[i] / notasControl.size();
        }

        assertTrue(alumnado1.porcentajeCalificaciones(notasControl).toString().contains(""+porcentajes));
    }
}
