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

import com.sena.prueba.interfaceService.IventasService;
import com.sena.prueba.model.ventas;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/api/v1/ventas")
@RestController
@CrossOrigin
public class ventasController {

    @Autowired
	private IventasService ventasService;

    @PostMapping("/")
   	public ResponseEntity<Object> save(@ModelAttribute("ventas") ventas ventas){
			// condicion para cuando ya exista el  registro 
			//   List<ventas>listaventasValidacion=ventasService.filtroCedulaventas(ventas.getNumero_documento());
			// if(listaventasValidacion.size()!=0){
			// 	//ya tiene un registro activo
			// 	return new ResponseEntity<>("El ventas ya se encuentra registrado",HttpStatus.BAD_REQUEST);		
			// }	
			// if (ventas.getTotal().equals("")) {
			// 	return new ResponseEntity<>("El número de documento es obligatorio", HttpStatus.BAD_REQUEST);
			// }
			if (ventas.getFecha_venta()==null) {
				return new ResponseEntity<>("Ingrese la fecha de la venta", HttpStatus.BAD_REQUEST);
			}
			if (ventas.getEstado()==null) {
				return new ResponseEntity<>("El estado es obligatorio", HttpStatus.BAD_REQUEST);
			}
			
		ventasService.save(ventas);
		return new ResponseEntity<>("Se guardo correctamente",HttpStatus.OK);
	}
    	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var Listaventas=ventasService.findAll();
		return new ResponseEntity<>(Listaventas, HttpStatus.OK);
	}
    @GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var Listaventas=ventasService.filtroVentaCliente(filtro);
		return new ResponseEntity<>(Listaventas, HttpStatus.OK);
	}
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id){
        var ventas=ventasService.findOne(id);
        return new ResponseEntity<>(ventas,HttpStatus.OK);
        
    }
    @DeleteMapping("/eliminarPermanente/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        ventasService.delete(id);
        return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
    }
    
		@PutMapping("/{id}")
		public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("ventas")ventas ventasUpdate){
			var ventas = ventasService.findOne(id).get();
        if (ventas != null) {
            ventas.setTotal(ventasUpdate.getTotal());
            ventas.setFecha_venta(ventasUpdate.getFecha_venta());
            ventas.setEstado(ventasUpdate.getEstado());
            ventasService.save(ventas);
            
            return new ResponseEntity<>("Se actualizo exitosamente", HttpStatus.OK);
			
			}
			else {
				return new ResponseEntity<>("Error producto no encontrado",HttpStatus.BAD_REQUEST);
			}
				
		}
    
}
