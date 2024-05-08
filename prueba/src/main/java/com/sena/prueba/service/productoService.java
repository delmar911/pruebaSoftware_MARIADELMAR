package com.sena.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.prueba.interfaceService.IproductoService;
import com.sena.prueba.interfaces.Iproducto;
import com.sena.prueba.model.producto;

@Service
public class productoService implements IproductoService {
    
    @Autowired
	private Iproducto data;
	
	
	@Override
	public String save(producto producto) {
		data.save(producto);
		return producto.getId_producto();
	}

	@Override
	public List<producto> findAll() {
		List<producto> Listaproducto=
				(List<producto>) data.findAll();
		//(List<producto>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <producto>
		//- se convierte a list <producto>
		return Listaproducto;
	}
	
	@Override
	public List<producto> filtroProducto(String filtro) {
		List<producto>Listaproducto=data.filtroProducto(filtro);
		return Listaproducto;
	}

	// la variable que almacena los registros
	// @Override
	// public List<producto> filtroCedulaproducto(String numero_documento ) {
	// 	List<producto>Listaproducto=data.filtroCedulaproducto(numero_documento);
	// 	return Listaproducto;
	// }
	 
	
	@Override
	public Optional<producto> findOne(String id) {
		Optional<producto> producto=data.findById(id);
		return producto;
	}

	@Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}
	// @Override
	// public int delete(String id_producto) {
	// 	var producto=data.findById(id_producto).get();
	// 	producto.setEstado("Inactivo"); 
    //     data.save(producto); 
	// 	return 0;
	// }
}
