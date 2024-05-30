package com.example.ClienteService.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// Anotación que marca esta clase como un manejador global de excepciones
@ControllerAdvice
public class ManejadorExcepcionesPersonalizado {

    // Método que maneja todas las excepciones generales
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> manejarTodasLasExcepciones(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Método que maneja la excepción personalizada RecursoNoEncontradoExcepcion
    @ExceptionHandler(RecursoNoEncontradoExcepcion.class)
    public final ResponseEntity<?> manejarRecursoNoEncontradoExcepcion(RecursoNoEncontradoExcepcion ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
