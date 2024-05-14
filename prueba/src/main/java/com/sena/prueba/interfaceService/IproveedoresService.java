package com.sena.prueba.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sena.prueba.model.proveedores;



@Service
public interface IproveedoresService {
    public String save(proveedores proveedores);
    public List<proveedores> filtro(String filtro);
    public List<proveedores>findAll();
    public Optional<proveedores> findOne(String id);
    public int delete(String id);

}
