package es.iespuerto.refactorizacion;

import java.util.*;

public class EjercicioArrays {
    private int maxNota;
    private int minNota;
    List<Integer> notasControl = null;
    List<Integer> notasPracticas = null;
    private int[] listaClase = null;

    /**
     * Constructor parametrizado de la clase al que se le introducira el numero de
     * alumnos del que se quiere hacer el estudio de las notas
     * 
     * @param numAlmunos del que se quiere hacer la muestra
     */
    public EjercicioArrays(int numAlumnos) {
        this.notasControl = obtenerNotasAleatorias(numAlumnos);
        this.notasPracticas = obtenerNotasAleatorias(numAlumnos);
        this.listaClase = obtenerListaAlumnado(numAlumnos);
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
        maxNota = notasOrdenadas.get(0);
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
    private int[] obtenerListaAlumnado(int numAlumnos) {
        int[] lista = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++) {
            lista[i] = i + 1;
        }
        return lista;
    }

    /**
     * Metodo para la obtencion de un array de doubles con las medias de las
     * calificaciones obtenidas por cada alumno en ambas partes, es decir, en
     * control y en la parte practica
     * 
     * @return media de las calificaciones obtenidas por el alumnado
     */
    private double[] mediaCalificaciones() {
        double[] mediaCalificaciones = new double[notasControl.size()];

        for (int i = 0; i < this.notasControl.size(); i++) {
            mediaCalificaciones[i] = (((double) notasControl.get(i) + (double) notasPracticas.get(i)) / 2);
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
     * @return array de int con las cuentas de aprobados y suspensos
     */
    public int[] aprobadosYsuspensos() {
        double[] media = mediaCalificaciones();
        int[] aprobadosYsuspensos = new int[2];

        for (int i = 0; i < media.length; i++) {
            if (media[i] >= 5) {
                aprobadosYsuspensos[0]++;
                break;
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
        resultado += "Lista de clase:\n" + this.listaClase + "\n" + mediaCalificaciones();
        resultado += "\nNotas Control:";
        resultado += "\n · Maxima nota obtenida por el alumno " + obtenerAluMaxNota(this.notasControl) + ": "
                + this.maxNota;
        resultado += "\n · Minima nota obtenida por el alumno " + obtenerAluMinNota(this.notasControl) + ": "
                + this.minNota;
        resultado += "\n · Porcentajes de control: \n    " + porcentajeCalificaciones(this.notasControl);
        resultado += "\n\nNotas Practicas:";
        resultado += "\n · Maxima nota obtenida por el alumno " + obtenerAluMaxNota(this.notasPracticas) + ": "
                + this.maxNota;
        resultado += "\n · Minima nota obtenida por el alumno " + obtenerAluMinNota(this.notasPracticas) + ": "
                + this.minNota;
        resultado += "\n · Porcentajes de control: \n    " + porcentajeCalificaciones(this.notasControl);
        resultado += "\nNumero de aprobados: " + aprobadosYsuspensos()[0];
        resultado += "\nNumero de suspensos: " + aprobadosYsuspensos()[1];

        return resultado;
    }

    public static void main(String[] args) {
        EjercicioArrays alumnado1 = new EjercicioArrays(10);
        List<Integer> notasControl = new ArrayList<>(Arrays.asList(2, 5, 10, 7, 4, 1, 6, 9, 0, 8));
        double[] porcentajes = new double[11];
        double[] sumaNotas = new double[11];

        for (int i = 0; i < sumaNotas.length; i++) {
            for (int j = 0; j < notasControl.size(); j++) {
                if (notasControl.get(j) == i) {
                    sumaNotas[i]++;
                }
            }
        }

        for (int i = 0; i < porcentajes.length; i++) {
            porcentajes[i] = sumaNotas[i] / notasControl.size() * 100;
        }

        alumnado1.porcentajeCalificaciones(notasControl).toString().contains("" + porcentajes);

        /**
         * 6. Suponer un vector de Calificaciones de tamaño 40
         * (máximo de alumnos por clase), pero que solo almacena las
         * notas de 31 alumnos. Realizar un programa que permita insertar en
         * la posición 4 del vector la calificación de un nuevo
         * alumno en clase al que supuestamente le corresponde como nota un 6.
         */
        double[] calif = new double[40];
        for (int j = 0; j < 31; j++) {
            calif[j] = (int) (Math.random() * 11);
        }
        System.out.println("Nota antigua alumno nº4: " + calif[3]);
        calif[3] = 6;
        System.out.println("Nota nueva   alumno nº4: " + calif[3]);
    }

}
