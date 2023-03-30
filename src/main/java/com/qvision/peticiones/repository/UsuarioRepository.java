package com.qvision.peticiones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qvision.peticiones.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername(String username);
	Optional<Usuario> findByName(String name);
	Optional<Usuario> findByEmail(String email);
}