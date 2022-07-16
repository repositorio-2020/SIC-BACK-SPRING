package com.sic.evalua.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sic.evalua.entitys.Marca;

public interface MarcasDAO extends JpaRepository<Marca, Long> {
	

}
