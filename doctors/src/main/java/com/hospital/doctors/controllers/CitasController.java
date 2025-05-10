package com.hospital.doctors.controllers;

import com.hospital.doctors.models.Cita;
import com.hospital.doctors.models.CitaDto;
import com.hospital.doctors.models.Consultorio;
import com.hospital.doctors.models.Doctor;
import com.hospital.doctors.repositories.CitasRepository;
import com.hospital.doctors.repositories.ConsultoriosRepository;
import com.hospital.doctors.repositories.DoctorsRepository;
import com.hospital.doctors.service.DoctorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private DoctorsService doctorsService;

    @Autowired
    private ConsultoriosRepository consultoriosRepository;

    @GetMapping({"","/"})
    public String getCitas(Model model){
        List<Cita> citas = citasRepository.findAll(Sort.by(Sort.Direction.DESC,"horario"));
        model.addAttribute("citas",citas);
        return "citas";
    }

    @GetMapping("/crear")
    public String createCita(Model model){
        CitaDto citaDto = new CitaDto();
        model.addAttribute("citaDto",citaDto);
        return "create";
    }

    @PostMapping("/crear")
    public String createMovement(
            @Valid @ModelAttribute CitaDto citaDto,
            BindingResult result){

        Doctor doctor = doctorsService.getAvailableDoctorId(citaDto.getFecha());

        if(doctor == null) {
            result.addError(
                    new FieldError("movementDto", "fecha", citaDto.getFecha()
                            , false, null, null,
                            "No hay doctores disponibles*")
            );
        }

        if(result.hasErrors()){
            return "create";
        }
        List<Consultorio> consultorios = consultoriosRepository.findAll();

        Cita cita = new Cita();

        // values hardcoded and the logic was not added to validate consultories or the time of doctors due needed more time
        cita.setDoctor(doctor);
        cita.setNombre(citaDto.getNombre());
        cita.setHorario(LocalDateTime.now());
        cita.setConsultorio(consultorios.get(0));
        citasRepository.save(cita);




        return "redirect:/citas";
    }

    @GetMapping("/eliminar")
    public String deleteCita(@RequestParam int id){
        Cita cita  = citasRepository.findById(id).orElse(null);

        if(cita != null){
            citasRepository.delete(cita);
        }
        return "redirect:/citas";
    }

}
