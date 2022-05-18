package es.iespuerto.refactorizacion;

public class NodoPila {

	Object elemento;
	NodoPila siguiente;

	/**
	 * Contructor sin parametros de entrada lo que se asignaran ambas variables como
	 * null
	 */
	public NodoPila() {
		this.elemento = null;
		this.siguiente = null;
	}

	/**
	 * Constructor con solo un parametro que recibe un objeto como parametro y lo
	 * asigna a la variable elemento y el apuntador (la variable siguiente) a null
	 * 
	 * @param elem a ser insertado
	 */
	public NodoPila(Object elem) {
		this.elemento = elem;
		this.siguiente = null;
	}

	/**
	 * Constructor con ambos parametros que recibe un objeto como parametro y otro
	 * objeto de la clase con el puntero al siguiente objeto
	 * 
	 * @param nuevoDato elemento a insertar
	 * @param arriba    siguiente puntero
	 */
	public NodoPila(double nuevoDato, NodoPila arriba) {
		this.elemento = nuevoDato;
		this.siguiente = arriba;
	}

	/**
	 * Getter del parametro elemento haciendole un casting a double para poder ser
	 * tratado en las clases que lo requieran
	 * 
	 * @return dato del puntero deseado
	 */
	public double getElemento() {
		return (double) this.elemento;
	}

	/**
	 * Getter del parametro siguiente que es el puntero al siguiente elemento de la
	 * pila
	 * 
	 * @return siguiente puntero
	 */
	public NodoPila getSiguiente() {
		return this.siguiente;
	}
}
