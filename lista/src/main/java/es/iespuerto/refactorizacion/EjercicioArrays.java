package es.iespuerto.refactorizacion;

import java.util.*;

/**
 * Clase que de la posibilidad a hacer el estudio de las calificaciones de las
 * notas en control y en practicas del alumnado de dos maneras:
 * 
 * · Generando una lista aleatoria de notas para ambas partes y una lista de
 * alumnos por medio de la introduccion del numero de alumnos de la lista
 * · Generando la lista de alumnado a partir de la introduccion de ambas listas
 * de calificaciones de los alumnos ordenadas
 * 
 * @author GuillermoSH
 * @version 1.0
 */
public class EjercicioArrays {
    private int maxNota;
    private int minNota;
    private List<Integer> notasControl = null;
    private List<Integer> notasPracticas = null;
    private int[] listaClase = null;

    /**
     * Constructor parametrizado de la clase al que se le introducira el numero de
     * alumnos del que se quiere hacer el estudio de las notas
     * 
     * @param numAlumnos del que se quiere hacer la muestra
     */
    public EjercicioArrays(int numAlumnos) {
        this.notasControl = obtenerNotasAleatorias(numAlumnos);
        this.notasPracticas = obtenerNotasAleatorias(numAlumnos);
        this.listaClase = obtenerListaAlumnado(numAlumnos);
    }

    /**
     * Constructor parametrizado de la clase al que se le introducira dos listas de
     * notas, una de control y otra de practicas, para hacer el estudio de las
     * calificaciones
     * 
     * @param notasControl   lista con las notas del alumnado en control
     * @param notasPracticas lista con las notas del alumnado en practicas
     */
    public EjercicioArrays(List<Integer> notasControl, List<Integer> notasPracticas) {
        this.notasControl = notasControl;
        this.notasPracticas = notasPracticas;
        this.listaClase = obtenerListaAlumnado(notasControl.size());
    }

    /**
     * Metodo para la obtencion del alumno que ha obtenido la mayor nota dentro de
     * una lista de notas
     * 
     * @param notas lista con las notas del alumnado
     * @return numero de alumno que ha obtenido la mayor nota
     */
    public int obtenerAluMaxNota(List<Integer> notas) {
        List<Integer> notasOrdenadas = new ArrayList<>();
        notasOrdenadas.addAll(notas);
        Collections.sort(notasOrdenadas, Collections.reverseOrder());

        maxNota = notasOrdenadas.get(0);

        return notas.indexOf(maxNota) + 1;
    }

    /**
     * Metodo para la obtencion del alumno que ha obtenido la menor nota dentro de
     * una lista de notas
     * 
     * @param notas lista con las notas del alumnado
     * @return numero del alumno que ha obtenido la menor nota
     */
    public int obtenerAluMinNota(List<Integer> notas) {
        List<Integer> notasOrdenadas = new ArrayList<>();
        notasOrdenadas.addAll(notas);
        Collections.sort(notasOrdenadas);

        minNota = notasOrdenadas.get(0);

        return notas.indexOf(minNota) + 1;
    }

    /**
     * Metodo de generacion de una lista de enteros con las notas aleatoriamente
     * generadas para cada alumno en la parte de control
     * 
     * @param numAlumnos que se encuentran dentro de la lista
     * @return lista de calificaciones en control
     */
    private List<Integer> obtenerNotasAleatorias(int numAlumnos) {
        List<Integer> notasAleatorias = new ArrayList<>();

        for (int i = 0; i < numAlumnos; i++) {
            notasAleatorias.add((int) (Math.random() * 11));
        }
        return notasAleatorias;
    }

    /**
     * Metodo de generacion de una lista de enteros con las notas aleatoriamente
     * generadas para cada alumno en la parte de practicas
     * 
     * @param numAlumnos que se encuentran dentro de la lista
     * @return lista de calificaciones en practicas
     */
    public int[] obtenerListaAlumnado(int numAlumnos) {
        int[] lista = new int[numAlumnos];

        for (int i = 0; i < numAlumnos; i++) {
            lista[i] = i + 1;
        }
        return lista;
    }

