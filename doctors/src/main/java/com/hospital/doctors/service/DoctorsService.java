package com.hospital.doctors.service;

import com.hospital.doctors.models.Doctor;
import com.hospital.doctors.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public Doctor getAvailableDoctorId(LocalDate fecha){
        List<Doctor> doctors =doctorsRepository.findAll();

        Optional<Doctor> doctorAvailable = doctors.stream()
                .filter(doctor -> {
                    long citasCountOnDate = doctor.getCitas().stream()
                            .filter(cita -> cita.getHorario().toLocalDate().equals(fecha))
                            .count();
                    return citasCountOnDate < 8;
                })
                .findFirst();

        return doctorAvailable.orElse(null);

    }

}
