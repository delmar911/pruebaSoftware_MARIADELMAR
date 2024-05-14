package com.sena.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.prueba.interfaceService.IproveedoresService;
import com.sena.prueba.model.proveedores;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/api/v1/proveedores")
@RestController
@CrossOrigin
public class proveedoresController {

    @Autowired
    private IproveedoresService proveedoresService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("proveedores") proveedores proveedores){
        if (proveedores.getNit().equals("")) {
            return new ResponseEntity<>("El Nit es obligatorio", HttpStatus.BAD_REQUEST);
        }

        proveedoresService.save(proveedores);
		return new ResponseEntity<>(proveedores,HttpStatus.OK);
    }
    @GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var Listaproveedores=proveedoresService.findAll();
		return new ResponseEntity<>(Listaproveedores, HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var Listaproveedores=proveedoresService.filtro(filtro);
		return new ResponseEntity<>(Listaproveedores, HttpStatus.OK);
	}
    //@PathVariable : Recibe una variable por enlace
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable String id){
		var proveedores=proveedoresService.findOne(id);
		return new ResponseEntity<>(proveedores,HttpStatus.OK);
		
	}
    @DeleteMapping("/{id_proveedores}")
	public ResponseEntity<Object> delete(@PathVariable String id_proveedores){
			proveedoresService.delete(id_proveedores);
				return new ResponseEntity<>("Registro Deshabilitado",HttpStatus.OK);
	}
    @PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("proveedores")proveedores proveedoresUpdate){
		var proveedores = proveedoresService.findOne(id).get();
		if (proveedores != null) {
			proveedores.setNit(proveedoresUpdate.getNit());
			proveedores.setRazon_social(proveedoresUpdate.getRazon_social());
			proveedores.setNombre_contacto(proveedoresUpdate.getNombre_contacto());
			proveedores.setDireccion(proveedoresUpdate.getDireccion());
			proveedores.setTelefono_contacto(proveedoresUpdate.getTelefono_contacto());
			proveedores.setCargo_contacto(proveedoresUpdate.getCargo_contacto());
			proveedores.setEstado(proveedoresUpdate.getEstado());
			proveedoresService.save(proveedores);
		return new ResponseEntity<>("Se actualizo exitosamente", HttpStatus.OK);
		
		}
		else {
			return new ResponseEntity<>("Error proveedores no encontrado",HttpStatus.BAD_REQUEST);
		}
			
	}
}
    
     

