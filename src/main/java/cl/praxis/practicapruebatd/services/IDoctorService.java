package cl.praxis.practicapruebatd.services;

import cl.praxis.practicapruebatd.entities.Doctor;
import cl.praxis.practicapruebatd.entities.Especialidad;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findDoctorByEspecialidad(Especialidad especialidad);
}
