package com.hospital.doctors.controllers;

import com.hospital.doctors.models.Cita;
import com.hospital.doctors.models.CitaDto;
import com.hospital.doctors.repositories.CitasRepository;
import com.hospital.doctors.repositories.DoctorsRepository;
import com.hospital.doctors.service.DoctorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private DoctorsService doctorsService;

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

            int doctorId = doctorsService.getAvailableDoctorId(citaDto.getFecha());



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
