package com.sic.evalua.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sic_usu_usuario") 
public class Usuario {
	
	@Id
	@Column(name="usu_id") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="usu_nombre", nullable=false, length=100) 
	private String nombre;
	
	@Column(name="usu_intentos", nullable=false, length=11) 
	private String intentos;
	
	@Column(name="usu_clave", nullable=false, length=45) 
	private String clave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIntentos() {
		return intentos;
	}

	public void setIntentos(String intentos) {
		this.intentos = intentos;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	
	
	
	
		
	

}
