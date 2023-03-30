package com.qvision.peticiones.models.keys;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class IdentPK implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipoIdentificacion;
	
	private String numeroIdentificacion;

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(numeroIdentificacion, tipoIdentificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentPK other = (IdentPK) obj;
		return Objects.equals(numeroIdentificacion, other.numeroIdentificacion)
				&& Objects.equals(tipoIdentificacion, other.tipoIdentificacion);
	}

	public IdentPK(String tipoIdentificacion, String numeroIdentificacion) {
		super();
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
	}


	
	
	
}
