package com.example.ClienteService.controlador;

import com.example.ClienteService.modelo.Cliente;
import com.example.ClienteService.excepcion.RecursoNoEncontradoExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Anotación que marca esta clase como un controlador REST
@RestController
@RequestMapping("/api/clientes") // Define la ruta base para las peticiones
public class ClienteController {

	// Método que maneja la solicitud GET para obtener un cliente por tipo y número
	// de documento
	@GetMapping("/{tipoDocumento}/{numeroDocumento}")
	public ResponseEntity<?> obtenerCliente(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) {
		// Verifica si los parámetros son nulos o vacíos
		if (tipoDocumento == null || numeroDocumento == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Tipo de documento y número de documento son obligatorios");
		}

		// Verifica si el tipo de documento es válido
		if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de documento no válido");
		}

		// Verifica si el tipo y número de documento coinciden con el cliente mockeado
		if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
			// Crea un objeto Cliente con datos mockeados
			Cliente cliente = new Cliente();
			cliente.setPrimerNombre("Juan");
			cliente.setSegundoNombre("Carlos");
			cliente.setPrimerApellido("Perez");
			cliente.setSegundoApellido("Gomez");
			cliente.setTelefono("123456789");
			cliente.setDireccion("Calle Falsa 123");
			cliente.setCiudadResidencia("Bogotá");

			// Retorna la respuesta con el cliente y el estado HTTP 200 OK
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		} else {
			// Lanza una excepción si el cliente no es encontrado
			throw new RecursoNoEncontradoExcepcion("Cliente no encontrado");
		}
	}
}
