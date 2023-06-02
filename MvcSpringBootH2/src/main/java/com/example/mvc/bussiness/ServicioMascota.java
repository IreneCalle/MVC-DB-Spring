package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Mascota;

public interface ServicioMascota {

	List <Mascota> todasMascotas() throws ServicioException;

	Mascota conseguirMascota(Integer mascotaId) throws ServicioException;

	Mascota grabarMascota(Mascota mascota) throws ServicioException;

	void eliminarMascota(Integer mascotaId) throws ServicioException;

}