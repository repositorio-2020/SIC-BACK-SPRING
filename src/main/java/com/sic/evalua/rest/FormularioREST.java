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

import com.sic.evalua.dao.FormulariosDAO;
import com.sic.evalua.entitys.Formulario;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;


@RestController
@RequestMapping("/api/formulario") 
public class FormularioREST {
	
	@Autowired
	private FormulariosDAO formularioDAO;
	
	@GetMapping
	public ResponseEntity<List<Formulario>> getFormularios()  {

		List<Formulario> formularios = formularioDAO.findAll();
		
		return ResponseEntity.ok(formularios);
		
	}
	

	@RequestMapping(value="{fomularioId}")
	public ResponseEntity<java.util.Optional<Formulario>> getUsuario(@PathVariable("fomularioId") Long fomularioId)  {

		 System.out.println("Buscar un usuario "+fomularioId);
		java.util.Optional<Formulario> optionalFormulario = formularioDAO.findById(fomularioId);
		
		if ( optionalFormulario.isPresent() ) {
			
			return ResponseEntity.ok(optionalFormulario);
			
		}
		else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
	@PostMapping
	public ResponseEntity<Formulario> addUsuario(@RequestBody Formulario formulario)  {

       Formulario newFormulario = formularioDAO.save(formulario);
	
       return ResponseEntity.ok(newFormulario);
       
	}
	
	
	@DeleteMapping(value="{formularioId}")
	public ResponseEntity<Void> deleteFormulario(@PathVariable("formularioId") Long formularioId)  {

       formularioDAO.deleteById(formularioId);
       System.out.println("Delete cosigo de usuario "+formularioId);
	
       return ResponseEntity.ok(null);
       
	}
	
	
	@PutMapping
	public ResponseEntity<Formulario> editFormulario(@RequestBody Formulario formulario)  {

		
	// Pendiente validar que exista el id antes de realizar la actualizacion 	
		
		
		System.out.println("Datos del formulario la fecha es "+formulario.getFecha());
		//formulario.setFecha("2022-05-05");
		
       Formulario updateFormulario = formularioDAO.save(formulario);
	
       return ResponseEntity.ok(updateFormulario);
       
	}
	
	
	
}
