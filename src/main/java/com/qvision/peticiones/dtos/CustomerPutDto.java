package com.qvision.peticiones.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class CustomerPutDto {
	private Long id;

	/** (CC - CE) */
	@Column(name = "tipo_identificacion", length = 2)
	private String tipoIdentificacion;

	@Column(name = "numero_identificacion")
	private Long numeroIdentificacion;

	@Column(length = 20)
	private String nombres;

	@Column(name = "primer_apellido", length = 12)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 12)
	private String segundoApellido;

	@Column(length = 20)
	private String escolaridad;

	@Column(name = "fecha_grado_bachiller")
	private LocalDate fechaGradoBachiller;

	@Column(name = "titulo_profesional", length = 20)
	private String tituloProfesional;

	@Column(length = 20, nullable = false)
	private String postgrado;

	@Column(name = "numero_matricula")
	private Long numeroMatricula;

	@Column(name = "tiene_vehiculo")
	private Boolean tieneVehiculo;

	@Column(name = "placa_vehiculo", length = 10)
	private String placaVehiculo;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

    @Column(name = "hora_nacimiento")
	private LocalDateTime horaNacimiento;

	/** Si/No */
	@Column(name = "tiene_mascota", length = 2)
	private String tieneMascota;

	/** (Gato, perro, gallina, loro) */
	@Column(name = "tipo_mascota", length = 10)
	private String tipoMascota;

	/** Si/No */
	@Column(name = "tiene_hijos", length = 2)
	private String tieneHijos;

	@Column(name = "cuantos_hijos")
	private Integer cuantosHijos;

	@Column(name = "empresa_donde_labora", length = 50)
	private String empresaDondeLabora;

	@Column(name = "salario")
	private Long salario;

	@Column(name = "gastos_mensuales")
	private Long gastosMensuales;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public LocalDate getFechaGradoBachiller() {
		return fechaGradoBachiller;
	}

	public void setFechaGradoBachiller(LocalDate fechaGradoBachiller) {
		this.fechaGradoBachiller = fechaGradoBachiller;
	}

	public String getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public String getPostgrado() {
		return postgrado;
	}

	public void setPostgrado(String postgrado) {
		this.postgrado = postgrado;
	}

	public Long getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Long numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Boolean getTieneVehiculo() {
		return tieneVehiculo;
	}

	public void setTieneVehiculo(Boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getHoraNacimiento() {
		return horaNacimiento;
	}

	public void setHoraNacimiento(LocalDateTime horaNacimiento) {
		this.horaNacimiento = horaNacimiento;
	}

	public String getTieneMascota() {
		return tieneMascota;
	}

	public void setTieneMascota(String tieneMascota) {
		this.tieneMascota = tieneMascota;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public String getTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(String tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public Integer getCuantosHijos() {
		return cuantosHijos;
	}

	public void setCuantosHijos(Integer cuantosHijos) {
		this.cuantosHijos = cuantosHijos;
	}

	public String getEmpresaDondeLabora() {
		return empresaDondeLabora;
	}

	public void setEmpresaDondeLabora(String empresaDondeLabora) {
		this.empresaDondeLabora = empresaDondeLabora;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	public Long getGastosMensuales() {
		return gastosMensuales;
	}

	public void setGastosMensuales(Long gastosMensuales) {
		this.gastosMensuales = gastosMensuales;
	}

	
}
