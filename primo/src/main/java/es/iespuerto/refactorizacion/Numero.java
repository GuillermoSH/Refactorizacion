package es.iespuerto.refactorizacion;

public class Numero {
    private int dimension;
    private boolean[] esPrimo;
    private int[] primos;

    public Numero(int limite) {
        this.primos = primos(limite);
    }

    public int[] getPrimos() {
        return primos;
    }

    private int[] primos(int limite) {
        int i = 0;
        int j = 0;
        if (limite >= 2) {
            dimension = limite + 1;

            generarArray();
            primosAtrue();
            
            int cuenta = contarPrimos();

            primos = new int[cuenta];
            for (i = 0, j = 0; i < dimension; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else {
            return new int[0];
        }
    }

    private void generarArray() {
        esPrimo = new boolean[dimension];
        for (int i = 0; i < dimension; i++) {
            esPrimo[i] = true;
        }
    }

    private void primosAtrue() {
        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i < Math.sqrt(dimension) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dimension; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    private int contarPrimos() {
        int cuenta = 0;

        for (int i = 0; i < dimension; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }
}
