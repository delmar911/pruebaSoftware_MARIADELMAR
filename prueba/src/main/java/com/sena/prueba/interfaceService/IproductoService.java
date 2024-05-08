package com.sena.prueba.interfaceService;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


import com.sena.prueba.model.producto;
@Service
public interface IproductoService {
    public String save(producto producto);
    public List<producto>findAll();
    public Optional<producto> findOne(String id);
    public int delete(String id);
    public List<producto> filtroProducto(String filtro);

}
