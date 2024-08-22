package cl.praxis.practicapruebatd.controllers;

import cl.praxis.practicapruebatd.entities.Doctor;
import cl.praxis.practicapruebatd.entities.Especialidad;
import cl.praxis.practicapruebatd.services.ICrudService;
import cl.praxis.practicapruebatd.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    ICrudService<Doctor> doctorCrudService;
    @Autowired
    IDoctorService doctorService;

    @Autowired
    ICrudService<Especialidad> especialidadService;

    @GetMapping("/doctores")
    public String listardoctores(@RequestParam(value= "especialidadId", required=false) Integer especialidadId, Model model) {
        System.out.println("Especialidad ID: " + especialidadId);
        List<Doctor> doctores;
        if(especialidadId != null) {
            doctores = doctorService.findDoctorByEspecialidad(especialidadService.obtenerPorId(especialidadId));
            model.addAttribute("doctores", doctores);
        } else {
            doctores = doctorCrudService.listar();
        }
        model.addAttribute("doctores", doctores);
        model.addAttribute("especialidades", especialidadService.listar());
        return "lista_doctores";
    }
}
