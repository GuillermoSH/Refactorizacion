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
    public void obtenerListaAlumnadoTest() {
        assertEquals(12, alumnado1.obtenerListaAlumnado(12).length);
    }

    @Test
    public void mediaCalificacionesTest() {
        double[] media = new double[notasControl.size()];

        for (int i = 0; i < notasControl.size(); i++) {
            media[i] = ((double) notasControl.get(i) + (double) notasControl.get(i)) / 2;
            assertEquals(media[i], alumnado1.mediaCalificaciones(notasControl,notasControl)[i]);
        }
    }

    @Test
    public void porcentajeCalificacionesTest() {
        // Comprobacion con una muestra pequenia
        double[] porcentajes1 = { 0, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0 };
        List<Integer> notas = new ArrayList<>(Arrays.asList(1, 2));

        for (int i = 0; i < porcentajes1.length; i++) {
            assertEquals(porcentajes1[i], alumnado1.porcentajeCalificaciones(notas)[i]);
        }
        // Comprobacion con una muestra exacta para que todos los elementos tengan la
        // misma probabilidad
        double[] porcentajes2 = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        notas = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 5, 8, 6, 7, 9, 0, 10));

        for (int i = 0; i < porcentajes2.length; i++) {
            assertEquals((int) porcentajes2[i], (int) alumnado1.porcentajeCalificaciones(notas)[i]);
        }
    }

    @Test
    public void aprobadosYsuspensosTest() {
        notasControl = new ArrayList<>(Arrays.asList(1,1,1,1,1,5,5,5,5,5));
        notasPracticas = new ArrayList<>(Arrays.asList(1,0,2,3,2,7,10,9,8,6));
        int[] array = {5,5};

        // Comprobacion de aprobados
        assertEquals(array[0],alumnado1.aprobadosYsuspensos(notasControl, notasPracticas)[0]);
        // Comprobacion de suspensos
        assertEquals(array[1],alumnado1.aprobadosYsuspensos(notasControl, notasPracticas)[1]);
    }

    @Test
    public void imprimirCalificacionesTest() {
        notasControl = new ArrayList<>(Arrays.asList(1,1,1,1,1,5,5,5,5,5));
        notasPracticas = new ArrayList<>(Arrays.asList(1,0,2,3,2,7,10,9,8,6));
        alumnado1 = new EjercicioArrays(notasControl,notasPracticas);

        // Comprobacion primera linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("Lista de clase:\n[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"));
        // Comprobacion tercera linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("· Maxima nota obtenida por el alumno 6: 5"));
        // Comprobacion cuarta linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("· Minima nota obtenida por el alumno 1: 1"));
        // Comprobacion quinta linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("· Porcentajes calificaciones:\n    [0.0, 50.0, 0.0, 0.0, 0.0, 50.0, 0.0, 0.0, 0.0, 0.0, 0.0]"));
        // Comprobacion septima linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("· Maxima nota obtenida por el alumno 7: 10"));
        // Comprobacion octava linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("· Minima nota obtenida por el alumno 2: 0"));
        // Comprobacion novena linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("· Porcentajes calificaciones:\n    [10.0, 10.0, 20.0, 10.0, 0.0, 0.0, 10.0, 10.0, 10.0, 10.0, 10.0]"));
        // Comprobacion decima linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("Media de calificaciones: [1.0, 0.5, 1.5, 2.0, 1.5, 6.0, 7.5, 7.0, 6.5, 5.5]"));
        // Comprobacion undecima linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("Numero de aprobados: 5"));
        // Comprobacion duodecima linea
        assertTrue(alumnado1.imprimirCalificaciones().contains("Numero de suspensos: 5"));
    }
}
