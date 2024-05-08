package com.sena.prueba.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="producto")
public class producto {
    
    @Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_producto", nullable = false, length = 36)
	private String id_producto;

    @Column (name = "nombre", nullable = false, length = 50)
	private String nombre;

    @Column (name = "descripcion", nullable = false, length = 50)
	private String descripcion;

    @Column (name = "cantidad", nullable = false, length = 50)
	private int cantidad;

    @Column (name = "precio", nullable = false, precision = 9, scale = 2)
	private BigDecimal precio;

    @Column (name = "porcentaje_iva", nullable = false, length = 2)
	private int porcentaje_iva;

    @Column (name = "porcentaje_descuento", nullable = false, length = 2)
	private int porcentaje_descuento;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
	private estado estado;

    
    public producto() {
		
	}
    public producto(String id_producto, String nombre, String descripcion, 
                    int cantidad, BigDecimal precio, int porcentaje_iva, 
                    int porcentaje_descuento, estado estado) {
       
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.porcentaje_iva = porcentaje_iva;
        this.porcentaje_descuento = porcentaje_descuento;
        this.estado = estado;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
    public int getPorcentaje_iva() {
        return porcentaje_iva;
    }

    public void setPorcentaje_iva(int porcentaje_iva) {
        this.porcentaje_iva = porcentaje_iva;
    }
    public int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(int porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

 
}
