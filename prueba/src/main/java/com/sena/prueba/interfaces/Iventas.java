package com.sena.prueba.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.prueba.model.ventas;


@Repository
public interface Iventas extends CrudRepository<ventas,String> {
    @Query("SELECT v FROM ventas v JOIN v.cliente c WHERE c.id_cliente LIKE %?1% OR c.nombres LIKE ?1 OR c.apellidos LIKE %?1%")
	
	List<ventas> filtroVentaCliente(String filtro);
}
