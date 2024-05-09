package com.sena.prueba.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.prueba.model.cliente;
import com.sena.prueba.model.estado;

@Service
public interface IclienteService {
    public String save(cliente cliente);
    public List<cliente>findAll();
    public List<cliente> filtrocliente(String filtro);
    public List<cliente> filtroClientePorEstado(estado estado);
    public Optional<cliente> findOne(String id);
    public int delete(String id);
   // public int deletePermanente(String id);
    

}
