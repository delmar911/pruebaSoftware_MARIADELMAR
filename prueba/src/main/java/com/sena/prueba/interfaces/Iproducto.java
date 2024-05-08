package com.sena.prueba.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sena.prueba.model.producto;

@Repository
public interface Iproducto  extends CrudRepository<producto,String>{
    @Query("SELECT p FROM producto p WHERE "
			+ "p.nombre LIKE %?1% OR "
			+ "p.estado LIKE %?1% ")
	
	List<producto> filtroProducto(String filtro);
}
