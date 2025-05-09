package com.hospital.doctors.repositories;

import com.hospital.doctors.models.Cita;
import com.hospital.doctors.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctor, Integer> {
}
