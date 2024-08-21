package cl.praxis.practicapruebatd.services.impl;

import cl.praxis.practicapruebatd.entities.Especialidad;
import cl.praxis.practicapruebatd.repositories.IEspecialidadRepository;
import cl.praxis.practicapruebatd.services.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService implements ICrudService<Especialidad> {
    @Autowired
    IEspecialidadRepository especialidadRepo;
    @Override
    public List<Especialidad> getAll() {
        return especialidadRepo.findAll();
    }

    @Override
    public Especialidad getById(int id) {
        return especialidadRepo.findById(id).orElse(null);
    }

    @Override
    public Especialidad create(Especialidad especialidad) {
        return especialidadRepo.save(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidad) {
        return especialidadRepo.save(especialidad);
    }

    @Override
    public void delete(int id) {

    }
}
