package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Mascota;
import com.example.mvc.repositories.MascotaRepository;

@Service
public class ServicioMascotaImpl implements ServicioMascota {
	
	Logger log = LoggerFactory.getLogger(ServicioMascotaImpl.class);
	
	@Autowired
	MascotaRepository repository;
	
	
	@Override
	public List<Mascota> todasMascotas() throws ServicioException{
		log.info("[listMascotas]");
		
		List<Mascota> mascotas;
		
		try {
			mascotas= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return mascotas;
		
	}
	
	
	@Override
	public Mascota conseguirMascota(Integer idMascota) throws ServicioException{
		log.info("[conseguirMascota]");
		log.debug("[idMascota: "+idMascota+"]");
		
		Mascota mascota;
		
		try {
			Optional<Mascota> mascotaOp= repository.findById(idMascota);
			if(!mascotaOp.isPresent()) throw new ServicioException(CodeError.MASCOTA_NOT_FOUND); 
			mascota= mascotaOp.get();
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return mascota;
		
	}
	
	@Override
	public Mascota grabarMascota(Mascota mascota) throws ServicioException{
		log.info("[grabarMascota]");
		log.debug("[mascota: "+ mascota.toString()+"]");
		
		
		try{
			mascota =repository.save(mascota);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return mascota;
		
	}
	
	
	@Override
	public void eliminarMascota(Integer idMascota) throws ServicioException{
		log.info("[eliminarMascota]");
		log.debug("[idMascota: "+idMascota+"]");
		
			try {
			repository.deleteById(idMascota);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
