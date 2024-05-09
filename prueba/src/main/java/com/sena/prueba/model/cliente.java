package com.sena.prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="cliente")
public class cliente {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_cliente", nullable = false, length = 36)
	private String id_cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false, length = 10)
	private tipo_documento tipo_documento;

    @Column(name = "numero_documento", nullable = false, length = 10)
	private String numero_documento;

    @Column (name = "nombres", nullable = false, length = 45)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 45)
	private String apellidos;

	@Column(name = "telefono", nullable = false, length = 13)
	private String telefono;

	@Column(name = "direccion", nullable = false, length = 45)
	private String direccion;

    @Column(name = "correo_electronico", nullable = false, length = 155)
	private String correo_electronico;

	@Column(name = "ciudad", nullable = false, length = 45)
	private String ciudad;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
	private estado estado;
    
    

    public cliente(String id_cliente, tipo_documento tipo_documento, String numero_documento, 
                    String nombres, String apellidos, String telefono, 
                    String direccion, String ciudad, estado estado, String correo_electronico) {
        this.id_cliente = id_cliente;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.correo_electronico=correo_electronico;
        this.estado = estado;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public tipo_documento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(tipo_documento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getciudad() {
        return ciudad;
    }

    public void setciudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	} 
    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    public cliente(){
        super();
    }


}
