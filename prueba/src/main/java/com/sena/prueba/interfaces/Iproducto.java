package com.sena.prueba.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.prueba.model.producto;

@Repository
public interface Iproducto  extends CrudRepository<producto,String>{

}
