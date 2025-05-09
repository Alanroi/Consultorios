package com.hospital.doctors.repositories;

import com.hospital.doctors.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitasRepository extends JpaRepository<Cita, Integer> {

}
