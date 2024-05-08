package com.sena.prueba.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.prueba.interfaceService.IproductoService;
import com.sena.prueba.model.producto;


@RequestMapping("/api/v1/producto")
@RestController
@CrossOrigin
public class productoController {

     @Autowired
	private IproductoService productoService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@ModelAttribute("producto") producto producto){
			// condicion para cuando ya exista el  registro 
			//   List<producto>listaproductoValidacion=productoService.filtroCedulaproducto(producto.getNumero_documento());
			// if(listaproductoValidacion.size()!=0){
			// 	//ya tiene un registro activo
			// 	return new ResponseEntity<>("El producto ya se encuentra registrado",HttpStatus.BAD_REQUEST);		
			// }	
			if (producto.getNombre().equals("")) {
				return new ResponseEntity<>("El nombre del producto es obligatorio", HttpStatus.BAD_REQUEST);
			}
			// if (producto.getDescripcion().equals("")) {
			// 	return new ResponseEntity<>("El número de documento es obligatorio", HttpStatus.BAD_REQUEST);
			// }
			if (producto.getCantidad()==0) {
				return new ResponseEntity<>("La cantidad es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (producto.getPrecio().compareTo(BigDecimal.ZERO) == 0) {
				return new ResponseEntity<>("El precio es obligatorio", HttpStatus.BAD_REQUEST);
			}
			if (producto.getPorcentaje_iva()==0) {
				return new ResponseEntity<>("el iva es obligatorio", HttpStatus.BAD_REQUEST);
			}
			// if (producto.getPorcentaje_descuento()==0) {
			// 	return new ResponseEntity<>("El número de telefono es obligatorio", HttpStatus.BAD_REQUEST);
			// }
			if (producto.getEstado().equals("")) {
				return new ResponseEntity<>("El estado es obligatorio", HttpStatus.BAD_REQUEST);
			}
			
			
		productoService.save(producto);
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var Listaproducto=productoService.findAll();
		return new ResponseEntity<>(Listaproducto, HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var Listaproducto=productoService.filtroProducto(filtro);
		return new ResponseEntity<>(Listaproducto, HttpStatus.OK);
	}
	
	//@PathVariable : Recibe una variable por enlace
		@GetMapping("/{id}")
		public ResponseEntity<Object> findOne(@PathVariable String id){
			var producto=productoService.findOne(id);
			return new ResponseEntity<>(producto,HttpStatus.OK);
			
		}
		
		@DeleteMapping("/eliminarPermanente/{id}")
		public ResponseEntity<Object> delete(@PathVariable String id){
			 productoService.delete(id);
					return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
		}
		// @DeleteMapping("/{id_producto}")
		// public ResponseEntity<Object> delete(@PathVariable String id_producto){
		// 	 productoService.delete(id_producto);
		// 			return new ResponseEntity<>("Registro Deshabilitado",HttpStatus.OK);
		// }
		

		@PutMapping("/{id}")
		public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("producto")producto productoUpdate){
			var producto = productoService.findOne(id).get();
        if (producto != null) {
            producto.setNombre(productoUpdate.getNombre());
            producto.setDescripcion(productoUpdate.getDescripcion());
            producto.setCantidad(productoUpdate.getCantidad());
            producto.setPrecio(productoUpdate.getPrecio());
            producto.setPorcentaje_iva(productoUpdate.getPorcentaje_iva());
            producto.setPorcentaje_descuento(productoUpdate.getPorcentaje_descuento());
            producto.setEstado(productoUpdate.getEstado());
            productoService.save(producto);
            
            return new ResponseEntity<>("Se actualizo exitosamente", HttpStatus.OK);
			
			}
			else {
				return new ResponseEntity<>("Error producto no encontrado",HttpStatus.BAD_REQUEST);
			}
				
		}
    
}
