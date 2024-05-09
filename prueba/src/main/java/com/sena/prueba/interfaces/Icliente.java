package com.sena.prueba.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.prueba.model.cliente;
import com.sena.prueba.model.estado;

@Repository
public interface Icliente extends CrudRepository<cliente,String> {
    @Query("SELECT c FROM cliente c WHERE "
			+ "c.nombres LIKE %?1% OR "
			+ "c.ciudad LIKE %?1% ")
	
	List<cliente> filtrocliente(String filtro);

    @Query("SELECT c FROM cliente c WHERE c.estado = ?1")

    List<cliente> filtroClientePorEstado(estado estado);

}

