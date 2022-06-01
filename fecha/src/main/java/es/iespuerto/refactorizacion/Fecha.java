package es.iespuerto.refactorizacion;

/**
 * Clase Fecha a refactorizar sin modificar los test ya creados anteriormente.
 * Esta clase se compone de 1 metodo principal el cual validara los parametros
 * de entrada que ha introducido el usuario de una fecha en concreto.
 * 
 * @author GuillermoSH
 * @version 1.2
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private final int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * Constructor parametrizado de la clase Fecha
     * 
     * @param dia  introducido por el usuario
     * @param mes  introducido por el usuario
     * @param anio introducido por el usuario
     */
    public Fecha(int dia, int mes, int anio) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Metodo que comprueba si el anio es bisiesto o no
     * 
     * @param anio a estudiar en el metodo
     * @return condicion de estudio si es verdadera o falsa
     */
    private boolean esBisiesto(int anio) {
        return (anio % 400 == 0 || anio % 4 == 0 && anio % 100 != 0);
    }

    /**
     * Metodo para validar el dia introducido por el usuario llamando al método
     * {@link #esBisiesto(int)} para ver si febrero tiene 28 o 29 dias y si el dia
     * es mayor al limite de dias del mes introducido, lanza una excepcion
     * 
     * @return si se valida la fecha en {@link #diaValido()} y {@link #mesValido()}
     */
    public boolean valida() {
        if (esBisiesto(this.anio)) {
            dias[1] = 29;
        }
        return mesValido() && diaValido();

    }

    /**
     * Metodo de validacion del mes de la fecha introducida por el usuario
     * 
     * @return true o false si se cumple o no la condicion de validacion
     */
    private boolean mesValido() {
        return (this.mes > 0 && this.mes < 13);
    }

    /**
     * Metodo de validacion del dia de la fecha introducida por el usuario
     * 
     * @return true o false si se cumple o no la condicion de validacion
     */
    private boolean diaValido() {
        return (this.dia <= dias[this.mes - 1] && this.dia > 0);
    }

    /**
     * Metodo que devuelve un string con la fecha si esta ha sido validada, si no
     * devolvera el string vacio
     * 
     * @return string de la fecha validada o string vacio si no lo fue
     */
    public String imprimeFecha() {
        String resultado = "";

        if (valida()) {
            resultado = String.format("%02d/%02d/%4d", this.dia, this.mes, this.anio);
        }

        return resultado;
    }
}
