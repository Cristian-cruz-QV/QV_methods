package com.qvision.peticiones.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SpringSecurityConfig {
    @Bean
    UserDetailsService jdbcUserDetailsManager(DataSource dataSource,
                                              @Value("${security-jdbc.user}") String usersByUsernameQuery,
                                              @Value("${security.jdbc-authorities}") String authoritiesByUsernameQuery) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(authoritiesByUsernameQuery);
        return jdbcUserDetailsManager;
    }
 
   @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   

}
