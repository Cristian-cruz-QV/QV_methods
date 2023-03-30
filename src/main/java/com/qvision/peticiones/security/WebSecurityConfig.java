package com.qvision.peticiones.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration

//@Profile("!https")
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
		try {
			httpSecurity.httpBasic(Customizer.withDefaults())
					// .formLogin().loginPage("/login").loginProcessingUrl("/perform_login")
					// .defaultSuccessUrl("/index.html")
					// .failureUrl("/index.html?error=true").and().logout()
					// .logoutSuccessUrl("/login?logout=true")
					// .and()
					.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth.requestMatchers("/token/**").permitAll()
							.requestMatchers(HttpMethod.GET, "/static/**", "/*.js", "/*.json", "/*.ico").authenticated()
							.requestMatchers("/login/**", "/public/**", "/expired/**","/login-error/**").permitAll()
							.requestMatchers(HttpMethod.DELETE, "/api/v2/clientes/*").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST, "/api/v2/clientes").hasRole("ADMIN")
							.requestMatchers(HttpMethod.DELETE, "/api/v2/contactos/*").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST, "/api/v2/contactos").hasRole("ADMIN").anyRequest()
							.authenticated())
					.formLogin(form -> form.loginPage("/login").permitAll().loginProcessingUrl("/perform_login")
							.defaultSuccessUrl("/").failureUrl("/login-error"))
					// .sessionManagement(sess ->
					// sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

					.sessionManagement((sessionManagement) -> sessionManagement
							.sessionConcurrency((sessionConcurrency) -> sessionConcurrency.maximumSessions(1)
									.expiredUrl("/login?expired")));

			return httpSecurity.build();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	/*
	 * @Bean DaoAuthenticationProvider authProvider() { DaoAuthenticationProvider
	 * authProvider = new DaoAuthenticationProvider();
	 * authProvider.setPasswordEncoder(springSecurityConfig.passwordEncoder());
	 * authProvider.setUserDetailsService(springDataUserDetailsService); return
	 * authProvider; }
	 * 
	 * 
	 * /*
	 * 
	 * @Autowired private DataSource dataSource;
	 * 
	 * @Bean PersistentTokenRepository persistentTokenRepository() {
	 * JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new
	 * JdbcTokenRepositoryImpl(); jdbcTokenRepositoryImpl.setDataSource(dataSource);
	 * return jdbcTokenRepositoryImpl; }
	 * 
	 * @Bean SavedRequestAwareAuthenticationSuccessHandler
	 * savedRequestAwareAuthenticationSuccessHandler () {
	 * SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler =
	 * new SavedRequestAwareAuthenticationSuccessHandler();
	 * authenticationSuccessHandler.setTargetUrlParameter("targetUrl"); return
	 * authenticationSuccessHandler; }
	 * 
	 * 
	 */
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) {
	 * auth.authenticationProvider(authProvider()); }
	 */

}
