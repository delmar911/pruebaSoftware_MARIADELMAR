package com.sena.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.prueba.interfaceService.IventasService;
import com.sena.prueba.interfaces.Iventas;
import com.sena.prueba.model.ventas;

@Service
public class ventasService implements IventasService {
    @Autowired
	private Iventas data;
	
	@Override
	public String save(ventas ventas){
        data.save(ventas);
        return ventas.getId_venta();
    }

	@Override
	public List<ventas> findAll() {
		List<ventas> Listaventas=
				(List<ventas>) data.findAll();
		//(List<ventas>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <ventas>
		//- se convierte a list <ventas>
		return Listaventas;
	}
    @Override
    public Optional<ventas> findOne(String id) {
        Optional<ventas> ventas=data.findById(id);
        return ventas;
    }
    @Override
	public List<ventas> filtroVentaCliente(String filtro) {
		List<ventas>Listaventas=data.filtroVentaCliente(filtro);
		return Listaventas;
	}
    @Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}


}
