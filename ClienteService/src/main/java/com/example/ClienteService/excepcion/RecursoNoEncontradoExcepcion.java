package com.example.ClienteService.excepcion;

// Clase que define una excepción personalizada para recursos no encontrados
public class RecursoNoEncontradoExcepcion extends RuntimeException {
	public RecursoNoEncontradoExcepcion(String mensaje) {
		super(mensaje);
	}
}
