package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entities.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