    /**
     * Metodo para la obtencion de un array de doubles con las medias de las
     * calificaciones obtenidas por cada alumno en ambas partes, es decir, en
     * control y en la parte practica (ambas listas del mismo tamanio)
     * 
     * @param notasControl   lista con las notas del alumnado en control
     * @param notasPracticas lista con las notas del alumnado en practicas
     * @return media de las calificaciones obtenidas por el alumnado
     */
    public double[] mediaCalificaciones(List<Integer> notasControl, List<Integer> notasPracticas) {
        double[] mediaCalificaciones = new double[notasControl.size()];

        for (int i = 0; i < notasControl.size(); i++) {
            mediaCalificaciones[i] = (((double) notasControl.get(i)) + ((double) notasPracticas.get(i))) / 2;
        }
        return mediaCalificaciones;
    }

    /**
     * Metodo por el que se obtienen los porcentajes de calificaciones de la lista
     * de notas del alumnado. Ej:
     * [0,1,2,3,4,5,6,7,8,9,10]
     * [1%,3%,10%,2%,4%,12%,20%,15%,18%,10%,5%]
     * 
     * @return array con los porcentajes de las calificaciones
     */
    public double[] porcentajeCalificaciones(List<Integer> notas) {
        double[] porcentajes = new double[11];

        for (int i = 0; i < porcentajes.length; i++) {
            porcentajes[i] = (sumaCalificaciones(notas)[i] / notas.size()) * 100;
        }

        return porcentajes;
    }

    /**
     * Metodo para contar las calificaciones que sean iguales para luego sacar
     * porcentajes de notas en el metodo {@link #sumaCalificaciones(List)}
     * 
     * @param notas lista de notas del alumnado
     * @return array de doubles con la cuenta de calificaciones
     */
    private double[] sumaCalificaciones(List<Integer> notas) {
        double[] sumaNotas = new double[11];

        for (int i = 0; i < sumaNotas.length; i++) {
            for (int j = 0; j < notas.size(); j++) {
                if (notas.get(j) == i) {
                    sumaNotas[i]++;
                }
            }
        }
        return sumaNotas;
    }

    /**
     * Metodo para obtener un array con dos posiciones:
     * · La primera posicion es la cuenta de aprobados
     * · La segunda posicion es la cuenta de suspensos
     * 
     * @param notasControl   lista de notas del alumnado en control
     * @param notasPracticas lista de notas del alumnado en practicas
     * @return array de int con las cuentas de aprobados y suspensos
     */
    public int[] aprobadosYsuspensos(List<Integer> notasControl, List<Integer> notasPracticas) {
        double[] media = mediaCalificaciones(notasControl, notasPracticas);
        int[] aprobadosYsuspensos = new int[2];

        for (int i = 0; i < media.length; i++) {
            if (media[i] >= 5) {
                aprobadosYsuspensos[0]++;
                continue;
            }
            aprobadosYsuspensos[1]++;
        }
        return aprobadosYsuspensos;
    }

    /**
     * Metodo para retornar la informacion sobre las calificaciones de los alumnos
     * de la clase obteniendo estas de la parte practica y la de control. Ademas
     * incluiran las estadisticas de las calificaciones y la cantidad de aprobados y
     * suspensos en la clase basado en la media de las calificaciones en ambas
     * partes de la asignatura
     * 
     * @return String con toda la informacion
     */
    public String imprimirCalificaciones() {
        String resultado = "";
        resultado += "\nLista de clase:\n" + Arrays.toString(this.listaClase);
        resultado += "\n\nNotas Control:";
        resultado += "\n · Maxima nota obtenida por el alumno " + obtenerAluMaxNota(this.notasControl) + ": "
                + this.maxNota;
        resultado += "\n · Minima nota obtenida por el alumno " + obtenerAluMinNota(this.notasControl) + ": "
                + this.minNota;
        resultado += "\n · Porcentajes calificaciones:\n    "
                + Arrays.toString(porcentajeCalificaciones(this.notasControl));
        resultado += "\n\nNotas Practicas:";
        resultado += "\n · Maxima nota obtenida por el alumno " + obtenerAluMaxNota(this.notasPracticas) + ": "
                + this.maxNota;
        resultado += "\n · Minima nota obtenida por el alumno " + obtenerAluMinNota(this.notasPracticas) + ": "
                + this.minNota;
        resultado += "\n · Porcentajes calificaciones:\n    "
                + Arrays.toString(porcentajeCalificaciones(this.notasPracticas));
        resultado += "\nMedia de calificaciones: "
                + Arrays.toString(mediaCalificaciones(this.notasControl, this.notasPracticas));
        resultado += "\nNumero de aprobados: " + aprobadosYsuspensos(this.notasControl, this.notasPracticas)[0];
        resultado += "\nNumero de suspensos: " + aprobadosYsuspensos(this.notasControl, this.notasPracticas)[1];

        return resultado;
    }
}
