package com.sic.evalua.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sic.evalua.dao.MarcasDAO;
import com.sic.evalua.entitys.Marca;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;


@RestController
@RequestMapping("/api/marca") 
public class MarcaREST {  
	
	@Autowired
	private MarcasDAO marcaDAO;
	
	@GetMapping
	public ResponseEntity<List<Marca>> getMarcas()  {

		List<Marca> marcas = marcaDAO.findAll();
		
		return ResponseEntity.ok(marcas);
		
	}
	

	
	
	
}
