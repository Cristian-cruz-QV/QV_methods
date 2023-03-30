package com.qvision.peticiones.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qvision.peticiones.models.Usuario;
import com.qvision.peticiones.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthenticationController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsuarioRepository usuarioRepository;



	@GetMapping("/hello")
	public String sayHello() {
		return "Windows Server @";
	}

	@GetMapping("/user")
	public Authentication getLoggedUserDeatil() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// get username
		String username = auth.getName();
		// concat list of authorities to single string seperated by comma
		String authorityString = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		// check if the user have authority -roleA
		String role = "role_A";
		boolean isCurrentUserInRole = auth.getAuthorities().stream().anyMatch(role::equals);
		// return Authentication object
		return auth;
	}

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody Usuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		if (usuarioRepository.findByName(nuevoUsuario.getName()).isPresent())
			return new ResponseEntity<>("El nombre ya existe", HttpStatus.BAD_REQUEST);

		if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()).isPresent())
			return new ResponseEntity<>("El correo ya existe", HttpStatus.BAD_REQUEST);

		Usuario usuario = new Usuario();
		usuario.setName(nuevoUsuario.getName());
		usuario.setEmail(nuevoUsuario.getEmail());
		usuario.setUsername(nuevoUsuario.getUsername());
		String pencode = passwordEncoder.encode(nuevoUsuario.getPassword());
		usuario.setPassword(pencode);
		usuario.setRol(nuevoUsuario.getRol());
		/*
		 * Set<Rol> roles = new HashSet<>(); for (String rol : rolesStr) { switch (rol)
		 * { case "admin": Rol rolAdmin =
		 * rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get(); roles.add(rolAdmin);
		 * break; default: Rol rolUser =
		 * rolService.getByRolNombre(RolNombre.ROLE_USER).get(); roles.add(rolUser); } }
		 */
		// usuario.setRol(rol);

		return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
	}

	/*@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity<>("campos vacíos o email inválido", HttpStatus.BAD_REQUEST);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = generateToken(authentication);
		Usuario userDetails = (Usuario) authentication.getPrincipal();
		Jwt jwtDTO = new Jwt(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<Jwt>(jwtDTO, HttpStatus.OK);

	}

	public String generateToken(Authentication authentication) {
		Usuario usuarioMain = (Usuario) authentication.getPrincipal();
		return Jwts.builder().setSubject(usuarioMain.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + 43200 * 1000))
				// .signWith(SignatureAlgorithm.HS512, secret)
				.signWith(SignatureAlgorithm.HS256, "secret").compact();
	}*/

}
