package com.qvision.peticiones.models;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;


@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	/** (CC - CE) */
	@Column(name = "tipo_identificacion", length = 2)
	@NotBlank(message = "Tipo identificacion no puede ser vacio")
	private String tipoIdentificacion;

	@Column(name = "numero_identificacion",precision=10, scale=0)
	@NotNull
	@Digits(fraction = 0, integer = 10)
	private BigDecimal numeroIdentificacion;

	@Column(length = 20)
	@NotBlank
	@Length(max = 20)
	private String nombres;

	@Column(name = "primer_apellido", length = 12)
	@NotBlank
	@Length(max = 12)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 12)
	@Length(max = 12)
	private String segundoApellido;

	@Column(length = 20)
	@NotBlank
	@Length(min = 1, max = 20)
	private String escolaridad;

	@Column(name = "fecha_grado_bachiller")
	private LocalDate fechaGradoBachiller;

	@Column(name = "titulo_profesional", length = 20)
	@NotBlank
	@Length(max = 20)
	private String tituloProfesional;

	@Column(length = 20, nullable = false)
	@NotBlank
	@Length(max = 20)
	private String postgrado;

	@Column(name = "numero_matricula",precision=10, scale=0)
	@NotNull(message = "Numero de matricula no puede ser nulo")
	@Digits(fraction = 0, integer = 10)
	private BigDecimal numeroMatricula;

	@Column(name = "tiene_vehiculo")
	private Boolean tieneVehiculo;

	@Column(name = "placa_vehiculo", length = 6)
	@Length(max = 6)
	private String placaVehiculo;

	@Column(name = "fecha_nacimiento")
	@NotNull
	private LocalDate fechaNacimiento;

	@Column(name = "hora_nacimiento")
	@NotNull
	private Time horaNacimiento;

	/** Si/No */
	@Column(name = "tiene_mascota", length = 2)
	@Length(max = 2)
	private String tieneMascota;

	/** (Gato, perro, gallina, loro) */
	@Column(name = "tipo_mascota", length = 10)
	@Length(max = 10)
	private String tipoMascota;

	/** Si/No */
	@Column(name = "tiene_hijos", length = 2)
	@Length(max = 2)
	private String tieneHijos;

	@Column(name = "cuantos_hijos",precision=3, scale=0)
	@Digits(fraction = 0, integer = 3)
	private BigDecimal cuantosHijos;

	@Column(name = "empresa_donde_labora", length = 50)
	@NotBlank
	@Length(max = 50)
	private String empresaDondeLabora;

	@Column(name = "salario",precision=15, scale=0)
	@NotNull
	@Digits(fraction = 0, integer = 15)
	private BigDecimal salario;

	@Column(name = "gastos_mensuales",precision=15, scale=0)
	@NotNull
	@Digits(fraction = 0, integer = 15)
	private BigDecimal gastosMensuales;

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

	public BigDecimal getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(BigDecimal numeroIdentificacion) {
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

	public BigDecimal getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(BigDecimal numeroMatricula) {
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

	public Time getHoraNacimiento() {
		return horaNacimiento;
	}

	public void setHoraNacimiento(Time horaNacimiento) {
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

	public BigDecimal getCuantosHijos() {
		return cuantosHijos;
	}

	public void setCuantosHijos(BigDecimal cuantosHijos) {
		this.cuantosHijos = cuantosHijos;
	}

	public String getEmpresaDondeLabora() {
		return empresaDondeLabora;
	}

	public void setEmpresaDondeLabora(String empresaDondeLabora) {
		this.empresaDondeLabora = empresaDondeLabora;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getGastosMensuales() {
		return gastosMensuales;
	}

	public void setGastosMensuales(BigDecimal gastosMensuales) {
		this.gastosMensuales = gastosMensuales;
	}
	
	
	
}

	