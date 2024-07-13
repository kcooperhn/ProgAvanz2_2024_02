package com.uth.biblioteca.controller;

import com.uth.biblioteca.data.LibrosResponse;
import com.uth.biblioteca.repository.DatabaseRepositoryImpl;
import com.uth.biblioteca.views.libros.LibrosViewModel;

public class LibrosInteractorImpl implements LibrosInteractor {

	private DatabaseRepositoryImpl modelo;
	private LibrosViewModel vista;
	
	public LibrosInteractorImpl(LibrosViewModel vista) {
		super();
		this.vista = vista;
		this.modelo = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 30000L);//TIEMPO EN MILISEGUNDOS
	}

	@Override
	public void consultarLibros() {
		//ESTRUCTURA TRY...CATCH PARA MANEJO DE ERRORES
		try{
			//EL CODIGO QUE SE EJECUTA EN EL HAPPY PATH
			LibrosResponse respuesta = this.modelo.consultarLibros();
			if(respuesta == null || respuesta.getCount() == 0 || respuesta.getItems() == null) {
				this.vista.mostrarMensajeError("No hay libros que mostrar");
			}else {
				this.vista.mostrarLibrosEnGrid(respuesta.getItems());
			}
			
		}catch(Exception error) {
			//EL CODIGO QUE SE EJECUTA CUANDO HAY PROBLEMAS
			error.printStackTrace();
			this.vista.mostrarMensajeError("Ha ocurrido un problema, revisa tu conexión a internet");
		}
	}

	
	
}