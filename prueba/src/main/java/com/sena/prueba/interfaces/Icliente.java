package com.sena.prueba.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.prueba.model.cliente;

@Repository
public interface Icliente extends CrudRepository<cliente,String> {
    @Query("SELECT c FROM cliente c WHERE "
			+ "c.nombres LIKE %?1% OR "
			+ "c.cuidad LIKE %?1% ")
	
	List<cliente> filtrocliente(String filtro);
}
