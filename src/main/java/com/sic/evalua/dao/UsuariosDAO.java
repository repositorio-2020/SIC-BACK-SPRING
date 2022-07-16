package com.sic.evalua.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sic.evalua.entitys.Usuario;

public interface UsuariosDAO extends JpaRepository<Usuario, Long> {
	
	
	 @Query("select p from Usuario p where p.id = :id and p.clave = :clave")
	 Usuario findByClave(@Param("id") Long id, @Param("clave") String clave);
//	 java.util.Optional<Usuario> findByClave(@Param("id") Long id, @Param("clave") String clave);
	 //se quiere que reciba solo un parámetro pero que realice la búsqueda en los dos campos

	

}


