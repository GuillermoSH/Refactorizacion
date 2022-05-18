package es.iespuerto.refactorizacion;

public class RPN {
    private String commando;
    private NodoPila arriba;

    public RPN(String commando) {
        arriba = null;
        this.commando = commando;
    }

    public void pushPila(double nuevoDato) {
        NodoPila nuevoNodo = new NodoPila(nuevoDato, arriba);
        arriba = nuevoNodo;
    }

    public double popPila() {
        double datoArriba = arriba.getElemento();
        arriba = arriba.getSiguiente();
        
        return datoArriba;
    }

    public double resultado() {
        double a;
        double b;
        int j;
        for (int i = 0; i < commando.length(); i++) {
            // si es un digito
            if (Character.isDigit(commando.charAt(i))) {
                double numero;
                // obtener un string a partir del numero

                String temp = "";
                for (j = 0; (j < 100)
                        && (Character.isDigit(commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
                    temp = temp + String.valueOf(commando.charAt(i));
                }
                // convertir a double y añadir a la pila
                numero = Double.parseDouble(temp);
                pushPila(numero);
            } else if (commando.charAt(i) == '+') {
                b = popPila();
                a = popPila();
                pushPila(a + b);
            } else if (commando.charAt(i) == '-') {
                b = popPila();
                a = popPila();
                pushPila(a - b);
            } else if (commando.charAt(i) == '*') {
                b = popPila();
                a = popPila();
                pushPila(a * b);
            } else if (commando.charAt(i) == '/') {
                b = popPila();
                a = popPila();
                pushPila(a / b);
            } else if (commando.charAt(i) == '^') {
                b = popPila();
                a = popPila();
                pushPila(Math.pow(a, b));
            } else if (commando.charAt(i) == '%') {
                b = popPila();
                a = popPila();
                pushPila(a % b);
            } else if (commando.charAt(i) != ' ') {
                throw new IllegalArgumentException();
            }
        }
        double val = popPila();
        if (arriba != null) {
            throw new IllegalArgumentException();
        }
        return val;
    }
}
