package com.sena.prueba.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="ventas")
public class ventas {
   
    @Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_venta", nullable = false, length = 36)
	private String id_venta;

    @Column(name = "total", nullable = false, length = 45)
	private String total;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_venta", nullable = false, length = 10)
	private LocalDateTime fecha_venta;
    
    @ManyToOne
	@JoinColumn(name = "cliente")
	private cliente cliente;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
	private estado estado;
    
    
    public ventas(String id_venta, cliente cliente, String total, LocalDateTime fecha_venta,
    estado estado) {
        this.id_venta = id_venta;
        this.total = total;
        this.fecha_venta = fecha_venta;
        this.estado = estado;
        
    }
    public ventas() {
        
    }
    public cliente getCliente() {
        return cliente;
    }
    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

  
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public LocalDateTime getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDateTime fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

}

