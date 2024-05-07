package com.sena.prueba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.prueba.interfaceService.IclienteService;
import com.sena.prueba.model.cliente;

@RequestMapping("/api/v1/cliente")
@RestController
@CrossOrigin

public class clienteController {

    @Autowired
	private IclienteService clienteService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@ModelAttribute("cliente") cliente cliente){
			// condicion para cuando ya exista el  registro 
			//   List<cliente>listaclienteValidacion=clienteService.filtroCedulacliente(cliente.getNumero_documento());
			// if(listaclienteValidacion.size()!=0){
			// 	//ya tiene un registro activo
			// 	return new ResponseEntity<>("El cliente ya se encuentra registrado",HttpStatus.BAD_REQUEST);		
			// }	
			if (cliente.getTipo_documento().equals("")) {
				return new ResponseEntity<>("El tipo documento es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getNumero_documento().equals("")) {
				return new ResponseEntity<>("El número de documento es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getNombres().equals("")) {
				return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getApellidos().equals("")) {
				return new ResponseEntity<>("El apellido es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getDireccion().equals("")) {
				return new ResponseEntity<>("La dirección es obligatoria", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getTelefono().equals("")) {
				return new ResponseEntity<>("El número de telefono es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getDireccion().equals("")) {
				return new ResponseEntity<>("La dirección es obligatoria", HttpStatus.BAD_REQUEST);
			}
			if (cliente.getEstado().equals("")) {
				return new ResponseEntity<>("El estado es obligatorio", HttpStatus.BAD_REQUEST);
			}
			
			
		clienteService.save(cliente);
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var Listacliente=clienteService.findAll();
		return new ResponseEntity<>(Listacliente, HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var Listacliente=clienteService.filtrocliente(filtro);
		return new ResponseEntity<>(Listacliente, HttpStatus.OK);
	}
	
	//@PathVariable : Recibe una variable por enlace
		@GetMapping("/{id}")
		public ResponseEntity<Object> findOne(@PathVariable String id){
			var cliente=clienteService.findOne(id);
			return new ResponseEntity<>(cliente,HttpStatus.OK);
			
		}
		
		// @DeleteMapping("/eliminarPermanente/{id}")
		// public ResponseEntity<Object> delete(@PathVariable String id){
		// 	 clienteService.delete(id);
		// 			return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
		// }
		// @DeleteMapping("/{id_cliente}")
		// public ResponseEntity<Object> delete(@PathVariable String id_cliente){
		// 	 clienteService.delete(id_cliente);
		// 			return new ResponseEntity<>("Registro Deshabilitado",HttpStatus.OK);
		// }
		

		@PutMapping("/{id}")
		public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("cliente")cliente clienteUpdate){
			var cliente = clienteService.findOne(id).get();
			if (cliente != null) {
				cliente.setTipo_documento(clienteUpdate.getTipo_documento());
				cliente.setNumero_documento(clienteUpdate.getNumero_documento());
				cliente.setNombres(clienteUpdate.getNombres());
				cliente.setDireccion(clienteUpdate.getDireccion());
				cliente.setEstado(clienteUpdate.getEstado());
			    clienteService.save(cliente);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
			
			}
			else {
				return new ResponseEntity<>("Error cliente no encontrado",HttpStatus.BAD_REQUEST);
			}
				
		}
}
