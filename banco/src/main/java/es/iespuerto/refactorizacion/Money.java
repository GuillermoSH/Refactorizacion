package es.iespuerto.refactorizacion;

/**
 * Clase para almacenar la cantidad y el tipo de moneda que se usara en otras
 * clases
 */
public class Money {
    private int cantidad;
    private String moneda;

    /**
     * Constructor parametrizado para asignar cantidad y moneda a las variables
     * miembro
     * 
     * @param cantidad de dinero insertado
     * @param moneda   del dinero
     */
    public Money(int cantidad, String moneda) {
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    /**
     * Este metodo devuelve el valor de la variable cantidad
     * 
     * @return el valor de la variable cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Este metodo devuelve el valor de la variable moneda
     * 
     * @return el valor de la variable moneda
     */
    public String getMoneda() {
        return moneda;
    }

}
