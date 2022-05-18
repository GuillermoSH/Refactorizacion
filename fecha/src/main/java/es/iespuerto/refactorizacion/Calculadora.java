package es.iespuerto.refactorizacion;

public class Calculadora {
	private NodoPila abajo;
	private double dato;

	public Calculadora(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}

	public NodoPila getAbajo() {
		return this.abajo;
	}

	public double getDato() {
		return this.dato;
	}
}