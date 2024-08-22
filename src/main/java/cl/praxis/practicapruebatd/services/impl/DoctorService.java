package cl.praxis.practicapruebatd.services.impl;

import cl.praxis.practicapruebatd.entities.Doctor;
import cl.praxis.practicapruebatd.entities.Especialidad;
import cl.praxis.practicapruebatd.repositories.ICitaRepository;
import cl.praxis.practicapruebatd.repositories.IDoctorRepository;
import cl.praxis.practicapruebatd.repositories.IEspecialidadRepository;
import cl.praxis.practicapruebatd.repositories.IHistoriaClinicaRepository;
import cl.praxis.practicapruebatd.services.ICrudService;
import cl.praxis.practicapruebatd.services.IDoctorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements ICrudService<Doctor>, IDoctorService {

    @Autowired
    IEspecialidadRepository especialidadRepo;

    @Autowired
    IDoctorRepository doctorRepo;

    @Autowired
    ICitaRepository citaRepo;

    @Autowired
    IHistoriaClinicaRepository historiaRepo;

    @Override
    public List<Doctor> listar() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor obtenerPorId(int id) {
        return doctorRepo.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Doctor crear(Doctor doctor) {
        Optional<Especialidad> especialidad = especialidadRepo.findById(doctor.getEspecialidad().getId());
        if(especialidad.isPresent()) {
            doctor.setEspecialidad(especialidad.get());
            return doctorRepo.save(doctor);
        }
        return null;
    }

    @Override
    public Doctor actualizar(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Transactional
    @Override
    public void eliminar(int id) {
        citaRepo.setDoctorToNull(id);
        historiaRepo.setDoctorToNull(id);

        doctorRepo.deleteById(id);
    }

    @Override
    public List<Doctor> findDoctorByEspecialidad(Especialidad especialidad) {
        return doctorRepo.findByEspecialidad(especialidad);
    }
}
