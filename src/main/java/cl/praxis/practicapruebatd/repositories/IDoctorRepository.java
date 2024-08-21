package cl.praxis.practicapruebatd.repositories;

import cl.praxis.practicapruebatd.entities.Doctor;
import cl.praxis.practicapruebatd.entities.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
        List<Doctor> findByEspecialidad(Especialidad especialidad);
}
