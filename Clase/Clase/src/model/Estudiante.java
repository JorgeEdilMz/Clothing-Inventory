package model;

public class Estudiante {

	private String nombre;
	private String apellido;
	private double nota;
	
	public Estudiante(String pNom, String pApe, double pNot) {
		nombre = pNom;
		apellido = pApe;
		nota = pNot;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Prendas.java [nombre=" + nombre + ", apellido=" + apellido + ", nota=" + nota + "]";
	}	
}
