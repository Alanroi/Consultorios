package com.hospital.doctors.repositories;

import com.hospital.doctors.models.Cita;
import com.hospital.doctors.models.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultoriosRepository extends JpaRepository<Consultorio, Integer> {

}
