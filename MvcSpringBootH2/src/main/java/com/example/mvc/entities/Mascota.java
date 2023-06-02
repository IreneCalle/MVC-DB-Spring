package com.example.mvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="MASCOTAS")
//@NamedQuery(name ="Mascota.findAll",query = "SELECT m FROM MASCOTAS m")
public class Mascota {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MASCOTA_ID")
	private Integer mascotaId;
	
	
	
	@Column(name="MASCOTA_NAME")
	private String nombre;
	@Column(name="CLINICA_ID")
	private Integer clinicaId;
	
	@Column(name = "LOCATION_ID")
	private Integer direccionId;

	
	public Mascota() {};
	
	
	public Integer getId() {
		return mascotaId;
	}

	public void setId(Integer id) {
		this.mascotaId = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Integer clinicaId) {
		this.clinicaId = clinicaId;
	}

	public Integer getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public Mascota(Integer id, String nombre, Integer clinicaId, Integer direccionId) {
		super();
		this.mascotaId = id;
		this.nombre = nombre;
		this.clinicaId = clinicaId;
		this.direccionId = direccionId;
	}
	
	
	
	

	


	

	
	
	

}
