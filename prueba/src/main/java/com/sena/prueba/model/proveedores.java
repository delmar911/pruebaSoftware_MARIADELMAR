package com.sena.prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="proveedores")
public class proveedores {

    @Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_proveedores", nullable = false, length = 36)
	private String id_proveedores;

    @Column (name = "nit", nullable = false, length = 9)
	private String nit;

    @Column (name = "razon_social", nullable = false, length = 50)
	private String razon_social;

    @Column (name = "nombre_contacto", nullable = false, length = 50)
	private String nombre_contacto;

    @Column (name = "cargo_contacto", nullable = false, length = 30)
	private String cargo_contacto;

    @Column (name = "telefono_contacto", nullable = false, length = 13)
	private String telefono_contacto;

    @Column(name = "direccion", nullable = false, length = 45)
	private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
    private estado estado;

    public proveedores(String id_proveedores, String nit, String razon_social, String nombre_contacto,
            String cargo_contacto, String telefono_contacto, String direccion, com.sena.prueba.model.estado estado) {
        this.id_proveedores = id_proveedores;
        this.nit = nit;
        this.razon_social = razon_social;
        this.nombre_contacto = nombre_contacto;
        this.cargo_contacto = cargo_contacto;
        this.telefono_contacto = telefono_contacto;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(String id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getCargo_contacto() {
        return cargo_contacto;
    }

    public void setCargo_contacto(String cargo_contacto) {
        this.cargo_contacto = cargo_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    
}
