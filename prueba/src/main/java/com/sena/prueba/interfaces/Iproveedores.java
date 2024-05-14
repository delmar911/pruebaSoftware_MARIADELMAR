package com.sena.prueba.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.sena.prueba.model.proveedores;

@Repository
public interface Iproveedores extends CrudRepository<proveedores,String> {
    @Query("SELECT p FROM proveedores p WHERE p.nit LIKE %?1% OR p.razon_social LIKE %?1%") 

    List<proveedores> filtro(String filtro);
}
