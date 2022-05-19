package es.iespuerto.refactorizacion;

import java.util.*;

public class EjercicioArrays {
    private int maxNota;
    private int minNota;
    private List<Integer> notasControl = null;
    private List<Integer> notasPracticas = null;
    private int[] listaClase = null;

    public EjercicioArrays(int numAlumnos) {
        this.notasControl = obtenerNotasAleatorias(numAlumnos);
        this.notasPracticas = obtenerNotasAleatorias(numAlumnos);
        this.listaClase = obtenerListaAlumnado(numAlumnos);
    }

    public int obtenerIndMaxNota(List<Integer> notas) {
        Collections.sort(notas, Collections.reverseOrder());
        maxNota = notas.get(0);
        return notas.indexOf(maxNota) + 1;
    }

    public int obtenerIndMinNota(List<Integer> notas) {
        Collections.sort(notas);
        minNota = notas.get(0);
        return notas.indexOf(minNota) + 1;
    }

    private List<Integer> obtenerNotasAleatorias(int numAlumnos) {
        List<Integer> control = new ArrayList<>();

        for (int i = 0; i < numAlumnos; i++) {
            control.add((int) (Math.random() * 11));
        }
        return control;
    }

    private int[] obtenerListaAlumnado(int numAlumnos) {
        int[] lista = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++) {
            lista[i] = i + 1;
        }
        return lista;
    }

    private double[] mediaCalificaciones() {
        double[] mediaCalificaciones = new double[notasControl.size()];

        for (int i = 0; i < this.notasControl.size(); i++) {
            mediaCalificaciones[i] = (((double) notasControl.get(i) + (double) notasPracticas.get(i)) / 2);
        }
        return mediaCalificaciones;
    }

    private double[] estadisticaCalificaciones() {
        double[] estadistica = new double[10];

        for (int i = 0; i < estadistica.length; i++) {
            estadistica[i] = (sumaCalificaciones(this.notasControl)[i]
                    + sumaCalificaciones(this.notasPracticas)[i] / this.notasControl.size());
        }

        return estadistica;
    }

    private double[] sumaCalificaciones(List<Integer> notas) {
        double[] sumaNotas = new double[10];

        for (int i = 0; i < sumaNotas.length; i++) {
            for (int j = 0; j < notas.size(); j++) {
                if (notas.get(j) == i) {
                    sumaNotas[i]++;
                }
            }
        }
        return sumaNotas;
    }

    private int[] aprobadosYsuspensos() {
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

    public String imprimirCalificaciones(boolean conEstadistica) {
        String resultado = "";
        resultado += "Lista de clase:\n" + this.listaClase + "\n" + mediaCalificaciones();
        resultado += "\nNotas Control:";
        resultado += "\n · Maxima nota obtenida por el alumno " + obtenerIndMaxNota(this.notasControl) + ": "+ this.maxNota;
        resultado += "\n · Minima nota obtenida por el alumno " + obtenerIndMinNota(this.notasControl) + ": "+ this.minNota;
        resultado += "\nNotas Practicas:";
        resultado += "\n · Maxima nota obtenida por el alumno " + obtenerIndMaxNota(this.notasPracticas) + ": "+ this.maxNota;
        resultado += "\n · Minima nota obtenida por el alumno " + obtenerIndMinNota(this.notasPracticas) + ": "+ this.minNota;
        resultado += "\nEstadistica de notas: \n"+estadisticaCalificaciones();
        resultado += "\nNumero de aprobados: "+aprobadosYsuspensos()[0];
        resultado += "\nNumero de suspensos: "+aprobadosYsuspensos()[1];

        return resultado;
    }

    public static void main(String[] args) {
        int numAlumnos = 40;
        // vector con las notas generadas
        Integer[] control = new Integer[numAlumnos];
        int maxNota = 0;
        int minNota = 0;
        int indMaxNota, indMinNota;
        int postEval;
        // Genera notas random entre 1 y 10
        for (int i = 0; i < control.length; i++) {
            control[i] = (int) (Math.random() * 11);
        }
        // buscamos al mayor
        postEval = 11;
        for (int i = 0; i < control.length; i++) {
            int preEval = control[i];
            if (preEval < postEval) {
                minNota = preEval;
                postEval = control[i];
            }
        }
        // buscamos al menor
        postEval = 0;
        for (int i = 0; i < control.length; i++) {
            int preEval = control[i];
            if (preEval > postEval) {
                maxNota = preEval;
                postEval = control[i];
            }
        }
        // creamos una lista de los alumnos de la clase
        int[] listaClase = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++) {
            listaClase[i] = i + 1;
        }
        // Empezamos el uso de listas para facilitar la tarea de índices.
        List notas = Arrays.asList(control);
        indMinNota = notas.indexOf(minNota) + 1;
        indMaxNota = notas.indexOf(maxNota) + 1;

        // Comprobamos el resultado del ejercicio
        System.out.println("Mínimo es: " + minNota);
        System.out.println("Máximo es: " + maxNota);
        System.out.println("Indice del mínimo es : " + indMinNota);
        System.out.println("Indice del máximo es : " + indMaxNota);
        System.out.println("Lista de clase :" + Arrays.toString(listaClase));
        System.out.println("Array de Notas :" + notas);

        // creamos el array de notas "practicas"
        int[] practicas = new int[numAlumnos];
        for (int i = 0; i < practicas.length; i++) {
            practicas[i] = (int) (Math.random() * 11);
        }
        // Creamos el vector calificaciones
        float[] calificaciones = new float[numAlumnos];
        for (int i = 0; i < control.length; i++) {
            calificaciones[i] = (((float) control[i]
                    + (float) practicas[i])
                    / 2);
        }
        System.out.println("Prácticas      :" + Arrays.toString(practicas));
        System.out.println("Calificaciones :" + Arrays.toString(calificaciones));

        // Sacamos la estadística de calificaciones
        // hacemos un array de 10 para la estadística.
        float[] estadistica = new float[10];

        for (int i = 0; i < 10; i++) {
            float count = 0;
            float sum = 0;
            for (int j = 0; j < control.length; j++) {
                if ((i < calificaciones[j]) && ((i + 1) >= calificaciones[j])) {
                    sum += calificaciones[j];
                    count += 1;
                }
            }
            if (count != 0) {
                estadistica[i] = (count / numAlumnos);
            } else {
                estadistica[i] = 0;
            }
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <="
                    + (i + 1) + " = "
                    + sol + "%");
        }
        // Aprobados y suspensos
        int[] aprobados = new int[numAlumnos];
        int[] suspensos = new int[numAlumnos];
        int countAprobados = 0;
        int countSuspensos = 0;
        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] < 5) {
                aprobados[i] = i;
                countAprobados += 1;
            } else {
                suspensos[i] = i;
                countSuspensos += 1;
            }
        }
        System.out.println("Relación de aprobados por nº de lista: "
                + Arrays.toString(aprobados));
        System.out.println("Relación de suspensos por nº de lista: "
                + Arrays.toString(suspensos));
        // Resumen de aprobados y suspensos
        int i = 0;
        int x = 0;
        int[] a = new int[countAprobados];
        int[] s = new int[countSuspensos];
        while (i < aprobados.length) {
            if (aprobados[i] != 0) {
                a[x] = aprobados[i];
                i++;
                x++;
            } else {
                i++;
            }
        }

        i = x = 0;
        while (i < suspensos.length) {
            if (suspensos[i] != 0) {
                s[x] = suspensos[i];
                i++;
                x++;
            } else {
                i++;
            }
        }
        System.out.println("Resumen  de aprobados por nº de lista: "
                + Arrays.toString(a));
        System.out.println("Resumen  de aprobados por nº de lista: "
                + Arrays.toString(s));

        /*
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
