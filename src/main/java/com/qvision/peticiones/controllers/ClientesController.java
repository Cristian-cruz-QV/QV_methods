/**
 * 
 */
package com.qvision.peticiones.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qvision.peticiones.models.Customer;
import com.qvision.peticiones.repository.CustomerRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping("api/v2")
@RestController
/**
 * @author Darvis Trillos A. - Q-Vision Technologies
 *
 */
public class ClientesController {

	@Autowired
	CustomerRepository customerRepository;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@GetMapping("/contactos")
	public ResponseEntity<List<?>> todos() {
		List<Customer> listCustomer;
		listCustomer = customerRepository.findAll();

		if (listCustomer.size() == 0) {
			List<String> errMessage = new ArrayList<>();
			errMessage.add("No se encontraron datos");
			return new ResponseEntity<>(errMessage, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/contactos/{id}")
	public ResponseEntity<?> uno(@PathVariable Long id) {
		try {
			Optional<Customer> objCust;
			objCust = customerRepository.findById(id);
			if (!objCust.isPresent())
				return new ResponseEntity<>("Ya no existe el empleado", HttpStatus.NOT_FOUND);

			return new ResponseEntity<>(objCust.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor, por favor revise los parametros ",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
	@GetMapping("/contactos/{tipoIdentificacion}/{numeroIdentificacion}")
	public ResponseEntity<?> unoPorIdentificacion(@PathVariable("tipoIdentificacion") String tipoIdentificacion,
			@PathVariable("numeroIdentificacion") Long numeroIdentificacion) {
		try {
			Optional<Customer> optCustm;
			optCustm = customerRepository.findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion,
					numeroIdentificacion);
			if (!optCustm.isPresent())
				return new ResponseEntity<>("No existe el cliente", HttpStatus.CONFLICT);

			return new ResponseEntity<>(optCustm.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor, por favor revise los parametros ",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping("/contactos")
	public ResponseEntity<?> grabar(@Valid @RequestBody Customer custom) {
		try {
			Customer cum = new Customer();
			Optional<Customer> optCustm;
			optCustm = customerRepository.findByTipoIdentificacionAndNumeroIdentificacion(
					custom.getTipoIdentificacion(), custom.getNumeroIdentificacion());
			if (optCustm.isPresent())
				return new ResponseEntity<>("Ya esta en la lista el cliente", HttpStatus.CONFLICT);

			cum = custom;

			return new ResponseEntity<>(customerRepository.save(cum), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor, por favor revise los parametros ",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PatchMapping("/contactos/{id}")
	public ResponseEntity<?> modificar(@Valid @RequestBody Customer custom, @PathVariable("id") Long id) {
		try {
			Optional<Customer> optCustm;
			optCustm = customerRepository.findById(id);
			if (!optCustm.isPresent())
				return new ResponseEntity<>("No existe cliente con ese tipo y numero de identificacion",
						HttpStatus.FORBIDDEN);

			customerRepository.save(custom);
			return new ResponseEntity<>("Actualizado con exito", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor, por favor revise los parametros",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@DeleteMapping("/contactos/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id) {
		try {
			Optional<Customer> optCustm;
			optCustm = customerRepository.findById(id);
			if (!optCustm.isPresent())
				return new ResponseEntity<>("No existe cliente con ese tipo y numero de identificacion",
						HttpStatus.FORBIDDEN);

			customerRepository.deleteById(id);
			return new ResponseEntity<>("Eliminado con exito", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor, por favor revise los parametros ",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	

}
