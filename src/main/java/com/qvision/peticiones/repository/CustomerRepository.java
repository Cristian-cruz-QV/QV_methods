package com.qvision.peticiones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qvision.peticiones.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Optional<Customer> findById(Long id);
	public Customer findById(String id);

	public Optional<Customer> findByTipoIdentificacionAndNumeroIdentificacion(String tipoIdentificacion,
			Number numeroIdentificacion);

}
