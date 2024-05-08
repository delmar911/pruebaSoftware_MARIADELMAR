package com.sena.prueba.interfaceService;

import java.util.List;
import java.util.Optional;


import com.sena.prueba.model.ventas;

public interface IventasService {

    public String save(ventas ventas);
    public List<ventas>findAll();
    public Optional<ventas> findOne(String id);
    public int delete(String id);
    public List<ventas> filtroVentaCliente(String filtro);
}
