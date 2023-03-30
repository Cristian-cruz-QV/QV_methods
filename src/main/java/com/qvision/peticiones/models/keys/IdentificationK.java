package com.qvision.peticiones.models.keys;

import java.io.Serializable;
import java.util.Objects;

public class IdentificationK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	@Override
	public int hashCode() {
		return Objects.hash(numeroIdentificacion, tipoIdentificacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		IdentificationK other = (IdentificationK) obj;
		return Objects.equals(numeroIdentificacion, other.numeroIdentificacion)
				&& Objects.equals(tipoIdentificacion, other.tipoIdentificacion);
	}
	
	
	
}
