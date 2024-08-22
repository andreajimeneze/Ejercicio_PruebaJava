package cl.praxis.practicapruebatd.restControllers;

import cl.praxis.practicapruebatd.entities.Doctor;
import cl.praxis.practicapruebatd.services.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorRestController {
    @Autowired
    ICrudService<Doctor> doctorService;
    @GetMapping("/doctores")
    public List<Doctor> ListarDoctores() {
        return doctorService.listar();
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> verDoctorPorId(@PathVariable int id) {
        Doctor doctor = doctorService.obtenerPorId(id);

        if (doctor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor id " + id + " No encontrado");
        }
        return ResponseEntity.ok(doctor);
    }

    @PostMapping("/new/doctor")
    public Doctor crearDoctor(@RequestBody Doctor doctor) {
        return doctorService.crear(doctor);
    }

    @PutMapping("/update/doctor/{id}")
    public ResponseEntity<?> actualizarDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        Doctor doctorFound = doctorService.obtenerPorId(id);

        if(doctorFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor id " + id + " No encontrado");
        }

        doctorFound.setNombre(doctor.getNombre());
        doctorFound.setEspecialidad(doctor.getEspecialidad());
        doctorFound.setExperiencia(doctor.getExperiencia());
        doctorService.actualizar(doctorFound);
        return ResponseEntity.ok(doctorFound);
    }

    @DeleteMapping("/delete/doctor/{id}")
    public void eliminarDoctor(@PathVariable int id) {
        doctorService.eliminar(id);
    }
}
