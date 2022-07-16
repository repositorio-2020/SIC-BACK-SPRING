package com.sic.evalua.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sic_for_formulario") 
public class Formulario {   
	
	@Id
	@Column(name="for_id") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="for_documento", nullable=false, length=10) 
	private String documento;

	@Column(name="for_mail", nullable=false, length=100) 
	private String mail;

	@Column(name="for_comentario", nullable=false, length=200) 
	private String comentario;
	
	@Column(name="for_fecha", nullable=false) 
	private Date fecha;
		
	
	@Column(name="sic_mar_marcas_mar_id", nullable=false, length=10) 
	private Long marca;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getMarca() {
		return marca;
	}


	public void setMarca(Long marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Formulario [id=" + id + ", documento=" + documento + ", mail=" + mail + ", comentario=" + comentario
				+ ", fecha=" + fecha + ", marca=" + marca + "]";
	}
	
	
	
	
	
	

}
