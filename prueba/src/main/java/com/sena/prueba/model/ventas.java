package com.sena.prueba.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="ventas")
public class ventas {
    @Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_venta", nullable = false, length = 36)
	private String id_venta;

    @Column(name = "cliente", nullable = false, length = 36)
	private String cliente;

    @Column(name = "total", nullable = false, length = 36)
	private String total;

    @Column(name = "fecha_venta", nullable = false, length = 36)
	private Date fecha_venta;

    @Column(name = "estado", nullable = false, length = 36)
	private estado estado;

    public ventas(String id_venta, String cliente, String total, Date fecha_venta,
            com.sena.prueba.model.estado estado) {
        this.id_venta = id_venta;
        this.cliente = cliente;
        this.total = total;
        this.fecha_venta = fecha_venta;
        this.estado = estado;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

}

