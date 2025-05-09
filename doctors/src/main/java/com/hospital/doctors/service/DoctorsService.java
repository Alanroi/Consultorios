package com.hospital.doctors.service;

import com.hospital.doctors.models.Cita;
import com.hospital.doctors.models.Doctor;
import com.hospital.doctors.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public int getAvailableDoctorId(LocalDate fecha){
        List<Doctor> doctors =doctorsRepository.findAll();

        int doctorId = 0;
        for (Doctor d: doctors){
            List<Cita> citas= d.getCitas();
            if( citas.size() < 8){
                doctorId = d.getId();
                break;
            }
        }

        return doctorId;
    }

}
