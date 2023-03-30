package com.qvision.peticiones.services;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.qvision.peticiones.models.Usuario;
import com.qvision.peticiones.repository.UsuarioRepository;


public class SpringDataUserDetailsService implements UserDetailsService {
 
    private final UsuarioRepository usuarioRepository;
 
    public SpringDataUserDetailsService(UsuarioRepository UsuarioRepository) {
        this.usuarioRepository = UsuarioRepository;
    }
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("user " + username + " not found with Spring Data"));
    }
 
    private UserDetails map(Usuario user) {
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getRol());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isEnabled(), user.isEnabled(), user.isEnabled(), authorities);
    }
     
}