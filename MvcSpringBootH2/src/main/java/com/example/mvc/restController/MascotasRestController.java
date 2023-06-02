package com.example.mvc.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.bussiness.ServicioMascota;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Mascota;

@RestController
public class MascotasRestController {
	
@Autowired
ServicioMascota service;


public MascotasRestController(){
	
	
	

}

//metodo que devuelve lista de todos los objetos

@GetMapping(value= "/mascotasrest")
public ResponseEntity <List <Mascota>> findAll () throws ServicioException{
	
	
	List <Mascota> mascotas = service.todasMascotas();
	
	
	return new ResponseEntity <List <Mascota>> (mascotas, HttpStatus.OK);
	
}




//metodo que devuelve entidad por id

@GetMapping(value="/mascotasrest/{mascotaId}")

public ResponseEntity <Mascota> findById (@PathVariable ("mascotaId") int id) throws ServicioException
{
Mascota mascota = service.conseguirMascota(id);
	

return new ResponseEntity <Mascota> (mascota, HttpStatus.OK );
	
}


//metodo actualizar 
@PutMapping(value="/mascotasrest") 
public ResponseEntity<Mascota> update(@RequestBody Mascota mascota) throws ServicioException {
	
Mascota mascotaGuardar = service.grabarMascota(mascota);

	return new ResponseEntity<Mascota>(mascotaGuardar, HttpStatus.OK);
}





//metodo crear, necesitamos postmapping, y producto por parametro con requestbody



@PostMapping(value= "/mascotasrest")
public ResponseEntity <Mascota> create(@RequestBody Mascota mascota) throws ServicioException {

	Mascota mascotaCrear = service.grabarMascota(mascota);

	
	return new ResponseEntity <Mascota>(mascotaCrear, HttpStatus.CREATED);
}






//finalmente, tenemos el metodo delete

@DeleteMapping(value="/mascotasrest/{mascotaId}")
public ResponseEntity <Void> delete(@PathVariable("mascotaId") int mascotaId) throws ServicioException {
	
	service.eliminarMascota(mascotaId);
	
	return new ResponseEntity (HttpStatus.OK);
	
	
}




}