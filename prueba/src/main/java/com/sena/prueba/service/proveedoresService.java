package com.sena.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.prueba.interfaceService.IproveedoresService;
import com.sena.prueba.interfaces.Iproveedores;
import com.sena.prueba.model.proveedores;


@Service
public class proveedoresService implements IproveedoresService{

    @Autowired
    private Iproveedores data;

    @Override
    public String save(proveedores proveedores) {
		data.save(proveedores);
		return proveedores.getId_proveedores();
	}
    @Override
	public List<proveedores> findAll() {
		List<proveedores> listaproveedores=
				(List<proveedores>) data.findAll();
		//(List<proveedores>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <proveedores>
		//- se convierte a list <proveedores>
		return listaproveedores;
	}
    @Override
	public List<proveedores> filtro(String filtro) {
		List<proveedores>Listaproveedores=data.filtro(filtro);
		return Listaproveedores;
	}
     @Override
	public Optional<proveedores> findOne(String id) {
		Optional<proveedores> proveedores=data.findById(id);
		return proveedores;
	}
    @Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}
}
