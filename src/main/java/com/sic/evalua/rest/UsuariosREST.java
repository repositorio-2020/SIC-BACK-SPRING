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

import com.sic.evalua.dao.UsuariosDAO;
import com.sic.evalua.entitys.Usuario;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;


@RestController
@RequestMapping("/api/usuario") 
public class UsuariosREST {
	
	@Autowired
	private UsuariosDAO usuarioDAO;
	

	

	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios()  {

		List<Usuario> usuarios = usuarioDAO.findAll();
		
		return ResponseEntity.ok(usuarios);
		
	}
	

	
	@RequestMapping(value="{userId}/{clave}")
	public ResponseEntity<java.util.Optional<Usuario>> getUsuario(@PathVariable("userId") Long userId, @PathVariable("clave") String clave )  {

		
		
		 System.out.println("Buscar un id "+userId);
		 System.out.println("Buscar un Clave "+clave);
       	java.util.Optional<Usuario> optionalUsuarioId = usuarioDAO.findById(userId);
		 // java.util.Optional<Usuario> optionalUsuario = usuarioDAO.findByClave(userId, clave);

		
		
		if ( optionalUsuarioId.isPresent() ) {
			
			System.out.println("Encontrado usuario "+userId);
			System.out.println("Clave  "+optionalUsuarioId.get().getClave());
			
			
			
			int intentos = Integer.parseInt(optionalUsuarioId.get().getIntentos());
			
			// Indica si la clave es correcta o no.
			if ( optionalUsuarioId.get().getClave().equals(clave) && intentos <= 3) {
				// Colocar en cero el numero de intentos
				System.out.println("Las Claves SON IGUALES");
			    intentos = 0;	
			}
			else {
				// Debo incrementar numero intento adicional  adicionar en uno 
				System.out.println("Las Claves SON DIFERENTES");
				intentos += 1; 
				
				if (intentos >= 10 ) intentos = 0; // Quita el bloqueo de manera automatica  
			}
				
			
			optionalUsuarioId.get().setIntentos(String.valueOf(intentos));
			
			// Vamos a actualizar el numero de intentos
			usuarioDAO.save(optionalUsuarioId.get());
			
			return ResponseEntity.ok(optionalUsuarioId);
			
		}
		else {
			
			// Retona No Content Error 204
			System.out.println("NO Encontrado ");
			return ResponseEntity.noContent().build();
		}
		
		 
		 
	}
	
	/*
	
	@PostMapping
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario)  {

       Usuario newUsuario = usuarioDAO.save(usuario);
	
       return ResponseEntity.ok(newUsuario);
       
	}
	
	
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("userId") Long userId)  {

       usuarioDAO.deleteById(userId);
       System.out.println("Delete cosigo de usuario "+userId);
	
       return ResponseEntity.ok(null);
       
	}
	
	
	@PutMapping
	public ResponseEntity<Usuario> editUsuario(@RequestBody Usuario usuario)  {

		
	// Pendiente validar que exista el id antes de realizar la actualizacion 	
       Usuario updateUsuario = usuarioDAO.save(usuario);
	
       return ResponseEntity.ok(updateUsuario);
       
	}
	
	
	
	*/

}
