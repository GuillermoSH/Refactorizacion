package es.iespuerto.refactorizacion;

/**
 * Clase banco que utiliza la clase money para hacer el cambio entre monedas
 * 
 * @author GuillermoSH
 */
public class Bank {
    /**
     * Metodo que recibe un objeto Money dinero y un String de moneda y devuelve un
     * nuevo objeto Money con la cantidad calculada si se ha de hacer cambio de
     * moneda
     * 
     * @param dinero a cambiar
     * @param moneda a la que queremos convertir
     * @return un nuevo objeto Money con la nueva cantidad y la moneda
     */
    public Money exchange(Money dinero, String moneda) {
        int cantidad = dinero.getCantidad();
        String monedaActual = dinero.getMoneda();

        if (!monedaActual.equals(moneda)) {
            cantidad = calculoCambio(monedaActual, cantidad, moneda);
        }

        return new Money(cantidad, moneda);
    }

    /**
     * Metodo para calcular el cambio insertando el valor actual de la moneda para
     * hacer el cambio a la moneda que quieres cambiar
     * 
     * @param monedaActual que se quiere convertir
     * @param cantidad     de dinero que se quiere cambiar
     * @param monedaCambio a la que se quiere cambiar
     * 
     * @return el cambio entre monedas
     */
    private int calculoCambio(String monedaActual, int cantidad, String monedaCambio) {
        int valorActual = (monedaActual.equals("EUR")) ? 130 : 100;
        int valorCambio = (monedaCambio.equals("USD")) ? 100 : 130;

        return (valorActual * cantidad) / valorCambio;
    }
}
