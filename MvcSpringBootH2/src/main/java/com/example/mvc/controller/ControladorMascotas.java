package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioMascota;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Mascota;

@Controller
@RequestMapping("/mascotas")
public class ControladorMascotas {
	
	@Autowired
	ServicioMascota servicio;
	
	@GetMapping
	public String paginaMascotas(Model model) throws Exception {
		List<Mascota> mascotas = servicio.todasMascotas();
		
		model.addAttribute("mascotas", mascotas);	
		return "mascotas";
	}
	
	@GetMapping("/{id}")
	public String paginaMascota(@PathVariable Integer id,Model model) throws Exception {
		Mascota mascota = servicio.conseguirMascota(id);
		
		model.addAttribute("mascota", mascota);	
		return "mascota";
	}
	
	@PostMapping
	public String grabarMascota(@ModelAttribute Mascota mascota,Model model) throws Exception {
		
		mascota =servicio.grabarMascota(mascota);
		
		model.addAttribute("mascota", mascota);	
		return "mascota";
	}
	
	
	@GetMapping("/d/{id}")
	public String eliminarMascota(@PathVariable Integer id,Model model) throws Exception {
		
		servicio.eliminarMascota(id);
		
		
		return "redirect:/mascotas";	
	}
		
	
	
	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute("mensaje","Se ha producido un error");		

		return "error";
    }

}
