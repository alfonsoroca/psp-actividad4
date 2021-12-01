package requerimiento2;

import java.io.Serializable;

// Clase que recoge las características de los objetos coche que implementa la interfaz Serializable
public class Coche implements Serializable {

	private static final long serialVersionUID = 1L;

	// Características del objeto coche
	private String matricula, marca, modelo;
	private double precio;

	// Constructor del objeto coche
	public Coche(String matricula, String marca, String modelo, Double precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	// Sobrescritura del método toString()
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "]";
	}
}
