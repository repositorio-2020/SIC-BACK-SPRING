package com.sic.evalua.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sic.evalua.entitys.Formulario;

public interface FormulariosDAO extends JpaRepository<Formulario, Long> {
	

}
