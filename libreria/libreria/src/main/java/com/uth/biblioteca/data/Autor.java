package com.uth.biblioteca.data;

public class Autor {

	private int id;
	private String nombre;
	private String biografia;
	private String nacimiento;
	private int cantidad_libros;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public int getCantidad_libros() {
		return cantidad_libros;
	}
	public void setCantidad_libros(int cantidad_libros) {
		this.cantidad_libros = cantidad_libros;
	}
	
	
}
